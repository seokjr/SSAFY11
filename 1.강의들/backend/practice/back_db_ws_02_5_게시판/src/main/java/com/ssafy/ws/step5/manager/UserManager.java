package com.ssafy.ws.step5.manager;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.ws.step5.dto.User;

public class UserManager {
	private List<User> users = new ArrayList<>();
	private static UserManager instance = new UserManager();
	private int userSeq;
	
	private UserManager() {
	}

	public static UserManager getInstance() {
		return instance;
	}
	
	public boolean signup(User user) {
		// 이미 등록된 유저 아이디가 null이 아니면 false리턴
		boolean flag = true;
		for (User each_user : users) {
			if(each_user.getUserId().equals(user.getUserId())) {
				flag = false;
			}
		}
		if (flag) {
			user.setUserSeq(++userSeq);
			users.add(user);
			return true;	
		}
		return false;
	}
	
	public User login(String id, String pw) {
		// for 문 돌면서 user 아이디랑 비번 같으면 user 반환
		for (int i = 0 ; i < users.size(); i++) {
			if (users.get(i).getUserId().equals(id)) {
				if (users.get(i).getPassword().equals(pw)) {
					return users.get(i);
				}
			}
		}
		// 비번이랑 아이디 안 같은 사람이다. null 리턴
		return null;
	}
	
	public String getNickName(int userSeq) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserSeq() == userSeq) {
				return users.get(i).getNickName();
			}
		}
		return null;
	}
}
