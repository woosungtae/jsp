<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false" %>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
              <% request.setCharacterEncoding("utf-8"); %>
     <c:set var="contextPath" value="${pageContext.request.contextPath }"/>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록창</title>
</head>
<body>
<table border="1" align="center" width="80%">
<tr align="center" bgcolor="lightgreen">
<td><b>아이디</b></td>
<td><b>비밀번호</b></td>
<td><b>이름</b></td>
<td><b>이메일</b></td>
<td><b>가입일</b></td>
</tr>
<c:forEach var="member" items="${membersList }">
<tr align="center">
<td>${member.id }</td>
<td>${member.pwd }</td>
<td>${member.name }</td>
<td>${member.email }</td>
<td>${member.joinDate }</td>
</tr>
</c:forEach>
</table>
<a href="${contextPath }/member/memberForm.do"><h1 style="text-align:center">회원가입</h1></a>
</body>
</html>