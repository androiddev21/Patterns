package bihavioral

//Посредник - поведенческий паттерн, который позволяет уменьшить взаимосвязь классов между собой,
//вынося межкласовые связи в класс-посредник

//Mediator should be used when you don't know how to communicate with other objects or you aren't allowed to
//
//Adapter should be used when you know exactly how to communicate with objects, but these objects might not
// support some communication methods or differ

//The facade pattern gives you a simple interface which interacts on a set of coherent classes
//The mediator pattern takes cares of communication between two objects, without the two objects need to
// have a reference to each other directly.
class Auto(val name: String)

data class Customer(val name: String, private val dealerMediator: DealerMediator) {

    fun makeOrder(auto: Auto) {
        dealerMediator.orderAuto(this, auto)
    }
}

class DealerMediator(private val customers: MutableList<Customer> = mutableListOf()) {

    fun orderAuto(customer: Customer, auto: Auto) {
        println("Order: Customer ${customer.name}, auto ${auto.name}")
        addCustomer(customer)
    }

    private fun addCustomer(customer: Customer) {
        customers.add(customer)
    }

    fun getCustomers() = customers
}

class CallManager(private val mediator: DealerMediator){

    fun findCustomers(){
        println(mediator.getCustomers())
    }
}

fun main() {
    val mediator = DealerMediator()
    val customer1 = Customer("Monika", mediator)
    val customer2 = Customer("Ann", mediator)
    val manager = CallManager(mediator)
    customer1.makeOrder(Auto("BMW"))
    customer2.makeOrder(Auto("Mercedes"))
    manager.findCustomers()
}

