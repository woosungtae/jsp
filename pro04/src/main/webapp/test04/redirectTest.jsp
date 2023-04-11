<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
  request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:redirect url="/test00/member1.jsp">
<c:param name="id" value="${'sung'}"/>
<c:param name="pwd" value="${'1424'}"/>
<c:param name="name" value="${'우성태'}"/>
<c:param name="email" value="${'woo@test.com'}"/>
</c:redirect>
</body>
</html>