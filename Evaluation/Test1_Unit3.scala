//Importar una simple sesión Spark.
import org.apache.spark.sql.SparkSession

//Utilice las lineas de código para minimizar errores
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

//Cree una instancia de la sesión Spark
val spark = SparkSession.builder().getOrCreate()

//Importar la librería de Kmeans para el algoritmo de agrupamiento.
import org.apache.spark.ml.clustering.KMeans

//Carga el dataset de Wholesale Customers Data
val data = spark.read.option("header", "true").option("inferSchema","true")csv("Wholesale customers data.csv")

//Seleccione las siguientes columnas: Fresh, Milk, Grocery, Frozen, Detergents_Paper, Delicassen y llamar a este conjunto feature_data
val feature_data = data.select("Fresh", "Milk", "Grocery", "Frozen", "Detergents_Paper", "Delicassen")

//Importar Vector Assembler y Vector
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors

//Crea un nuevo objeto Vector Assembler para las columnas de caracteristicas como un conjunto de entrada, recordando que no hay etiquetas
val assembler = new VectorAssembler().setInputCols(Array("Fresh", "Milk", "Grocery", "Frozen", "Detergents_Paper", "Delicassen")).setOutputCol("features")

//Utilice el objeto assembler para transformar feature_data

val featuredataset = assembler.transform(feature_data)
featuredataset.show(5)

// Crear un modelo Kmeans con K=3

val kmeans = new KMeans().setK(3).setSeed(1L)
val model = kmeans.fit(featuredataset)

//Evalúe los grupos utilizando Within Set SUm of Squared Errors WSSEE e imprima los centroides

val WSSSE = model.computeCost(featuredataset)
println(s"Within set sum of Squared Errors = $WSSSE")

println("Cluster Centers: ")
model.clusterCenters.foreach(println)