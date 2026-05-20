package com.practise;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AspectProgrammingExample {

    @Before("execution(* com.practise.controller.*.*(..))")
    public void beforeAdvice(){
        System.out.println("I am the before advice");
    }

    @AfterReturning(pointcut = "execution(* com.practise.controller.*.*(..))",returning = "data")
    public void afterAdvice(JoinPoint point, Object data){
        System.out.println("Method Signature is coming from after advice ==> "+ point.getSignature().toString());
        System.out.println("The data is coming from after advice ==> "+data);
    }

    @AfterThrowing(pointcut = "execution(* com.practise.controller.*.*(..))",throwing = "data")
    public void afterThrowing(JoinPoint point, Throwable data){
        System.out.println("Method Signature is coming from after advice ==> "+ point.getSignature().toString());
        System.out.println("The data is coming from after advice ==> "+data.getMessage());
    }

    @Around("execution(* com.practise.controller.*.*(..))")
    public Object aroundData(ProceedingJoinPoint point) throws Throwable {

        long start= System.currentTimeMillis();

        Object data =point.proceed();

        long end =System.currentTimeMillis();

        System.out.println("The Time taken to execute this method =>"+ (end-start));

        return  data;

    }
}