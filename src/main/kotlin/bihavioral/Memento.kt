package bihavioral

//снимок
//Позволяет сохранять и восстанавливать прошлые состояния объектов, не раскрывая подробностей их реализации
class Memento(var value: Any?)

class Creator() {

    fun save(value: Any?): Memento = Memento(value)

    fun restore(memento: Memento) = memento.value
}

class Caretaker(private val values: MutableList<Memento> = mutableListOf()) {

    fun addMemento(memento: Memento) {
        values.add(memento)
    }

    fun getMemento(index: Int): Memento? = if (index < values.size) values[index] else null
}

fun main() {
    val caretaker = Caretaker()
    val creator = Creator()
    caretaker.addMemento(creator.save("first"))
    caretaker.addMemento(creator.save("second"))
    caretaker.addMemento(creator.save("third"))

    caretaker.getMemento(1)?.also {
        val savedValue = creator.restore(it)
        println(savedValue)
    }
}