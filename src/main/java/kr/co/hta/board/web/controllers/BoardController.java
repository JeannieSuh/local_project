package kr.co.hta.board.web.controllers;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.hta.board.annotation.LoginUser;
import kr.co.hta.board.service.BoardService;
import kr.co.hta.board.vo.Board;
import kr.co.hta.board.vo.User;
import kr.co.hta.board.web.form.BoardForm;
import kr.co.hta.board.web.views.DownloadView;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private String directory = "C:\\upload\\formfile";
	@Autowired
	private DownloadView downloadView;
	@Autowired
	private BoardService boardSerivce;
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		List<Board> boards = boardSerivce.getBoards();
		model.addAttribute("boards", boards);
		return "board/list.jsp";
	}
	
	@RequestMapping("/detail.do")
	public String detail(@RequestParam("no") int boardNo, Model model) {
		Board board = boardSerivce.getBoardByNo(boardNo);
		model.addAttribute("board", board);
		return "board/detail.jsp";
	}
	
	@RequestMapping("/down.do")
	public ModelAndView download(@RequestParam("no") int boardNo) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("directory", directory);
		mav.addObject("filename", boardSerivce.getBoardByNo(boardNo).getFilename());
		//뷰 객체가 직접들어있어서 바로 객체 속 render를 실행함
		//HandlerAdapter, 컨트롤러 쪽의 과정을 수행할 필요가 없는거지!
		mav.setView(downloadView);
		//원래 모든 과정의 마지막은 해당 뷰의 렌더링이기때문에
		return mav;
	}

	//requestParam : 요청파라미터에서 해당 이름에 해당하는 값을 찾아랏
	//쿼리스트링문에 작성한 변수명을 메소드안에서 사용하기전 변경시킬수 있는 방법이다.
	@RequestMapping("/del.do")
	public String delete(@RequestParam("no") int boardNo, @LoginUser User user) {
		
		//해당 게시글의 작성자만 삭제할 수 있어야함
		boardSerivce.deleteBoard(boardNo, user.getId());
		return "redirect:/board/list.do";
	}

	@RequestMapping("/form.do")
	public String form() {
		return "board/form.jsp";
	}
	
	@RequestMapping("/add.do")
	public String add(BoardForm boardForm, @LoginUser User user) throws Exception {
		
		Board board = new Board();
		board.setTitle(boardForm.getTitle());
		board.setNick(user.getId());
		board.setContents(boardForm.getContents());
		
		MultipartFile upfile = boardForm.getUpfile();
		//업로드된 파일이 없을 수도 있어서
		if (!upfile.isEmpty()) {
			String filename = upfile.getOriginalFilename();
			board.setFilename(filename);
			//해당 위치에 해당 파일명으로 저장하기
			FileCopyUtils.copy(upfile.getBytes(), new File(directory, filename));
		}
		boardSerivce.addBoard(board);
		return "redirect:/board/list.do";
	}

	@RequestMapping("/modify.do")
	public String modify(int no) {
		
		return "modifyform.jsp";
	}
}
