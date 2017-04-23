package domains

import play.api.libs.json.Json
import utils.JsonUtility._

/**
  * Created by anand-singh on 4/23/2017.
  */
case class ContributorStats
(
  total: Long,
  weeks: List[WeeklyHash],
  author: Author
) {

  def toJson = Json.toJson(this)

  def toJsonString = toJson.toString()

}
