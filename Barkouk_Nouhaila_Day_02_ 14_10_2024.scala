// Databricks notebook source
// MAGIC %md
// MAGIC ## Programming Paradigms

// COMMAND ----------

// MAGIC %md
// MAGIC ### Composable

// COMMAND ----------

def f(x: Int): Int = x * 2

def g(x: Int): Int = x + 2

def h(x: Int): Int = f(g(x))

// COMMAND ----------

val input = 4
println(s"g($input) = ${g(input)}")
println(s"f(g($input)) = ${f(g(input))}")
println(s"h($input) = ${h(input)}")

// COMMAND ----------

// MAGIC %md
// MAGIC ### Scala Programming language

// COMMAND ----------

val name: String = "Scala"
val age: Int = 25

// COMMAND ----------

val languag: Int = "Scala"

// COMMAND ----------

// MAGIC %md
// MAGIC ### Operators

// COMMAND ----------

val x = 10
val y = 20
val z = x + y

// COMMAND ----------

val z = x.+ (y)
val z1 = x.* (y)

// COMMAND ----------

// MAGIC %md
// MAGIC ### Traits

// COMMAND ----------

trait Shape {
  def area(): Int
}

class Square(length: Int) extends Shape {
  def area = length * length
}

class Rectangle(length: Int, width: Int) extends Shape {
  def area = length * width
}
val square = new Square(10)
val area = square.area

// COMMAND ----------

// MAGIC %md
// MAGIC ### Tuples
// MAGIC - it is immutable

// COMMAND ----------

val twoElements = ("10", true)
val threeElements = ("10", "harry", true)

// COMMAND ----------

val first = threeElements._1
val second = threeElements._2
val three = threeElements._3

// COMMAND ----------

// MAGIC %md
// MAGIC ### Collections
// MAGIC A list is immutable but an array is mutable, this is why lists are more used in scala

// COMMAND ----------

val arr = Array(10, 20, 30)

// COMMAND ----------

arr(0) = 50

// COMMAND ----------

val xs = List(10, 20, 30, 40, 50)

// COMMAND ----------

val ys = (1 to 100).toList

// COMMAND ----------

val zs = arr.toList

// COMMAND ----------

zs.isEmpty

// COMMAND ----------

// MAGIC %md
// MAGIC ### Vectors

// COMMAND ----------

val v1 = Vector(0, 10, 20, 30, 40)

// COMMAND ----------

val v2 = v1 :+ 50

// COMMAND ----------

val v5 = 

// COMMAND ----------

// MAGIC %md
// MAGIC ### Sets

// COMMAND ----------

val fruits = Set("apple", "orange", "pear", "banana")

// COMMAND ----------

fruits.contains("Ananas")

// COMMAND ----------

fruits.isEmpty

// COMMAND ----------

// MAGIC %md
// MAGIC ### Map

// COMMAND ----------

val capitals = Map ("France" -> "Paris", "USA" -> "Washington D.C.", "UK" -> "London")

// COMMAND ----------

val FranceCapital = capitals("France")

// COMMAND ----------

// MAGIC %md
// MAGIC ### Higher-Order Methods on Collection Classes
// MAGIC

// COMMAND ----------

val myList1 = List(1.0, 2.0, 3.0, 4.0)

// COMMAND ----------

val myAnotherList1 = myList1.map((x: Double) => x * 10)

// COMMAND ----------

val myList = List(1, 2, 3, 4)

// COMMAND ----------

val myAnotherList = myList.map((x: Int) => x * 10.0)

// COMMAND ----------

// MAGIC %md
// MAGIC ### flatMap

// COMMAND ----------

val line = "Scala is fun"

// COMMAND ----------

val SingleSpace = " "

// COMMAND ----------

val words = line.split(SingleSpace)

// COMMAND ----------

val arrayOfListOfChars = words.map{x => x.toList}

// COMMAND ----------

val arrayOfChars = words.flatMap {x => x.toList}

// COMMAND ----------

// MAGIC %md
// MAGIC ### filter

// COMMAND ----------

val myNewList = (1 to 100).toList

// COMMAND ----------

val even = myNewList.filter {_ %2 == 0}

// COMMAND ----------

// MAGIC %md
// MAGIC ### foreach
// MAGIC it performs an operation often for side effects

// COMMAND ----------

words.foreach(println(_))

// COMMAND ----------

// MAGIC %md
// MAGIC ### reduce

// COMMAND ----------

val reduceList = List(2, 4, 6, 8, 10)

// COMMAND ----------

val sum = reduceList.reduce{(x, y) => x + y}

// COMMAND ----------

val product = reduceList.reduce{(x, y) => x * y}

// COMMAND ----------

val max = reduceList.reduce{(x, y) => if (x > y) x else y}

// COMMAND ----------

val min = reduceList.reduce{(x, y) => if (x < y) x else y}

// COMMAND ----------

val words = "Scala is my favorite programming language".split(" ")
