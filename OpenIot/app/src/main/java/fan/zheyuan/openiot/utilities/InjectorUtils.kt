package fan.zheyuan.openiot.utilities

import fan.zheyuan.openiot.data.FakeDatabase
import fan.zheyuan.openiot.data.QuoteRepository
import fan.zheyuan.openiot.ui.quotes.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}