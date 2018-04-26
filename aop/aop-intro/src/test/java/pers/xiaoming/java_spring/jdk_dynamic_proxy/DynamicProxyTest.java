package pers.xiaoming.java_spring.jdk_dynamic_proxy;

import org.junit.Test;
import pers.xiaoming.java_spring.non_apo_impl.Calculator;

public class DynamicProxyTest {
    @Test
    public void test() {
        Calculator target = new CalculatorImpl();
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
}
