package fan.zheyuan.kodein_di.coffee

interface Heater {
    fun on()
    fun off()
    val isHot: Boolean
}