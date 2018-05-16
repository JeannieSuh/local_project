package kr.co.hta.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.hta.board.dao.UserDao;
import kr.co.hta.board.exception.SimpleBoardException;
import kr.co.hta.board.vo.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	
	@Override
	public void addNewUser(User user) {
		List<User> users = dao.searchUsers(user.getId());
		if(!users.isEmpty()) {
			throw new SimpleBoardException("이미 사용중인 아이디 입니다.");
		}
		dao.addNewUser(user);
	}

	@Override
	public User getUserById(String userId) {
		return dao.getUserById(userId);
	}
	
}
