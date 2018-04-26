package pers.xiaoming.java_spring;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Ignore("demo test")
public class CGLIBAopTest {
    /*

        Class name is : com.sun.proxy.$Proxy6
        Super Class is : class java.lang.reflect.Proxy
        Interfaces are : [interface pers.xiaoming.java_spring.AOPTarget, interface org.springframework.aop.SpringProxy, interface org.springframework.aop.framework.Advised]

        Class name is : pers.xiaoming.java_spring.AOPTargetNoInterface$$EnhancerBySpringCGLIB$$34683113
        Super Class is : class pers.xiaoming.java_spring.AOPTargetNoInterface
        Interfaces are : [interface org.springframework.aop.SpringProxy, interface org.springframework.aop.framework.Advised, interface org.springframework.cglib.proxy.Factory]

        Class name is : pers.xiaoming.java_spring.AOPTargetImpl$$EnhancerBySpringCGLIB$$6cba5f42
        Super Class is : class pers.xiaoming.java_spring.AOPTargetImpl
        Interfaces are : [interface pers.xiaoming.java_spring.AOPTarget, interface org.springframework.aop.SpringProxy, interface org.springframework.aop.framework.Advised, interface org.springframework.cglib.proxy.Factory]
    */
    @Test
    public void noInterfaceProxy() {
        ApplicationContext jdkAopAc = new ClassPathXmlApplicationContext("singleAopContext.xml");
        AOPTarget interfaceProxy = (AOPTarget) jdkAopAc.getBean("beforeAdviceProxy");
        ClassInfoPrinter.print(interfaceProxy.getClass());

        ApplicationContext cglibAOPAc = new ClassPathXmlApplicationContext("cglibAopContext.xml");
        AOPTargetNoInterface noInterfaceProxy = (AOPTargetNoInterface) cglibAOPAc.getBean("noInterfaceProxy");
        ClassInfoPrinter.print(noInterfaceProxy.getClass());

        AOPTarget forceCGLIBProxy = (AOPTarget) cglibAOPAc.getBean("forceCGLIBProxy");
        ClassInfoPrinter.print(forceCGLIBProxy.getClass());
    }
}
