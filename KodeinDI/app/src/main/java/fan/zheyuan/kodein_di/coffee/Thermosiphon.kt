package fan.zheyuan.kodein_di.coffee

import fan.zheyuan.kodein_di.logger.Logger
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class Thermosiphon(private val logger: Logger, private val heater: Heater) : Pump {
    init {
        logger.log("<Creating Thermosiphon")
    }

    override fun pumpWater() {
        if (heater.isHot)
            logger.log("=> => pumping => =>")
        else
            logger.log("!!! water is cold !!!")
    }
}

val thermosiphonModule = Kodein.Module("Thermosiphon") {
    bind<Pump>() with singleton { Thermosiphon(instance(), instance()) }
}
