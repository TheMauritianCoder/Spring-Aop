package services.ravi.tutorial.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import services.ravi.tutorial.service.FortuneService;

import java.util.logging.Logger;

@Component
public class InitializingBean implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOG  = Logger.getLogger(InitializingBean.class.getName());

    @Autowired
    FortuneService fortuneService;

    @Override public void onApplicationEvent(ContextRefreshedEvent event) {
        String fortune = fortuneService.getFortune();
        System.out.println("My Fortune is --> "+fortune);

        String result = fortuneService.getDummyException();
        System.out.println("The result is ---> "+result);
    }
}