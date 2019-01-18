package fan.zheyuan.kodein_di.logger

class Logger {
    var text: String = ""
        private set

    var callback: (() -> Unit)? = null

    fun log(msg: String) {
        text += "$msg\n"
        callback?.invoke()
    }
}