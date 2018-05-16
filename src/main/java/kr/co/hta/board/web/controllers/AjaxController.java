package kr.co.hta.board.web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.hta.board.service.BookService;
import kr.co.hta.board.vo.Book;
import kr.co.hta.board.vo.Criteria;

@Controller
@RequestMapping("/ajax")
public class AjaxController {

	@Autowired
	private BookService bookservice;
	
	@RequestMapping("/search.do")
	public @ResponseBody Map<String, Object> search(Criteria c) {
		Map<String, Object> map = new HashMap<>();

		List<Book> books = bookservice.searchBooks(c);
		if (books.isEmpty()) {
			map.put("success", false);
		} else {
			map.put("success", true);
			map.put("items", books);
		}
		return map;
	}
	
	
/*	@RequestMapping("/user.do")
	public @ResponseBody User getUser() {
		User user = new User();
		user.setId("hong");
		user.setPwd("zxcv1234");
		user.setName("홍길동");
		
		return user;
	}

	@RequestMapping("/user2.do")
	public @ResponseBody ResponseEntity<User> getUser2() {
		User user = new User();
		user.setId("hong");
		user.setPwd("zxcv1234");
		user.setName("홍길동");
		
		//HttpStatus.OK는 응답성공을 나타내는 200을 함께 보냄
		return new ResponseEntity<User>(user, HttpStatus.OK);	
		//HttpStatus.NO_CONTENT는 null처럼 데이터를 찾을 수 없다라는 듯으로 보낼 수있음
		//return new ResponseEntity<User>(HttpStatus.NO_CONTENT);	
	}
	
	@RequestMapping("/user3.do")
	public @ResponseBody Map<String, Object> getUser3() {
		Map<String, Object> map = new HashMap<>();
		
		//DB조회 결과로 찾은 유저
		User user = new User();
		user.setId("hong");
		user.setPwd("zxcv1234");
		user.setName("홍길동");

		//success로 담겨진 value값만 뽑아봐도
		//데이터를 내려보낼지 결정할 수 있다.
		if (user != null) {
			map.put("success", true);
			map.put("items", Arrays.asList(user));
		} else {
			map.put("success", false);
			map.put("items", new User[] {});
		}
		
		return map;
	}*/
	
}
