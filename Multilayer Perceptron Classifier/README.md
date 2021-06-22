# Multilayer perceptron classifier
## ¿Qué son los perceptrones multicapa?


El perceptrón es muy útil para clasificar conjuntos de datos que son linealmente separables. Se encuentran con serias limitaciones con conjuntos de datos que no se ajustan a este patrón como se descubrió con el problema XOR. El problema XOR muestra que para cualquier clasificación de cuatro puntos existe un conjunto que no es separable linealmente.

MultiLayer Perceptron (MLP) rompe esta restricción y clasifica conjuntos de datos que no son separables linealmente. Lo hacen utilizando una arquitectura más robusta y compleja para aprender modelos de regresión y clasificación para conjuntos de datos difíciles.

## ¿Cómo funciona?

El perceptrón multicapa esta compuesto por una capa de entrada, una capa de salida y n capas ocultas entremedias.
Se caracteriza por tener salidas disjuntas pero relacionadas entre sí, de tal manera que la salida de una neurona es la entrada de la siguiente.


En el perceptrón multicapa se pueden diferenciar una 2 fases:

- **Propagación** en la que se calcula el resultado de salida de la red desde los valores de entrada hacia delante.
  
- **Aprendizaje** en la que los errores obtenidos a la salida del perceptrón se van propagando hacia atrás (backpropagation) con el objetivo de modificar los pesos de las conexiones para que el valor estimado de la red se asemeje cada vez más al real, este aproximación se realiza mediante la función gradriente del error.

## Arquitectura

Las capas pueden clasificarse en tres tipos:

- **Capa de entrada**: Constituida por aquellas neuronas que introducen los patrones de entrada en la red. En estas neuronas no se produce procesamiento.  Las neuronas de la capa de entrada no actuan como neuronas propiamente dichas, sino que se encargan unicamente de recibir las señales o patrones del exterior y propagar dichas señales a todas las neuronas de la siguiente capa
  
- **Capas ocultas**: Formada por aquellas neuronas cuyas entradas provienen de capas anteriores y cuyas salidas pasan a neuronas de capas posteriores. Las neuronas de las capas ocultas realizan un procesamiento no lineal de los patrones recibidos.

  
- **Capa de salida**: Neuronas cuyos valores de salida se corresponden con las salidas de toda la red.  La ultima capa actua como salida de la red, proporcionando al exterior la respuesta de la red para cada uno de los patrones de entrada.

## MultilayerPerceptronClassifier

El clasificador de perceptrones multicapa (MLPC) es un clasificador basado en la red neuronal artificial feedforward,lo que significa que los datos se transmiten desde la capa de entrada a la capa de salida en la dirección de avance. MLPC consta de múltiples capas de nodos. Cada capa está completamente conectada a la siguiente capa de la red. Los nodos de la capa de entrada representan los datos de entrada. Todos los demás nodos asignan entradas a salidas mediante una combinación lineal de las entradas con los pesos w del nodo y el sesgo b y aplicando una función de activación.

# Definición y parámetros de la clase MLlib

El MultilayerPerceptronClassifier acepta varios parámetros diferentes, para cualquier algoritmo de aprendizaje automático, existen varios parámetros llamados "hiperparámetros", ajustarlos con precisión puede ayudar a aumentar la precisión del modelo. Para MultilayerPerceptronClassifier, los siguientes parámetros sirven como hiperparámetros:


- **Tol(tol)**: es la tolerancia de convergencia que describe los conjuntos de pesos que comienzan a converger hacia las salidas que darían los resultados correctos. El valor predeterminado es 1e-06. Los valores más pequeños producen resultados más precisos, mientras que los valores altos pueden provocar un sobreajuste.

- **Semilla(seed)**: es el valor de semilla aleatorio con el que se generarían números aleatorios. Proporcionar este valor asegura que se generen números verdaderamente aleatorios. Este parámetro asegura que se generen los mismos valores aleatorios cada vez que se prueba el algoritmo.

- **Capas(layers)**: este parámetro acepta una lista de números enteros que representan la capa de entrada, oculta y de salida. El formato es el siguiente [780,200,100,10]   
80 representa el número de valores de entrada.  
200 y 100 representan las capas ocultas.  
10 representan las capas de salida. 
Más capas ocultas harán que la red neuronal sea más compleja, pero no garantizan una mayor precisión.

- **Tamaño de bloque(blockSize)**: es el número de entradas que se incluirán durante cada iteración. P.ej. blockSize = 100 significa que se incluirán 100 entradas en una iteración del algoritmo. El valor predeterminado es 128. Un tamaño de bloque más pequeño mejora la precisión a expensas de un tiempo de aprendizaje prolongado y viceversa.

- **Tamaño de paso(stepSize)**: esta es la tasa de aprendizaje del algoritmo y generalmente está entre 0.0 y 1.0. Básicamente, se trata de la rapidez o la lentitud con la que aprende el modelo. El valor predeterminado es 0.03. Un valor más pequeño puede conducir a una mayor precisión, mientras que los valores más altos pueden provocar un ajuste excesivo.

- **Solucionador(solver)**: este parámetro especifica qué rutina de optimización debe usarse para encontrar el mínimo local, p. descenso de gradiente. El valor predeterminado es l-bfgs.
(L-BFGS: Se trata de un método que hace un uso limitado de la memoria (usa mucha menos memoria que otros algoritmos para el mismo problema)



### Video complementario:
https://youtu.be/pbQtQ2Bdzf8


### Referencias:
https://spark.apache.org/docs/2.4.7/ml-classification-regression.html#multilayer-perceptron-classifier

https://medium.com/analytics-vidhyaspark-mllibs-multilayer-perceptron-classifier-mlpc-hands-on-32ac4014eee9

https://dzone.com/articles/deep-learning-via-multilayer-perceptron-classifier#

https://es.wikipedia.org/wiki/L-BFGS