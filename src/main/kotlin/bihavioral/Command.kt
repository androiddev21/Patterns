package bihavioral

//помогает инкапсулировать некоторые действия и необходимые для них данные, позволяя передавать их как аргументы
// при вызове методов, ставить запросы в очередь, логировать их, а также поддерживать отмену операций
//между интерфейсом и бизнес логикой появляется прослойка из патерна команда (логика события в команде,
// а исполнение будет в бизнес-логике
interface Command{
    fun execute()
}

class Driver(var command: Command){

    fun  execute(){
        command.execute()
    }
}

class Engine {

    private var state = false

    fun on(){
        state = true
        println("Engine on")
    }

    fun off(){
        state = false
        println("Engine off")
    }
}

class OnStartCommand(private val engine: Engine): Command{

    override fun execute() {
        engine.on()
    }
}

class OnStopCommand(private val engine: Engine): Command{

    override fun execute() {
        engine.off()
    }
}

fun main() {
    val engine = Engine()
    val driver = Driver(OnStartCommand(engine))
    driver.execute()
    driver.command = OnStopCommand(engine)
    driver.execute()
}