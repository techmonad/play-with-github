package controllers

import javax.inject._

import domains.{BarChart, ContributorStats}
import play.api.Logger
import play.api.libs.json.Json
import play.api.mvc._
import play.twirl.api.HtmlFormat
import services.GithubService

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class ApplicationController @Inject()
(
  webJarAssets: WebJarAssets,
  githubService: GithubService
)(implicit exec: ExecutionContext) extends Controller {
  // trying to build like this => https://github.com/apache/kafka/graphs/contributors

  def index: Action[AnyContent] = Action.async { implicit request =>
    Future.successful(Ok(views.html.index("Test")(webJarAssets)))
  }

  def stats(repo: String) = Action.async { implicit request =>
    githubService.getContributorsStats(repo).map { contributors =>
      val contributorsHtml: String = views.html.reports.contributors(contributors).toString()
      Ok(Json.obj("barChart" -> initBarChart(contributors).toJson, "content" -> contributorsHtml))
    }
  }

  private def initBarChart(contributors: List[ContributorStats]): BarChart = {
    BarChart(
      labels = contributors.map(_.author.login),
      additions = contributors.map(_.weeks.map(_.a).sum),
      deletions = contributors.map(_.weeks.map(_.d).sum)
    )
  }

}
