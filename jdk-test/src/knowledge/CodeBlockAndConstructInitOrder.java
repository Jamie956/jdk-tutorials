package knowledge;

public class CodeBlockAndConstructInitOrder {
    public static void main(String[] args) {
        //静态代码块只加载一次
        new Child();
        System.out.println("-----------------");
        new Child();
    }
}

class Parent {
    static {
        System.out.println("父类静态代码块");
    }

    {
        System.out.println("父类代码块");
    }

    Parent() {
        System.out.println("父类构造函数");
    }
}

class Child extends Parent {
    static {
        System.out.println("子类静态代码块");
    }

    {
        System.out.println("子类代码块");
    }

    public Child() {
        System.out.println("子类构造函数");
    }
}
