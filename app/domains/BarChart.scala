package domains

import play.api.libs.json.Json
import utils.JsonUtility._

/**
  * Created by imana on 4/23/2017.
  */
case class BarChart
(
  labels: List[String],
  additions: List[Long],
  deletions: List[Long]
) {

  def toJson = Json.toJson(this)

  def toJsonString = toJson.toString()

}
