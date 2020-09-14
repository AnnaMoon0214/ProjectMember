<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="include/Header.jsp" %>
<input type="button" onclick="location.href='add'" value="신규회원 등록">
<br>

<c:forEach var="member" items="${members}">
${member.mno}, ${member.mname}, ${member.email}, ${member.pwd},
<fmt:formatDate value="${cre_date}" pattern="yyyy-mm-dd"/>
<fmt:formatDate value="${mod_date}" pattern="yyyy-mm-dd"/>
<input type="button" onclick="location.href='update'" value="수정"><br>
</c:forEach>

