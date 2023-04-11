<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.* , test01.*"
    isELIgnored="false"
     %>
     <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/fmt" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
         <% request.setCharacterEncoding("utf-8"); %>
     <c:set var="contextPath" value="${pageContext.request.contextPath }"/>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 목록</title>
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
 <table align="center" width="100%" border="1">
 <tr align="center" bgcolor="lightgreen">
 <td width="7%">${'id' }</td>
 <td width="7%">${'이름' }</td>
 <td width="7%">${'대학'}</td>
 <td width="7%">${'생일'}</td>
 <td width="7%">${'이메일'}</td>
 </tr>
 <c:choose>
 <c:when test="${studentslist ==null }">
  <tr align="center">
  <td colspan="5" width="7%">
  <b>등록된 학생이 없습니다</b>
  </td>
  </tr>
 </c:when>
 <c:when test="${studentslist != null }">
  <c:forEach var="mem" items ="${studentslist }">
  <tr align="center" >
 <td width="7%">${mem.id}</td>
 <td width="7%">${mem.username}</td>
 <td width="7%">${mem.univ}</td>
 <td width="7%">${mem.birth}</td>
 <td width="7%">${mem.email}</td>
 </tr>
  </c:forEach>
 </c:when>
 </c:choose>
 </table>
<a href="${contextPath}/board/studentlists/studentsForm.do"><p class ="cls2"> 학생 추가하기 </p>
</a> 
</body>
</html>