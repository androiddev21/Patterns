package bihavioral

// определяет скелет алгоритма, перекладывая ответственность за некоторые его шаги на подклассы
abstract class CarTemplate{

    protected abstract fun addEngine()

    protected abstract fun addElectronic()

    protected abstract fun collectAccessories()

    fun build(){
        addEngine()
        addElectronic()
        collectAccessories()
    }
}

class Tesla: CarTemplate(){

    override fun addEngine() {
        println("Tesla engine")
    }

    override fun addElectronic() {
        println("Tesla electronics")
    }

    override fun collectAccessories() {
        println("Tesla accessories")
    }
}

fun main() {
    val tesla = Tesla()
    tesla.build()
}