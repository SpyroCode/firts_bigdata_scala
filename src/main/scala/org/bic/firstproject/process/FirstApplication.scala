package org.bic.firstproject.process

import com.typesafe.config.Config
import org.bic.firstproject.config.{Parameters => pr}
import org.bic.firstproject.data.{Inputs => in}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, count}
import com.typesafe.scalalogging.LazyLogging

object FirstApplication extends LazyLogging{
  def processFirstApplication(config: Config, spark: SparkSession): Unit = {
    pr.setVariablesParameter(config, spark)
    in.setVariablesInput(spark)

    var df = in.inputDf.groupBy(col("Location")).count()
    df.write.mode("overwrite").parquet(pr.pathOut)
  }

}

