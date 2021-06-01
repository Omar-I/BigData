# Test 2
# Develop the following instructions in Spark with the Scala programming language, using only the documentation of the Machine Learning Mllib library from Spark and Google.

## 1.- Load into a dataframe Iris.csv and elaborate the necessary data cleaning to be processed by the Machine Learning algorithm corresponding to multilayer perceptron  

To start, the first thing we need to do is import all libraries including the "SparkSession" library and create a Spark variable then Load the file "iris CSV"
``` scala
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.ml.feature.StringIndexer 
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.ml.feature.VectorIndexer
import org.apache.spark.ml.feature.IndexToString

val spark = SparkSession.builder().getOrCreate()

/* Habilitaremos el 'header = true' para que spark infiera en los tipos de datos.
Limpiamos el dataset de datos nulos utilizando 'na.drop' */

val data = spark.read.option("header", "true").option("inferSchema","true")csv("iris.csv")
data.na.drop()
```

## 2.- What are the names of the columns?
To show the column names we use "df.column"
``` scala
df.columns
```
## 3.- How is the schema like?
The function "printSchema()" will show us the info we require
``` scala
df.printSchema()
```
## 4.- Print the first 5 columns
To show the first 5 columns we use the function select.show with the parameter 5
``` scala
data.show(5)
```
## 5.- Use "describe()" method to learn about the dataframe
We call the function "describe().show()"

``` scala
df.describe().show()
```
## 6.- Make the pertinent transformation for the categorical data which will be our labels to be classified. 
to transform the data we use the 'VectorAssembler' method to combine all the columns of the array into a single vector column
``` scala
val assembler = new VectorAssembler().setInputCols(Array("sepal_length","sepal_width","petal_length","petal_width")).setOutputCol("features")
val asmb = assembler.transform(data)
asmb.show()
```
With the 'StringIndexer' method we gather a column of strings and set them as indexes and then we print the found values
``` scala
val labelIndexer = new StringIndexer().setInputCol("species").setOutputCol("indexedspecies").fit(data)
val lblInd = new StringIndexer().setInputCol("species").setOutputCol("indexedspecies")
val indx = lblInd.fit(data).transform(data)
indx.show()

println(s"Found species: ${labelIndexer.labels.mkString("[", ", ", "]")}")
```
Here we create a new dataframe based on the data of the main dataframe 'data' renaming the column of the indexes
``` scala
val indexed = labelIndexer.transform(data).withColumnRenamed("indexedSpecies", "label")
val features = assembler.transform(indexed)
features.show()
```
With the 'StringIndexer' method we sort the columns of the string according to the frequency of occurrence. The input data will be "label" and the output data will be "indexedSpecies"
``` scala
val featureIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedSpecies").fit(indexed)
```
We now allocate 60% of the data for training and 40% for testing. We also assign a random seed for the data.
``` scala
val splits = features.randomSplit(Array(0.6, 0.4), seed = 1234L)
val train = splits(0)
val test = splits(1)
```
Here we establish our neural network with 4 layers:  
- 1 input layer with 4 neurons 
- 2 hidden layers of 5 and 4 neurons respectively  
- 1 output layer with 3 neurons  
``` scala
val layers = Array[Int](4, 5, 4, 3)
```
## 7.- Build the classification model and explain its architecture.
Now we create the trainer setting the corresponding parameters:  
- SetLayers for the structure of the previously constructed layers  
- Setblocksize for the block size for the input data
- The seed or the seed with its respective weight
- And the maxiter as the number of maximum iterations to be performed
``` scala
val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setBlockSize(128).setSeed(1234L).setMaxIter(100)     

//Inicio del entrenamiento
val model = trainer.fit(train) 
val result = model.transform(test) 
```
MulticlassClassificationEvaluator receives two input values: prediction and label and as output it shows the precision of the test
``` scala
val predictionAndLabels = result.select("prediction", "label")
val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")
``` 
## 8.- Print the model results
Finally we can print the results of the model based on the precision obtained
``` scala
println(s"\n\nTest set accuracy = ${evaluator.evaluate(predictionAndLabels)}")
```