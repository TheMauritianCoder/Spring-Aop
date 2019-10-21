package services.ravi.tutorial.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import services.ravi.tutorial.model.Account;

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
	
}










