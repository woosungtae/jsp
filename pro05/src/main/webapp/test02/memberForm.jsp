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
<title>회원 가입 창</title>
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
<form action="${contextPath }/std/addMember.do" method="post">
<table align="center">
<caption>회원가입창</caption>
<tr>
<td width="110"><p>아이디 :</p></td>
<td width="50"><input type="text" name="id"></td>
</tr>
<tr>
<td width="110"><p>이름 :</p></td>
<td width="50"><input type="text" name="name"></td>
</tr>
<tr>
<td width="110"><p>비밀번호 :</p></td>
<td width="50"><input type="password" name="pwd"></td>
</tr>
<tr>
<td width="110"><p>이메일 :</p></td>
<td width="50"><input type="email" name="email"></td>
</tr>
<tr>
<td width="110"><p>&nbsp;</p></td>
<td width="50">
<input value="회원가입" type="submit"/>
<input type="reset" value="취소">
</td>
</tr>
</table>
</form>
</body>
</html>