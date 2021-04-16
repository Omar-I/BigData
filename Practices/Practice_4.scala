//In this function, a list made up of integers numbers is declared and it tells us if it is even or odd
def listEvens(list:List[Int]): String ={
    for(n <- list){ 
        if(n%2==0){ //Operator to know if it is even or odd
            println(s"$n is even")
        }else{
            println(s"$n is odd")
        }
    }
    return "Done"
}

val l = List(1,2,3,4,5,6,7,8) //These are the lists with the numbers that will be evaluated in the function to know if a number is even or odd prime in the list
val l2 = List(4,3,22,55,7,8)
listEvens(l) //Printing the lists
listEvens(l2)

//In this function, a list with integers numbers are evaluated to know the luck
def afortunado(list:List[Int]): Int={
    var res=0 //The result initialize in zero
    for(n <- list){
        if(n==7){ 
            res = res + 14 //If the number is equal to 7, +14 will be added to the final result
        }else{
            res = res + n //If not, only the same number evaluated will be added as amount to the final result
        }
    }
    return res //Returns the value
}

val af= List(1,7,7) //The list that will be evaluated
println(afortunado(af))

//In this function, a list with integers numbers are evaluated returning a boolean value
def balance(list:List[Int]): Boolean={
    var primera = 0 //Initialize vars
    var segunda = 0

    segunda = list.sum //Returns the sum of the entire List and is assigned to the second variable

    for(i <- Range(0,list.length)){ //Iteration range
        primera = primera + list(i)
        segunda = segunda - list(i)

        if(primera == segunda){ //if any of the values ​​in the same position are equal, it returns a true, and if not, it returns a false.
            return true
        }
    }
    return false 
}

val bl = List(3,2,1) //The lists that will be evaluated
val bl2 = List(2,3,3,2)
val bl3 = List(10,30,90)

balance(bl)
balance(bl2)
balance(bl3)

////In this function, a list with integers numbers are evaluated returning a boolean value
def palindromo(palabra:String):Boolean ={ 
    return (palabra == palabra.reverse) //Check if each of the words backwards is the same as the normal written word returning a boolean value
}

val palabra = "OSO" //Words that will be evaluated
val palabra2 = "ANNA"
val palabra3 = "JUAN"

println(palindromo(palabra))
println(palindromo(palabra2))
println(palindromo(palabra3))