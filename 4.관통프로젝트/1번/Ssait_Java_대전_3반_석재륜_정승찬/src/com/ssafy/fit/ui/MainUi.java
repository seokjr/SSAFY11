package com.ssafy.fit.ui;

import com.ssafy.fit.util.SsafitUtil;

public class MainUi {
	
	public static void service() {
		SsafitUtil.printLine();
		System.out.println("1.영상정보");
		System.out.println("0.종료");
		SsafitUtil.printLine();
		
		int n = SsafitUtil.inputInt("메뉴를 선택하세요 : ");
		if (n == 1) {
			VideoUi.service();
		} else if (n == 0){
			MainUi.exit();
		} else {
			System.out.println("잘못된 번호입니다. 다시 입력해주세요");
			service();
		}
	}

	public static void exit() {
		System.exit(0);
	}
}

