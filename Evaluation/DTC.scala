//DTC
val time = System.currentTimeMillis

import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.DecisionTreeClassificationModel
import org.apache.spark.ml.classification.DecisionTreeClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{VectorAssembler, IndexToString, StringIndexer, VectorIndexer}
import org.apache.spark.sql.SparkSession
import org.apache.log4j._

Logger.getLogger("org").setLevel(Level.ERROR)

val spark = SparkSession.builder().getOrCreate()



val data = spark.read.option("header", "true").option("inferSchema","true").option("delimiter",";")csv("bank-full.csv")

data.na.drop()

val indexer = new StringIndexer().setInputCol("loan").setOutputCol("indexedLabel").fit(data)
val indexed = indexer.transform(data).drop("loan").withColumnRenamed("indexedLabel", "label") 
val assembler = (new VectorAssembler().setInputCols(Array("age", "balance", "day", "duration", "previous")).setOutputCol("features"))
val features = assembler.transform(indexed)

val filter = features.withColumnRenamed("loan", "label")

val data2 = filter.select("label", "features")

val indexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(data2)
val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4).fit(data2)

val splits = features.randomSplit(Array(0.6, 0.4), seed = 12345)
val train = splits(0)
val test = splits(1)

val trainer = new DecisionTreeClassifier().setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures")

val labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(labelIndexer.labels)

val pipeline = new Pipeline().setStages(Array(indexer, featureIndexer, trainer, labelConverter))

val model = pipeline.fit(train)
val predictions = model.transform(test)

predictions.select("predictedLabel", "label", "features").show(5)

val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")
val accuracy = evaluator.evaluate(predictions)
println(s"Test Error = ${(1.0 - accuracy)}")

val treeModel = model.stages(2).asInstanceOf[DecisionTreeClassificationModel]
println(s"Learned classification tree model:\n ${treeModel.toDebugString}")

val totalTime = System.currentTimeMillis - time
