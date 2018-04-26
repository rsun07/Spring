package pers.xiaoming.java_spring;

import java.util.Arrays;

public class ClassInfoPrinter {
    public static void print(Class myClass) {
        System.out.printf("\nClass name is : %s\n"
                        + "Super Class is : %s\n"
                        + "Interfaces are : %s\n",
                myClass.getName(),
                myClass.getSuperclass(),
                Arrays.asList(myClass.getInterfaces()));
    }
}
