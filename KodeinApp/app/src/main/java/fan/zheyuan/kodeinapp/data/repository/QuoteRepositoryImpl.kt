package fan.zheyuan.kodeinapp.data.repository

import androidx.lifecycle.LiveData
import fan.zheyuan.kodeinapp.data.db.QuoteDao
import fan.zheyuan.kodeinapp.data.model.Quote

class QuoteRepositoryImpl(private val quoteDao: QuoteDao) : QuoteRepository {
    override fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    override fun getQuotes() = quoteDao.getQuotes()
}