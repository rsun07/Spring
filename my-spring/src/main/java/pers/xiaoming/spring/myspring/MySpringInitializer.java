package pers.xiaoming.spring.myspring;

import pers.xiaoming.spring.myspring.annotation.MyBean;
import pers.xiaoming.spring.myspring.annotation.MyComponent;
import pers.xiaoming.spring.myspring.annotation.MyConfiguration;
import pers.xiaoming.spring.myspring.annotation.MyService;
import pers.xiaoming.spring.myspring.annotation.MySpringApp;
import pers.xiaoming.spring.myspring.annotation.MyValue;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class MySpringInitializer {
    private static final String DEFAULT_CONFIG_PATH = "classpath:application.properties";
    private Properties properties;
    private Map<String, Object> beanMap;

    public void init(Class className) {
        properties = loadProperties(DEFAULT_CONFIG_PATH);

        String packageName = getScanPackage(className);

        List<String> classNames = new ArrayList<>();
        scanClasses(packageName, classNames);

        beanMap = new HashMap<>();
        instanceBeans(classNames);
    }

    private Properties loadProperties(String propertyPath) {
        Properties properties = new Properties();
        try (InputStream fileInputStream = this.getClass().getClassLoader().getResourceAsStream(propertyPath)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }


    private String getScanPackage(Class mainClass) {
        if (mainClass.isAnnotationPresent(MySpringApp.class)) {
            MySpringApp mySpringApp = (MySpringApp) mainClass.getAnnotation(MySpringApp.class);
            return mySpringApp.scanPackage();
        } else {
            throw new RuntimeException("No package found");
        }
    }

    private void scanClasses(String packageName, List<String> classNames) {
        URL url = this.getClass().getClassLoader().getResource("/" + packageName.replaceAll("\\.","/"));

        if (url == null) return;

        File rootDir = new File(url.getFile());

        for (File file : rootDir.listFiles()) {
            if (file.isDirectory()) {
                scanClasses(packageName + "." + file.getName(), classNames);
            } else {
                String className = packageName + "." + file.getName().replace(".class", "");
                classNames.add(className);
            }
        }
    }

    private void instanceBeans(List<String> classNames) {
        for (String className : classNames) {
            try {
                Class<?> clazz = Class.forName(className);

                if (clazz.isAnnotationPresent(MyConfiguration.class)) {
                    instanceConfigBeans(clazz);
                } else if (clazz.isAnnotationPresent(MyService.class) || clazz.isAnnotationPresent(MyComponent.class)) {
                    instanceComponent(clazz);
                } else {
                    // ignore no annotated classes
                }

            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Class not found " + className);
            }
        }
    }

    private void instanceConfigBeans(Class<?> clazz) {
        instanceFields(clazz);

        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            Parameter[] params = method.getParameters();
            if (method.isAnnotationPresent(MyBean.class)) {
                instanceParams(params);
            }
            try {
                method.invoke(method, (Object[]) params);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void instanceFields(Class<?> clazz) {
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(MyValue.class)) {
                MyValue myValue = field.getAnnotation(MyValue.class);
                String key = myValue.value();
                field.setAccessible(true);
                try {
                    field.set(field.getClass(), properties.get(key));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void instanceParams(Parameter[] params) {
        for (int i = 0; i < params.length; i++) {
            if (params[i].isAnnotationPresent(MyValue.class)) {
                MyValue myValue = params[i].getAnnotation(MyValue.class);
                String key = myValue.value();

                // here we need to handle param type
                // just ignore here to reduce complexity
                // Type type = params[i].getType();
                params[i] = (Parameter) properties.get(key);
            }
        }
    }

    private void instanceComponent(Class<?> clazz) {

    }
}
