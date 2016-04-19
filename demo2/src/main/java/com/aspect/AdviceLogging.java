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
 * spring boot AOP example
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
		
		
		/**
		 	AOP Logging Result
			2016-02-22:13:28:06.361 INFO  7727 --- [main] com.aspect.AdviceLogging.loggingAdvice(AdviceLogging.java:31) : method path : User com.user.controller.UserRestController.createUser(UserVo) 
			2016-02-22:13:28:06.371 INFO  7737 --- [main] com.aspect.AdviceLogging.loggingAdvice(AdviceLogging.java:36) : com.entity.UserVo@42ac84a9[name=홍길동,email=test@test.com,gender=male] 
		 */
	}
	
	
	/**
	 * annotation을 이용한 Logging
	 * @param joinPoint
	 */
	@Before("@within(Loggings)")
	public void loggingAdvice2(JoinPoint joinPoint) {
	
		logger.info("annotation method path : " + joinPoint.getSignature());
		
		Object params[] = joinPoint.getArgs();
		for(Object param : params) {
			if(param instanceof UserVo) {
				logger.info(ToStringBuilder.reflectionToString((UserVo)param));
			}
		}

	}

}
