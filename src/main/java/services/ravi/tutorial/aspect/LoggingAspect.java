package services.ravi.tutorial.aspect;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {


    // match on method name in a specific class.
    @Before("execution(public void services.ravi.tutorial.dao.AccountDao.addAccount())")
    public void executeBeforeAddingAccountOnASpecificClass(){
        System.out.println("Printing before adding account in a specific class...");
    }

    // match on method name in ANY class.
    @Before("execution(public void addAccount())")
    public void executeBeforeAddingAccountOnAnyClass(){
        System.out.println("Printing before adding account on any class...");
    }

    // match on method names using WILDCARDS
    @Before("execution(public void add*())")
    public void executeBeforeMethodsStartingWithAddOnAnyClass(){
        System.out.println("Printing before adding account on any class using wildcards...");
    }


    // match on method names using WILDCARDS, for modifier and return type
    @Before("execution(* addAccount())")
    public void executeBeforeAnyAddAccountMethodWhichHaveAnyAccessModifierAndReturnType(){
        System.out.println("Printing before adding account on any class which have any access modifier and return type...");
    }


    // match on method names using WILDCARDS, for modifier and return type
    @Before("execution(* addAccount(services.ravi.tutorial.model.Account))")
    public void executeBeforeAnyAddAccountWith1Parameter(){
        System.out.println("Printing before adding account with 1 Parameter Account...");
    }

    // match on any class and method in a specific package.
    @Before("execution(* services.ravi.tutorial.dao.*.*(..))")
    public void executeOnAnyClassAndAnyMethodWithAnyParameterInAPackage(){
        System.out.println("Printing before any method in the package services.ravi.tutorial.dao...");
    }

    // Reusing Advice.
    @Pointcut("execution(* services.ravi.tutorial.dao.*.*(..))")
    public void forDaoPackages(){
        System.out.println("Printing before any method in the package services.ravi.tutorial.dao...");
    };

    @Before("forDaoPackages()")
    public void beforeAddAccountAdvice(){
        System.out.println("Printing before pointcut forDaoPackages().");
    }

    // Combining Pointcut Declaration
    @Before("forDaoPackages()")
    public void performDummyAnalytics(){
        System.out.println("Doing some dummy api analytics.");
    }

    // Applying multiple pointcut expression to a single advice. [Works like an IF statement. we can use AND(&&) OR(||) NOT (!)

    @Pointcut("execution(* services.ravi.tutorial.dao.*.get*(..))")
    private void getter(){
        System.out.println("Running advice on getter");
    }

    @Pointcut("execution(* services.ravi.tutorial.dao.*.set*(..))")
    private void setter(){
        System.out.println("Running advice on setter");
    }

    @Pointcut("forDaoPackages() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter(){
        System.out.println("Printing... forDaoPackageNoGetterSetter() Advice");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice2(){
        System.out.println("Printing... beforeAddAccountAdvice2() Advice");
    }
}
