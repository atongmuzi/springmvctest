package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
//@Component
public class aroundAudience {

    @Pointcut("execution(* service.Performance.perform(..))")
    public void performance(){};

    @Around("performance()")
    public void around(ProceedingJoinPoint joinPoint){

        try {
            System.out.println("This is Performance before phoneShutdown");
            System.out.println("This is Performance before peopleSitdown");
            joinPoint.proceed();
            System.out.println("This is Performance after peopleSitup");
        }catch (Throwable e){
            System.out.println("exception");
        }
    }

//    @Before("performance()")
//    public  void phoneShutdown(){
//        System.out.println("This is Performance before phoneShutdown");
//    }
//    @Before("performance()")
//    public  void peopleSitdown(){
//        System.out.println("This is Performance before peopleSitdown");
//    }
//    @AfterReturning("performance()")
//    public void  peopleSitup(){
//        System.out.println("This is Performance after peopleSitup");
//    }
}