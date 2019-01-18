package fan.zheyuan.kodein_di.coffee

import fan.zheyuan.kodein_di.logger.Logger
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class ElectricHeader(private val logger: Logger) : Heater {
    private var heating: Boolean = false

    init {
        logger.log("<Creating ElectricHeater>")
    }

    override fun on() {
        logger.log("~ ~ ~ Heating ~ ~ ~")
        this.heating = true
    }

    override fun off() {
        logger.log(". . . cooling . . .")
        this.heating = false
    }

    override val isHot: Boolean
        get() = heating
}

val electricHeaderModule = Kodein.Module("Electric Heater") {
    bind<Heater>() with singleton { ElectricHeader(instance()) }
}