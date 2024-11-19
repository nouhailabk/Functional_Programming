// Databricks notebook source
// Load the CSV file
val filePath = "/FileStore/tables/user.csv/user.csv"
val df = spark.read.option("header", "true").csv(filePath)

// Show the data
df.show()

// COMMAND ----------

// Filter users aged 25 and above
val filteredDf = df.filter("age >= 25")

// Show the filtered data
filteredDf.show()

// COMMAND ----------

// Extract only the 'name' and 'city' columns
val transformedDf = filteredDf.select("name", "city")

// Show the transformed data
transformedDf.show()

// COMMAND ----------

// Group users by city and count the number of users in each city
val groupedDf = transformedDf.groupBy("city").count()

// Show the grouped data
groupedDf.show()
