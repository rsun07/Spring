package pers.xiaoming.java_framework.spring_basic.aop_basic;

import pers.xiaoming.java_framework.spring_basic.aop_basic.dynamic_proxy_intro.CalculatorImpl;
import pers.xiaoming.java_framework.spring_basic.aop_basic.dynamic_proxy_intro.CalculatorLoggingProxy;
import pers.xiaoming.java_framework.spring_basic.aop_basic.traditional_impl.Calculator;
import org.junit.Test;

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
