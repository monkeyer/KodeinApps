package fan.zheyuan.kodeinapp.data.repository

import androidx.lifecycle.LiveData
import fan.zheyuan.kodeinapp.data.model.Quote

interface QuoteRepository {

    fun addQuote(quote: Quote)

    fun getQuotes(): LiveData<List<Quote>>
}