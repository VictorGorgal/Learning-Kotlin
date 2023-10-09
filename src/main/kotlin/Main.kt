fun main() {
    val string: String = getString()
    val number: Int = getNumber()
    println("$string - $number")
    separator()

    val a = doNothing("me")
    println(a)
    separator()

    val list: Array<Int> = arrayOf(0, 1, 2)
    list[0] = 2
    list[1] = 4
    println(list.toList())
    separator()

    val list2: List<Int> = listOf(0, 1, 2)
    println(list2)
    separator()

    val list3: ArrayList<Int> = ArrayList()
    list3.add(0)
    list3.add(4)
    list3.add(2)
    println(list3)
    separator()

    for (num in list3) {
        println(num)
    }
    separator()

    list3.forEachIndexed { id, num ->
        println("$id - $num")
    }
    separator()

    val tuple2: Pair<String, Int> = "1" to 1
    println(tuple2)
    separator()

    val map: Map<String, Int> = mapOf("2" to 2, "4" to 4, "6" to 6)
    map.forEach { (key, value) ->
        println("$key -> $value")
    }
    println(map["2"])
    separator()

    val map2: MutableMap<String, Int> = mutableMapOf("2" to 2, "4" to 4, "6" to 6)
    map2["10"] = 10
    map2.forEach { (key, value) ->
        println("$key -> $value")
    }
    separator()

    doSomething("hello")
    doSomething("hello", "1", "2", "3", "4...")
    val setArray: Array<String> = arrayOf("one", "two", "three")
    doSomething("hello", *setArray)
    doSomething(arg1 = "hello", *setArray)
    doSomething(arg1 = "hello", args2 = setArray)
    separator()

    multipleArgsFun("1", "2", "3")
    multipleArgsFun(arg3 = "3", arg1 = "1", arg2 = "2")
    multipleArgsFun()
    separator()

    val customClass = Test1Class("name", 16)
    customClass.printStuff()
    val customClass2 = Test1Class()
    customClass2.printStuff()
    val customClass3 = Test1Class(1)
    customClass3.printStuff()
    customClass3.name = "aaa"
    customClass3.name
    separator()

    val interfaceTest = BasicProvider()
    interfaceTest.onSuccess("yey")
    interfaceTest.onError("nope")
    separator()

    val callback = object: TestInterface {
        override val variable: String
            get() = "MY VARIABLE"

        override fun onError(message: String) {
            println("custom error")
        }

        override fun onSuccess(message: String) {
            super.onSuccess(message)
        }
    }
    val interfaceTest2 = BasicProvider2(callback)
    interfaceTest2.doStuff()
    separator()

    val aaa: Singleton = Singleton.getInstance()
    aaa.someFunction()
    separator()

    println(TestEnum.UP)
    println(TestEnum.DOWN.ordinal)
    println(TestEnum.entries)
    separator()

    val dc = TestDataClass(9, "hey")
    val dc2 = TestDataClass(10, "hey")
    println(dc == dc2)
    dc2.num = 9
    println(dc == dc2)
    separator()

    val ndc = TestNonDataClass(9, "hey")
    val ndc2 = TestNonDataClass(10, "hey")
    println(ndc == ndc2)
    ndc2.num = 9
    println(ndc == ndc2)
    separator()

    val dc3 = dc.copy(str = "not hey")
    println(dc)
    println(dc3)
    separator()

    functionWithCallback("hehe") {
        println(it)
        2
    }
    separator()

    functionWithCallback2("numb")
    functionWithCallback2("numb") {
        println(it)
        2
    }
}

fun getString(): String {
    return "Some string"
}

fun getNumber(): Int = 123

fun separator() = println("---------")

fun doNothing(something: String) = println("doing nothing with $something")

fun doSomething(arg1: String, vararg args2: String) {
    println("$arg1 - ${args2.joinToString(", ") }")
}

fun multipleArgsFun(arg1: String = "1", arg2: String = "2", arg3: String = "3") {
    println("$arg1 - $arg2 - $arg3")
}

fun functionWithCallback(variable: String, callback: (String) -> Int) {
    val res = callback(variable)
    println("Response: $res")
}

fun functionWithCallback2(variable: String, callback: ((String) -> Int)? = null) {
    val res = callback?.invoke(variable)
    println("Response: $res")
}
