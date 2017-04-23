package services

import javax.inject._

import domains.ContributorStats
import play.api.libs.ws.WSClient

import scala.concurrent.{ExecutionContext, Future}

import utils.JsonUtility._

@Singleton
class GithubService @Inject()(ws: WSClient)(implicit exec: ExecutionContext) {

  val GITHUB_API_BASE_URL = "https://api.github.com"

  def getContributorsStats(repo: String): Future[List[ContributorStats]] = {
    val url = s"$GITHUB_API_BASE_URL/repos/$repo/stats/contributors"
    ws.url(url).withHeaders(("Accept", "application/vnd.github.v3+json")).get().map { response =>
      response.json.asOpt[List[ContributorStats]].getOrElse(List.empty).sortBy(- _.total)
    }
  }

}
