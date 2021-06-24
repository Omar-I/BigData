//SVM
val time = System.currentTimeMillis

import org.apache.spark.ml.classification.LinearSVC
import org.apache.spark.ml.feature.{VectorAssembler, StringIndexer}
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.mllib.evaluation.MulticlassMetrics
import org.apache.log4j._

Logger.getLogger("org").setLevel(Level.ERROR)



val data = spark.read.option("header", "true").option("inferSchema","true").option("delimiter",";")csv("bank-full.csv")

data.na.drop()

val trainer = new LinearSVC().setMaxIter(10).setRegParam(0.1)

val indexer = new StringIndexer().setInputCol("loan").setOutputCol("indexedLabel").fit(data)
val indexed = indexer.transform(data).withColumnRenamed("indexedLabel", "label") 

val assembler = new VectorAssembler().setInputCols(Array("age", "balance", "day", "duration", "previous")).setOutputCol("features")
val features = assembler.transform(indexed)

val splits = features.randomSplit(Array(0.6, 0.4), seed = 12345)
val train = splits(0)
val test = splits(1)

val model = trainer.fit(train)
val results = model.transform(test)

val prediction = results.select($"prediction",$"label").as[(Double, Double)].rdd
val metrics = new MulticlassMetrics(prediction)

println("Confusion matrix:")
println(metrics.confusionMatrix)

metrics.accuracy

val err = 1 - metrics.accuracy

println(s"Coefficients: ${model.coefficients} Intercept: ${model.intercept}")

val totalTime = System.currentTimeMillis - time

