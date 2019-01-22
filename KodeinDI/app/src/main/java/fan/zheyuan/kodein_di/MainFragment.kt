package fan.zheyuan.kodein_di

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fan.zheyuan.kodein_di.coffee.Coffee
import fan.zheyuan.kodein_di.coffee.Kettle
import fan.zheyuan.kodein_di.logger.Logger
import kotlinx.android.synthetic.main.fragment_main.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class MainFragment : Fragment(), KodeinAware {
    override val kodein by closestKodein()

//    override val kodeinTrigger = KodeinTrigger()

    val coffeeMaker: Kettle<Coffee> by instance()

    val logger: Logger by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        logger.log("Fragment onCreate!")
//        kodeinTrigger.trigger()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        logger.log("Fragment onCreateView!")
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logger.log("Fragment onViewCreated!")

        logger.callback = {
            text?.text = logger.text
        }

        logger.log("Starting to brew coffee using $coffeeMaker")

        Handler().postDelayed({
            coffeeMaker.brew()
        }, 3000)

        Handler().postDelayed({
            coffeeMaker.brew()
        }, 6000)
    }
}