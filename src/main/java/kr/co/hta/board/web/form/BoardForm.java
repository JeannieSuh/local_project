package kr.co.hta.board.web.form;

import org.springframework.web.multipart.MultipartFile;

public class BoardForm {

	private int no;
	private String title;
	private String contents;
	//여기서는 MPF타입이라서, 
	//혹시나 자동으로 변수명따라 값이 옮겨질까봐
	//FORM.JAVA랑 구분하기위해서 변수명을 다르게 해주었다 !=filename
	private MultipartFile upfile;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public MultipartFile getUpfile() {
		return upfile;
	}
	public void setUpfile(MultipartFile upfile) {
		this.upfile = upfile;
	}
	@Override
	public String toString() {
		return "BoardForm [no=" + no + ", title=" + title + ", contents=" + contents + ", upfile=" + upfile + "]";
	}
	
}
