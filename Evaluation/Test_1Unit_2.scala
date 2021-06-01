//Importamos las librerías necesarias de MLlib Spark.

import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.ml.feature.StringIndexer 
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.ml.feature.VectorIndexer
import org.apache.spark.ml.feature.IndexToString

//Iniciamos una simple sesión de Spark con la variable "spark"

val spark = SparkSession.builder().getOrCreate()

//1. Cargar en un dataframe Iris.csv
/* Habilitaremos el 'header = true' para que spark infiera en los tipos de datos.
Limpiamos el dataset de datos nulos utilizando 'na.drop' */

val data = spark.read.option("header", "true").option("inferSchema","true")csv("iris.csv")
data.na.drop()

//2. ¿Cuáles son los nombres de las columnas?
//'columns' Nos arroja un arreglo de string de las columnas del dataset

data.columns

//3. ¿Cómo es el esquema?
// 'printSchema' nos muestra las columas del dataset y sus tipos de datos

data.printSchema()

//4. Imprime las primeras 5 columnas.

data.show(5)

//5. Usa el metodo describe () para aprender mas sobre los datos del DataFrame.
//'Describe' hace una analítica básica de los datos

data.describe().show()

//6. Haga la transformación pertinente para los datos categoricos los cuales serán
//nuestras etiquetas a clasificar.
/* 'VectorAssembler' combina todas las columnas del array en una sola columna de vector*/

val assembler = new VectorAssembler().setInputCols(Array("sepal_length","sepal_width","petal_length","petal_width")).setOutputCol("features")
val asmb = assembler.transform(data)
asmb.show()

// 'StringIndexer' Reune una columna de cadenas y los establece en índices
val labelIndexer = new StringIndexer().setInputCol("species").setOutputCol("indexedspecies").fit(data)
val lblInd = new StringIndexer().setInputCol("species").setOutputCol("indexedspecies")
val indx = lblInd.fit(data).transform(data)
indx.show()

println(s"Found species: ${labelIndexer.labels.mkString("[", ", ", "]")}")

// Se transforma el labelIndexer en el dataframe principal 'data' con las nuevas columnas renombrando la columna de los indices y lo transforma en un nuevo dataframe
val indexed = labelIndexer.transform(data).withColumnRenamed("indexedSpecies", "label")
val features = assembler.transform(indexed)
features.show()

/*'StringIndexer' ordena las columnas de la cadena de acuerdo con la frecuencia de ocurrencia.
Los datos de entrada serán "label" y los de salida serán "indexedSpecies" */
val featureIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedSpecies").fit(indexed)

//Asignamos un 60% de los datos para entrenamiento y un 40% para hacer pruebas.
//Asignamos una seed random para los datos.

val splits = features.randomSplit(Array(0.6, 0.4), seed = 1234L)
val train = splits(0)
val test = splits(1)

/*Aquí vamos a establecer nuestra red neuronal con 4 capas:
4 neuronas de entrada
2 capas ocultas de 5 y 4 neuronas
3 neuronas de salida
*/

val layers = Array[Int](4, 5, 4, 3)

//7. Construya el modelo de clasificación y explique su arquitectura.

/* Creamos el entrenador estableciendo los parametros correspondientes:
SetLayers para la estructura de las capas construidas anteriormente
Setblocksize para el tamano del bloque para los datos de entrada
El seed o la semiña con su respectivo peso
Y el maxiter como numero de iteraciones maximas que se realizaran
*/

val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setBlockSize(128).setSeed(1234L).setMaxIter(100)
//Inicio del entrenamiento
val model = trainer.fit(train) 
val result = model.transform(test) 

// MulticlassClassificationEvaluator recibe dos valores de entrada: prediction y label y como salida muestra la precision del test
val predictionAndLabels = result.select("prediction", "label")
val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")

//8. Imprima los resultados del modelo

println(s"\n\nTest set accuracy = ${evaluator.evaluate(predictionAndLabels)}")