/**
 * 
 */
package com.aspect;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.entity.UserVo;

/**
 * @author 정명성
 * create date : 2015. 12. 29.
 * com.aspect.AdviceLogging.java
 */
@Aspect
@Component
public class AdviceLogging {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Before("execution(* com..*Controller.*(..))" 
				+ "execution(* com..*Service.*(..))")
	public void loggingAdvice(JoinPoint joinPoint) {
		
		logger.info("method path : " + joinPoint.getSignature());
		
		Object params[] = joinPoint.getArgs();
		for(Object param : params) {
			if(param instanceof UserVo) {
				logger.info(ToStringBuilder.reflectionToString((UserVo)param));
			}
		}
		
	}
	
}
