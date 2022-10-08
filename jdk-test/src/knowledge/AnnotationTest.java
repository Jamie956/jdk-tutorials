package knowledge;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AnnotationTest {
    /**
     * 定义一个注解
     * Target ElementType.TYPE 作用对象：类、接口、枚举类
     * Target ElementType.METHOD 作用对象：方法
     * Retention RetentionPolicy.RUNTIME 编译时写到class，虚拟机运行时创建
     * Retention RetentionPolicy.SOURCE 编译时移除
     * Retention RetentionPolicy.CLASS 编译时写到class，虚拟机运行时不创建
     */
    @Target({ElementType.TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Role {
        String value();
    }

    @Role(value = "admin")
    static class Student {
    }

    @Role(value = "user")
    static class Teacher {
    }

    public static void main(String[] args) {
        System.out.println(new Student().getClass().getAnnotation(Role.class).value());
        System.out.println(new Teacher().getClass().getAnnotation(Role.class).value());
    }
}

