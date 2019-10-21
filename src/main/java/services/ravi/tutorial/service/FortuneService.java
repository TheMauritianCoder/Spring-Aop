package services.ravi.tutorial.service;

import org.springframework.stereotype.Service;

@Service
public class FortuneService {

    public String getFortune(){
        return "Got get some lottery!!!!";
    }

    public String getDummyException(){
        throw new RuntimeException("This is an exception thrown on purpose");
    }
}
