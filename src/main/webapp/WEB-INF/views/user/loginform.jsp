<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>Spring board :: login form</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="../include/nav.jsp" %>
<div class="container">
	<h1>로그인 폼</h1>
	
	<br/>
	
	<c:if test="${param.err eq 'fail' }">
		<div class="alert alert-danger">
			<strong>[오류]</strong> 아이디 혹은 비밀번호가 올바르지않습니다.
		</div>
	</c:if>
	<c:if test="${param.err eq 'deny' }">
		<div class="alert alert-danger">
			<strong>[오류]</strong> 로그인이 필요한 서비스입니다.
		</div>
	</c:if>
	
	<form class="well" method="post" action="login.do" >
		<div class="form-group">
			<label>아이디</label>
			<input type="text" name="id" class="form-control" />
		</div>
		<div class="form-group">
			<label>비밀번호</label>
			<input type="password" name="pwd" class="form-control" />
		</div>
		<div class="text-right">
			<input class="btn btn-primary" type="submit" value="로그인" />		
		</div>
	</form>
</div>
</body>
</html>