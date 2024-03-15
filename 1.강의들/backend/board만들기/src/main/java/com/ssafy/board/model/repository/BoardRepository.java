package com.ssafy.board.model.repository;

import java.util.List;

import com.ssafy.board.model.dto.Board;

public interface BoardRepository {
	public abstract List<Board> selectAll();

	public abstract Board selectOne(int id);

	public abstract void insertBoard(Board board);

	public abstract void updateBoard(Board board);

	public abstract void deleteBoard(int id);

	public abstract void updateViewCnt(int id);

}
