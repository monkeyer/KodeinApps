package fan.zheyuan.openiot.ui.quotes

import androidx.lifecycle.ViewModel
import fan.zheyuan.openiot.data.Quote
import fan.zheyuan.openiot.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}