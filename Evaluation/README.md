# Test 2
# Develop the following instructions in Spark with the Scala programming language.   

## 1.- Import a simple Spark session. 

To start, the first thing we need to do is import the sparksession library 
``` scala
import org.apache.spark.sql.SparkSession
```

## 2.- Use the lines of code to minimize errors.
Log4j is a message log library which serves to record a certain transaction that happens at runtime. By default log4j has 8 priority levels for messages and one of them is ERROR which is used for error messages that you want to save and is a type of event that affects
to the program but lets it keep running
``` scala
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)
```
## 3.- Create an instance of the Spark session
``` scala
val spark = SparkSession.builder().getOrCreate()
```
## 4.- Import the K Means library for the clustering algorithm.
The following is to import the k means library to be able to use the kmeans algorithm which is a grouping algorithm which allows us to group data in a predefined number of groups
``` scala
import org.apache.spark.ml.clustering.KMeans
```
## 5.- Loads the Wholesale Customers Data dataset
here we create a Spark variable to Load the CSV file
``` scala
val data = spark.read.option("header", "true").option("inferSchema","true")csv("Wholesale customers data.csv")
```
## 6.- Select the following columns: Fresh, Milk, Grocery, Frozen, Detergents Paper, Delicatessen and call this set feature_data
We use the select function to select the columns that we need from the dataset
``` scala
val feature_data = data.select("Fresh", "Milk", "Grocery", "Frozen", "Detergents_Paper", "Delicassen")
```
## 7.- Import Vector Assembler and Vector
``` scala
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors
```
## 8.- Create a new Vector Assembler object for the feature columns as an input set, remembering that there are no labels
Here we use the 'VectorAssembler' method to combine all the columns of the array into a single vector column
``` scala
val assembler = new VectorAssembler().setInputCols(Array("Fresh", "Milk", "Grocery", "Frozen", "Detergents_Paper", "Delicassen")).setOutputCol("features")
```
## 9.- Use the assembler object to transform feature data
Here we transform the data with the method transform
``` scala
val featuredataset = assembler.transform(feature_data)
featuredataset.show(5)
```
## 10.- Create a K Means model with K = 3
Set the number of clusters to create and Set the random seed for cluster initialization
``` scala
val kmeans = new KMeans().setK(3).setSeed(1L)
val model = kmeans.fit(featuredataset)
```
## 11.- Evaluate the groups using Within Set Sum of Squared Errors WSSSE and print the centroids.
We then compute Within Set Sum of Squared Error (WSSSE) showing the result
``` scala
val WSSSE = model.computeCost(featuredataset)
println(s"Within set sum of Squared Errors = $WSSSE")

println("Clusters centers: ")
model.clusterCenters.foreach(println)
```


