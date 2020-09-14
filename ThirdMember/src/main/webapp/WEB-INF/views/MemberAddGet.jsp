<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신규회원 등록</title>
</head>
<body>
<%@ include file="include/Header.jsp" %>
<h1>회원 가입</h1>
<form action="add" method="post">
이름:<input type="text" name="mname"><br>
E-MAIL:<input type="text" name="email"><br>
비밀번호:<input type="password" name="pwd"><br>
<input type="submit" value="가입">
<input type="button" onclick="location.href='list'" value="취소">
</form>
<%@ include file="include/Footer.jsp" %>
</body>
</html>