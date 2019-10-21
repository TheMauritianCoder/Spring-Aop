package services.ravi.tutorial.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {

	@Pointcut("execution(* services.ravi.tutorial.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// create pointcut for getter methods
	@Pointcut("execution(* services.ravi.tutorial.dao.*.get*(..))")
	public void getter() {}
	
	// create pointcut for setter methods
	@Pointcut("execution(* services.ravi.tutorial.dao.*.set*(..))")
	public void setter() {}
	
	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}

}
