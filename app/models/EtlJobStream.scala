package models

import slick.driver.MySQLDriver.api._

/**
  * Created by yxl on 17/1/6.
  */


case class EtlJobStream(id:Option[Int] = None,jobName:String,streamJob:String,enable:Int)

object EtlJobStream extends BaseJob

class EtlJobStreamTable(tag:Tag) extends Table[EtlJobStream](tag,"t_etl_job_stream"){
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def jobName = column[String]("job_name")
  def streamJob = column[String]("stream_job")
  def enable = column[Int]("enable")

  def * = (id.?,jobName,streamJob,enable) <> ((EtlJobStream.apply _).tupled,EtlJobStream.unapply)
}
