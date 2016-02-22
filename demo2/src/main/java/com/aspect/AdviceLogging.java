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
		
		/**
		 * 코드 변경 
		 * 참고사이트 : http://stackoverflow.com/questions/27659523/retrieve-parameter-value-from-proceedingjoinpoint
		 * method parameter 가져오기 부분 추가
		 */
		Object params[] = joinPoint.getArgs();
		for(Object param : params) {
			if(param instanceof UserVo) {
				logger.info(ToStringBuilder.reflectionToString((UserVo)param));
			}
		}
		
	}
	
}
