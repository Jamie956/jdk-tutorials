package com.cat;

/**
 * 静态内部类测试外部类
 */
public class StaticInnerTest {
    private int x = 1;
    private static int y = 2;

    public void test() {
        //本类访问静态内部类的非静态变量需要本类先实例化
        System.out.println(new InnerClass().a);
        //本类访问静态内部类的静态变量不需要实例化本类
        System.out.println(InnerClass.b);
    }

    public void a() {
    }
    public static void b() {
    }
    static class InnerClass {
        private int a = 3;
        private static int b = 4;

        public void test() {
//            StaticInnerTest.a();
            //外部类静态方法
            b();
            //静态内部类不可以访问外部类的非静态变量
//            System.out.println(x);
            //静态内部类可以访问外部类的静态变量
            System.out.println(y);
        }
    }

    public static void main(String[] args) {
        StaticInnerTest staticInnerTest = new StaticInnerTest();
        staticInnerTest.test();

        InnerClass innerClass = new InnerClass();
        innerClass.test();
    }
}