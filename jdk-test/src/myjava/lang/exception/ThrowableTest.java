package myjava.lang.exception;

import org.junit.Test;

public class ThrowableTest {
    @Test
    public void cons() throws Throwable {
        Throwable a = new Throwable();
        throw a;
    }

    @Test
    public void cons2() throws Throwable {
        Throwable a = new Throwable("eeeee");
        throw a;
    }

    @Test
    public void cons3() throws Throwable {
        Throwable b = new Throwable("exp b");

        Throwable a = new Throwable("exp a", b);
        throw a;
    }

    @Test
    public void cons4() throws Throwable {
        Throwable b = new Throwable("exp b");
        Throwable a = new Throwable(b);
        throw a;
    }

}
