package pers.xiaoming.java_spring.advice;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.xiaoming.java_spring.ClassInfoPrinter;
import pers.xiaoming.java_spring.entity.AOPTarget;
import pers.xiaoming.java_spring.entity.AOPTargetNoInterface;

@Ignore("demo test")
public class CGLIBAopTest {
    /*

        Class name is : com.sun.proxy.$Proxy6
        Super Class is : class java.lang.reflect.Proxy
        Interfaces are : [interface pers.xiaoming.java_spring.entity.AOPTarget, interface org.springframework.aop.SpringProxy, interface org.springframework.aop.framework.Advised]

        Class name is : pers.xiaoming.java_spring.entity.AOPTargetNoInterface$$EnhancerBySpringCGLIB$$34683113
        Super Class is : class pers.xiaoming.java_spring.entity.AOPTargetNoInterface
        Interfaces are : [interface org.springframework.aop.SpringProxy, interface org.springframework.aop.framework.Advised, interface org.springframework.cglib.proxy.Factory]

        Class name is : pers.xiaoming.java_spring.entity.AOPTargetImpl$$EnhancerBySpringCGLIB$$6cba5f42
        Super Class is : class pers.xiaoming.java_spring.entity.AOPTargetImpl
        Interfaces are : [interface pers.xiaoming.java_spring.entity.AOPTarget, interface org.springframework.aop.SpringProxy, interface org.springframework.aop.framework.Advised, interface org.springframework.cglib.proxy.Factory]
    */
    @Test
    public void noInterfaceProxy() {
        ApplicationContext jdkAopAc = new ClassPathXmlApplicationContext("singleAdviseContext.xml");
        AOPTarget interfaceProxy = (AOPTarget) jdkAopAc.getBean("beforeAdviceProxy");
        ClassInfoPrinter.print(interfaceProxy.getClass());

        ApplicationContext cglibAOPAc = new ClassPathXmlApplicationContext("cglibAdviseContext.xml");
        AOPTargetNoInterface noInterfaceProxy = (AOPTargetNoInterface) cglibAOPAc.getBean("noInterfaceProxy");
        ClassInfoPrinter.print(noInterfaceProxy.getClass());

        AOPTarget forceCGLIBProxy = (AOPTarget) cglibAOPAc.getBean("forceCGLIBProxy");
        ClassInfoPrinter.print(forceCGLIBProxy.getClass());
    }
}
