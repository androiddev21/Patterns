package bihavioral

//цепочка обязанностей
//позволяет передавать запросы последовательно по цепочке обработчиков, каждый обработчик решает сам, может ли он
//обработать этот запрос или передает другому

sealed class Account(private val name: String, private val balance: Double) {

    var next: Account? = null

    private fun canPay(amount: Double) = amount <= balance

    fun pay(amount: Double) {
        if (canPay(amount)) {
            println("Payed $amount using $name")
        } else if (next == null) {
            println("Can not pay $amount using $name")
        } else {
            println("Can not pay $amount using $name")
            next?.pay(amount)
        }
    }
}

class MasterCard(balance: Double) : Account("MasterCard", balance)

class Paypal(balance: Double) : Account("Paypal", balance)

class Visa(balance: Double) : Account("Visa", balance)

fun main() {
    val masterCard = MasterCard(500.0)
    val paypal = Paypal(600.0)
    val visa = Visa(700.0)

    masterCard.next = paypal
    paypal.next = visa

    masterCard.pay(1000.0)
}