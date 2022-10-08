package knowledge.staticclz;

/**
 * 静态内部类测试外部类
 */
public class StaticInnerClassTest {
    private int outerNonStaticVar = 1;
    private static int outerStaticVar = 2;

    public void outerFun() {
        //先实例化静态内部类再访问内部类非静态变量
        System.out.println(new InnerClass().innerNonStaticVar);
        //访问静态内部类静态变量不需要实例化
        System.out.println(InnerClass.innerStaticVar);
    }

    public void outerFun2() {
    }
    public static void outerFun3() {
    }
    static class InnerClass {
        private int innerNonStaticVar = 3;
        private static int innerStaticVar = 4;

        public void innerFun() {
            new StaticInnerClassTest().outerFun2();
            //静态内部类可以访问外部类静态方法
            outerFun3();
            //静态内部类不可以访问外部类的非静态变量
//            System.out.println(outerNonStaticVar);
            //静态内部类可以访问外部类的静态变量
            System.out.println(outerStaticVar);
        }
    }

    public static void main(String[] args) {
        StaticInnerClassTest staticInnerTest = new StaticInnerClassTest();
        staticInnerTest.outerFun();

        InnerClass innerClass = new InnerClass();
        innerClass.innerFun();
    }
}