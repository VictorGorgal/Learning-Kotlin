class Test1Class(name: String = "default", age: Int = 0) {
    var name: String = name
        set(value) {
            field = value
            println("Custom setter $field")
        }
        get() {
            println("Custom getter $field")
            return field
        }

    var age: Int = age
        set(value) {
            field = value
            println("Custom setter")
        }
        get() {
            println("Custom getter $field")
            return field
        }

    constructor(num: Int): this("something", -1)

    init {
        1 + 1
    }

    private fun method() {
        println("This is a method")
    }

    fun printStuff() {
        println("$name $age")
    }
}
