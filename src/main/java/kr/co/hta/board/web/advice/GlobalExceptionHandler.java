package kr.co.hta.board.web.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import kr.co.hta.board.exception.SimpleBoardException;

@ControllerAdvice
public class GlobalExceptionHandler {
//모든 클래스에서 예외처리시 사용하는 클래스이다보니
//GlobalExceptionHandler라고 주로 명명한다.
	
	
	//어차피 sbe도 exception타입이라 헷갈려하지않을까싶겠지만
	//더 구체적인 타입으로 찾아가기때문에 괜찮음
	@ExceptionHandler(SimpleBoardException.class)
	public String handleException(SimpleBoardException ex) {
		ex.printStackTrace();
		return "error/500.jsp";
	}
	
	//내가 예상하지도 못한 어떠한 예외처리라도 받을 수 있도록
	//설정하여 생성한 메소드 (최상위 예외처리 타입)
	@ExceptionHandler(Exception.class)
	public String handleException(Exception ex) {
		ex.printStackTrace();
		return "error/500.jsp";
	}
}
