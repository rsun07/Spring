package com.xiaoming.spring.aop_basic.spring_aop;

import com.xiaoming.spring.aop_basic.traditional_impl.Calculator;
import org.springframework.stereotype.Component;

@Component("aopCalculator")
public class CalculatorAopImpl implements Calculator {
    CalculatorAopImpl() {
    }

    public int add(int a, int b) {
        int result = a + b;
        return result;
    }

    public int sub(int a, int b) {
        int result = a - b;
        return result;
    }

    public int mul(int a, int b) {
        int result = a * b;
        return result;
    }

    public int div(int a, int b) {
        int result = a / b;
        return result;
    }

    // test method for around advice @Around
    public double divide(int a, int b) {
        int result = a / b;
        return result;
    }
}
