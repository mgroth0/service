package matt.service.action

import matt.model.code.idea.ServiceIdea
import matt.model.data.dir.YesOrNo

interface ActionAbilitiesService: ServiceIdea {
  fun input(prompt: String): String
  fun confirm(s: String): Boolean
  fun yesOrNo(s: String): YesOrNo
  fun <E: Enum<E>> enum(enumOptions: Array<E>, prompt: String): E
}