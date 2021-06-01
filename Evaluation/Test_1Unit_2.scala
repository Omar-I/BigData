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