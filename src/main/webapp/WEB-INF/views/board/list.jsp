<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>Spring board :: list</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="../include/nav.jsp" %>
<div class="container">
	<h1>게시글 목록</h1>
	
	<br/>
	
	<table class="table">
		<colgroup>
			<col width="10%">
			<col width="*">
			<col width="10%">
			<col width="10%">
			<col width="10%">
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<c:choose>
			<c:when test="${empty boards }">
				<tr>
					<td colspan="5" class="text-center">게시글이 존재하지않습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="board" items="${boards }">
					<tr>
						<td>${board.no }</td>
						<!-- c:out은 혹여 코딩에 적용되는 문자열이 입력되었을 때, 
						    변환되는것을 막고, 입력받은 값 그대로 출력할때 사용한다.  -->
						<td><a href="detail.do?no=${board.no }"><c:out value="${board.title }" /></a></td>
						<td><c:out value="${board.nick }" /></td>
						<td><fmt:formatDate value="${board.createDate }" pattern="yyyy-MM-dd"/></td>
						<td>
							<!-- disabled를 class 바깥에 작성하면 a태그 기능이 남아있어서 404오류 발생
							     클래스안에 넣어주면 아예 a태그 기능까지 비활성화시켜준다.  -->
							<a class="btn btn-xs btn-danger ${board.nick ne LOGIN_USER.id ? 'disabled' : '' }" href="del.do?no=${board.no }">삭제</a>
							<a class="btn btn-xs btn-success ${board.nick ne LOGIN_USER.id ? 'disabled' : '' } " href="modify.do?no=${board.no }">수정</a>
						</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		</tbody>
	</table>
	
	<div class="text-right">
		<a class="btn btn-default" href="form.do">게시글 작성</a>
	</div> 
</div>
</body>
</html>