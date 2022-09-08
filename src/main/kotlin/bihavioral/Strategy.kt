package bihavioral

//Стратегия — это поведенческий паттерн проектирования, который определяет семейство схожих алгоритмов и помещает каждый из них
// в собственный класс, после чего алгоритмы можно взаимозаменять прямо во время исполнения программы.
//Chain of responsibility is about having a chain of objects
//Strategy is about having a generic interface which you can use to provide different implementations of an algorithm,
// or several algorithms or pieces of logic which have some common dependencies.

//The strategy pattern allows you to polymorphically change behavior of a class.
//
//The factory pattern allows you to encapsulate object creation.

interface SortStrategy {
    fun sort(numbers: Array<Int>)
}

class BubbleSortStrategy : SortStrategy {
    override fun sort(numbers: Array<Int>) {
        println("Numbers are sorted using Bubble sort.")
    }
}

class MergeSortStrategy: SortStrategy {
    override fun sort(numbers: Array<Int>) {
        println("Numbers are sorted using Merge sort.")
    }
}

fun main() {
    val numbers = arrayOf(4, 56, 12, 79, 25, 2)
    sort(BubbleSortStrategy(), numbers)
    sort(MergeSortStrategy(), numbers)
}

fun sort(sortStrategy: SortStrategy, numbers: Array<Int>) {
    sortStrategy.sort(numbers)
}
