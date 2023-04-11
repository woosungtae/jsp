<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
     %>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <% request.setCharacterEncoding("utf-8"); %>
     <c:set var="contextPath" value="${pageContext.request.contextPath }"/>
         
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 추가 창</title>
<style type="text/css">
.cls1{
font-size:40px;
text-align:center;
}
.cls2{
text-align:center;
}
</style>
</head>
<body>
<form action="${contextPath }/board/studentlists/addstudents.do" method="post">
<table align="center">
<caption>학생 추가 창</caption>
<tr>
<td width="110"><p>이름: </p></td>
<td width="50"><input type="text" name="username"></td>
</tr>
<tr>
<td width="110"><p>대학 :</p></td>
<td width="50"><input type="text" name="univ"></td>
</tr>
<tr>
<td width="110"><p>생일</p></td>
<td width="50"><input type="text" name="birth"></td>
</tr>
<tr>
<td width="110"><p>이메일 :</p></td>
<td width="50"><input type="email" name="email"></td>
</tr>
<tr>
<td width="110"><p>&nbsp;</p></td>
<td width="50">
<input value="등록" type="submit"/>
</td>
</tr>
</table>
</form>
</body>
</html>