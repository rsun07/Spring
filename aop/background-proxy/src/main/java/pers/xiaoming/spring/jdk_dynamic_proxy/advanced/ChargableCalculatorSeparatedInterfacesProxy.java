package pers.xiaoming.spring.jdk_dynamic_proxy.advanced;

import pers.xiaoming.spring.jdk_dynamic_proxy.LogInvocationHandler;
import pers.xiaoming.spring.Calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ChargableCalculatorSeparatedInterfacesProxy {

    private ChargableCalculatorSeparatedInterfacesImpl target;

    public ChargableCalculatorSeparatedInterfacesProxy(ChargableCalculatorSeparatedInterfacesImpl target) {
        this.target = target;
    }

    public ChargableCalculatorSeparatedInterfacesImpl getChargableCalculatorProxy() {
        ChargableCalculatorSeparatedInterfacesImpl proxy = null;

        ClassLoader classLoader = target.getClass().getClassLoader();

        Class[] interfaces = new Class[]{Calculator.class, Chargable.class};

        InvocationHandler invocationHandler = new LogInvocationHandler(target);

        proxy = (ChargableCalculatorSeparatedInterfacesImpl) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        return proxy;
    }
}
