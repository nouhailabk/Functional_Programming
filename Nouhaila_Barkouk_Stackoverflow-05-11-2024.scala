// Databricks notebook source
import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

// COMMAND ----------

val csvDataFile = "/FileStore/tables/Stackoverflow-05-11-2024.scala/Stackoverflow_05_11_2024.scala" 

// COMMAND ----------

val df = spark.read
      .option("header", "false")
      .option("inferSchema", "true")
      .csv(csvDataFile)

// COMMAND ----------

println(s"\nCount of records in CSV file: ${df.count()}")

// COMMAND ----------

df.printSchema()

// COMMAND ----------

df.show(5)
