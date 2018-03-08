package com.xiaoming.spring.aop_basic.spring_aop;

import com.xiaoming.spring.aop_basic.traditional_impl.Calculator;
import org.springframework.stereotype.Component;

@Component("aopCalculator")
public class CalculatorAopImpl implements Calculator {
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
