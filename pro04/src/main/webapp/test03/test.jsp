<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%
    request.setCharacterEncoding("utf-8");
    String name = "홍길동";
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${10+20}<br>
${10*20}<br>
${true && false}<br>
${10>=20}<br>
${user.name =="홍길동"? "교수":"학생"}
</body>
</html>