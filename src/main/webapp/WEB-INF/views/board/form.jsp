<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>     
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>Spring board :: form</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="../include/nav.jsp" %>
<div class="container">
	<h1>게시글 등록 폼</h1>
	
	<form class="well" method="post" action="add.do" id="f" enctype="multipart/form-data">
		<!-- 부모태그 클래스의 has-error와 자식태그의 form-control은 서로를 활성화시킴 -->
		<div class="form-group has-feedback">
			<label class="control-label">제목</label>
			<input type="text" class="form-control" name="title" />
			<span class="glyphicon glyphicon-remove form-control-feedback" style="display: none;"></span>
		</div>
		<div class="form-group">
			<label>첨부파일</label>
			<input type="file" class="form-control" name="upfile" />
		</div>
		<div class="form-group has-feedback">
			<label class="control-label">내용</label>
			<textarea rows="4" class="form-control" name="contents"></textarea>
			<span class="glyphicon glyphicon-remove form-control-feedback" style="display: none;"></span>			
		</div>
		<div class="text-right">
			<button class="btn btn-primary">등록</button>
		</div>
	</form>
</div>
<script type="text/javascript">
$(function() {
	$("#f").submit(function() {
		var hasError = false;
		
		if($(":input[name=title]").val().trim() == "") {
			$(":input[name=title]").parents(".form-group").addClass("has-error").find('span').show();
			hasError = true;
		}
		if($(":input[name=contents]").val().trim() == "") {
			$(":input[name=contents]").parents(".form-group").addClass("has-error").find('span').show();
			hasError = true;
		}

		return !hasError;
	});
})
</script>
</body>
</html>