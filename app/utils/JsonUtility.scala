package utils

import domains._
import play.api.libs.json.{Json, OFormat}

/**
  * Created by imana on 3/25/2017.
  */
object JsonUtility {

  implicit val AuthorJson: OFormat[Author] = Json.format[Author]
  implicit val WeeklyHashJson: OFormat[WeeklyHash] = Json.format[WeeklyHash]
  implicit val ContributorStatsJson: OFormat[ContributorStats] = Json.format[ContributorStats]
  implicit val BarChartJson: OFormat[BarChart] = Json.format[BarChart]

}
