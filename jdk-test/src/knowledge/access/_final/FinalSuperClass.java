package knowledge.access._final;

import org.junit.Test;

//all function default final
public final class FinalSuperClass {
    int i = 1;

    public void parentFunction() {
        System.out.println("parent");
    }

    @Test
    public void changeValue() {
        //able to change int value under final class
        i = 2;
    }
}
