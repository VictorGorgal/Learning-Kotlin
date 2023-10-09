class Singleton private constructor() {
    var name: String? = null
    var value: String? = null

    companion object {

        @Volatile
        private var instance: Singleton? = null

        fun getInstance(): Singleton =
            instance?: synchronized(this) {
                instance?: Singleton().also { instance = it }
            }
    }

    fun someFunction() {
        println("This is definitely a function")
    }
}
