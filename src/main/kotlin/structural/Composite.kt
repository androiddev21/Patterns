package structural

//cтруктурные
//позволяет группировать множество объектов в древовидную структуру и работать с ней так, как будто это
//единый объект
interface Equipment{
    fun getName(): String

    fun getPrice(): Int
}
class Engine1 : Equipment {

    override fun getName(): String = "Engine"

    override fun getPrice(): Int = 200
}

class Body : Equipment {

    override fun getName(): String = "Body"

    override fun getPrice(): Int = 800
}

class Tools : Equipment {

    override fun getName(): String = "Tools"

    override fun getPrice(): Int = 500
}


class Composite(val items: MutableList<Equipment>) : Equipment{

    override fun getName(): String = "Composite"

    override fun getPrice(): Int {
        var price = 0
        items.forEach {
            price += it.getPrice()
        }
        return price
    }
}

class BMWCar{

    private val composite: Composite = Composite(mutableListOf())

    fun getPrice(): Int = composite.getPrice()

    fun addItem(equipment: Equipment){
        composite.items.add(equipment)
    }
}

fun main() {
    val car = BMWCar()
    car.addItem(Engine1())
    println(car.getPrice())
    car.addItem(Body())
    println(car.getPrice())
    car.addItem(Tools())
    println(car.getPrice())
}