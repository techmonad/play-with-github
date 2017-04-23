package domains

import play.api.libs.json.Json
import utils.JsonUtility._

/**
  * Created by imana on 4/23/2017.
  */
case class WeeklyHash
(
  w: Long,
  a: Long,
  d: Long,
  c: Long
) {

  def toJson = Json.toJson(this)

  def toJsonString = toJson.toString()

}
