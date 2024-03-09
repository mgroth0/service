package matt.service.gradle

import matt.lang.shutdown.ShutdownContext
import matt.model.code.mod.AbsoluteMod
import matt.model.code.mod.GradleTaskSelector
import matt.service.MattService

interface GradleService : MattService {
    val rootDir: String
    fun project(path: String): GradleProjectService
    context(ShutdownContext)
    fun runTasks(vararg tasks: GradleTaskSelector)
    fun propertyValue(propertyName: String): String?
}

object NoGradleService : GradleService {
    override val rootDir: String
        get() = error("no gradle service")

    override fun project(path: String) = error("no gradle service")


    context(ShutdownContext)
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
