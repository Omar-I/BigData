//1. Comienza una simple sesión Spark.

import org.apache.spark.sql.SparkSession

val spar = SparkSession.builder().getOrCreate()

//2. Cargue el archivo Netflix Stock CSV, haga que Spark infiera los tipos de datos.

val df = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016.csv")

df.printSchema()

df.show()

// 3. ¿Cuáles son los nombres de las columnas?

df.columns

//4. ¿Cómo es el esquema?

df.printSchema()

//5. Imprime las primeras 5 columnas.

df.select("Date", "Open", "High", "Low", "Close").show(5)

//6. Usa describe () para aprender sobre el DataFrame.

df.describe().show()

//7. Crea un nuevo dataframe con una columna nueva llamada “HV Ratio” que es la
//relación entre el precio de la columna “High” frente a la columna “Volume” de
//acciones negociadas por un día. (Hint: Es una operación de columnas).

var hvRatio = df.withColumn("HV Ratio", df("High")/df("Volume"))
hvRatio.show()

//8. ¿Qué día tuvo el pico mas alto en la columna “Close”?

val dfdias = df.withColumn("Dia", dayofmonth(df("Date"))) //Se crea una nueva columna para el dataframe para manipular los dias
val dias = dfdias.groupBy("Dia").max() //Agrupamiento para el dataframe de todos los dias
dias.select($"Dia", $"max(Close)").sort(desc("max(Close)")).show(1) //Ordenamiento de mayor a menor mostrando el primer registro con el valor mas alto