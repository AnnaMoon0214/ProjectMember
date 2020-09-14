<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<%@ include file="../include/Header.jsp" %>
<h1>로그인</h1>
<form action="login" method="post">
E-mail:<input type="text" name="email"><br>
비밀번호:<input type="password" name="pwd"><br>
<input type="submit" value="로그인">
<input type="button" onclick="location.href='list'" value="취소">
</form>
<%@ include file="../include/Footer.jsp" %>
</body>
</html>