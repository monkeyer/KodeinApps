package fan.zheyuan.kodeinapp.ui.quotes

import androidx.lifecycle.ViewModel
import fan.zheyuan.kodeinapp.data.model.Quote
import fan.zheyuan.kodeinapp.data.repository.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository) : ViewModel(){

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)

    fun getQuotes() = quoteRepository.getQuotes()
}