package pers.xiaoming.java_spring;

public class CalculatorImpl implements Calculator {
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

    private long add(long a, long b) {
        return a + b;
    }

    public final long sub(long a, long b) {
        return a - b;
    }
}
