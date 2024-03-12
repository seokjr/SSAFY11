package com.ssafy.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	// 메서드 명은 중요하지 않다. 직관적으로 보이기 위해 이러한 이름을 사용함.
	public void before() {
		System.out.println("컴퓨터를 부팅한다.");
	}

	// 정상 수행 후
	public void afterReturning(int line) {
		System.out.println("GIt에 Push한다. : " + line + "개의 줄을...");
	}

	// 예외 발생 후
	public void afterThrowing(Throwable th) {
		System.out.println("조퇴를 한다.");
		if (th instanceof OuchException) {
			((OuchException) th).handleException();
		}
	}

	// 이후에
	public void after() {
		System.out.println("하루를 마무리 한다.");
	}

	//////////////
	// around

	public int around(ProceedingJoinPoint pjt) {
		int line = 0;

		// 실행 전
		this.before();
		try {
			line = (int) pjt.proceed(); // 핵심 관심사항
			this.afterReturning(line);  
		} catch (Throwable e) {
			this.afterThrowing(e);      // 예외
		} finally {
			this.after();				// 실행 후
		}

		

		
		return line;
	}
}
