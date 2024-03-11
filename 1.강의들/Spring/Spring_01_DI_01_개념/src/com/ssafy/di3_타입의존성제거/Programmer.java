package com.ssafy.di3_타입의존성제거;

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

	public void setComputer(Computer computer) {
		this.computer = computer;
	}
}
