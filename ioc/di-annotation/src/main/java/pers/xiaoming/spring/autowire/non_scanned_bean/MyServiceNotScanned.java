package pers.xiaoming.spring.autowire.non_scanned_bean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pers.xiaoming.spring.autowire.bean.MyService;
import pers.xiaoming.spring.autowire.repository.MyRepository;

import javax.inject.Inject;

@Component("not scanned")
public class MyServiceNotScanned implements MyService {
    @Inject
    @Qualifier("My Repository")
    private MyRepository myRepo;

    public String showRepo() {
        return myRepo.showRepo();
    }
}
