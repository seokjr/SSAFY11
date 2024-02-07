package com.ssafy.fit.model.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.ssafy.fit.model.Video;

public class VideoDaoImpl implements VideoDao {

	private List<Video> list = new ArrayList<>();

	private static VideoDaoImpl Instance = new VideoDaoImpl();

	private VideoDaoImpl() {
        try (

                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data/video.json")))) {
            StringBuilder sb = new StringBuilder();
            String str = null;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            Gson gson = new Gson();
            Video[] arr = gson.fromJson(sb.toString(), Video[].class);
            for (int i = 0; i<arr.length; i++) {
                list.add(arr[i]);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public static VideoDaoImpl getInstance() {
		return Instance;
	}

	// 구현해야 하는 메서드

	// 비디오 리스트를 직접 반환해주는 메서드
	public List<Video> selectVideo() {
		return this.list;
	}

	// 특정 영화의 고유 No을 입력받아서 그 No에 해당하는 비디오 객체를 반환하는 메서드
	public Video selectVideoByNo(int no) {

		for (int i = 0; i < this.list.size(); i++) {
			if (this.list.get(i).getNo() == no) {
				return this.list.get(i);
			}
		}
		// 만약 해당하는 int가 없으면 예외를 던진다.
		return null;

	}
	public int getSize() {
		return this.list.size();
	}
	

}