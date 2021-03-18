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

//Algoritmo 4
var a: Int = 0
var b: Int = 0

def Algoritmo4(n4: Int): Int = {
    a = 0
    b = 1

    for (k <- Range(0, n4)){
        b = b + a
        a = b - a
    }

    return a
}

Algoritmo4(17)

// Algortimo 5

def Algoritmo5(n: Int): Int = {
    if (n < 2)
        return n
    else {
        var vector = new Array[Int](n + 1)
        vector(0) = 0
        vector(1) = 1
        for (k <- Range(2, n + 1)){
            vector(k) = vector(k -  1) + vector(k - 2)
        }
        return vector(n)
    }
}

Algoritmo5(15)

// Algoritmo 6

def fibonacci6 (n : Int) : Double = {
     if (n <= 0) {
     return 0
     }
     var i = n-1
     var auxOne = 0.0
     var auxTwo = 1.0
     var ab = Array(auxTwo,auxOne)
     var cd = Array(auxOne,auxTwo)
     while (i>0)
     {
     if (i % 2 != 0)
     {
     auxOne = cd(1) * ab(1) + cd(0) * ab(0)
     auxTwo = cd(1) * (ab(1)+ab(0)) + cd(0)*ab(1)
     ab(0) = auxOne
     ab(1) = auxTwo
     }
     auxOne = (math.pow(cd(0),2)) + (math.pow(cd(1),2))
     auxTwo = cd(1)* (2*cd(0) + cd(1))
     cd(0) = auxOne
     cd(1) = auxTwo
     i = i/2
     }
     return (ab(0) + ab(1))
}

fibonacci6(17)
