package structural

//cтруктурные
//оборачивает не совместимый с чем-то объект и делает его совместимым
interface Engine {
    fun simpleInterface()
}

class Engine2: Engine {
    override fun simpleInterface(){
        println("Engine 2.0")
    }
}

class EngineV8 {
    fun complicatedInterface(){
        println("Engine v8")
    }
}

class EngineV8Adapter(private val engineV8: EngineV8): Engine {

    override fun simpleInterface(){
        this.engineV8.complicatedInterface()
    }
}

class EngineCar(engine: Engine){
    init {
        engine.simpleInterface()
    }
}

fun main() {
    val engine2 = Engine2()
    EngineCar(engine2)

    val engineV8Adapter = EngineV8Adapter(EngineV8())
    EngineCar(engineV8Adapter)
}