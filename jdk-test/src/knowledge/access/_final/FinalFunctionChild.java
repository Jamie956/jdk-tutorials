package knowledge.access._final;

import org.junit.Test;

public class FinalFunctionChild extends FinalFunctionParent{
    //unable override parent final function
//    @Override
//    public void finalFunction() {
//        System.out.println("child");
//    }

    @Test
    public void parentFunction() {
        finalFunction();
    }

}
