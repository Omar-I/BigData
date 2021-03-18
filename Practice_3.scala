//Algoritmo 1

def fibonacci(n:Int): Int = {
    if (n<2){
        return n
    }
    else{
        return (fibonacci(n-1) + fibonacci(n-2))
    }
}

println(fibonacci(2))
println(fibonacci(5))
println(fibonacci(15))
println(fibonacci(17))

//Algoritmo 2

var p: Double = 0
var j: Double = 0
 
def Algoritmo2(n: Double): Double = {
 
    if (n < 2)
        return n
    else {
        p = ((1 + Math.sqrt(5)) / 2)
        j = ((Math.pow(p, n) - Math.pow((1 - p), n)) / Math.sqrt(5))
        return j
    }
}
 
Algoritmo2(15)

//Algoritmo 3

var a: Int = 0
var b: Int = 0
var c: Int = 0

def fibonacci3(n3:Int): Int = {
    
    b = 1
    
    for(k <- Range(0,n3)){
        c = b + a 
        a = b
        b = c
    }
    return a
}

println(fibonacci3(17))