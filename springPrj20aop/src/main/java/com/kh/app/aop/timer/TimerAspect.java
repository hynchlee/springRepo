package com.kh.app.aop.timer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@EnableAspectJAutoProxy
@Component
@Slf4j
@Aspect
public class TimerAspect {
	
	//com.kh.app.member.dao.MemberDao 안에 있는 메소드가 실행되기 전에 호출된다.
//	@Before("target(com.kh.app.member.dao.MemberDao)")
	public void m01() {
		log.debug("before");
	}
	
	// 타겟 실행 이후에 동작
//	@After("target(com.kh.app.member.dao.MemberDao)")
	public void m02() {
		log.debug("after");
	}
	
	// 타겟 실행 이후, 에러가 없을 경우 동작
//	@AfterReturning("target(com.kh.app.member.dao.MemberDao)")
	public void m03() {
		log.debug("afterreturning");
	}
	
	// 타겟 실행 이후, 에러가 있을 경우 동작
//	@AfterThrowing("target(com.kh.app.member.dao.MemberDao)")
	public void m04() {
		log.debug("afterthrowing");
	}
	
	// 타겟 실행 시점을 지정 가능
	@Around("execution( public * com..dao.*.*(..) )")
	public Object m05(ProceedingJoinPoint jp) throws Throwable {
		long start = System.currentTimeMillis();
		Object object = jp.proceed();	//타겟 메소드 실행
		long end = System.currentTimeMillis();
		long time = end - start;
		String str = jp.getSignature().toString();
		log.debug("{}메소드 실행시간 : {}ms", str, time);
		
		return object;
	}
}
