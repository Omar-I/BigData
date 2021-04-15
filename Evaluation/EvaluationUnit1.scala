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

//9. Escribe con tus propias palabras en un comentario de tu código. ¿Cuál es el
//significado de la columna Cerrar “Close”?

//La columna Close se refiere al precio de la acción que tuvo al final de cerrar con el dia

//10. ¿Cuál es el máximo y mínimo de la columna “Volume”?
df.select(max("Volume"), min("Volume")).show()

//11.Con Sintaxis Scala/Spark $ conteste los siguiente:
/*◦ Hint: Basicamente muy parecido a la session de dates, tendran que crear otro
dataframe para contestar algunos de los incisos.*/

//a. ¿Cuántos días fue la columna “Close” inferior a $ 600?

df.filter($"Close" < 600).count()

//b. ¿Qué porcentaje del tiempo fue la columna “High” mayor que $ 500?

var High500: Double = df.filter($"High" > 500).count()
(High500 / df.count())*100

//c. ¿Cuál es la correlación de Pearson entre columna “High” y la columna “Volumen”?

df.select(corr("High","Volume")).show()

//d. ¿Cuál es el máximo de la columna “High” por año?

val dfyear = df.withColumn("Year", year(df("Date")))
val year = dfyear.groupBy("Year").max()
year.select($"Year", $"max(High)").show()

//e. ¿Cuál es el promedio de columna “Close” para cada mes del calendario?

val dfmes = df.withColumn("Mes", month(df("Date")))
val mes = dfmes.groupBy("Mes").mean()
mes.select($"Mes", $"avg(Close)").show()