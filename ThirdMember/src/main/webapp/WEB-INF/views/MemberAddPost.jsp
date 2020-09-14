<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록 결과</title>
</head>
<body>
<%@ include file="include/Header.jsp" %>
<h1>회원 등록 결과</h1>
	${name}님의 등록이 완료되었습니다.<br>
	3초 후 목록 리스트로 돌아갑니다.<br>
	<input type="button" onclick="location.href='list'" value="지금 돌아가기">
<script>
	setTimeout(function() {window.location='list;'}, 3000);
</script>
<%@ include file="include/Footer.jsp" %>
</body>
</html>