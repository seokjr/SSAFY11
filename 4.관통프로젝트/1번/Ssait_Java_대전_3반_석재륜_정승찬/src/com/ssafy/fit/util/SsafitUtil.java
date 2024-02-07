package com.ssafy.fit.util;

import java.util.Scanner;

public class SsafitUtil {
	static Scanner sc = new Scanner(System.in);

	private SsafitUtil() {
	}

	public static int inputInt(String msg) {
		System.out.print(msg);
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}

	public static String input(String msg) {
		System.out.print(msg);
		String str = sc.nextLine();
		return str;
	}

	public static void printLine() {
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------");
	}

	public static void printLine(char ch) {

	}

	public static void printLine(char ch, int len) {

	}

	public static void screenClear() {

	}

}
