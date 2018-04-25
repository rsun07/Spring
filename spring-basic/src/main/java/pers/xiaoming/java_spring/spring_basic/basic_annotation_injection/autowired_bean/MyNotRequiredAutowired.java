package pers.xiaoming.java_spring.spring_basic.basic_annotation_injection.autowired_bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pers.xiaoming.java_spring.spring_basic.basic_annotation_injection.repository.MyRepository;

@Service
public class MyNotRequiredAutowired implements MyService {
    @Autowired(required = false)
    @Qualifier("not exist bean")
    private MyRepository myRepo;

    public String showRepo() {
        return null;
    }

    public MyRepository getMyRepo() {
        return myRepo;
    }
}