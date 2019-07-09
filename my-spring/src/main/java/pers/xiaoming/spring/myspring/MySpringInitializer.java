package pers.xiaoming.spring.myspring;

import pers.xiaoming.spring.myspring.annotation.MySpringApp;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MySpringInitializer {
    private static final String DEFAULT_CONFIG_PATH = "classpath:application.properties";

    public void init(Class className) {
        Properties properties = loadProperties(DEFAULT_CONFIG_PATH);

        String packageName = getScanPackage(className);

        List<String> classNames = new ArrayList<>();
        scanClasses(packageName, classNames);
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
}
