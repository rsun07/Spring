package pers.xiaoming.java_framwork.spring_basic.basic_annotation_injection.autowired_bean;

import pers.xiaoming.java_framwork.spring_basic.basic_annotation_injection.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class MyParameterAutowired implements MyService {
    @Autowired
    @Qualifier("My Repository")
    private MyRepository myRepo;

    public String showRepo() {
        return myRepo.showRepo();
    }
}