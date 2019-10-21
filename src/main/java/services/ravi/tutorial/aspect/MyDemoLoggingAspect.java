package services.ravi.tutorial.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import services.ravi.tutorial.model.Account;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	/**
	 *
	 * @param joinPoint: Has meta data about method call.
	 */
	@Before("services.ravi.tutorial.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("\n=====>>> Executing @Before advice on method");

		// display the method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method: "+methodSignature);

		// display method arguments

		// get args
		Object [] args = joinPoint.getArgs();

		// loop through args
		for(Object obj : args){
			System.out.println(obj);
			if(obj instanceof Account){
				// downcast and print Account details.
				Account account = (Account) obj;
				System.out.println("Account Name: "+account.getName());
				System.out.println("Account Level: "+account.getLevel());
			}
		}
	}


	/**
	 * Note that the exception is still propagated to the main program.
	 * To stop the propagation see the "Around" Branch
	 * @param joinPoint
	 * @param theException
	 */
	@AfterThrowing(pointcut = "execution(* services.ravi.tutorial.dao.AccountDao.triggerExceptionOnPurposeWhenGettingAccounts(..))", throwing = "theException")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, Throwable theException) {
		System.out.println("Executing @AfterThrowing advice");

		System.out.println("\n====>>> The exception is: "+theException);

	}
	
}










