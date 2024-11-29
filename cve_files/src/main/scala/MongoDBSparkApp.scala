import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._

object MongoDBSparkApp {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("MongoDB Integration for CVE")
      .master("local[*]")
      // Configuration Spark avec une gestion de la mémoire optimisée
      .config("spark.executor.memory", "4g")
      .config("spark.driver.memory", "4g")
      .config("spark.mongodb.read.connection.uri", "mongodb+srv://nouhabk97:ltLR3zQ3A5AsBDJq@cluster0.6noly.mongodb.net/?retryWrites=true&w=majority")
      .config("spark.mongodb.write.connection.uri", "mongodb+srv://nouhabk97:ltLR3zQ3A5AsBDJq@cluster0.6noly.mongodb.net/?retryWrites=true&w=majority")
      .getOrCreate()

    try {
      // Étape 1: Écrire uniquement les fichiers 2023 et 2024 dans MongoDB
      write2023And2024ToMongoDB(spark)

      // Étape 2: Lire et extraire les CVE_Items depuis MongoDB
      val items2023 = readAndExtractItems(spark, "CVE_2023")
      val items2024 = readAndExtractItems(spark, "CVE_2024")

      // Afficher les résultats pour vérification
      println("Items extraits pour 2023 :")
      items2023.show(10, truncate = false)

      println("Items extraits pour 2024 :")
      items2024.show(10, truncate = false)
    } finally {
      // Fermer la session Spark pour libérer les ressources
      spark.stop()
    }
  }

  // Fonction pour écrire les fichiers 2023 et 2024 dans MongoDB
  private def write2023And2024ToMongoDB(spark: SparkSession): Unit = {
    val inputDir = "src/main/resources/CVE_files"

    // Charger uniquement les deux fichiers spécifiques 2023 et 2024
    val filesToLoad = Seq("nvdcve-1.1-2023.json", "nvdcve-1.1-2024.json")

    filesToLoad.foreach { fileName =>
      val filePath = s"$inputDir/$fileName"
      val df = spark.read.option("multiline", "true").json(filePath)

      val collectionName = fileName.split("\\.")(0).replace("nvdcve-1.1-", "CVE_")
      df.write
        .format("mongodb")
        .option("database", "CVE_Database")
        .option("collection", collectionName)
        .mode("overwrite")
        .save()

      println(s"Fichier $fileName sauvegardé dans la collection $collectionName.")
    }
  }

  // Fonction pour lire les données depuis MongoDB et extraire les CVE_Items
  private def readAndExtractItems(spark: SparkSession, collection: String): DataFrame = {
    val mongoDF = spark.read
      .format("mongodb")
      .option("database", "CVE_Database")
      .option("collection", collection)
      .load()

    // Extraction des CVE_Items avec gestion des champs nuls
    mongoDF.select(explode(col("CVE_Items")).as("item"))
      .select(
        col("item.cve.CVE_data_meta.ID").as("CVE_ID"),
        col("item.cve.description.description_data")(0)("value").as("Description"),
        col("item.impact.baseMetricV3.cvssV3.baseScore").as("Base_Score"),
        col("item.impact.baseMetricV3.impactScore").as("Impact_Score"),
        col("item.impact.baseMetricV3.cvssV3.baseSeverity").as("Severity"),
        col("item.publishedDate").as("Published_Date")
      ).na.fill("N/A", Seq("Base_Score", "Impact_Score", "Severity"))
  }
}





