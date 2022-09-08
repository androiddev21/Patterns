package creational

//порождающий
//фабричный метод
//класс будет создавать однотипные объекты на основании каких-то данных
sealed interface TransportForRent {
    fun printDescription()
}

class Car : TransportForRent {
    override fun printDescription() {
        println("Car")
    }
}

class Scooter : TransportForRent {
    override fun printDescription() {
        println("Scooter")
    }
}

class Bike : TransportForRent {
    override fun printDescription() {
        println("Bike")
    }
}

inline fun <reified T : TransportForRent> getTransport(): TransportForRent = when (T::class) {
    Car::class -> Car()
    Scooter::class -> Scooter()
    Bike::class -> Bike()
    else -> throw java.lang.IllegalArgumentException()
}

fun main() {
    val transport = getTransport<Bike>()
    transport.printDescription()
}