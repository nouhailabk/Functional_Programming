// Databricks notebook source
// MAGIC %md
// MAGIC ##Functions

// COMMAND ----------

(x: Int) => x+1

// COMMAND ----------

// MAGIC %md
// MAGIC ###Functions with name

// COMMAND ----------

val addOne = (x: Int) => x + 1
println(addOne(1))

// COMMAND ----------

val add = (x: Int, y: Int) => x + y
println(add(1, 2))

// COMMAND ----------

// MAGIC %md
// MAGIC ##Methods

// COMMAND ----------

def add = (x: Int, y: Int) => x + y
println(add(1, 2))

// COMMAND ----------

def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
println(addThenMultiply(1, 2)(3))

// COMMAND ----------

// MAGIC %md
// MAGIC ##Classes

// COMMAND ----------

class Greeter(prefix: String, suffix: String) {
  def greet(name: String): Unit =
    println(prefix + name + suffix)
}

// COMMAND ----------

val greeter = new Greeter("Hello, ","!")
greeter.greet("Scala developer")

// COMMAND ----------

// MAGIC %md
// MAGIC ##Case Classes

// COMMAND ----------

// MAGIC %md
// MAGIC case classes are compared with values wich are assigned not like classes who are compared whose instances are compared 
// MAGIC by referance (memory allocation)

// COMMAND ----------

val point = Point(1, 2)
val anotherPoint = Point(1, 2)
val yetanotherPoint = Point(2, 2)

// COMMAND ----------

// MAGIC %md
// MAGIC ##Objects

// COMMAND ----------

object IdFactory {
  private var counter = 0
  daf create(): Int = {
    counter += 1
    counter
  }
}

// COMMAND ----------

// MAGIC %md
// MAGIC ## Traits

// COMMAND ----------

class DefaultGreeter extends Greeter

class CustomizableGreeter(prefix: String, postfix: String) extends Greeter {
  override
}
