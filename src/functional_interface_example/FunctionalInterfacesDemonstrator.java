package functional_interface_example;

import java.time.Duration;
import java.time.LocalDate;

public class FunctionalInterfacesDemonstrator {

    public static void demonstrateFuncInterfacesWork() {
        Summable summable = obj -> obj instanceof Number;

        System.out.println(summable.isSummable(new Integer(32)));
        System.out.println(summable.isSummable(new Double(32.0)));
        System.out.println(summable.isSummable(new String("abc")));
    }
}