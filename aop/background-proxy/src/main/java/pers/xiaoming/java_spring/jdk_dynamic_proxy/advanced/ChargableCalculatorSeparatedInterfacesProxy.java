package pers.xiaoming.java_spring.jdk_dynamic_proxy.advanced;

import pers.xiaoming.java_spring.Calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ChargableCalculatorSeparatedInterfacesProxy {

    private ChargableCalculatorSeparatedInterfacesImpl target;

    public ChargableCalculatorSeparatedInterfacesProxy(ChargableCalculatorSeparatedInterfacesImpl target) {
        this.target = target;
    }

    public ChargableCalculatorSeparatedInterfacesImpl getChargableCalculatorProxy() {
        ChargableCalculatorSeparatedInterfacesImpl proxy = null;

        ClassLoader classLoader = target.getClass().getClassLoader();

        Class[] interfaces = new Class[]{Calculator.class, Chargable.class};

        InvocationHandler invocationHandler = (proxy1, method, args) -> {

            String methodName = method.getName();
            System.out.println("Running the " + methodName + " method begins with " + Arrays.asList(args));

            Object result = null;
            try {
                result = method.invoke(target, args);
            } catch (Exception e) {
                e.printStackTrace();
            }


            System.out.println("Running the " + methodName + " method ends with " + result + "\n");
            return result;
        };

        proxy = (ChargableCalculatorSeparatedInterfacesImpl) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        return proxy;
    }
}
