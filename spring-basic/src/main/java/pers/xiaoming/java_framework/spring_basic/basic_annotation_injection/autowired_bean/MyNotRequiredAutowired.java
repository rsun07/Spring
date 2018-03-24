package pers.xiaoming.java_framework.spring_basic.basic_annotation_injection.autowired_bean;

import pers.xiaoming.java_framwork.spring_basic.basic_annotation_injection.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
