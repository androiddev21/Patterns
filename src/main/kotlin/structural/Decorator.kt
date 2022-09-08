package structural

//cтруктурные
//можем добавлять объектам новые свойства и методы
interface ICar{
    fun getDescription(): String
}

class SimpleCar(
    val price: Int,
    val model: String
): ICar {

    override fun getDescription() = "price: $price, model: $model"
}

//Decorate by Composition
abstract class Decorator(val simpleCar: SimpleCar): ICar{

    override fun getDescription() : String = simpleCar.getDescription()
}

class AutopilotDecorator(simpleCar: SimpleCar): Decorator(simpleCar){

    override fun getDescription() = "${super.getDescription()} with autopilot"
}

//Decorate by Delegation
class ParktronicDecorator(val simpleCar: SimpleCar): ICar by simpleCar{
    override fun getDescription() = "${simpleCar.getDescription()} with parktronic"
}

fun main() {
    val car = SimpleCar(
        price = 1000,
        model = "Tesla"
    )
    println(AutopilotDecorator(car).getDescription())
    println(ParktronicDecorator(car).getDescription())
}