package bihavioral

//позволяет объектам менять поведение в зависимости от своего состояния. Извне создаётся впечатление,
//что изменился класс объекта
//Паттерн Состояние невозможно рассматривать в отрыве от концепции машины состояний, также известной
// как стейт-машина или конечный автомат

//States store a reference to the context object that contains them. Strategies do not.
//States are allowed to replace themselves (IE: to change the state of the context object to something else),
// while Strategies are not.

//Strategies are passed to the context object as parameters,
// while States are created by the context object itself.
//Strategies only handle a single, specific task,
// while States provide the underlying implementation for everything (or most everything) the context object does.
interface MobileAlertState {
    fun alert(ctx: AlertStateContext)
}

class AlertStateContext {
    private var currentState: MobileAlertState? = null

    init {
        currentState = Vibration()
    }

    fun setState(state: MobileAlertState) {
        currentState = state
    }

    fun alert() {
        currentState!!.alert(this)
    }
}

class Vibration : MobileAlertState {

    override fun alert(ctx: AlertStateContext) {
        println("vibration...")
    }
}

class Silent : MobileAlertState {

    override fun alert(ctx: AlertStateContext) {
        println("silent...")
    }
}

fun main() {
    val stateContext = AlertStateContext()
    stateContext.alert()
    stateContext.alert()
    stateContext.setState(Silent())
    stateContext.alert()
    stateContext.alert()
}

