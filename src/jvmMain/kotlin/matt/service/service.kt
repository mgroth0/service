package matt.service

import java.util.*
import kotlin.jvm.optionals.getOrNull


inline fun <reified T : Any> loadService() = ServiceLoader.load(T::class.java).findFirst().get()
inline fun <reified T : Any> loadServiceOrNull() = ServiceLoader.load(T::class.java).findFirst().getOrNull()

object YesIUseService