package com.ssafy.fit.ui;
import java.util.List;

import com.ssafy.fit.model.VideoReview;
import com.ssafy.fit.model.dao.VideoReviewDao;
import com.ssafy.fit.model.dao.VideoReviewDaoImpl;
import com.ssafy.fit.util.SsafitUtil;

public class VideoReviewUi {
	private int videoNo;
	private VideoReviewDao videoReviewDao = VideoReviewDaoImpl.getInstance();
	
	private VideoReviewUi() {
	}
	private static VideoReviewUi instance = new VideoReviewUi();
	
	public static VideoReviewUi getInstance(int videoNo) {
		instance.videoNo = videoNo;
		return instance;
	}
	public static void service() {
		
		VideoReviewUi videoReviewUi = new VideoReviewUi();
		videoReviewUi.registReview();
		
	}
	public void listReview() {
		List<VideoReview> new_reviews = videoReviewDao.selectReview(videoNo);
        if (new_reviews != null) {
            SsafitUtil.printLine();
            System.out.println("영 상 리 뷰 : "+new_reviews.size()+"개");
            SsafitUtil.printLine();
            for(int i =0; i<new_reviews.size(); i++) {
                System.out.printf(" %d %s %s\n",i+1,new_reviews.get(i).getNickName(), new_reviews.get(i).getContent());
            }
            SsafitUtil.printLine();
        } else {
        	System.out.println("리뷰가 아직 없습니다 ㅜㅜ 당신이 남겨주세요");
        }
        
	}
	public void registReview() {
		String name = SsafitUtil.input("닉네임을 입력하세요 : ");
		String text = SsafitUtil.input("내용을 입력하세요 : ");
		
		// 리뷰 관리 객체 생성
		VideoReview newone = new VideoReview(videoNo, name, text);
		
		// 리뷰 관리 객체의 멤버 변수에 리뷰 객체 집어넣기
		videoReviewDao.insertReview(newone);
		
		System.out.println("저장이 완료되었습니다.");
		
		VideoUi.service();
	}
	
}
