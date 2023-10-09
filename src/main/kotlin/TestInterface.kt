interface TestInterface {
    val variable: String

    fun onSuccess(message: String) {
        println("Success! $message $variable")
    }
    fun onError(message: String)
}

class BasicProvider: TestInterface {
    override val variable: String
        get() = "Some overridden variable"

    override fun onError(message: String) {
        println("Error! $message $variable")
    }
}

class BasicProvider2(private val callback: TestInterface) {
    fun doStuff() {
        callback.onSuccess("b")
        callback.onError("b")
    }
}
