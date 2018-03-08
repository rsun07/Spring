package com.xiaoming.spring.basic_annotation_injection.repository;

import org.springframework.stereotype.Component;

// Component has the same function as @Repository
@Component("myRepo")
public class MyRepoImpl implements MyRepository {

    public String showRepo() {
        return "myRepo";
    }
}
