package com.xiaoming.spring.aop_basic.dynamic_proxy_intro;

import com.xiaoming.spring.aop_basic.traditional_impl.Calculator;

public class CalculatorImpl implements Calculator {
    public double add(double a, double b) {
        double result = a + b;
        return result;
    }

    public double sub(double a, double b) {
        double result = a - b;
        return result;
    }

    public double mul(double a, double b) {
        double result = a * b;
        return result;
    }

    public double div(double a, double b) {
        double result = a / b;
        return result;
    }
}
