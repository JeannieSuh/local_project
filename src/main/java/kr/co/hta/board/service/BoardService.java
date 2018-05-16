package kr.co.hta.board.service;

import java.util.List;

import kr.co.hta.board.vo.Board;

public interface BoardService {

	List<Board> getBoards();
	void addBoard(Board board);
	Board getBoardByNo(int boardNo);
	void deleteBoard(int boardNo, String userId);
}
