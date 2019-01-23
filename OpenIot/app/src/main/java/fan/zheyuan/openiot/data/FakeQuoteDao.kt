package fan.zheyuan.openiot.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeQuoteDao {
    private val quoteList = mutableListOf<Quote>()
    private val quotes = MutableLiveData<List<Quote>>()

    init {
        refresh()
    }

    fun addQuote(quote: Quote) {
        quoteList.add(quote)
        refresh()
    }

    private fun refresh() {
        quotes.value = quoteList
    }

    fun getQuotes() = quotes as LiveData<List<Quote>>
}