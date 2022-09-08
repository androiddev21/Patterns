package structural

//cтруктурные
//разделяет один или несколько классов на две отдельные иерархии — абстракцию и реализацию,
// позволяя изменять их независимо друг от друга.
open class Model(val color: Color)

interface Painter{
    fun paint(): String
}

class Audi(color: Color) : Model(color), Painter {
    override fun paint() = "Auto: Audi, Color: ${color.type}"
}

class Bmw(color: Color) : Model(color), Painter {
   override fun paint() = "Auto: BMW, Color: ${color.type}"
}

open class Color(val type: String)

class BlackColor : Color("dark-black")

class SilbrigColor : Color("silbermetallic")

fun main() {
    val blackBmw = Bmw(BlackColor())
    println(blackBmw.paint())
}