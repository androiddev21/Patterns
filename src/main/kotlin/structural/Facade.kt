package structural

//cтруктурные
//предоставляет простой интерфейс к сложной системе классов
class BodyProvider(){
    fun getBody(){
        println("Body")
    }
}

class EngineProvider(){
    fun getEngine(){
        println("Engine")
    }
}

class WheelsProvider(){
    fun getWheels(){
        println("Wheels")
    }
}

class ElectronicsProvider(){
    fun getElectronics(){
        println("Electronics")
    }
}

class ConveyorFacade() {

    fun doCar() {
        // reminds a bit of Template Method
        // or a Strategy, if instances would be injected
        // nothing is stopping Facade to use other patterns internally
        // for the client it won't matter after all
        BodyProvider().getBody()
        EngineProvider().getEngine()
        WheelsProvider().getWheels()
        ElectronicsProvider().getElectronics()
        println("Car is ready")
    }
}

fun main() {
    val facade = ConveyorFacade()
    facade.doCar()
}

