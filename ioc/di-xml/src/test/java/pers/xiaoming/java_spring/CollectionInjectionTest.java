package pers.xiaoming.java_spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.xiaoming.java_spring.di_xml_entity.MyCollections;

public class CollectionInjectionTest {
    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("collectionInjectionContext.xml");
        MyCollections myCollections = ac.getBean(MyCollections.class);
        System.out.println(myCollections);
    }
}
