package pers.xiaoming.spring.myspring;

import pers.xiaoming.spring.myspring.annotation.MyAutowired;
import pers.xiaoming.spring.myspring.annotation.MyBean;
import pers.xiaoming.spring.myspring.annotation.MyComponent;
import pers.xiaoming.spring.myspring.annotation.MyConfiguration;
import pers.xiaoming.spring.myspring.annotation.MyQualifier;
import pers.xiaoming.spring.myspring.annotation.MyService;
import pers.xiaoming.spring.myspring.annotation.MySpringApp;
import pers.xiaoming.spring.myspring.annotation.MyValue;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
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
            Class<?> clazz;
            try {
                clazz = Class.forName(className);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Class not found " + className);
            }
            instanceBean(clazz);
        }
    }

    // TODO : avoid same bean be initialize more than onece
    private void instanceBean(Class clazz) {
        if (clazz.isAnnotationPresent(MyConfiguration.class)) {
            instanceConfigBean(clazz);
        } else if (clazz.isAnnotationPresent(MyService.class) || clazz.isAnnotationPresent(MyComponent.class)) {
            instanceComponent(clazz);
        } else {
            // ignore no annotated classes
        }
    }

    private void instanceConfigBean(Class<?> clazz) {
        instanceFields(clazz);

        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            Parameter[] paramClasses = method.getParameters();
            Object[] parameters = new Object[];
            if (method.isAnnotationPresent(MyBean.class)) {
                parameters = instanceParams(paramClasses);
            }
            try {
                Object bean = method.invoke(method, parameters);
                beanMap.put(beanNameHandler(method), bean);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private String beanNameHandler(Method method) {
        MyBean myBean = method.getAnnotation(MyBean.class);
        String defaultName = myBean.value();
        if (!"".equals(defaultName)) {
            return defaultName;
        }

        String beanClassName = method.getReturnType().getName();
        return firstLetterLower(beanClassName);
    }

    private String firstLetterLower(String methodName) {
        char[] chars = methodName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
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

    // Assumption: All @MyBean methods' or @MyAutowired Constructors' parameters are from beanMap
    private Object[] instanceParams(Parameter[] paramClasses) {
        Object[] parameters = new Object[paramClasses.length];
        for (int i = 0; i < paramClasses.length; i++) {
            if (paramClasses[i].isAnnotationPresent(MyValue.class)) {
                String key = paramClasses[i].getAnnotation(MyValue.class).value();
                parameters[i] = properties.get(key);
            } else {
                String beanName = "";
                if (paramClasses[i].isAnnotationPresent(MyQualifier.class)) {
                    beanName = paramClasses[i].getAnnotation(MyQualifier.class).value();
                } else {
                    beanName = firstLetterLower(paramClasses[i].getType().getName());
                }
                // If dependency bean is not initialized yet
                // initialize that bean first
                if (!beanMap.containsKey(beanName)) {
                    instanceBean(paramClasses[i].getType());
                }
                parameters[i] = beanMap.get(beanName);
            }
        }
        return parameters;
    }

    // Only allow constructor @MyAutowired here
    // Don't support fields @MyAutowired
    private void instanceComponent(Class<?> clazz) {
        instanceFields(clazz);
        Constructor[] constructors = clazz.getConstructors();

        // If only one constructor is annotated by @MyAutowired, autowire that one
        // If multiple constructors are annotated by @MyAutowired, throw exception
        // if No constructor is annotated by @MyAutowired, only one constructor is allowed and autowired that constructor

        Constructor targetConstructor = null;
        for (Constructor constructor : constructors) {
            if (constructor.isAnnotationPresent(MyAutowired.class)) {
                if (targetConstructor != null) {
                    throw new RuntimeException("Ambiguous constructors annotated");
                }
                targetConstructor = constructor;
            }
        }

        if (targetConstructor == null && constructors.length != 1) {
            throw new RuntimeException("Ambiguous constructors annotated");
        }

        targetConstructor = constructors[0];

        Parameter[] paramClasses = targetConstructor.getParameters();
        Object parameters = instanceParams(paramClasses);
        try {
            Object bean = targetConstructor.newInstance(parameters);
            String beanName = firstLetterLower(targetConstructor.getName());
            beanMap.put(beanName, bean);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
