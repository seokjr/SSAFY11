package com.ssafy.di2_객체의존성제거;

public class Test {
	public static void main(String[] args) {
		// 지금은 뭔가 바뀜.
		// 어디 외부에 다른 애를 그냥 집어넣어주면 되게 바뀌었다.
		
		// 스프링 설정파일이 이러한 것들을 대신 해준다.
		// programmer -> test로 의존성 넘겨줬다.
		Desktop desktop = new Desktop();
		
		Programmer p = new Programmer(desktop);
		
		p.coding();
		
	}
}
