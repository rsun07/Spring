package pers.xiaoming.java_spring.annotation_aop;

import org.springframework.stereotype.Component;

@Component("aopCalculator")
// doesn't need interface as using CGLIB
public class CalculatorAopImpl {
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
