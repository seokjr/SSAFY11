package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.repository.BoardRepository;
import com.ssafy.board.model.repository.BoardRepositoryImpl;

// 싱글턴으로 만들어야 함.
public class BoardServiceImpl implements BoardService {

	private static BoardService service = new BoardServiceImpl() {
	};
	// 의존성 주입
	private BoardRepository repository = BoardRepositoryImpl.getInstance();
	private BoardServiceImpl() {
	}

	public static BoardService getInstance() {
		return service;
	}

	@Override
	public List<Board> getList() {
		return repository.selectAll();
	}

	@Override
	public Board getBoard(int id) {
		repository.updateViewCnt(id);
		return repository.selectOne(id);
	}

	@Override
	public void writeBoard(Board board) {
		repository.insertBoard(board);
	}

	@Override
	public void modifyBoard(Board board) {
		repository.updateBoard(board);
		// TODO Auto-generated method stub

	}

	@Override
	public void removeBoard(int id) {
		repository.deleteBoard(id);
	}

}
