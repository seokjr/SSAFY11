package com.ssafy.di;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer{
	// 필드명 작성
	// CPU, GPU, RAM, SSD ... 
	
	public String getInfo() {
		return "랩톱";
	}
}
