package kr.co.hta.board.service;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import kr.co.hta.board.vo.Book;
import kr.co.hta.board.vo.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/META-INF/spring/test-root-context.xml")
@Transactional
public class BookServiceTest {

	@Autowired
	BookService bookService;
	
	@Test
	public void testConfig() {
		assertThat(bookService, notNullValue());
	}

	@Test
	public void testSearchBooks() {
		Criteria c = new Criteria();
		c.setTitle("온도");
		List<Book> books = bookService.searchBooks(c);
		assertThat(books, notNullValue());
		System.out.println(books);
	}
	
}

