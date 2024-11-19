// Databricks notebook source
var x = 10

// COMMAND ----------

x = 20

// COMMAND ----------

val y = 10

// COMMAND ----------

y = 20

// COMMAND ----------

def add(firstInput: Int, secondInput: Int): Int = {
  val sum = firstInput + secondInput
  return sum
}

// COMMAND ----------

val addNumbers = add(5,6)

// COMMAND ----------

def addSimple(firstInput: Int, secondInput: Int) = firstInput + secondInput

// COMMAND ----------

val addTwoNumbers = addSimple(6,7)

// COMMAND ----------

// MAGIC %md
// MAGIC ##Higher-Order Functions

// COMMAND ----------

def encode(n: Int, f: (Int) => Long): Long = {
  val x = n * 10
  f(x)
}

// COMMAND ----------

// MAGIC %md
// MAGIC ###Function Literals

// COMMAND ----------

val higherOrderFunctionTest1 = encode(10, (x: Int) => {x+100})

// COMMAND ----------

// MAGIC %md
// MAGIC here the curly braces can be omitted, so the function body consistes of a single statements.

// COMMAND ----------

val higherOrderFunctionTest2 = encode(5, (x: Int) => x+100)

// COMMAND ----------

// MAGIC %md
// MAGIC The higher order function encode can be used with a function literal.

// COMMAND ----------

val higherOrderFunctionTest3 = encode(5, x => x + 100)

// COMMAND ----------

// MAGIC %md
// MAGIC A function literal can be just _

// COMMAND ----------

val higherOrderFunctionTest4 = encode(5, _ + 100)

// COMMAND ----------

// MAGIC %md
// MAGIC ###Classes

// COMMAND ----------

class Car(mk: String, ml: String, cr: String) {
  val make = mk
  val model = ml
  var color = cr
  def repaint(newColor: String) = {
    color = newColor
  }
}

// COMMAND ----------

val mustang = new Car("Ford", "Mustang", "Red")
val corvette = new Car("GM", "Corvette", "Black")

// COMMAND ----------

corvette.repaint("Blue")
println(corvette.color)

// COMMAND ----------

// MAGIC %md
// MAGIC ##Singletons

// COMMAND ----------

// MAGIC %md
// MAGIC ###Case Classes

// COMMAND ----------

case class Message(from: String, to: String, content: String)
// This

// COMMAND ----------

val request = Message("harry", "sam", "discussion")

// COMMAND ----------

// MAGIC %md
// MAGIC ###Pattern Matching

// COMMAND ----------

def colorToNumber(color: String): Int = {
  val num = color match {
    case "Red" => 1
    case "Blue" => 2
    case "Green" => 3
    case "Yellow" => 4
    case _ => 0
  }
  num
}

// COMMAND ----------

val colorName = "Red"
val colorCode = colorToNumber(colorName)
println(s"The color code for $colorName is $colorCode")

// COMMAND ----------

def f(x: Int, y: Int, operator: String): Double = {
  operator match {
    case "+" => x + y
    case "-" => x - y
    case "*" => x * y
    case "/" => x / y.toDouble
  }
}

// COMMAND ----------

val sum = f(10,20, "+")
val product = f(10, 20, "*")