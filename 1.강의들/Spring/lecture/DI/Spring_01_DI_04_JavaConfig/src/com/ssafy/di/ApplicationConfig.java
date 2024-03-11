package com.ssafy.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	@Bean
	public Desktop desktop() {
		return new Desktop();
	}
	@Bean
	public Laptop laptop() {
		return new Laptop();
	}
	
	@Bean
	public Programmer programmer() {
		// 생성자 주입, 설정자 주입도 문제 없어.
		Programmer p = new Programmer(desktop());
		return p;
	}
}
