package com.yiran.kotlinprimer.test2

class B : AInterface {
    // 初始化
    companion object {
        val b = B()
    }

    override fun putNumber(num: Int) {
        print("int")
    }

    // 编译器会直接提示你，这两个方法是重名的，在kotlin中没有Integer这个类，所以不能申明这样一个方法
    // 所以，虽然接口有两个方法，但是kotlin认为那两个方法是重名的，只实现一个没有问题
    /*override fun putNumber(num: Int?) {
        print("Integer")
    }*/
}