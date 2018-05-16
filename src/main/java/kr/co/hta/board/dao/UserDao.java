package kr.co.hta.board.dao;

import java.util.List;

import kr.co.hta.board.vo.User;

public interface UserDao {

	void addNewUser(User user);
	List<User> searchUsers(String userId);
	User getUserById(String userId);
	
}