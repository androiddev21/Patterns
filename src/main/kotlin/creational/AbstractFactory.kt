package creational

//порождающий
//абстрактная фабрика
//интерфейс, группирующий другие фабрики, которые связаны друг с другом
class TestCar(val model: String, val interior: Interior, val body: Body)

sealed interface CarFactory {

    fun createBmw(): TestCar

    fun createMercedes(): TestCar
}

class HatchbackFactory : CarFactory {

    override fun createBmw(): TestCar {
        val interior = getInterior<Interior.HatchbackInterior>()
        val body = getBody<Body.HatchbackBody>()
        return TestCar(
            model = "BMW",
            interior = interior,
            body = body
        )
    }

    override fun createMercedes(): TestCar {
        val interior = getInterior<Interior.HatchbackInterior>()
        val body = getBody<Body.HatchbackBody>()
        return TestCar(
            model = "Mercedes",
            interior = interior,
            body = body
        )
    }
}

class CoupeCarFactory : CarFactory {

    override fun createBmw(): TestCar {
        val interior = getInterior<Interior.CoupeCarInterior>()
        val body = getBody<Body.CoupeCarBody>()
        return TestCar(
            model = "BMW",
            interior = interior,
            body = body
        )
    }

    override fun createMercedes(): TestCar {
        val interior = getInterior<Interior.CoupeCarInterior>()
        val body = getBody<Body.CoupeCarBody>()
        return TestCar(
            model = "Mercedes",
            interior = interior,
            body = body
        )
    }
}

sealed interface Interior {
    fun printDescription()

    class HatchbackInterior : Interior {
        override fun printDescription() {
            println("Hatchback Interior")
        }
    }

    class CoupeCarInterior : Interior {
        override fun printDescription() {
            println("Coupe Car Interior")
        }
    }
}

inline fun <reified T : Interior> getInterior(): Interior = when (T::class) {
    Interior.HatchbackInterior::class -> Interior.HatchbackInterior()
    Interior.CoupeCarInterior::class -> Interior.CoupeCarInterior()
    else -> throw java.lang.IllegalArgumentException()
}

sealed interface Body {

    fun printDescription()

    class HatchbackBody : Body {
        override fun printDescription() {
            println("Hatchback Body")
        }
    }

    class CoupeCarBody : Body {
        override fun printDescription() {
            println("Coupe Car Body")
        }
    }
}

inline fun <reified T : Body> getBody(): Body = when (T::class) {
    Body.HatchbackBody::class -> Body.HatchbackBody()
    Body.CoupeCarBody::class -> Body.CoupeCarBody()
    else -> throw java.lang.IllegalArgumentException()
}

inline fun <reified T : CarFactory> getFactory(): CarFactory = when (T::class) {
    HatchbackFactory::class -> HatchbackFactory()
    CoupeCarFactory::class -> CoupeCarFactory()
    else -> throw java.lang.IllegalArgumentException()
}

fun main() {
    val factory = getFactory<HatchbackFactory>()
    val bmw = factory.createBmw()
    println(bmw.model)
    bmw.body.printDescription()
    bmw.interior.printDescription()
}



