package kr.co.hta.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.hta.board.dao.BoardDao;
import kr.co.hta.board.dao.UserDao;
import kr.co.hta.board.exception.SimpleBoardException;
import kr.co.hta.board.vo.Board;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<Board> getBoards() {
		return boardDao.getBoards();
	}

	@Override
	public void addBoard(Board board) {
		boardDao.addBoard(board);
		// User user = userDao.getUserById(board.getNick());
		// user.setPoint(user.getPoint() + 5);
		// userDao.updateUser(user);
	}

	@Override
	public Board getBoardByNo(int boardNo) {
		return boardDao.getBoardByNo(boardNo);
	}
	
	@Override
	public void deleteBoard(int boardNo, String userId) {
		Board board = boardDao.getBoardByNo(boardNo);
		//작성자가 아닌 사람이 삭제를 실행할 경우
		if(!userId.equals(board.getNick())) {
			throw new SimpleBoardException("본인이 작성한 글만 삭제할 수 있습니다.");
		}
		//해당 게시글의 작성자만 삭제할 수 있어야함
		boardDao.deleteBoard(boardNo);
	}
}
