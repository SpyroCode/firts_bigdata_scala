package org.bic.firstproject.config

import com.typesafe.config.Config
import org.apache.spark.sql.SparkSession

object Parameters {

  var pathIn:String=""
  var pathOut:String=""

  def setVariablesParameter(config: Config, spark:SparkSession):Unit={
    val paramsConfig=config.getConfig("paramLocal")
    pathIn=paramsConfig.getString("pathIn")
    pathOut=paramsConfig.getString("pathOut")
  }

}
