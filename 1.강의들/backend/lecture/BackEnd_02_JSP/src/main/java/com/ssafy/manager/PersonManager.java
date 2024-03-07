package com.ssafy.manager;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.Person;

// 메모리 직접 저장해서 관리할 DB 같은 거
// 싱글턴으로 관리하면 좋을 것! 왜냐면 꺼져도 계속 있게
public class PersonManager {
	private List<Person> list = new ArrayList<>();
	private static PersonManager manager= new PersonManager();
	
	private PersonManager() {}
	
	public static PersonManager getInstance() {
		return manager;
	}
	public void regist(Person p) {
		list.add(p);
	}
	public List<Person> getAll(){
		return list;
	}
}
