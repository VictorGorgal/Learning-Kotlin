data class TestDataClass(var num: Int, var str: String) {
    fun print() {
        println("$num - $str")
    }
}

class TestNonDataClass(var num: Int, var str: String) {
    fun print() {
        println("$num - $str")
    }
}
