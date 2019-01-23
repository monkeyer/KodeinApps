package fan.zheyuan.kodeinapp.data.db

import androidx.lifecycle.LiveData
import fan.zheyuan.kodeinapp.data.model.Quote

interface QuoteDao {

    fun addQuote(quote: Quote)

    fun getQuotes(): LiveData<List<Quote>>

}