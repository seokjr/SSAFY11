package com.ssafy.fit.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.fit.model.VideoReview;

public class VideoReviewDaoImpl implements VideoReviewDao {
	
	private int reviewNo;

	// data list 생성. 여기 근데 map으로 integer랑 list할 수 있게 해야함
	private Map<Integer, List<VideoReview>> videoReviewDb = new HashMap<>();
	// 싱글턴
	private static VideoReviewDaoImpl instance = new VideoReviewDaoImpl();

	private VideoReviewDaoImpl() {
	}

	public static VideoReviewDaoImpl getInstance() {
		return instance;
	}

	@Override
	public int insertReview(VideoReview videoReview) {
		if(videoReviewDb.containsKey(videoReview.getVideoNo())) {
			videoReviewDb.get(videoReview.getVideoNo()).add(videoReview);
		}
		else {
			List<VideoReview> list = new ArrayList<>();
			list.add(videoReview);
			videoReviewDb.put(videoReview.getReviewNo(), list);
		}
		return this.reviewNo;
	}
	
	public Map<Integer, List<VideoReview>> getMap(){
		return this.videoReviewDb;
	}

	@Override
	public List<VideoReview> selectReview(int videoNo) {
		return videoReviewDb.get(videoNo);
	}

}
