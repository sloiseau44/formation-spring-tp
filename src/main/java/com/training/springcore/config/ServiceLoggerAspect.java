package com.training.springcore.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServiceLoggerAspect {

    @Pointcut("execution(* com.training.springcore..service.*.*(..))")
    public void inService(){}

    @Pointcut("execution(public * find*(..))")
    public void anyFinder(){}

    @Before("inService() && anyFinder()")
    public void logServiceBeforeCall(JoinPoint jp){
        System.out.println("Appel de " + jp.getSignature());
    }

}
