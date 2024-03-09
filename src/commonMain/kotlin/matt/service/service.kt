package matt.service

import matt.lang.assertions.require.requireNull
import matt.lang.sync.common.ReferenceMonitor
import matt.lang.sync.common.inSync
import matt.model.code.idea.ServiceIdea


/*maybe these should just be called interfaces... services are different things related to servers and web and port programming


but I need to give them a better name than interface... maybe InterfaceProper ...or maybe API ... idk ... good thing I have different words. Give them different meanings.*/
interface MattService : ServiceIdea

/*alternative name idea: ServiceRegistry*/
abstract class ServiceHub<S : MattService> : ReferenceMonitor {
    private var service: S? = null

    fun install(s: S) =
        inSync {
            requireNull(service)
            service = s
        }

    /* @OnlySynchronizedOnJvm
     fun clear() {
         service = null
     }*/

    fun get() = service ?: error("service was not installed for ${this::class.simpleName}")
}
