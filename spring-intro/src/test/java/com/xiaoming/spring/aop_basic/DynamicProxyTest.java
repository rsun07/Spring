package com.xiaoming.spring.aop_basic;

import com.xiaoming.spring.aop_basic.dynamic_proxy_intro.CalculatorImpl;
import com.xiaoming.spring.aop_basic.dynamic_proxy_intro.CalculatorLoggingProxy;
import com.xiaoming.spring.aop_basic.traditional_impl.Calculator;
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

        // com.xiaoming.spring.aop_basic.dynamic_proxy_intro.CalculatorImpl
        System.out.println(target.getClass().getName());

        // com.sun.proxy.$Proxy4
        System.out.println(proxy.getClass().getName());
    }
}
