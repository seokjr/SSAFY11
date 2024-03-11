package com.ssafy.di4_의존성주입;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Programmer p = new Programmer();
		
//		Computer computer = ComputerFactory.getComputer(sc.next());
//		p.setComputer(computer);
//		p.coding();
		// 컴퓨터가 꺼진 상태에서도 이게 기능했다.
		while (true) {
			p.setComputer(ComputerFactory.getComputer(sc.next()));
			p.coding();
		}

	}
}
