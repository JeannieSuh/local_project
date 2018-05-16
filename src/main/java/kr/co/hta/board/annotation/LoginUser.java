package kr.co.hta.board.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 어노테이션 정의
 * 
 * @Target
 * 각 ElementType뒤에 추가되는 값에 따라
 * 어느 타입에 어노테이션을 부착할 수 있는지를 나타낸다.
 * 
 * @Retention
 * 어느 시점에 어노테이션이 해석되게 할것인가.
 * runtime : 해당 프로그램이 실행될때 
 * @author JHTA
 *
 */
/*@Target(ElementType.TYPE)			: 클래스
@Target(ElementType.CONSTRUCTOR)	: 생성자
@Target(ElementType.FIELD) 			:변수
@Target(ElementType.METHOD) 		: 메소드 */
@Target(ElementType.PARAMETER) // 	: 파라미터
@Retention(RetentionPolicy.RUNTIME) // 실행될 때
@Documented							//문서에 어노테이션 정보를 표시되게한다.
public @interface LoginUser {

}

