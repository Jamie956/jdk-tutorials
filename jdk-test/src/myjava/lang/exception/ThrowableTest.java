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

    @Test
    public void getMessage() throws Throwable {
        Throwable a = new Throwable("ops");
        String m = a.getMessage();
        throw a;
    }

    @Test
    public void getLocalizedMessage() throws Throwable {
        Throwable a = new Throwable("ops");
        String m = a.getLocalizedMessage();
        throw a;
    }

    @Test
    public void getCause() throws Throwable {
        Throwable b = new Throwable("exp b");
        Throwable a = new Throwable("exp a", b);
        Throwable c = a.getCause();
        throw a;
    }

    @Test
    public void initCause() throws Throwable {
        Throwable b = new Throwable("exp b");
        Throwable a = new Throwable("exp a");
        Throwable r = a.initCause(b);
        throw a;
    }

    @Test
    public void toString1() throws Throwable {
        Throwable a = new Throwable("exp a");
        String s = a.toString();
        throw a;
    }












}
