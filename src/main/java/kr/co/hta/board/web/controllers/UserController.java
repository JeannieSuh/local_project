package kr.co.hta.board.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.hta.board.service.UserService;
import kr.co.hta.board.vo.User;
import kr.co.hta.board.web.form.UserRegisterForm;

@Controller
@RequestMapping("/user")
public class UserController {
//상단의 매핑은 url 요청시 앞에 붙는 것

	@Autowired
	private UserService service;
	
	@RequestMapping("/form.do")
	public String form() {
		return "user/form.jsp";
	}
	
	@RequestMapping("/register.do")
	public String register(UserRegisterForm uf) {
		
		User user = new User();
		BeanUtils.copyProperties(uf, user);
		service.addNewUser(user);
		
		return "user/success.jsp";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login() {
		return "user/loginform.jsp";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(String id, String pwd, HttpSession session) {
		
		User user = service.getUserById(id);
		if(user == null) {
			return "redirect:/user/login.do?err=fail";
		}
		if(!user.getPwd().equals(pwd)) {
			return "redirect:/user/login.do?err=fail";			
		}
		session.setAttribute("LOGIN_USER", user);
		
		//localhost/home.do로 간다.
		//리다이렉션일때는 컨트롤러 전체 매핑이 적용 안됨!
		return "redirect:/home.do";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home.do";
	}
}
