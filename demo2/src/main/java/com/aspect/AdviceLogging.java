/**
 * 
 */
package com.aspect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.anntation.ProcessInfo;
import com.entity.SystemLog;
import com.entity.vo.SystemLogVo;
import com.entity.vo.UserVo;
import com.enums.Actions;
import com.systemlog.repository.SystemLogRepository;

/**
 * spring boot AOP example
 * 
 * @author 정명성 create date : 2015. 12. 29. com.aspect.AdviceLogging.java
 */
@Aspect
@Component
public class AdviceLogging {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Before("execution(* com..*Controller.*(..))")
	public void loggingAdvice(JoinPoint joinPoint) {

		logger.info("method path : " + joinPoint.getSignature());

		/**
		 * 코드 변경 참고사이트 :
		 * http://stackoverflow.com/questions/27659523/retrieve-parameter-value-
		 * from-proceedingjoinpoint method parameter 가져오기 부분 추가
		 */
		Object params[] = joinPoint.getArgs();
		for (Object param : params) {
			if (param instanceof UserVo) {
				logger.info(ToStringBuilder.reflectionToString((UserVo) param));
			}
		}

		/**
		 * AOP Logging Result 2016-02-22:13:28:06.361 INFO 7727 --- [main]
		 * com.aspect.AdviceLogging.loggingAdvice(AdviceLogging.java:31) :
		 * method path : User
		 * com.user.controller.UserRestController.createUser(UserVo)
		 * 2016-02-22:13:28:06.371 INFO 7737 --- [main]
		 * com.aspect.AdviceLogging.loggingAdvice(AdviceLogging.java:36) :
		 * com.entity.UserVo@42ac84a9[name=홍길동,email=test@test.com,gender=male]
		 */
	}

	/**
	 * annotation을 이용한 Logging
	 * 
	 * @param joinPoint
	 */
	@Before("@within(Loggings)")
	public void loggingAdvice2(JoinPoint joinPoint) {

		logger.info("annotation method path : " + joinPoint.getSignature());

		Object params[] = joinPoint.getArgs();
		for (Object param : params) {
			if (param instanceof UserVo) {
				logger.info(ToStringBuilder.reflectionToString((UserVo) param));
			}
		}

	}

	@Autowired
	private SystemLogRepository systemLogRepository;

	/**
	 * 서비스 영역을 통한 SystemLogging service를 포함하는 Class에 select 로 시작되는 메서드를 실행할 때
	 * 로깅을 적용한다.
	 * 
	 * @param joinPoint
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@Before("execution(* com..*Service.select*(..))")
	public void loggingService(JoinPoint joinPoint) throws IllegalAccessException, InvocationTargetException {
		StopWatch stopWatch = new StopWatch();

		stopWatch.start();
		SystemLogVo syslogVo = new SystemLogVo();
		syslogVo.setClassName(joinPoint.getTarget().getClass().getName());
		syslogVo.setMethodName(joinPoint.getSignature().getName());
		syslogVo.setRegId("홍길동");
		syslogVo.setTitle("추후 결정");
		syslogVo.setAction(Actions.select);

		SystemLog systemLog = new SystemLog();
		BeanUtils.copyProperties(systemLog, syslogVo);

		stopWatch.stop();

		systemLog.setProcessTime(Long.toString(stopWatch.getTotalTimeMillis()));

		systemLogRepository.save(systemLog);

	}

	/**
	 * @ProcessInfo annotation을 이용한 마킹
	 * @param joinPoint
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	@Before("execution(* com..*Service.*(..))")
	public void loggingServiceWithProcessAnnotation(JoinPoint joinPoint) {
		StopWatch stopWatch = new StopWatch();

		stopWatch.start();

		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method m = methodSignature.getMethod();
		ProcessInfo annotation;
		annotation = m.getAnnotation(ProcessInfo.class);
		if (annotation != null) {
			SystemLog systemLog = new SystemLog();
			systemLog.setClassName(joinPoint.getTarget().getClass().getName());
			systemLog.setMethodName(joinPoint.getSignature().getName().toString());
			systemLog.setRegId("임꺽정");
			systemLog.setTitle(annotation.title());
			systemLog.setAction(annotation.actions());
			stopWatch.stop();
			systemLog.setProcessTime(Long.toString(stopWatch.getTotalTimeMillis()));

			systemLogRepository.save(systemLog);
		}
	}

}
