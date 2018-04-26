package pers.xiaoming.java_spring.jdk_dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class LogInvocationHandler implements InvocationHandler {
    private Object target;

    public LogInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     *
     * @param proxy the currently proxy instance, in normal cases, it should not be used within the invoke method
     * otherwise it may cause recursive invoke.
     * @param method the current method invoked from the target proxy instance
     * @param args the parameters passed when invoking the method
     *
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // For AOP, the @Before advice will execute here

        String methodName = method.getName();
        List<Object> argList = args == null ? null : Arrays.asList(args);
        System.out.println("Running the " + methodName + " method begins with " + argList);

        Object result = null;
        try {
            result = method.invoke(target, args);
            // For AOP, the @AfterRunning advice will execute here

            // For AOP, the @After advice will execute here
            // Because Exception may through before, so After advice cannot get the return value
        } catch (Exception e) {
            // For AOP, the @AfterThrowing advice will execute here

            // For AOP, the @After advice will execute here
            // Because Exception may through before, so After advice cannot get the return value
            // so whatever situation, @After advice got executed
            e.printStackTrace();
        }


        System.out.println("Running the " + methodName + " method ends with " + result + "\n");
        return result;
    }
}
