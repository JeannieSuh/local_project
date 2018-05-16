<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>Spring board :: register form</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="../include/nav.jsp" %>
<div class="container">
	<h1>회원가입 폼</h1>
	
	<br/>
	
	<form class="well" method="post" action="register.do" >
		<div class="form-group">
			<label>아이디</label>
			<input type="text" name="id" class="form-control" />
		</div>
		<div class="form-group">
			<label>비밀번호</label>
			<input type="password" name="pwd" class="form-control" />
		</div>
		<div class="form-group">
			<label>이름</label>
			<input type="text" name="name" class="form-control" />
		</div>
		<div class="text-right">
			<input class="btn btn-primary" type="submit" value="회원가입" />		
		</div>
	</form>
</div>
</body>
</html>