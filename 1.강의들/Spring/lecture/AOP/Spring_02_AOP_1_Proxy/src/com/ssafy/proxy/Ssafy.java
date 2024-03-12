package com.ssafy.proxy;

import java.util.Random;

public class Ssafy {
	// 교육생의 일상
	public void coding() {
		System.out.println("컴퓨터를 부팅한다.");		// 이전에 수행해야할 친구
		try {
			System.out.println("열심히 공부를 한다.");	// 핵심관심사항
			if (new Random().nextBoolean()) {
				throw new OuchException();
			}
			System.out.println("Git에 Push 한다.");  // 이상없이 마무리가 되었을 때
		} catch (OuchException e) {
			System.out.println("조퇴를 한다.");
			e.handleException();
		} finally {
			System.out.println("하루를 마무리한다.");		// 모든 게 마무리가 되었을 때
		}
	}
}
