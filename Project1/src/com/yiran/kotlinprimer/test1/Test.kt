package com.yiran.kotlinprimer.test1

import kotlin.reflect.KClass


// var 表示变量
// var age: Int = 18
// 编译器可以通过代码推断出你的变量类型，比如这里 18 为 Int，可以直接这样写，下面的String同理
var age = 18

// val 表示不可变的变量，而不是常量，之后会详细讲解
// val name: String = "Yi Ran"
// val name = "Yi Ran"

// kotlin中，表示这个类型是一个不可为空的变量，如果写的时候不确定是否可能为空，可以加一个?，如 String?
// val name2: String = null  // 报错
// val name3: String? = null

// String 与 String? 是两种完全不同的类型 它们之间不能互相赋值

var name: String = "Yi Ran"
var name2: String? = null

// 为了赋值首先要建一个方法

fun main(args: Array<String>) {
    // name = name2 // 报错，如果想给它赋值，那就加 !! 表示强转
    // name = name2!! // 确定 name2 不会为空了，就可以强转，但是如果为 null，则会报错 KotlinNullPointerException
    // name2 = name // 反过来，将 String 类型赋值给 String? 类型，则是完全可以的。
    // String? 表示可以为空的 String 类型，包含了String 类型本身

    printLen(name)

    // 调用方式  输出 JavaMain
    // 为什么会在后面加一个.java呢，这是因为java的class和kotlin的class格式是不一样的
    testClass(JavaMain::class.java)
    // 调用 kotlin 的class，这里就不需要在后面加 .java
    testClass(KotlinMain::class)

    // 在 kotlin 中，in 是一个关键字，在 JavaMain.java 中定义的 字符串in，不能直接写，否则会冲突
    // 所以用 ``(就是键盘esc下面的那个) 两个反引号去转义，比如调用刚刚定义的 in
    println(JavaMain.`in`)

}


// 函数
// fun 关键字表示申明一个函数 后面跟函数名，函数的参数与函数的变量类似 变量名: 类型
// 如果有返回值，则在括号后面加 : 返回类型
fun printLen(str: String): String{
    // kotlin 的模板语法，可以在字符串中直接引用变量，将其组合成新的字符串，如
    println("输入的字符串是：$str")
    return str
}


// 在 kotlin 中传递 java.class
fun testClass(clazz: Class<JavaMain>){
    println(clazz.simpleName)
}

// 调用 kotlin class的方式，同时这里可以看出 kotlin也支持重载
fun testClass(clazz: KClass<KotlinMain>){
    println(clazz.simpleName)
}