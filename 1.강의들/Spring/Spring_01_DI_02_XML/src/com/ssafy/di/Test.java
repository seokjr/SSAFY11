package com.ssafy.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		System.out.println("1~~~~~~");
		Programmer p = (Programmer) context.getBean("programmer");
		// 기본 설정은 getBean 할 때 생성하는 것이 아닌 컨테이너를 생성할 때 빈들이 생성이 된다.
		// 설정을 바꾸면 getBean할 때 바뀔 수 있게 한다.
		Desktop d = context.getBean("desktop", Desktop.class);
		p.setComputer(d);
		System.out.println("2~~~~~~");
		p.coding();
		
		Desktop d2 = context.getBean("desktop", Desktop.class);
		System.out.println(d == d2); // true - 새 객체를 생성한 게 아니라 컨테이너는 기본적으로 싱글턴이다.
		
	}
}
