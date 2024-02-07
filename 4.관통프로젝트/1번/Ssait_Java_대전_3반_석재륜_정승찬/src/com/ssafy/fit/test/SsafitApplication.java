package com.ssafy.fit.test;

import com.ssafy.fit.ui.MainUi;
import com.ssafy.fit.util.SsafitUtil;

public class SsafitApplication {
	public static void main(String[] args) {
		SsafitUtil.printLine();
		System.out.println("자바로 구현하는 SSAFIT");
		SsafitUtil.printLine();
		
		MainUi.service();
		
	
	}
}