package fan.zheyuan.kodeinapp.data.db

class DatabaseFakeImpl : Database {
    override val quoteDao: QuoteDao = QuoteDaoFakeImpl()
}