package fan.zheyuan.kodein_di

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import fan.zheyuan.kodein_di.coffee.Coffee
import fan.zheyuan.kodein_di.coffee.Kettle
import fan.zheyuan.kodein_di.coffee.thermosiphonModule
import fan.zheyuan.kodein_di.logger.Logger
import org.kodein.di.*
import org.kodein.di.android.closestKodein
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.instance
import org.kodein.di.generic.kcontext

class MainActivity : AppCompatActivity(), KodeinAware {

    override val kodeinContext: KodeinContext<*> = kcontext(this)

    private val _parentKodein by closestKodein()

    override val kodein: Kodein by retainedKodein {
        extend(_parentKodein, copy = Copy.All)

        import(thermosiphonModule)
    }

    val coffeeMaker: Kettle<Coffee> by instance()
    val logger: Logger by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            logger.log("Going to brew coffee using $coffeeMaker")

            supportFragmentManager.beginTransaction().add(R.id.fragment, MainFragment()).commit()
        }

        Log.i("Kodein", "=====================-BINDINGS-=====================")
        Log.i("Kodein", kodein.container.tree.bindings.description())
        Log.i("Kodein", "====================================================")
    }
}
