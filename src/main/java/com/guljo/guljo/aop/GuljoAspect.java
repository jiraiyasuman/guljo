package com.guljo.guljo.aop;

import org.aspectj.lang.annotation.Aspect;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class GuljoAspect {

	private Logger LOGGER = Logger.getLogger(getClass().getName());
    // setup pointcut declarations
	@Pointcut("execution(* com.guljo.guljo.*.*(..))")
	private void forControllerPackage() {
		LOGGER.info("LoginUserController class is being executed");
	}
	@Pointcut("com.guljo.guljo.*.*(..))")
	private void forServicePackage() {
		LOGGER.info("LoginUserService class is being executed");
	}
	@Pointcut("com.guljo.guljo.repository.*.*(..))")
	private void forRepositoryPackage() {
		LOGGER.info("LoginRepository interface is being executed ");
	}
	@Pointcut("forControllerPackage()|| forServicePackage()|| forRepositoryPackage()")
	private void forAppFlow() {
		LOGGER.info("================<>==============");
	}
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		// display the method we are calling
		String method = joinPoint.getSignature().toShortString();
		LOGGER.info("========>  In @Before: calling method:"+method);
		
		// display the arguments to the methods
		
		// get the arguments
		Object[] args = joinPoint.getArgs();
		// loops through and display arguments
		for(Object tempArg : args) {
			LOGGER.info("===========> argument: "+args);
		}
		
		
	}

	@AfterReturning(
			pointcut="forAppFlow()",
			returning = "theResult"
			)
	public void afterReturning(JoinPoint joinPoint,Object theResult) {
		// display method we are returning from 
		String method = joinPoint.getSignature().toShortString();
		LOGGER.info("====> In AfterReturning: from method:"+method);
		// display data returned
		LOGGER.info("========> Result:"+theResult);
	}
}
