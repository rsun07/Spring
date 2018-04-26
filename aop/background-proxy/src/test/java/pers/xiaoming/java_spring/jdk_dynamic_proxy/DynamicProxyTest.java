package pers.xiaoming.java_spring.jdk_dynamic_proxy;

import org.junit.Test;
import pers.xiaoming.java_spring.Calculator;
import pers.xiaoming.java_spring.CalculatorImpl;

public class DynamicProxyTest {
    private Calculator target = new CalculatorImpl();

    @Test
    public void test() {
        Calculator proxy = new CalculatorLoggingProxy(target).getLoggingProxy();

        proxy.add(2, 8);
        proxy.sub(8, 3);
        proxy.mul(8,3);
        proxy.div(8,3);

        // CalculatorImpl
        System.out.println(target.getClass().getName());

        // com.sun.proxy.$Proxy4
        System.out.println(proxy.getClass().getName());
    }

    /*
        JDK dynamic proxy is proxy based on interface.
        See java.lang.reflect.Proxy implement for more detail.

        java.lang.ClassCastException: com.sun.proxy.$Proxy4 cannot be cast to pers.xiaoming.java_spring.CalculatorImpl
     */
    @Test(expected = ClassCastException.class)
    public void testCastToImpl() {
        try {
            CalculatorImpl proxy = (CalculatorImpl) new CalculatorLoggingProxy(target).getLoggingProxy();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
