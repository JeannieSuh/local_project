package kr.co.hta.board.dao;

import java.util.List;

import kr.co.hta.board.vo.Board;

public interface BoardDao {

	//반드시 로그인해야만 게시판 접근가능
	List<Board> getBoards();
	void addBoard(Board board);
	Board getBoardByNo(int boardNo);
	void deleteBoard(int boardNo);
}
