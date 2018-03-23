package com.xiaoming.java_framwork.spring_basic.aop_basic;

import com.xiaoming.java_framwork.spring_basic.aop_basic.traditional_impl.Calculator;
import com.xiaoming.java_framwork.spring_basic.aop_basic.traditional_impl.CalculatorLoggingImpl;
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
