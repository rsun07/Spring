package pers.xiaoming.java_spring.autowire.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import pers.xiaoming.java_spring.autowire.repository.MyRepository;

@Controller
public class MyParameterAutowired implements MyService {
    @Autowired
    @Qualifier("My Repository")
    private MyRepository myRepo;

    public String showRepo() {
        return myRepo.showRepo();
    }
}
