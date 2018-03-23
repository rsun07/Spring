package com.xiaoming.java_framwork.spring_basic.basic_annotation_injection.autowired_bean;

import com.xiaoming.java_framwork.spring_basic.basic_annotation_injection.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class MyConstructorAutowired implements MyService {
    private MyRepository myRepo;

    @Autowired
    public MyConstructorAutowired(@Qualifier("myRepo") MyRepository myRepo) {
        this.myRepo = myRepo;
    }

    public String showRepo() {
        return myRepo.showRepo();
    }
}
