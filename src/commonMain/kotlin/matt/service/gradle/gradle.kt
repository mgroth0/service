package matt.service.gradle

import matt.model.code.mod.AbsoluteMod
import matt.service.MattService

interface GradleService: MattService {
  fun project(path: String): GradleProjectService
}

object NoGradleService: GradleService {
  override fun project(path: String) = error("no gradle service")
}

interface GradleProjectService: MattService, AbsoluteMod {
  val path: String
  val subProjects: List<GradleProjectService>
}