package pers.xiaoming.spring.cglib_dynamic_proxy;

import net.sf.cglib.proxy.Enhancer;
import org.junit.Assert;
import org.junit.Test;
import pers.xiaoming.spring.ClassInfoPrinter;

public class DynamicProxyTest {
    // CGLIB use inherit to implement the proxy
    // Proxy class's super class is target class
    /*
        Class name is : pers.xiaoming.spring.cglib_dynamic_proxy.NoInterfaceCalculator$$EnhancerByCGLIB$$85b80530
        Super Class is : class pers.xiaoming.spring.cglib_dynamic_proxy.NoInterfaceCalculator
        Interfaces are : [interface net.sf.cglib.proxy.Factory]
     */
    @Test
    public void test() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(NoInterfaceCalculator.class);
        enhancer.setCallback(new LogMethodInterceptor());

        NoInterfaceCalculator proxy = (NoInterfaceCalculator) enhancer.create();
        Assert.assertEquals(10, proxy.add(2,8));
        Assert.assertEquals(5, proxy.sub(8,3));
        Assert.assertEquals(24, proxy.mul(8,3));
        Assert.assertEquals(2, proxy.div(8,3));

        ClassInfoPrinter.print(proxy.getClass());
    }
}
