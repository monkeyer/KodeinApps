package fan.zheyuan.kodein_di.coffee

import fan.zheyuan.kodein_di.logger.Logger

interface Ration {
    fun name(): String
}

class Coffee(log: Logger) : Ration {
    init {
        log.log("<Creating CoffeeRation>")
    }

    override fun name(): String = "coffee"
}

class Tea(log: Logger) : Ration {
    init {
        log.log("<Creating TeaRation>")
    }

    override fun name(): String = "tea"
}

class Kettle<T : Ration> (
    private val logger: Logger,
    private val heater: Heater,
    private val pump: Pump,
    private val ration: () -> T
) {
    init {
        logger.log("<Creating CoffeeMaker>")
    }

    fun brew() {
        heater.on()
        pump.pumpWater()
        val ration = ration()
        logger.log("[_]P ${ration.name()} ${System.identityHashCode(ration)} [_]P")
        heater.off()
    }
}