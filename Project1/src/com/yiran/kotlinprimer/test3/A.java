package com.yiran.kotlinprimer.test3;

// 空值敏感问题
public class A {
    public static String format(String string){
        // 为空返回null
        return string.isEmpty()?null:string;
    }

    public static void main(String[] args) {
        // TestKt.sayMessage(null);
        KotlinStatic.sayMessage("测试");
        // 在 kotlin 中定义的变量会自动被隔断开，使用set() get()方式来运用
        System.out.println(KotlinStatic.getName());
    }
}
