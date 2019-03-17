package com.yiran.kotlinprimer.test2

import kotlin.reflect.KClass
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.jvm.javaMethod

fun main(args: Array<String>) {
    // 调用 java 方法
    // 输出 int
    A.a.putNumber(123)
    // 输出 Integer，当参数为null时，才会调用 Integer 的方法
    A.a.putNumber(null)

    // 通过反射调用 Integer 方法
    // 通过类::class的方式获取KClass实例
    // val clazz: KClass<*> = A::class

    // 通过实例.javaClass.kotlin获取KClass实例
    val a: A = A()
    val clazz: KClass<*> = a.javaClass.kotlin
    clazz.declaredFunctions.forEach{
        println(it.javaMethod)
        it.javaMethod!!.invoke(a,11)
    }
}