package creational

//порождающий
//для создания сложного объекта пошагово и чтобы не разрастался конструктор
class SportCar private constructor(
    val model: String,
    val autopilot: Boolean,
    val year: Int
) {

    constructor(builder: Builder) : this(
        model = builder.model,
        autopilot = builder.autopilot,
        year = builder.year
    )

    class Builder {
        var model: String = ""
        var autopilot: Boolean = false
        var year: Int = 0

        fun setModel(model: String): Builder {
            this.model = model
            return this
        }

        fun setAutopilot(autopilot: Boolean): Builder {
            this.autopilot = autopilot
            return this
        }

        fun setYear(year: Int): Builder {
            this.year = year
            return this
        }

        fun build() = SportCar(this)
    }
}

fun main() {
    val sportCar = SportCar.Builder()
        .setModel("Tesla")
        .setYear(2022)
        .setAutopilot(true)
        .build()
    println(sportCar.model)
}