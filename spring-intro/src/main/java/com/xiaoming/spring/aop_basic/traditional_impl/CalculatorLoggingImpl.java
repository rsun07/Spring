package com.xiaoming.spring.aop_basic.traditional_impl;

public class CalculatorLoggingImpl implements Calculator {

    public double add(double a, double b) {
        System.out.println("Running the add method begins with [" + a + "," + b + "]");
        double result = a + b;
        System.out.println("Running the add method ends with " + result + "\n");
        return result;
    }

    public double sub(double a, double b) {
        System.out.println("Running the sub method begins with [" + a + "," + b + "]");
        double result = a - b;
        System.out.println("Running the sub method ends with " + result + "\n");
        return result;
    }

    public double mul(double a, double b) {
        System.out.println("Running the mul method begins with [" + a + "," + b + "]");
        double result = a * b;
        System.out.println("Running the mul method ends with " + result + "\n");
        return result;
    }

    public double div(double a, double b) {
        System.out.println("Running the div method begins with [" + a + "," + b + "]");
        double result = a / b;
        System.out.println("Running the div method ends with " + result + "\n");
        return result;
    }
}
