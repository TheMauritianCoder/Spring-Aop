package services.ravi.tutorial.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import services.ravi.tutorial.model.Account;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	/**
	 * Runs before and after the method.
	 *
	 * @param proceedingJoinPoint: The handle to the target method.
	 */
	@Around("execution(* services.ravi.tutorial.service.*.getFortune(..))")
	public Object afterGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		// get the beginning timestamp.
		long begin = System.currentTimeMillis();

		// Executes the target method.
		Object result = proceedingJoinPoint.proceed();

		long end = System.currentTimeMillis();
		System.out.println("\n====> Duration: "+(end - begin)+" milliseconds." );
		return result;
	}


	/**
	 * Here the calling program will never know that we ever had an exception since we have handled it.
	 *
	 * @param proceedingJoinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("execution(* services.ravi.tutorial.service.*.getDummyException(..))")
	public Object afterGetFortuneWithException(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Object result = "";
		try{
			// execute the method.
			result = proceedingJoinPoint.proceed();
		}catch (Exception e){
			System.out.println("@Around advice: We have a problem "+e);

			// Handling the exception: Be careful though. This approach depends on your app.
			result = "Nothing exciting here.";

			// You could re throw the exception like so:
			// throw e;
		}
		return result;
	}


}










