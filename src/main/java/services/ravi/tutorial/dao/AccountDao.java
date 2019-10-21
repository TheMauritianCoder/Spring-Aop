package services.ravi.tutorial.dao;

import org.springframework.stereotype.Component;
import services.ravi.tutorial.model.Account;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDao {

	private String name;
	private String serviceCode;
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}
	
	public boolean doWork() {
		
		System.out.println(getClass() + ": doWork()");
		return false;
	}

	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
	}

	public List<Account> findAccounts(){
		List<Account> accounts = new ArrayList<>();

		Account account1 = new Account();
		account1.setName("Account 1");
		accounts.add(account1);

		Account account2 = new Account();
		account2.setName("Account 2");
		accounts.add(account2);

		return accounts;
	}

	public List<Account> triggerExceptionOnPurposeWhenGettingAccounts(){
		throw new RuntimeException("This is an exception triggered on purpose");
	}
	
}





