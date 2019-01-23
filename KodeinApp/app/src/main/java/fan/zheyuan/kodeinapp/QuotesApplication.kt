package fan.zheyuan.kodeinapp

import android.app.Application
import fan.zheyuan.kodeinapp.data.db.Database
import fan.zheyuan.kodeinapp.data.db.DatabaseFakeImpl
import fan.zheyuan.kodeinapp.data.db.QuoteDao
import fan.zheyuan.kodeinapp.data.repository.QuoteRepository
import fan.zheyuan.kodeinapp.data.repository.QuoteRepositoryImpl
import fan.zheyuan.kodeinapp.ui.quotes.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class QuotesApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        bind<Database>() with singleton { DatabaseFakeImpl() }
        bind<QuoteDao>() with singleton { instance<Database>().quoteDao }
        bind<QuoteRepository>() with singleton { QuoteRepositoryImpl(instance()) }
        bind() from provider { QuotesViewModelFactory(instance()) }

    }
}