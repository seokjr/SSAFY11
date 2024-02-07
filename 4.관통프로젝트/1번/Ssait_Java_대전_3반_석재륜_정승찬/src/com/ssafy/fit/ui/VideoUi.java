package com.ssafy.fit.ui;

import com.ssafy.fit.model.Video;
import com.ssafy.fit.model.dao.VideoDaoImpl;
import com.ssafy.fit.util.SsafitUtil;

public class VideoUi {

	public static void service() {
		SsafitUtil.printLine();
		System.out.println("1.영상목록");
		System.out.println("0.이전으로");
		SsafitUtil.printLine();
		int n = SsafitUtil.inputInt("메뉴를 선택하세요 : ");
		if (n == 1) {
			VideoUi.listVideo();
		} else if (n == 0) {
			MainUi.service();
		} else {
			System.out.println("잘못된 번호입니다. 다시 입력해주세요");
			service();
		}
	}

	private static void listVideo() {
		SsafitUtil.printLine();
		VideoDaoImpl vm = VideoDaoImpl.getInstance();
		System.out.println("전체 " + vm.getSize() + "개");
		SsafitUtil.printLine();

		for (int i = 0; i < vm.getSize(); i++) {
			System.out.printf("%d %s", vm.selectVideo().get(i).getNo(), vm.selectVideo().get(i).getTitle());
			System.out.println();
		}

		SsafitUtil.printLine();
		System.out.println("1. 영상상세");
		System.out.println("0. 이전으로");
		SsafitUtil.printLine();
		int n = SsafitUtil.inputInt("메뉴를 선택하세요 : ");
		if (n == 1) {
			VideoUi.detailVideo();
		} else if (n == 0) {
			VideoUi.service();
		} else {
			System.out.println("잘못된 번호입니다. 다시 입력해주세요");
			VideoUi.listVideo();
		}

	}

	private static void detailVideo() {
		int n = SsafitUtil.inputInt("영상번호를 입력하세요 : ");
		VideoDaoImpl vm = VideoDaoImpl.getInstance();
		Video v = vm.selectVideoByNo(n);
		SsafitUtil.printLine();
		System.out.println("번 호 : " + v.getNo());
		System.out.println("제 목 : " + v.getTitle());
		System.out.println("운 동 : " + v.getPart());
		System.out.println("영 상 URL : " + v.getUrl());
		SsafitUtil.printLine();
		SsafitUtil.printLine();

		VideoReviewUi videoReviewUi = VideoReviewUi.getInstance(n);
		videoReviewUi.listReview();

		SsafitUtil.printLine();
		System.out.println("1. 리뷰등록");
		System.out.println("0. 이전으로");
		SsafitUtil.printLine();
		n = SsafitUtil.inputInt("메뉴를 선택하세요 : ");
		if (n == 1) {
			// 리뷰 등록
			VideoReviewUi.service();
		} else if (n == 0) {
			VideoUi.listVideo();
		} else {
			System.out.println("잘못된 번호입니다. 다시 입력해주세요");
			VideoUi.detailVideo();
		}
	}
}
