package matt.service.gradle

import matt.model.mod.AbsoluteMod
import matt.service.MattService

interface GradleService: MattService {
  fun project(path: String): GradleProjectService
}

interface GradleProjectService: MattService, AbsoluteMod {
  val path: String
  val subProjects: List<GradleProjectService>
}