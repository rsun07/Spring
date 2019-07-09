package pers.xiaoming.spring.jdk_dynamic_proxy.advanced;

import pers.xiaoming.spring.jdk_dynamic_proxy.LogInvocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ChargableCalculatorUnionedInterfaceProxy {

    private ChargableCalculator target;

    public ChargableCalculatorUnionedInterfaceProxy(ChargableCalculator target) {
        this.target = target;
    }

    public ChargableCalculator getChargableCalculatorProxy() {
        ChargableCalculator proxy = null;

        ClassLoader classLoader = target.getClass().getClassLoader();

        Class[] interfaces = new Class[]{ChargableCalculator.class};

        InvocationHandler invocationHandler = new LogInvocationHandler(target);

        proxy = (ChargableCalculator) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        return proxy;
    }
}
