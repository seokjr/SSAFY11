package com.ssafy.di2;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer {
	// 필드명 작성
	// CPU, GPU, RAM, SSD ... 
	public Desktop() {
		System.out.println("데스크탑이 생성되었습니다.");
	}
	
	public String getInfo() {
		return "데스크톱";
	}
}
