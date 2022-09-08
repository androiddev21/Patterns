package creational

//порождающий
//позволяет копировать объекты, не вдаваясь в детали реализации. В клонах можно изменять данные
data class TeslaCar(var model: String, var price: Int, var autopilot: Boolean): Cloneable

fun main() {
    val teslaCar = TeslaCar(
        model = "S",
        price = 800000,
        autopilot = true
    )
    val teslaCarWithDiscount = teslaCar.copy().apply {
        price = 790000
    }
    println(teslaCar)
    println(teslaCarWithDiscount)
}