package services.ravi.tutorial.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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

	/**
	 * @After Advice does not have access to the exception. (If you need the exception, use AfterThrowing.
	 * The Advice should be able to run in case of success or error.
	 * Your code should not depend on the happy path or an exception.
	 * Used for Logginf/Auditing mostly.
	 *
	 * Will run regardless of a success or failure.
	 *
	 * @param joinPoint
	 *
	 */
	@After("execution(* services.ravi.tutorial.dao.AccountDao.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {
		System.out.println("Executing @After advice on method: "+joinPoint.getSignature().toShortString());

	}



}










