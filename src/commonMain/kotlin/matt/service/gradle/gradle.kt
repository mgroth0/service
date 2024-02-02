package matt.service.gradle

import matt.model.code.mod.AbsoluteMod
import matt.model.code.mod.GradleTaskSelector
import matt.model.code.mod.RelativeToKMod
import matt.service.MattService

interface GradleService : MattService {
    val rootDir: String
    fun project(path: String): GradleProjectService
    val allKSubProjects: Set<RelativeToKMod>
    fun runTasks(vararg tasks: GradleTaskSelector)
    fun propertyValue(propertyName: String): String?
}

object NoGradleService : GradleService {
    override val rootDir: String
        get() = error("no gradle service")

    override fun project(path: String) = error("no gradle service")

    override val allKSubProjects: Set<RelativeToKMod>
        get() = error("no gradle service")

    override fun runTasks(vararg tasks: GradleTaskSelector) {
        TODO()
    }

    override fun propertyValue(propertyName: String): String? {
        TODO()
    }
}

interface GradleProjectService : MattService, AbsoluteMod {
    val path: String
    val subProjects: List<GradleProjectService>
}
