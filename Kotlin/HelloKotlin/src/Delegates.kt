import kotlin.properties.Delegates

interface Animal {
    fun eat(): String
}

class Cat : Animal {
    override fun eat() = "eat() at Cat"
}

class Dog : Animal {
    override fun eat() = "eat() at Dog"
}

val cat = Cat()

class Robot : Animal by cat

class AnimalModel(private val name: String, anim: Animal) : Animal by anim {
    fun animalInfo() {
        println("name: $name, eat: ${eat()}")
    }
}

class Person {
    var age: Int by Delegates.observable(0) { prop, old, new ->
        println("age: $old -> $new")
    }
}

fun main() {
//    val dog = AnimalModel("doge", Dog())
//    val cat = AnimalModel("nangman", Cat())
//    dog.animalInfo()
//    cat.animalInfo()

//    val me = Person()
//    me.age = 22
//    me.age = 23

    var max: Int by Delegates.vetoable(0) { prop, old, new ->
        new > old
    }

    max = 50
    println("max: $max")

    max = 10 // veto!
    println("max: $max")
}