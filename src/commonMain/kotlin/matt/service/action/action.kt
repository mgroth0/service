package matt.service.action

import matt.model.code.idea.ServiceIdea
import matt.model.data.dir.YesOrNo

interface ActionAbilitiesService : ServiceIdea {
    fun input(prompt: String): String
    fun openFile(prompt: String): String?
    fun confirm(s: String): Boolean
    fun yesOrNo(s: String): YesOrNo
    fun <T> yesOrNoAllowAllCommands(
        prompts: Map<T, String>
    ): Map<T, YesOrNo>

    fun <E : Enum<E>> enum(
        enumOptions: List<E>,
        prompt: String
    ): E
}

object NoActionAbilities : ActionAbilitiesService {
    private fun noActionAbilities(): Nothing = error("no action abilities")
    override fun input(prompt: String) = noActionAbilities()
    override fun openFile(prompt: String) = noActionAbilities()
    override fun confirm(s: String) = noActionAbilities()
    override fun yesOrNo(s: String) = noActionAbilities()
    override fun <T> yesOrNoAllowAllCommands(prompts: Map<T, String>) = noActionAbilities()
    override fun <E : Enum<E>> enum(
        enumOptions: List<E>,
        prompt: String
    ) = noActionAbilities()
}