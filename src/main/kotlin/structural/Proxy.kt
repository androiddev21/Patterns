package structural

//cтруктурные
//вместо реальных объектов предоставляет объекты заменители. Эти объекты перехватывают вызовы к оригинальному объекту,
//позволяя сделать что-то до или после передачи вызова оригиналу.
interface AccessSystem {
    fun openCar()

    fun closeCar()
}

class VoiceCarAccess : AccessSystem {

    override fun openCar() {
        println("Opening car with voice")
    }

    override fun closeCar() {
        println("Closing car with voice")
    }
}

class SecuritySystem(private val accessSystem: AccessSystem) {

    fun openCar(password: String) {
        if (authenticate(password))
            accessSystem.openCar()
        else
            println("Access denied")
    }

   private fun authenticate(password: String) = password == "12345678"

    fun closeCar() {
        accessSystem.closeCar()
    }
}

fun main() {
    val securitySystem = SecuritySystem(VoiceCarAccess())
    securitySystem.openCar("12")
    securitySystem.openCar("12345678")
    securitySystem.closeCar()
}