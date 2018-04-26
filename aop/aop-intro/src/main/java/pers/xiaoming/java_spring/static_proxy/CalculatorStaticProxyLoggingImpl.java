package pers.xiaoming.java_spring.static_proxy;

import pers.xiaoming.java_spring.Calculator;

public class CalculatorStaticProxyLoggingImpl implements Calculator {

    private Calculator calculator;

    CalculatorStaticProxyLoggingImpl(Calculator calculator) {
        this.calculator = calculator;
    }

    public int add(int a, int b) {
        System.out.println("Running the add method begins with [" + a + "," + b + "]");
        int result = calculator.add(a, b);
        System.out.println("Running the add method ends with " + result + "\n");
        return result;
    }

    public int sub(int a, int b) {
        System.out.println("Running the sub method begins with [" + a + "," + b + "]");
        int result = calculator.sub(a, b);
        System.out.println("Running the sub method ends with " + result + "\n");
        return result;
    }

    public int mul(int a, int b) {
        System.out.println("Running the mul method begins with [" + a + "," + b + "]");
        int result = calculator.mul(a, b);
        System.out.println("Running the mul method ends with " + result + "\n");
        return result;
    }

    public int div(int a, int b) {
        System.out.println("Running the div method begins with [" + a + "," + b + "]");
        int result = calculator.div(a, b);
        System.out.println("Running the div method ends with " + result + "\n");
        return result;
    }
}
