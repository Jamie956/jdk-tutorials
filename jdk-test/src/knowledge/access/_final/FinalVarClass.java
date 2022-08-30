package knowledge.access._final;

import org.junit.Test;

public class FinalVarClass {
    final int i = 1;
    final Object[] arr = {1,2};

    @Test
    public void changeFinalValue() {
        //unable to change final int value
//        i = 2;
    }

    @Test
    public void changeFinalObjectValue() {
        arr[0] = 3;
        System.out.println(arr[0]);
    }

    @Test
    public void changeFinalObjectPointer() {
        Object[] arr2 = {5,6};
        //unable to change final object pointer
//        arr = arr2;
    }

}
