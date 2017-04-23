package domains

import play.api.libs.json.Json
import utils.JsonUtility._

/**
  * Created by imana on 4/23/2017.
  */
case class Author
(
  login: String,
  avatar_url: String,
  html_url: String
) {

  def toJson = Json.toJson(this)

  def toJsonString = toJson.toString()

}
