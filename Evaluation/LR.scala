//LR
val time = System.currentTimeMillis

import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.feature.{VectorAssembler, StringIndexer}
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.ml.Pipeline
import org.apache.spark.mllib.evaluation.MulticlassMetrics
import org.apache.log4j._

Logger.getLogger("org").setLevel(Level.ERROR)

val spark = SparkSession.builder().getOrCreate()

val data = spark.read.option("header", "true").option("inferSchema","true").option("delimiter",";")csv("bank-full.csv")
data.na.drop()

val indexer = new StringIndexer().setInputCol("loan").setOutputCol("indexedLabel").fit(data)
val indexed = labelIndexer.transform(data).drop("loan").withColumnRenamed("indexedLabel", "label") 
val assembler = (new VectorAssembler().setInputCols(Array("age", "balance", "day", "duration", "previous")).setOutputCol("features"))
val features = assembler.transform(indexed)

val filter = features.withColumnRenamed("loan", "label")

val logregdata = filter.select("label", "age", "balance", "day", "duration", "previous")

val splits = logregdata.randomSplit(Array(0.6, 0.4), seed = 12345)
val train = splits(0)
val test = splits(1)

val trainer = new LogisticRegression()

val pipeline = new Pipeline().setStages(Array(assembler, trainer))

val model = pipeline.fit(train)
val results = model.transform(test)

val predictionAndLabels = results.select($"prediction",$"label").as[(Double, Double)].rdd
val metrics = new MulticlassMetrics(predictionAndLabels)

println("Confusion matrix:")
println(metrics.confusionMatrix)

metrics.accuracy

val error = 1 - metrics.accuracy

val totalTime = System.currentTimeMillis - time

