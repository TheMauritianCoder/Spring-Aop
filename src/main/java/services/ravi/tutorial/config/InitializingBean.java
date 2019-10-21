package services.ravi.tutorial.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import services.ravi.tutorial.dao.AccountDao;
import services.ravi.tutorial.dao.MembershipDao;
import services.ravi.tutorial.model.Account;

import java.util.logging.Logger;

@Component
public class InitializingBean implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOG  = Logger.getLogger(InitializingBean.class.getName());

    @Autowired
    AccountDao accountDao;

    @Autowired
    MembershipDao membershipDao;

    @Override public void onApplicationEvent(ContextRefreshedEvent event) {


        // call the business method
        Account myAccount = new Account();
        myAccount.setName("Blabla Account");
        myAccount.setLevel("PRO");
        accountDao.addAccount(myAccount, true);
        accountDao.doWork();

        // call the accountdao getter/setter methods
        accountDao.setName("foobar");
        accountDao.setServiceCode("silver");

        String name = accountDao.getName();
        String code = accountDao.getServiceCode();

        // call the membership business method
        membershipDao.addSillyMember();
        membershipDao.goToSleep();

    }
}