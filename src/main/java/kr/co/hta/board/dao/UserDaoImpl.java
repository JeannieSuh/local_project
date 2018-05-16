package kr.co.hta.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.co.hta.board.vo.User;

//@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate template;

	private RowMapper<User> rowMapper = new RowMapper<User>() {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getString("user_id"));
			user.setPwd(rs.getString("user_pwd"));
			user.setName(rs.getString("user_name"));
			user.setCreateDate(rs.getDate("create_date"));
			return user;
		}
	};
	
	@Override
	public void addNewUser(User user) {
		String sql = "insert into simple_board_user(user_id, user_pwd, user_name, create_date) "
				  + "values(?, ?, ?, sysdate)";
		template.update(sql, user.getId(), user.getPwd(), user.getName());
	}

	@Override
	public List<User> searchUsers(String userId) {
		String sql = "select * from simple_board_user where user_id = ?";
		return template.query(sql, rowMapper, userId);
	}

	@Override
	public User getUserById(String userId) {
		List<User> users =  searchUsers(userId);
		if(users.isEmpty()) {
			return null;
		}
		//혹시 없어서 list자체에 null이 오면 exception이 발생할까봐
		return users.get(0);
	}
	
}