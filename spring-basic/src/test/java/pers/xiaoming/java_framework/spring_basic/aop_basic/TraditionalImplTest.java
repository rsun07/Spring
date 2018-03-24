package pers.xiaoming.java_framework.spring_basic.aop_basic;

import pers.xiaoming.java_framework.spring_basic.aop_basic.traditional_impl.Calculator;
import pers.xiaoming.java_framework.spring_basic.aop_basic.traditional_impl.CalculatorLoggingImpl;
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
