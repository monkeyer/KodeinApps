package fan.zheyuan.kodeinapp.data.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import fan.zheyuan.kodeinapp.data.model.Quote

class QuoteDaoFakeImpl : QuoteDao {
    private val quoteList = mutableListOf<Quote>()

    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.value = quoteList
    }

    override fun addQuote(quote: Quote) {
        quoteList.add(quote)
        quotes.value = quoteList
    }

    override fun getQuotes() = quotes as LiveData<List<Quote>>

}