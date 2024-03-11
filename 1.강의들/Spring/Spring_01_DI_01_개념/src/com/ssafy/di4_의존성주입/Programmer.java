package com.ssafy.di4_의존성주입;

public class Programmer {
	private Computer computer;

	// 객체 생성 의존성 제거
	public Programmer() {
	}

	public Programmer(Computer computer) {
		// 직접 생성하는 것이 아닌, 데스크톱을 인자로 받아서 제공하겠다.
		this.computer = computer;
	}

	public void coding() {
		System.out.println(computer.getInfo() + "으로 개발을 합니다.");
	}

	// 설정자 주입
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
//	// 메서드 주입 (여러개를 동시에 주입하려고 할 때)
//	public void init(Computer computer, Keyboard keyboard) {
//		this.computer = computer;
//		this.keyboard = keyboard;
//	}
	
}
