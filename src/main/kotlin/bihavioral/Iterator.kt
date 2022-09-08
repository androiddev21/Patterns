package bihavioral

//для обхода элементов составных объектов, не раскрывая их внутреннего состояния
class TestIterator(private val elements: List<Int>) {

    var index = 0

    fun next(): Int {
        return elements[index++]
    }

    fun hasNext() = index < elements.size
}

fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6)
    val testIterator = TestIterator(list)
    while (testIterator.hasNext()) {
        println(testIterator.next())
    }
}