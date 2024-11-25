Self-Contained Applications
Suppose we wish to write a self-contained application using the Spark API. We will walk through a simple application in Scala (with sbt), Java (with Maven), and Python (pip).

Python
Scala
Java
We’ll create a very simple Spark application in Scala–so simple, in fact, that it’s named SimpleApp.scala:

/* SimpleApp.scala */
import org.apache.spark.sql.SparkSession

object SimpleApp {
def main(args: Array[String]): Unit = {
val logFile = "YOUR_SPARK_HOME/README.md" // Should be some file on your system
val spark = SparkSession.builder.appName("Simple Application").getOrCreate()
val logData = spark.read.textFile(logFile).cache()
val numAs = logData.filter(line => line.contains("a")).count()
val numBs = logData.filter(line => line.contains("b")).count()
println(s"Lines with a: $numAs, Lines with b: $numBs")
spark.stop()
}
}
Note that applications should define a main() method instead of extending scala.App. Subclasses of scala.App may not work correctly.

This program just counts the number of lines containing ‘a’ and the number containing ‘b’ in the Spark README. Note that you’ll need to replace YOUR_SPARK_HOME with the location where Spark is installed. Unlike the earlier examples with the Spark shell, which initializes its own SparkSession, we initialize a SparkSession as part of the program.

We call SparkSession.builder to construct a SparkSession, then set the application name, and finally call getOrCreate to get the SparkSession instance.

Our application depends on the Spark API, so we’ll also include an sbt configuration file, build.sbt, which explains that Spark is a dependency. This file also adds a repository that Spark depends on: