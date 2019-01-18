package fan.zheyuan.kodein_di

import android.app.Activity
import android.app.Application
import fan.zheyuan.kodein_di.coffee.Coffee
import fan.zheyuan.kodein_di.coffee.Kettle
import fan.zheyuan.kodein_di.coffee.electricHeaderModule
import fan.zheyuan.kodein_di.logger.Logger
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.bindings.WeakContextScope
import org.kodein.di.generic.*

class ShareApplication : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@ShareApplication))

        bind() from instance(Logger())

        import(electricHeaderModule)

        bind<Coffee>() with provider { Coffee(instance()) }

        //
        bind<Kettle<Coffee>>() with scoped(WeakContextScope.of<Activity>()).singleton { Kettle<Coffee>(instance(), instance(), instance(), provider()) }

    }

    override fun onCreate() {
        super.onCreate()
        val k = kodein
        println(k)
    }
}