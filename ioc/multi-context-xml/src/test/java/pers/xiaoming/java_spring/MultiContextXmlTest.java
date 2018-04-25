package pers.xiaoming.java_spring;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MultiContextXmlTest {
    @Test
    public void testEqualMultiXmls() {
        String[] resourceFiles = {
                "spring-a.xml",
                "spring-b.xml"
        };

        ApplicationContext ac = new ClassPathXmlApplicationContext(resourceFiles);
        MyEntity myEntityA = (MyEntity) ac.getBean("myEntityA");
        MyEntity myEntityB = (MyEntity) ac.getBean("myEntityB");

        Assert.assertEquals(new MyEntity("myEntityA"), myEntityA);
        Assert.assertEquals(new MyEntity("myEntityB"), myEntityB);
    }

    @Test
    public void testAggregatedMultiXmls() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyEntity myEntityA = (MyEntity) ac.getBean("myEntityA");
        MyEntity myEntityB = (MyEntity) ac.getBean("myEntityB");

        Assert.assertEquals(new MyEntity("myEntityA"), myEntityA);
        Assert.assertEquals(new MyEntity("myEntityB"), myEntityB);
    }
}
