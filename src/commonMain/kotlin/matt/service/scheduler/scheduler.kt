package matt.service.scheduler

interface Scheduler {
    fun schedule(op: ()->Unit)
}
