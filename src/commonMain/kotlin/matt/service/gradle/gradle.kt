package matt.service.gradle

import matt.model.mod.ModType
import matt.service.MattService

interface GradleService: MattService {
  fun project(path: String): GradleProjectService
}

interface GradleProjectService: MattService, ModType {
  val path: String
  val subProjects: List<GradleProjectService>
}