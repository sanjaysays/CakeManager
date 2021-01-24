package com.cake.manager.aop;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;


import lombok.extern.slf4j.Slf4j;

@Aspect
@Configuration
@Slf4j
public class CakeAspect {
	private static final Logger log = LogManager.getLogger(CakeAspect.class);
	
	/**
	 * 
	 * @param joinPoint
	 */
	  @Before("execution(* com.cake.manager.service.interfaces.CakeService.findAll())")
	public void beforeAdvice(JoinPoint joinPoint) {
		
		log.info("================================================================");
		
	    Signature signature = joinPoint.getSignature();
	    String methodName = signature.getName();
	    
	    String arguments = Arrays.toString(joinPoint.getArgs());
	    log.info("Before handler:" + joinPoint.getSignature()+" - We are just about to call method: "
	        + methodName + " with arguments " + arguments);
	    log.info("================================================================");
		
	}
	  
	  

}
