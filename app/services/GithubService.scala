package services

import java.io.File

import org.eclipse.jgit.api.Git

import scala.collection.JavaConversions._
import scala.util.Random

class GithubService {

  def getCommitByRepository(gitURL: String) = {
    val git = Git.cloneRepository.setURI(gitURL)
      .setDirectory(new File("repos/git-" + Random.nextLong())).setNoCheckout(true).call
    val commits = git.log.all.call
    commits.map { commit => (commit.getAuthorIdent.getEmailAddress, 1) }
      .groupBy { case (name, _) => name }
      .mapValues(_.size)

  }


}
