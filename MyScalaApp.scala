// Databricks notebook source
val logFile = "/FileStore/tables/README.md/README.md" // Should be some file on your system
//val spark = SparkSession.builder.appName("Simple Application").master("local[*]").getOrCreate()
spark.sparkContext.setLogLevel("ERROR")
val logData = spark.read.textFile(logFile).cache()
val numAs = logData.filter(line => line.contains("Spark")).count()
val numBs = logData.filter(line => line.contains("Scala")).count()
println(s"Lines with Spark: $numAs, Lines with Scala: $numBs")
