<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="reply.iu" method="post">
<h3>내용입력</h3>
<input type="hidden" name="num" value="${boardDTO.num}">
<input type="hidden" name="writer" value="${member.id}">
<input type="text" name="title">
<input type="text" name="contents">
<button>제출</button>
</form>
</body>
</html>