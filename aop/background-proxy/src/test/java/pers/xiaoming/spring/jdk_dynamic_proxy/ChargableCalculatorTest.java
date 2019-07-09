package pers.xiaoming.spring.jdk_dynamic_proxy;

import org.junit.Assert;
import org.junit.Test;
import pers.xiaoming.spring.CalculatorImpl;
import pers.xiaoming.spring.jdk_dynamic_proxy.advanced.ChargableCalculator;
import pers.xiaoming.spring.jdk_dynamic_proxy.advanced.ChargableCalculatorSeparatedInterfacesImpl;
import pers.xiaoming.spring.jdk_dynamic_proxy.advanced.ChargableCalculatorSeparatedInterfacesProxy;
import pers.xiaoming.spring.jdk_dynamic_proxy.advanced.ChargableCalculatorUnionedInterfaceImpl;
import pers.xiaoming.spring.jdk_dynamic_proxy.advanced.ChargableCalculatorUnionedInterfaceProxy;
import pers.xiaoming.spring.jdk_dynamic_proxy.advanced.ChargerImpl;

public class ChargableCalculatorTest {
    /*
        Exception throws in line 41 at ChargableCalculatorSeparatedInterfacesProxy.java
        java.lang.ClassCastException: com.sun.proxy.$Proxy4 cannot be cast to pers.xiaoming.spring.jdk_dynamic_proxy.advanced.ChargableCalculatorSeparatedInterfacesImpl
     */
    @Test(expected = ClassCastException.class)
    public void testTwoInterfaces() {
        ChargableCalculatorSeparatedInterfacesImpl target = new ChargableCalculatorSeparatedInterfacesImpl(
                new CalculatorImpl(), new ChargerImpl());

        try {
            ChargableCalculatorSeparatedInterfacesImpl proxy = new ChargableCalculatorSeparatedInterfacesProxy(target).getChargableCalculatorProxy();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Test
    public void testUnionedInterface() {
        ChargableCalculator target = new ChargableCalculatorUnionedInterfaceImpl(
                new CalculatorImpl(), new ChargerImpl());

        ChargableCalculator proxy = new ChargableCalculatorUnionedInterfaceProxy(target).getChargableCalculatorProxy();

        Assert.assertEquals(9, proxy.add(1, 8));
        proxy.charge();
    }
}
