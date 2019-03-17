package com.yiran.kotlinprimer.test3

import com.yiran.kotlinprimer.test3.A.format

fun main(args: Array<String>) {
    function("")
}

fun function(str: String){
    // 让编译器推断返回类型、返回String类型、返回String?类型
    // 可以看到，这里编译器推断的是 String! 这个类型，这个类型不能自己声明，只能调用java的时候，编译器来判断
    // String! 这个类型只是编辑器的一个临时类型，如果后面用，则会按照java语法去运行
    val fmt1 = format(str)
    // println(fmt1.length) // java 空指针异常
    // val fmt2: String = format(str) // 这里就报错了
    val fmt3: String? = format(str)
    println(fmt3?.length) // 输出 null，表示这段代码正常执行

    // 如果kotlin接收java对象时，我们不确定是否可能会空，一定要声明为 ? 可空类型，这样才能保证代码是安全可靠的。
    // 而不是像 fmt1 一样，表面上没有报错，实际使用中则会报错空指针异常
}


fun sayMessage(str: String) {
    println(str)
}

// 命名对象(named objects)和伙伴对象(companion objects)下，可以使用 @JvmStatic
object KotlinStatic{
    @JvmStatic
    fun sayMessage(msg: String){
        println(msg)
    }

    @JvmStatic
    var name: String = "YiRan"
}