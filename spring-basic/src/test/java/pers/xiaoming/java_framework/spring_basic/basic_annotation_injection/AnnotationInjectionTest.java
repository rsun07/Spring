package pers.xiaoming.java_framework.spring_basic.basic_annotation_injection;

import pers.xiaoming.java_framework.spring_basic.basic_annotation_injection.autowired_bean.MyNotRequiredAutowired;
import pers.xiaoming.java_framework.spring_basic.basic_annotation_injection.autowired_bean.MyService;
import pers.xiaoming.java_framework.spring_basic.basic_annotation_injection.AppConfig;
import pers.xiaoming.java_framework.spring_basic.basic_annotation_injection.autowired_bean.MyNotRequiredAutowired;
import pers.xiaoming.java_framework.spring_basic.basic_annotation_injection.autowired_bean.MyService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pers.xiaoming.java_framework.spring_basic.basic_annotation_injection.autowired_bean.MyNotRequiredAutowired;
import pers.xiaoming.java_framework.spring_basic.basic_annotation_injection.autowired_bean.MyService;

public class AnnotationInjectionTest {
    private ApplicationContext appContext;

    @Before
    public void setUp() {
        appContext = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @Test
    public void testConstructorAutowired() {
        MyService myService = (MyService) appContext.getBean("myConstructorAutowired");
        Assert.assertEquals("myRepo", myService.showRepo());
    }

    @Test
    public void testParameterAutowired() {
        // use java_framework default bean name
        MyService myService = (MyService) appContext.getBean("myParameterAutowired");
        Assert.assertEquals("My Repository", myService.showRepo());
    }

    @Test
    public void testParameterInject() {
        // use customized bean name
        MyService myService = (MyService) appContext.getBean("customized bean name: parameter inject");
        Assert.assertEquals("My Repository", myService.showRepo());
    }

    @Test
    public void testSetterAutowired() {
        MyService myService = (MyService) appContext.getBean("mySetterAutowired");
        Assert.assertEquals("myRepo", myService.showRepo());
    }

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void testNotScannedBean() {
        appContext.getBean("not scanned");
    }

    @Test
    public void testNotRequired() {
        MyNotRequiredAutowired myService = (MyNotRequiredAutowired) appContext.getBean("myNotRequiredAutowired");
        Assert.assertNull(myService.getMyRepo());
    }
}
