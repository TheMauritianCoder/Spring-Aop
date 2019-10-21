package services.ravi.tutorial.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import services.ravi.tutorial.dao.AccountDao;
import services.ravi.tutorial.model.Account;

import java.util.Arrays;
import java.util.logging.Logger;

@Component
public class InitializingBean implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOG  = Logger.getLogger(InitializingBean.class.getName());

    @Autowired
    AccountDao accountDao;

    @Override public void onApplicationEvent(ContextRefreshedEvent event) {
        accountDao.addAccount();

        Account account = new Account();
        accountDao.addAccount(account);
    }
}