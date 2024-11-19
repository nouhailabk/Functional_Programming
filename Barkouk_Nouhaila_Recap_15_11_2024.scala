// Databricks notebook source
// MAGIC %md
// MAGIC ##Functional Programming in Scala
// MAGIC

// COMMAND ----------

// MAGIC %md
// MAGIC - ###1. Functional Programming (FP)
// MAGIC ####key concepts 
// MAGIC - Declarative Style
// MAGIC - Expression over statements 
// MAGIC - Function composition
// MAGIC

// COMMAND ----------

// MAGIC %md
// MAGIC ##2. Pure Functions

// COMMAND ----------

def multiply(a: Int, b: Int): Int = a * b

// COMMAND ----------

val result_after_first_call = multiply(3, 4)

// COMMAND ----------

val result_after_second_call = multiply(3, 4)

// COMMAND ----------

var total = 0
def addTotal(a: Int): Int = {
  total += a
  total
}

// COMMAND ----------

val total_after_first_call = addTotal(5)

// COMMAND ----------

// MAGIC %md
// MAGIC ##3. Immutibality

// COMMAND ----------

val list = List(1, 2, 3)

// COMMAND ----------

val list1 = List(0, 1, 2, 3)

// COMMAND ----------

val list2 = -1 :: list1

// COMMAND ----------

list = List(0, 1, 2, 3)

// COMMAND ----------

// MAGIC %md
// MAGIC ###4. Higher-Order Functions
// MAGIC takes other functions as parameter and return a function 

// COMMAND ----------

val greet = (name: String) => s"hello,$name"

// COMMAND ----------

greet("Nouhaila")

// COMMAND ----------

def applyTwice(f: Int => Int, x: Int): Int = f(f(x))

// COMMAND ----------

val increment = (x: Int) => x + 1

// COMMAND ----------

println(applyTwice(increment, 5))

// COMMAND ----------

def multiplier(factor: Int): Int => Int = {
  (x: Int) => x * factor
}

// COMMAND ----------

val triple = multiplier(3)
println(triple(20))

// COMMAND ----------

// MAGIC %md
// MAGIC ###5. Function and Anonymous Functions

// COMMAND ----------

// (val1: Type1, val2: Type2) => expression
(x: Int, y: Int) => x + y 


// COMMAND ----------

(a,b) => a+b

// COMMAND ----------

// MAGIC %md
// MAGIC ###6. Currying and Partial Application
// MAGIC Currying is the process of transforming a function that takes multiples arguments into a sequence 

// COMMAND ----------

def add(x: Int)(y: Int): Int = x + y

// COMMAND ----------

println(add(5)(10))

// COMMAND ----------

// MAGIC %md
// MAGIC ####Partial Application
// MAGIC Fixing a few arguments of a function, producing another function of fewer arguments

// COMMAND ----------

val addFive = add(5)_

// COMMAND ----------

println(addFive(10))

// COMMAND ----------

def log(level: String)(message: String): Unit = {
  println(s"[$level] $message")
}

// COMMAND ----------

val infoLog = log("INFO")_
val errorLog = log("ERROR")_

// COMMAND ----------

val infomessage = infoLog("ceci est une info complementaire")
val errormessage = errorLog("ceci est une info compelmentaire d'erreur")

// COMMAND ----------

// MAGIC %md
// MAGIC ###7. Functional Collections

// COMMAND ----------

val numbers = List(1, 2, 3, 4, 5)
val doubled = numbers.map(_*2)
println(doubled)

// COMMAND ----------

// MAGIC %md
// MAGIC FlatMapping

// COMMAND ----------

val nestedNumbers = List(List(1, 2), List(3, 4), List(5))
val incremented = nestedNumbers.flatMap(list => list.map(_ + 1))
println(incremented)

// COMMAND ----------

val doubleEvens = numbers.collect { case x if x % 2 == 0 => x * 2}
println(doubleEvens)

// COMMAND ----------

val evens = numbers.filter(_ % 2 == 0)
println(evens)

// COMMAND ----------

val odds = numbers.filterNot(_ % 2 == 0)
println(odds)

// COMMAND ----------

val lessThanFour = numbers.takeWhile(_ < 4)
println(lessThanFour)

// COMMAND ----------

val moreThanFour = numbers.takeWhile(_ > 4)
println(moreThanFour)

// COMMAND ----------

val sum = numbers.reduce(_+_)
println(sum)

// COMMAND ----------

val words = List("Scala", "is", "fun")
val sentence = words.foldLeft("Programming in")(_ + "" + _)
println(sentence)

// COMMAND ----------

val maxNumber = numbers.reduceLeft((x, y) => if (x > y) x else y)
println(maxNumber)

// COMMAND ----------

val minNumber = numbers.reduceRight((x, y) => if (x < y) x else y)
println(minNumber)

// COMMAND ----------

// MAGIC %md
// MAGIC aggregate

// COMMAND ----------

val sumOfSquares = numbers.aggregate(0)(
  (acc, num) => acc + num * num,
  (acc1, acc2) => acc1 + acc2
)
println(sumOfSquares)

// COMMAND ----------

val ages = Map("Faaiz" ->)

// COMMAND ----------

// MAGIC %md
// MAGIC Lazy Function

// COMMAND ----------

lazy val expensiveComputation = {
  println("Performing expensive computation... ")
  Thread.sleep(100)
  42
}

// COMMAND ----------

println("Before accessing 'expensiveComputation'")
