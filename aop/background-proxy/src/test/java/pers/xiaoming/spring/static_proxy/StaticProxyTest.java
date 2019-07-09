package pers.xiaoming.spring.static_proxy;

import org.junit.Assert;
import org.junit.Test;
import pers.xiaoming.spring.Calculator;
import pers.xiaoming.spring.CalculatorImpl;

public class StaticProxyTest {
    @Test
    public void test() {
        Calculator calculator = new CalculatorStaticProxyLoggingImpl(new CalculatorImpl());
        Assert.assertEquals(10, calculator.add(2,8));
        Assert.assertEquals(5, calculator.sub(8,3));
        Assert.assertEquals(24, calculator.mul(8,3));
        Assert.assertEquals(2, calculator.div(8,3));
    }
}
