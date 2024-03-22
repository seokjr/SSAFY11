package com.ssafy.ws.step2.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.ws.step2.dto.Movie;
import com.ssafy.ws.step2.util.DBUtil;

public class MovieDaoImpl implements MovieDao{

	private final DBUtil util = DBUtil.getInstance();

	private static MovieDaoImpl instance = new MovieDaoImpl();

	private MovieDaoImpl(){}

	public static UserDaoImpl getInstance(){
		return instance;
	} 
	
	public List<Movie> selectAllMovies() throws SQLException{
		String sql = "SELECT * FROM movies";
		List<movie> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()){
				Movie movie = new Movie();
				movie.setId(rs.getInt("Id"));
				movie.setTitle(rs.getString("Title"));
				movie.setDirector(rs.getString("Director"));
				movie.setGenre(rs.getString("Genre"));
				movie.setRunningTime(rs.getInt("RunningTime"));
				result.add(movie);
			}

		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}

		return result;
	} 
	
	public boolean insertMovie(Movie movie)throws SQLException{
		String sql = "INSERT INTO movies (Title, Director, Genre, RunningTime) VALUES (?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movie.getTitle());
			pstmt.setString(2, movie.getDirector());
			pstmt.setString(3, movie.getGenre());
			pstmt.setInt(4, movie.getRunningTime());
			// sql 실행 결과 영향받은 행 수가 0 이상인 경우 정상 실행
			result = pstmt.executeUpdate() > 0 ? true : false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt);
		}
		
		return result;
	}
	
	public int movieCount() throws SQLException{
		String sql = "SELECT COUNT(*) as total FROM movies";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()){
				result = rs.getInt("total");
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt, rs);
		}

		return result;
	}
}
