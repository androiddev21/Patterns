package bihavioral

//позволяет добавлять в программу новые операции, не изменяя классы объектов,
// над которыми эти операции могут выполняться

//no need in kotlin ?
//fun main() {
//    val human: LivingCreature = Human("Ann")
//    val cat  : LivingCreature = Cat("black")
//    human.accept(Guest())
//    cat.accept( Guest() )
//}
//
//sealed class LivingCreature {
//    abstract fun accept(visitor: Visitor)
//}
//interface Visitor {
//    fun visit(creature : Human)
//    fun visit(creature : Cat)
//}
//class Human(val name: String): LivingCreature() {
//    override fun accept(visitor: Visitor) = visitor.visit(this)
//}
//class Cat(val colour: String): LivingCreature() {
//    override fun accept(visitor: Visitor) = visitor.visit(this)
//}
//
//class Guest : Visitor{
//    override fun visit(creature : Human) = println("Hello ${creature.name}")
//    override fun visit(creature : Cat) = println("Cat color is ${creature.colour}")
//}

//Kotlin variant instead pattern
fun main() {
    val human: LivingCreature = Human("Ann")
    val cat  : LivingCreature = Cat("black")
    Guest().visit(human )
    Guest().visit( cat )
}

sealed class LivingCreature
interface Visitor {
    fun visit(creature: LivingCreature)
}
class Human(val name: String): LivingCreature()
class Cat(val colour: String): LivingCreature()

class Guest : Visitor{
    override fun visit(creature : LivingCreature) = when(creature) {
        is Human -> println( "Hello ${creature.name}")
        is Cat -> println( "black ${creature.colour} ) ")
        else -> Unit
    }
}

//when (animal) {
//    is Cat -> catAction.accept(animal)
//    is Dog -> dogAction.accept(animal)
//    is Fish -> fishAction.accept(animal)
//    is Bird -> birdAction.accept(animal)
//    else -> throw AssertionError(animal.javaClass)
//}

//In Kotlin you don't need to cast since a smart cast is automatically made when the compiler sees the
// is check for the instance type.
//
//Also in Kotlin you can use Sealed Classes to represent your possible options in the hierarchy and
// then the compiler can determine if you have exhausted all cases meaning you do not need the else in the when statement.