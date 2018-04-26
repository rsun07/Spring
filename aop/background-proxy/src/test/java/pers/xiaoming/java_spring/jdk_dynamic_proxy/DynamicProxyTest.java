package pers.xiaoming.java_spring.jdk_dynamic_proxy;

import org.junit.Assert;
import org.junit.Test;
import pers.xiaoming.java_spring.Calculator;
import pers.xiaoming.java_spring.CalculatorImpl;

import java.util.Arrays;

public class DynamicProxyTest {
    private Calculator target = new CalculatorImpl();

    // JDK dynamic proxy is reflection on interface
    /*
        Class name is : pers.xiaoming.java_spring.CalculatorImpl
        Super Class is : class java.lang.Object
        Interfaces are : [interface pers.xiaoming.java_spring.Calculator]

        Class name is : com.sun.proxy.$Proxy4
        Super Class is : class java.lang.reflect.Proxy
        Interfaces are : [interface pers.xiaoming.java_spring.Calculator]
     */
    @Test
    public void test() {
        Calculator proxy = new CalculatorLoggingProxy(target).getLoggingProxy();

        Assert.assertEquals(10, proxy.add(2,8));
        Assert.assertEquals(5, proxy.sub(8,3));
        Assert.assertEquals(24, proxy.mul(8,3));
        Assert.assertEquals(2, proxy.div(8,3));

        // CalculatorImpl
        printClassInfo(target.getClass());

        // com.sun.proxy.$Proxy4
        printClassInfo(proxy.getClass());
    }

    private void printClassInfo(Class myClass) {
        System.out.printf("\nClass name is : %s\n"
                + "Super Class is : %s\n"
                + "Interfaces are : %s\n",
                myClass.getName(),
                myClass.getSuperclass(),
                Arrays.asList(myClass.getInterfaces()));

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
