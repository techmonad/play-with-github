package controllers

import javax.inject._

import play.api.mvc._
import services.GithubService


@Singleton
class ApplicationController @Inject()(githubService: GithubService) extends Controller {
  // trying to build like this => https://github.com/apache/kafka/graphs/contributors

  def index = Action {
    val url = "https://github.com/knoldus/activator-play-slick-app.git"
    //get from params
    val userAndCommits = githubService.getCommitByRepository(url)
    Ok("Commits details " + userAndCommits)
  }

}
