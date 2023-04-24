package matt.service.gradle

import matt.model.code.mod.AbsoluteMod
import matt.model.code.mod.RelativeToKMod
import matt.service.MattService

interface GradleService : MattService {
    val rootDir: String
    fun project(path: String): GradleProjectService
    val allKSubProjects: List<RelativeToKMod>
}

object NoGradleService : GradleService {
    override val rootDir: String
        get() = error("no gradle service")

    override fun project(path: String) = error("no gradle service")

    override val allKSubProjects: List<RelativeToKMod>
        get() = error("no gradle service")
}

interface GradleProjectService : MattService, AbsoluteMod {
    val path: String
    val subProjects: List<GradleProjectService>
}