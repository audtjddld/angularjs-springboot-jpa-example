/**
 * 
 */
package com.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author 정명성
 * create date : 2015. 12. 29.
 * com.aspect.AdviceLogging.java
 */
@Aspect
@Component
public class AdviceLogging {
	
	@Before("execution(* com..*Controller.*(..))" 
				+ "execution(* com..*Service.*(..))")
	public void loggingAdvice(JoinPoint joinPoint) {
		//System.out.println("call full path : " + joinPoint.getSignature());
	}
	
}
