package matt.service

import matt.model.idea.ServiceIdea
import kotlin.jvm.Synchronized


/*maybe these should just be called interfaces... services are different things related to servers and web and port programming*/
/*but I need to give them a better name than interface... maybe InterfaceProper ...or maybe API ... idk ... good thing I have different words. Give them different meanings.*/
interface MattService: ServiceIdea

abstract class ServiceHub<S: MattService> {
  private var service: S? = null

  @Synchronized
  fun install(s: S) {
	require(service == null)
	service = s
  }

  fun get() = service ?: error("service was not installed for ${this::class.simpleName}")

}