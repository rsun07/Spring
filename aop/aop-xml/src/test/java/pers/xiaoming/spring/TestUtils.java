package pers.xiaoming.spring;

import pers.xiaoming.spring.entity.AOPTarget;

import java.util.Arrays;

public class TestUtils {
    public static void printClassInfo(Class myClass) {
        System.out.printf("\nClass name is : %s\n"
                        + "Super Class is : %s\n"
                        + "Interfaces are : %s\n",
                myClass.getName(),
                myClass.getSuperclass(),
                Arrays.asList(myClass.getInterfaces()));
    }

    public static void testTarget(AOPTarget target) {
        target.print();
        System.out.println();
        target.toUppercase("Abc");
        System.out.println();
        target.toLowercase("Abc");
    }
}
