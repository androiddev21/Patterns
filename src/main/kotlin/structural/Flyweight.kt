package structural

//структурные
//(легковес, приспоболенец, кеш)
//позволяет вместить бóльшее количество объектов в отведённую оперативную память.
//разделяет общее состояние объектов между собой, вместо дублирования в каждом
//свойства должны быть не изменяемые
class Code(code: String)

sealed interface Platform {
    fun execute(code: Code?)
}

class JavaPlatform : Platform {
    init {
        println("JavaPlatform object created")
    }

    override fun execute(code: Code?) {
        println("Compiling and executing Java code.")
    }
}

class RubyPlatform : Platform {
    init {
        println("RubyPlatform object created")
    }

    override fun execute(code: Code?) {
        println("Compiling and executing Ruby code.")
    }
}

object PlatformFactory {
    private val map = hashMapOf<String, Platform>()

    fun getPlatformInstance(platformType: String): Platform {
        var platform = map[platformType]
        if (platform == null) {
            platform = when (platformType) {
                "java" -> JavaPlatform()
                "ruby" -> RubyPlatform()
                else -> throw java.lang.IllegalArgumentException()
            }
            map[platformType] = platform
        }
        return platform
    }
}

fun main() {
    var platform = PlatformFactory.getPlatformInstance("java")
    platform.execute(Code("java code"))
    platform = PlatformFactory.getPlatformInstance("ruby")
    platform.execute(Code("ruby code"))
    platform = PlatformFactory.getPlatformInstance("java")
    platform.execute(Code("java code"))
}