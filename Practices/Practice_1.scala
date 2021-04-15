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

    //4. Dada la variable mensaje = "Hola Luke yo soy tu padre!" utiliza slice para extraer la
    //   secuencia "Luke"

    val mensaje = "Hola Luke yo soy tu padre!"

    mensaje.slice (5,9)

    //5. Cual es la diferencia entre value y una variable en scala?

    //La variable val NO se puede modificar una vez que ha sido predefinido su valor.

    //La variable var SÍ se pueden sobreescribir sus valores, se puede modificar. 
    //(Únicamente se puede sobrescribir si el dato a ingresar es el mismo tipo de dato que el anterior)

    //6. Dada la tupla (2,4,5,1,2,3,3.1416,23) regresa el número 3.1416 

    val tupla = (2,4,5,1,2,3,3.1416,23)

    (tupla._7)