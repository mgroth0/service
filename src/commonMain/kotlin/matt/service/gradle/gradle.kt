package matt.service.gradle

import matt.service.MattService

interface GradleService: MattService {
  fun project(path: String): GradleProjectService
}

interface GradleProjectService: MattService {
  val path: String
  val subProjects: List<GradleProjectService>
}