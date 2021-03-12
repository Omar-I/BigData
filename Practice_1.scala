// Assessment 1/Practica 1

  
    //1. Desarrollar un algoritmo en scala que calcule el radio de un círculo
    
    val Pi = 3.1416
    var Diametro = 3.18
    var Circunferencia = 10
    var Area = 8
    
    //If we know the "circumference"
    var r = (Circunferencia / (Pi*2))
    
    //If we know the "Diameter"
    var r = Diametro / 2
    
    //If we know the "Area"
    var r = scala.math.sqrt(Area/Pi)
    
    //2. Desarrollar un algoritmo en scala que me diga si un número es primo
    var num: Int = 7 
    var prime: Boolean = true
    for(value <- Range(2,num))
    {
        if ((num % value) == 0){
            prime = false
        }
    }
    if (prime == true){
        println("Prime")
    }else{
        println("Not prime")
    } 
    
    
    //3. Dada la variable bird = "tweet", utiliza interpolación de string para
    //   imprimir "Estoy escribiendo un tweet"
    
    val bird = "tweet"
    printf(s"Estoy escribiendo un $bird")
