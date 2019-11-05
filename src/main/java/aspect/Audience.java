package aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Audience {

    @Pointcut("execution(* service.Performance.*(int))&&args(i)")
    public void performance(int i){
    };

    @Before("performance(i)")
    public  void phoneShutdown(int i){
        System.out.println("This is Performance before phoneShutdown"+i);
    }
    @Before("performance(i)")
    public  void peopleSitdown(int i){
        System.out.println("This is Performance before peopleSitdown"+i);
    }
    @AfterReturning("performance(i)")
    public void  peopleSitup(int i){
        System.out.println("This is Performance after peopleSitup"+i);
    }
}