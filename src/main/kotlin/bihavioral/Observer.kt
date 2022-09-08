package bihavioral

//создаёт механизм подписки, позволяющий одним объектам следить и реагировать на события, происходящие в других объектах.
interface Observer{
    fun inform(news: String)
}

class User(val name: String): Observer {
    override fun inform(news: String) {
       println("$name is informed about $news")
    }

}

class AutoNews {

    var news: String = ""
        set(value) {
            field = value
            notifyAllObservers()
        }

    private val actions: MutableList<Observer> = mutableListOf()

    private fun notifyAllObservers(){
        actions.forEach {
            it.inform(news)
        }
    }

    fun registerObserver(observer: Observer){
        actions.add(observer)
    }

    fun unregisterObserver(observer: Observer){
        actions.remove(observer)
    }
}

fun main() {
    val user1 = User("Max")
    val user2 = User("Ann")
    val user3 = User("Kate")

    val news = AutoNews()
    news.registerObserver(user1)
    news.news = "news1"
    news.registerObserver(user2)
    news.news = "news2"
    news.registerObserver(user3)
    news.news = "news3"
    news.unregisterObserver(user2)
    news.news = "news4"
}