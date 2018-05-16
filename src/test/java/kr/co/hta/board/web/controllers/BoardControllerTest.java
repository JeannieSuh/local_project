package kr.co.hta.board.web.controllers;

import static org.junit.Assert.*;
import org.junit.Before;
import static org.hamcrest.CoreMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:/META-INF/spring/test-root-context.xml",
								  "classpath:/META-INF/spring/test-app-servlet.xml"})
@Transactional
public class BoardControllerTest {

	@Autowired
	BoardController boardController;
	
	//컨트롤러를 실행해볼 수 있다. (MVC를 따라하는 객체)
	MockMvc mockMvc = null;
	
	@Before
	public void setUp() {
		//독립적으로 가지고놀 수 있는 컨트롤러 객체 만들기
		mockMvc = MockMvcBuilders.standaloneSetup(boardController).build();
	}
	
	@Test
	public void testBoardController() {
		assertThat(boardController, notNullValue());
	}

	@Test
	public void testList() throws Exception {
		//해당 요청을 따라서 실행시켜보고, 출력해보기
		mockMvc.perform(get("/board/list.do"))
			   .andDo(print())
			   .andExpect(status().isOk())
			   .andExpect(view().name("board/list.jsp"))
			   .andExpect(model().attributeExists("boards"));
	}

	@Test
	public void testDetail() throws Exception {
		//필요한 param값 넣어보기, 변수명일치시켜주고 반드시 문자열타입
		mockMvc.perform(get("/board/detail.do").param("no", "145"))
			   .andDo(print())
			   .andExpect(status().isOk())
			   .andExpect(view().name("board/detail.jsp"))
			   .andExpect(model().attributeExists("board"))
			   .andExpect(model().attribute("board", notNullValue()));
	}
}

