<div align="center">

**TECNOLÓGICO NACIONAL DE MÉXICO**

INSTITUTO TECNOLÓGICO DE TIJUANA

SUBDIRECCIÓN ACADÉMICA
 
DEPARTAMENTO DE SISTEMAS Y COMPUTACIÓN
 
SEMESTRE FEBRERO – JUNIO 2021

INGENIERÍA EN SISTEMAS COMPUTACIONALES

 

JOSÉ CHRISTIAN ROMERO HERNÁNDEZ

DATOS MASIVOS   
BDD-1704, L - V 18:00 - 19:00 


**FINAL PROJECT**


**MEMBERS**

QUINTERO RENTERIA OMAR ISRAEL - 16210791

DIAZ URIAS JORGE DAVID - 17211516


Tijuana, Baja California, al 23 de Junio de 2021.
 
</div>

# Index

### [Introduction](#introduccion)
### [Theoretical Framework](#marco_teorico)

 - [SVM](#svm)
 - [DTC](#dtc)
 - [LR](#lr)
 - [MLPC](#mlpc)
 
### [Implementation](#implementacion)
### [Results](#resultados)
### [Conclusion](#conclusiones)
### [References](#referencias)


## Introduction <a name="introduccion"></a>
<div align="justify">
In this document, a comparison of different supervised machine learning algorithms will be shown, which are defined by the use of a set of labels for their training, classifying data and predicting results with precision, as well as the evaluation of the performance results of each one with the aim of comparing their differences.The data set used for the classification and evaluation of the data was used from the following source:   

https://archive.ics.uci.edu/ml/datasets/Bank+Marketing

</div>

## Theoretical Framework <a name="marco_teorico"></a>

### SVM - Support Vector Machine <a name="svm"></a>
<div align="justify">
SVM is a supervised learning technique that is trained to classify different categories of data from various disciplines. These have been used for two-class classification problems and are applicable in linear and nonlinear data classification tasks. SVM creates one hyperplane or multiple hyperplanes in a high-dimensional space, and the best hyperplane in them is the one that optimally divides the data into different classes with the greatest separation between the classes. A nonlinear classifier uses various kernel functions to estimate margins.     

The primary goal of these kernel functions (ie, linear, polynomial, radial-based, and sigmoid) is to maximize the margins between hyperplanes. Recently, researchers have developed many very promising applications due to the growing interest in SVMs. SVM has been used extensively in image processing and pattern recognition applications.    
  
Support vector machines are a machine learning technique that finds the best possible separation between classes. With two dimensions it is easy to understand what you are doing. Typically, machine learning problems have many dimensions. So instead of finding the optimal line, the SVM finds the hyperplane that maximizes the separation margin between classes.

![imagen](https://github.com/Omar-I/BigData/blob/Unit_4/Images/SVM.jpg)

It's called "machine" in Spanish because of the "machine" learning part. The support vectors are the points that define the maximum margin of separation of the hyperplane that separates the classes. They are called vectors, instead of points, because these "points" have as many elements as the dimensions of our input space. That is, these multi-dimensional points are represented with an n-dimensional vector.

![imagen](https://github.com/Omar-I/BigData/blob/Unit_4/Images/SVM2.jpg) 

Learning SVM is one of the many methods of Machine Learning. Compared to the other ML methods, SVM is very powerful at recognizing subtle patterns in complex data sets. SVM can be used to recognize handwriting, recognize fraudulent credit cards, identify a speaker, and detect faces. Cancer is a genetic disease in which patterns of genomic features or patterns of feature function may represent cancer subtypes, prognosis of outcomes, prediction of drug benefit, drivers of tumorigenesis, or a biological process. tumor specific. Therefore, SVM Artificial Intelligence can help us recognize these patterns in a variety of applications.

</div>

### DTC - Decision Tree Classifier <a name="dtc"></a>
<div align="justify">
A normal tree includes roots, branches, and leaves. The same structure is followed in the decision tree. Contains root node, branches, and leaf nodes. The test of an attribute is in each internal node, the result of the test is in branch and class as a result, the label is in the leaf node. A root node is the parent of all nodes and, as the name suggests, is the highest node in the Tree. A decision tree is a tree where each node shows a characteristic (attribute), each link (branch) shows a decision (rule), and each leaf shows a result (categorical or continues value). As decision trees mimic human-level thinking, it is very easy to obtain the data and generate good interpretations. The idea is to create a tree like this for all the data and process a single result on each sheet.  
   
![imagen](https://github.com/Omar-I/BigData/blob/Unit_4/Images/DTC.jpg)

The decision tree makes all possible alternatives explicit and tracks each alternative to its conclusion in a single view, to facilitate comparison between the different alternatives. Transparent by nature is one of the best advantages of
Decision tree. Another main advantage is the possibility to select the largest quantity
biased characteristic and understandable nature. It is also easy to classify and easily interpret. It is also used for both continuous and discrete data sets.
The variable display and feature section are good enough at
decision tree. Speaking of performance, nonlinear does not affect any of the decision tree parameters.

Decision tree algorithms are used to divide the attributes to be tested. at any node to determine if the division is "better" in individual classes. The result divided in each branch is PURE as possible, for that the division criteria must be identical.


How does the decision tree algorithm work?
The basic idea behind any decision tree algorithm is as follows:

1- Select the best attribute using Attribute Selection Measures (ASM) to split the records.  
2- Convert that attribute into a decision node and divide the data set into smaller subsets.   
3- Start building the tree by repeating this process recursively for each node until one of the conditions matches:  
- All tuples belong to the same attribute value.
- No more attributes left.
- There are no more instances.

![imagen](https://github.com/Omar-I/BigData/blob/Unit_4/Images/DTC2.jpg)
</div>


### LR - Logistic Regression <a name="lr"></a>
<div align="justify">
Logistic regression is a statistical machine learning algorithm that classifies the data considering the outcome variables at the extremes and tries to make a logarithmic line that distinguishes them. It is presented as the statistical method of choice to analyze the effects of the independent variables on a binary dependent variable in terms of the probability of being in one of its two categories compared to the other.     


Logistic regression can be classified as:   

binomial: the target variable can only have 2 possible types: "0" or "1" which can represent "win" vs. "loss", "pass" vs. "fail", "dead" vs. "alive", etc.
multinomial: the target variable can have 3 or more possible types that are not ordered (that is, the types are not quantitatively important) such as "disease A" versus "disease B" versus "disease C".
ordinal: deals with target variables with ordered categories. For example, a test score can be classified as: "very poor", "poor", "good", "very good". Here, each category can be given a score such as 0, 1, 2, 3.

![imagen](https://github.com/Omar-I/BigData/blob/Unit_4/Images/LR.jpg)

The logistic term is derived from the cost function (logistic function) which is a type of sigmoid function known for its characteristic S-shaped curve. A logistic regression model predicts probability values that are assigned to two (binary classification) or plus (multiclass classification) classes.
</div>

### MLPC - Multilayer Perceptron Classifier <a name="mlpc"></a>
<div align="justify">
The multilayer perceptron is made up of an input layer, an output layer, and n hidden layers in between. It is characterized by having disjoint but related outputs, in such a way that the output of one neuron is the input of the next.    

In the multilayer perceptron they can be differentiated into 2 phases:
   
Propagation in which the output result of the network is calculated from the input values forward.

Learning in which the errors obtained at the output of the perceptron are propagated backwards (backpropagation) with the aim of modifying the weights of the connections so that the estimated value of the network increasingly resembles the real one, this approach is carried out using the gradient function of the error.


![imagen](https://github.com/Omar-I/BigData/blob/Unit_4/Images/MLPC.jpg)

Architecture  
Layers can be classified into three types:

Input layer: Made up of those neurons that introduce the input patterns in the network. No processing occurs in these neurons. The neurons of the input layer do not act as neurons themselves, but are only responsible for receiving signals or patterns from the outside and propagating these signals to all the neurons of the next layer

Hidden layers: Formed by those neurons whose inputs come from previous layers and whose outputs go to neurons from later layers. Neurons in hidden layers perform non-linear processing of received patterns.

Output layer: Neurons whose output values ​​correspond to the outputs of the entire network. The last layer acts as the output of the network, providing the network's response for each of the input patterns to the outside.

MultilayerPerceptronClassifier  
The multilayer perceptron classifier (MLPC) is a classifier based on the feedforward artificial neural network, which means that data is transmitted from the input layer to the output layer in the forward direction. MLPC consists of multiple layers of nodes. Each layer is fully connected to the next layer in the network. The nodes in the input layer represent the input data. All other nodes map inputs to outputs by linearly combining the inputs with the node weights w and bias b and applying an activation function.
</div>

## Implementation <a name="implementacion"></a>

<div align="justify">In this project we used two technologies   

- Scala     
  
  Scala is not a Java extension, but it is fully interoperable with it. During compilation, the Scala file is translated into Java bytecode and runs in JVM (Java Virtual Machine).

  Scala was designed to be functional and object-oriented. It is a pure object-oriented language in the sense that every value is an object and a functional language in the sense that every function is a value.

  This technology that was used for the development of the code and the reason for using Scala in this project is due to its amazing concurrency support, which is the key in parallelizing processing of the large data sets.

- Spark    
  Apache Spark is a unified analytics engine for large-scale data processing. It provides high-level APIs in Java, Scala, Python and R, and an optimized engine that supports general execution graphs. It also supports a rich set of higher-level tools including Spark SQL for SQL and structured data processing, MLlib for machine learning, GraphX for graph processing, and Structured Streaming for incremental computation and stream processing.

  The reason for using spark in this case is because it is compatible with the Java virtual machine, this means that we can reuse Java libraries in Scala applications, having compatibility with the Java code.



</div>
 
## Results <a name="resultados"></a>

<table class="egt" border="0">
<tr>
  <td> Algorithm </td>
    <td>Time (s)</td>
    <td>Accuracy %</td>
    <td>Error %</td>
  </tr>
  <tr>
    <td>SVM</td>
    <td>18.73</td>
    <td>84.26</td>
    <td>15.73</td>
  </tr>
    <tr>
    <td>DTC</td>
    <td>18.11</td>
    <td>84.13</td>
    <td>15.86</td>
  </tr>
    <tr>
    <td>LR</td>
    <td>15.35</td>
    <td>84.36</td>
    <td>15.63</td>
  </tr>
   <tr>
    <td>MLPC</td>
    <td>16.80</td>
    <td>83.96</td>
    <td>16.03</td>
  </tr>
</table>

<div align="justify">
As we can see, the results show us that the most accurate method was Logistic Regression and the one with the highest error rate was Multilayer Perceptron Classifier. But in terms of execution time we can see that the Multilayer Perceptron Classifier was the second fastest and the SVM the slowest.              
                   
These results do not mean that one algorithm is superior to another in all aspects, this decision was based only on 30 iterations of the code, also the result obtained for each algorithm may vary slightly when modifying, for example, the number of splits in which they are divided the data being one for training the algorithm and the other for testing or on the other hand handling different input, hidden or output layers for the Multilayer Perceptron Classifier. All these variants can show us different results depending on the case.

</div>


## Conclusion <a name="conclusiones"></a>
<div align="justify">
Before starting to use all the algorithms, we must ask ourselves the following questions:   

What type of result do I want to obtain? Is the algorithm that I am going to use suitable for carrying out the task in an optimal way?    

Currently there are many machine learning algorithms focused on the ordering and analysis of data. Each algorithm has its own variants and methods. There is no specific algorithm that is the winner. The results will depend on the data source, the construction of the algorithm and its main objective. In the observations that we made previously in the document, we noticed that the results were almost exact, it only varied a couple of seconds and its percentage of precision differed between + -1.
These results were due to the amount of data we had. By having a dataset with more data, the learning times of each algorithm would change significantly.

As a conclusion regarding the classification algorithms seen throughout the massive data course, we know that there are supervised and unsupervised algorithms and the functionalities of each of them taking into account the characteristics that each one covers, the supervised ones consist of data from Training labels and unsupervised ones not so they both fulfill different functionalities.

In the case of this project, supervised classification algorithms were used since training with labels was necessary and we were able to see the performance that each one of them showed, thus being the logistic regression algorithm the most accurate and the multilayer perception the least accurate but When choosing to use a specific one, we must also take into account the execution time and ease of use. The best algorithms may not always be the most accurate as they generally require more extensive training to obtain the best possible performance.
</div>

## References <a name="referencias"></a>

[1] Ahmad, I., Basheri, M., Iqbal, M. J., & Rahim, A. (2018). Performance comparison of support vector machine, random forest, and extreme learning machine for intrusion detection. IEEE access, 6, 33789-33795.   

[2] Huang, S., Cai, N., Pacheco, P. P., Narrandes, S., Wang, Y., & Xu, W. (2018). Applications of Support Vector Machine (SVM) Learning in Cancer Genomics. Cancer genomics & proteomics, 15(1), 41–51. https://doi.org/10.21873/cgp.20063   

[3] Patel, H. H., & Prajapati, P. (2018). Study and analysis of decision tree based classification algorithms. International Journal of Computer Sciences and Engineering, 6(10), 74-78.   

[4] Joseph L. Fleiss, Janet B.W. Williams, Alan F. Dubro, The logistic regression analysis of psychiatric data, Journal of Psychiatric Research, Volume 20, Issue 3,
1986, Pages 195-209, ISSN 0022-3956, https://doi.org/10.1016/0022-3956(86)90003-8.
(https://www.sciencedirect.com/science/article/pii/0022395686900038)  

[5] Apache Spark. (s. f.). Classification and regression - Spark 2.4.7 Documentation. Recuperado 18 de junio de 2021, de https://spark.apache.org/docs/2.4.7/ml-classification-regression.html#multilayer-perceptron-classifier   

[6] JavaTpoint. history of scala. 22/06/2021, from JavaTpoint web site:   
https://www.javatpoint.com/history-of-scala  

[7] Spark. Spark Overview. 22/06/2021, from spark.apache web site:   
https://spark.apache.org/docs/latest/

[8] JavaTpoint. history of scala. 22/06/2021, from JavaTpoint web site:   
https://www.javatpoint.com/history-of-scala

[9] Spark. Spark Overview. 22/06/2021, from spark.apache web site:   
https://spark.apache.org/docs/latest/