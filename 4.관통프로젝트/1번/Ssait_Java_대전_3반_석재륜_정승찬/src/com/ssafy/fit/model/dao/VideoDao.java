package com.ssafy.fit.model.dao;

import java.util.List;

import com.ssafy.fit.model.Video;

public interface VideoDao {

    public abstract List<Video> selectVideo();
    
    public abstract Video selectVideoByNo(int no);
    
}