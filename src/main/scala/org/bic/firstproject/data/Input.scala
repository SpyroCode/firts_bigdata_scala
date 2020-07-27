package org.bic.firstproject.data

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.bic.firstproject.config.{Parameters => pr}

object Inputs {
  var inputDf: DataFrame = _

  def setVariablesInput(spark: SparkSession): Unit ={
    inputDf = spark.read
      .option("inferschema","true")
      .option("header","true")
      .option("sep",",")
      .csv(pr.pathIn)
  }
}
