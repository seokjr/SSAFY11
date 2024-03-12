package com.ssafy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

	@Pointcut("execution(* com.ssafy.aop.*.coding())")
	// 함수 내용은 없어야 한다.
	public void mypt() {
	}

	@Before("mypt()")
	// 메서드 명은 중요하지 않다. 직관적으로 보이기 위해 이러한 이름을 사용함.
	public void before() {
		System.out.println("컴퓨터를 부팅한다.");
	}

	// 정상 수행 후
	@AfterReturning(value = "mypt()", returning = "line")
	public void afterReturning(int line) {
		System.out.println("GIt에 Push한다. : " + line + "개의 줄을...");
	}

	// 예외 발생 후
	@AfterThrowing(value = "mypt()", throwing="th")
	public void afterThrowing(Throwable th) {
		System.out.println("조퇴를 한다.");
		if (th instanceof OuchException) {
			((OuchException) th).handleException();
		}
	}

	// 이후에
	@After("mypt()")
	public void after() {
		System.out.println("하루를 마무리 한다.");
	}

	//////////////
	// around
//	@Around("mypt()")
	public int around(ProceedingJoinPoint pjt) {
		int line = 0;

		// 실행 전
		this.before();
		try {
			line = (int) pjt.proceed(); // 핵심 관심사항
			this.afterReturning(line);
		} catch (Throwable e) {
			this.afterThrowing(e); // 예외
		} finally {
			this.after(); // 실행 후
		}

		return line;
	}
}
