package services.ravi.tutorial.dao;

import org.springframework.stereotype.Component;
import services.ravi.tutorial.model.Account;

@Component
public class AccountDao {

    public void addAccount(){
        System.out.println(getClass()+": Adding new account...");
    }

    public void addAccount(Account account){
        System.out.println(getClass()+": Adding new account 1 param...");
    }

    public void addVipAccount(Account account,boolean vip){
        System.out.println(getClass()+": Adding new account 2 params...");
    }


    public void getSomething(){
        System.out.println("Getting something....");
    }

    public void setSomething(){
        System.out.println("Setting something....");
    }

}
