package com.ssafy.board.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.dto.Board;

public class JdbcTest {
	public JdbcTest() {
		// 1. 데이터 베이스 가져옴
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		JdbcTest db = new JdbcTest();
		
		for (Board board : db.selectAll()) {
			System.out.println(board);
		}
		
	}
	private List<Board> selectAll() {
		List<Board> list = new ArrayList<>();
		// 2. 데이터 베이스를 가져와야 함.
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafy_board?serverTimezone=UTC", "ssafy", "ssafy");
		
			// 3. SQL 실행
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM board";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Board board = new Board(); // 바구니 빈 게시글 준비
				board.setId(rs.getInt("id")); // 컬럼명
//				board.setId(rs.getInt(1)); //인덱스 1부터 시작
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setViewCnt(rs.getInt("view_cnt"));
				board.setRegDate(rs.getString("reg_date"));
				
				list.add(board);
				
			}
			
			// 역순으로
			rs.close();
			stmt.close();
			conn.close();
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
