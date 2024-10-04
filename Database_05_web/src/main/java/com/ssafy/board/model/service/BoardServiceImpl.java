package com.ssafy.board.model.service;

import java.util.List;
import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dao.BoardDaoImpl;

public class BoardServiceImpl implements BoardService {
	// daository 의 싱글톤을 갖고 온다. 의존성 주입 
	private BoardDao dao = BoardDaoImpl.getInstance();
	
	// 싱글톤 관리 
	private static BoardService service= new BoardServiceImpl();
	private BoardServiceImpl() {}

	public static BoardService getInstance() {
		return service;
	}
	
	
	@Override
	public List<Board> getList() {
		return dao.selectAll();
	}

	@Override
	public Board getBoard(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeBoard(Board board) {
		// 게시글 등록 ! daository 사용 
		dao.insertBoard(board);
	}

	@Override
	public void modifyBoard(Board board) {
		dao.updateBoard(board);
		
	}

	@Override
	public void removeBoard(int id) {
		dao.deleteBoard(id);
		
	}

}
