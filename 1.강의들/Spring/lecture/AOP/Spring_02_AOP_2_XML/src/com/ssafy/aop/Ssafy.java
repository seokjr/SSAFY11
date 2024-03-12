package com.ssafy.aop;

import java.util.Random;

public class Ssafy implements Person {
	// 교육생의 일상
	public int coding() {
		System.out.println("열심히 공부를 한다."); // 핵심관심사항
		if (new Random().nextBoolean()) {
			throw new OuchException();
		}
		return (int)(Math.random() * 100) + 1;
	}
}
