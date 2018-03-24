package pers.xiaoming.java_framework.spring_basic.basic_annotation_injection.repository;

import org.springframework.stereotype.Component;

// Component has the same function as @Repository
@Component("myRepo")
public class MyRepoImpl implements MyRepository {

    public String showRepo() {
        return "myRepo";
    }
}
