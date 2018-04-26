package pers.xiaoming.java_spring.jdk_dynamic_proxy.advanced;

import pers.xiaoming.java_spring.Calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;

public class ChargableCalculatorUnionedInterfaceProxy {

    private ChargableCalculator target;

    public ChargableCalculatorUnionedInterfaceProxy(ChargableCalculator target) {
        this.target = target;
    }

    public ChargableCalculator getChargableCalculatorProxy() {
        ChargableCalculator proxy = null;

        ClassLoader classLoader = target.getClass().getClassLoader();

        Class[] interfaces = new Class[]{ChargableCalculator.class};

        InvocationHandler invocationHandler = (proxy1, method, args) -> {

            String methodName = method.getName();
            List<Object> argList = args == null ? null : Arrays.asList(args);
            System.out.println("Running the " + methodName + " method begins with " + argList);

            Object result = null;
            try {
                result = method.invoke(target, args);
            } catch (Exception e) {
                e.printStackTrace();
            }


            System.out.println("Running the " + methodName + " method ends with " + result + "\n");
            return result;
        };

        proxy = (ChargableCalculator) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        return proxy;
    }
}
