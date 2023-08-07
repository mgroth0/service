package matt.service

import matt.lang.anno.OnlySynchronizedOnJvm
import matt.lang.require.requireNull
import matt.model.code.idea.ServiceIdea


/*maybe these should just be called interfaces... services are different things related to servers and web and port programming*/
/*but I need to give them a better name than interface... maybe InterfaceProper ...or maybe API ... idk ... good thing I have different words. Give them different meanings.*/
interface MattService : ServiceIdea

/*alternative name idea: ServiceRegistry*/
abstract class ServiceHub<S : MattService> {
    private var service: S? = null

    @OnlySynchronizedOnJvm
    fun install(s: S) {
        requireNull(service)
        service = s
    }

    /* @OnlySynchronizedOnJvm
     fun clear() {
         service = null
     }*/

    fun get() = service ?: error("service was not installed for ${this::class.simpleName}")

}