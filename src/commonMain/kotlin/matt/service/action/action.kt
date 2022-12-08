package matt.service.action

import matt.model.code.idea.ServiceIdea

interface ActionAbilitiesService: ServiceIdea {
  fun input(prompt: String): String
  fun confirm(s: String)
}