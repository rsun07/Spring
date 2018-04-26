package pers.xiaoming.java_spring.non_apo_impl;

import org.junit.Test;

public class TraditionalImplTest {
    @Test
    public void test() {
        Calculator calculator = new CalculatorLoggingImpl();
        calculator.add(2,8);
        calculator.sub(8,3);
        calculator.mul(8,3);
        calculator.div(8,3);
    }
}
