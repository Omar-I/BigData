# Test 1

# Answer the following questions with Spark DataFrames using the “CSV” file Netflix_2011_2016.csv.

## 1.- Start a simple Spark session.
To start, the first thing we need to do is import the "SparkSession" library and create a Spark variable

``` scala
//1. Comienza una simple sesión Spark.

import org.apache.spark.sql.SparkSession
val spar = SparkSession.builder().getOrCreate()
``` 
## 2.- Load the file "Netflix Stock CSV", make spark infer the data types
To load the csv file we must use "spark.read" and to infer the data types we use ".option (" inferSchema, "true") ", then we use" csv "and the file path

``` scala
//2. Cargue el archivo Netflix Stock CSV, haga que Spark infiera los tipos de datos.

val df = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016.csv")
```
## 3.- What are the names of the columns?
To show the column names we use "df.column"

``` scala
//3. ¿Cuáles son los nombres de las columnas?

df.columns
```
## 4.- How is the schema like?
The function "printSchema()" will show us the info we require

``` scala
//4. ¿Cómo es el esquema?

df.printSchema()
```
## 5.- Print the first 5 columns
To show the first 5 columns we use the function select.show with the parameter 5

``` scala
//5. Imprime las primeras 5 columnas.

df.select("Date", "Open", "High", "Low", "Close").show(5)
```
## 6.- Use "describe()" to learn about the dataframe
We call the function "describe().show()"

``` scala
//6. Usa describe () para aprender sobre el DataFrame.

df.describe().show()
```
## 7.- Create a new dataframe with a new column called “HV Ratio” which is the relationship between the price of the column "High" versus the column "Volume" of shares traded for one day. (Hint: It is a column operation).
With "withColumn", the parameters we need are the name of the new column and the operation, first we put the name and for the values we divided the values of the column "High" over the values of "Volume" and with de function .show() we can see the new dataframe.

``` scala
//7. Crea un nuevo dataframe con una columna nueva llamada “HV Ratio” que es la
//relación entre el precio de la columna “High” frente a la columna “Volume” de
//acciones negociadas por un día. (Hint: Es una operación de columnas).

var hvRatio = df.withColumn("HV Ratio", df("High")/df("Volume"))
hvRatio.show()
```

## 8.- Which day had the most high peak in the column "Close"? 
First of all, we need the day that had the peak we are looking for, so we added a new column to our dataframe with this

``` scala
//8. ¿Qué día tuvo el pico mas alto en la columna “Close”?

val dfdias = df.withColumn("Dia", dayofmonth(df("Date"))) //Se crea una nueva columna para el dataframe para manipular los dias
```
The next step was to use a groupBy to order them with by maximum values
```scala
val dias = dfdias.groupBy("Dia").max() //Agrupamiento para el dataframe de todos los dias
```
And the last step was to show it, we used a select with a sort by descendent showing the first value.
```scala
dias.select($"Dia", $"max(Close)").sort(desc("max(Close)")).show(1) //Ordenamiento de mayor a menor mostrando el primer registro con el valor mas alto
```
## 9.- Write in your own words in a comment of your code. Which is the meaning of the Close column “Close”?

``` scala
//9. Escribe con tus propias palabras en un comentario de tu código. ¿Cuál es el
//significado de la columna Cerrar “Close”?

//La columna Close se refiere al precio de la acción que tuvo al final de cerrar con el dia

```
## 10.- What is the max and the min in the Volume column
We use the select function to show the two columns at once with the maximum and minimum value with the commands max and min

``` scala
//10. ¿Cuál es el máximo y mínimo de la columna “Volume”?

df.select(max("Volume"), min("Volume")).show()
```
## 11.- With Scala / Spark $ syntax answer the following:
◦ Hint: Basically very similar to the dates session, you will have to create another
dataframe to answer some of the questions.   
### a. How many days was the “Close” column less than $ 600?  
We use a filter and count function with the "<" sign to find the amount of days 
```scala
df.filter($"Close" < 600).count()
```
### b. What percentage of the time was the “High” column greater than $ 500?  
We use the filter and count function in the same way as the previous example and
then we create our variable that contains the percentage and we simply divide the number of days by the total of days and then multiply by 100 to get the percentage.
```scala
var High500: Double = df.filter($"High" > 500).count()
(High500 / df.count())*100
```
### c. What is the Pearson correlation between column "High" and column "Volume"? 
We use the selection function and the "corr" function that will automatically give us the coefficient
```scala
df.select(corr("High","Volume")).show()
``` 
### d. What is the maximum in the “High” column per year? 
Just like we did at the exercise #8 we need to add a year column, then we get the max values with a GroupBy and finally we use a select to show the results
```scala
val dfyear = df.withColumn("Year", year(df("Date")))
val year = dfyear.groupBy("Year").max()
year.select($"Year", $"max(High)").show()
``` 
### e. What is the “Close” column average for each calendar month?  
Same process that we did before, we just change the year for a month but with the the function mean to get the average
```scala
val dfmes = df.withColumn("Mes", month(df("Date")))
val mes = dfmes.groupBy("Mes").mean()
mes.select($"Mes", $"avg(Close)").show()
```

