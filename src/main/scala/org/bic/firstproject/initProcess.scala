package org.bic.firstproject

import org.apache.spark.sql.SparkSession
import com.typesafe.config.ConfigFactory
import org.bic.firstproject.process.FirstApplication
/**
 * Hello world!
 *
 */
protected trait initProcessTrait {
  def main(args: Array[String]): Unit = {

    val reference = args(0).toString
    val globalConfig = ConfigFactory.load(reference)
    val configIn = globalConfig.getConfig("firstApplicatonJob")

    val spark = SparkSession
      .builder()
      .appName("firstapplication")
      .config("spark.sql.shuffle.partitions", "4")
      .master("local[*]")
      .getOrCreate()

    FirstApplication.processFirstApplication(configIn, spark)
  }
}

object initProcessJob extends initProcessTrait
