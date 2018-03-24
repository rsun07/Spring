package pers.xiaoming.java_framework.spring_basic.aop_basic.traditional_impl;

public class CalculatorLoggingImpl implements Calculator {

    public int add(int a, int b) {
        System.out.println("Running the add method begins with [" + a + "," + b + "]");
        int result = a + b;
        System.out.println("Running the add method ends with " + result + "\n");
        return result;
    }

    public int sub(int a, int b) {
        System.out.println("Running the sub method begins with [" + a + "," + b + "]");
        int result = a - b;
        System.out.println("Running the sub method ends with " + result + "\n");
        return result;
    }

    public int mul(int a, int b) {
        System.out.println("Running the mul method begins with [" + a + "," + b + "]");
        int result = a * b;
        System.out.println("Running the mul method ends with " + result + "\n");
        return result;
    }

    public int div(int a, int b) {
        System.out.println("Running the div method begins with [" + a + "," + b + "]");
        int result = a / b;
        System.out.println("Running the div method ends with " + result + "\n");
        return result;
    }
}
