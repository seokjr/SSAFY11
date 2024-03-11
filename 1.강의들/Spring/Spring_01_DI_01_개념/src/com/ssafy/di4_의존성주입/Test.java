package com.ssafy.di4_의존성주입;

public class Test {
	public static void main(String[] args) {
		Desktop desktop = new Desktop();
		Laptop laptop = new Laptop();
		Programmer p = new Programmer(desktop);
		
		p.coding();
		
		
		Programmer p2 = new Programmer();
		p2.setComputer(laptop);
		
		p2.coding();
	}
}
