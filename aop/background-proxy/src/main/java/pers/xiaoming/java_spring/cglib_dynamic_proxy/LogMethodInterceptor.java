package pers.xiaoming.java_spring.cglib_dynamic_proxy;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class LogMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        String methodName = method.getName();
        List<Object> argList = args == null ? null : Arrays.asList(args);
        System.out.println("Running the " + methodName + " method begins with " + argList);

        Object result = null;
        try {
            result = proxy.invokeSuper(object, args);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Running the " + methodName + " method ends with " + result + "\n");
        return result;
    }
}
