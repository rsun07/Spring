package pers.xiaoming.java_framework.spring_basic.basic_annotation_injection.autowired_bean;

import pers.xiaoming.java_framework.spring_basic.basic_annotation_injection.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MySetterAutowired implements MyService {
    private MyRepository myRepo;

    @Autowired
    public void setMyRepo(@Qualifier("myRepo") MyRepository myRepo) {
        this.myRepo = myRepo;
    }

    public String showRepo() {
        return myRepo.showRepo();
    }
}
