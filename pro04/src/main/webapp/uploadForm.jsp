<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<form action="${contextPath}/pro04/upload.do" method="post" enctype="multipart/form-data">
파일 1:<input type="file" name="file1"><br>
파일 2:<input type="file" name="file2"><br>
매개변수1:<input type="text" name="param1"> <br>
매개변수2:<input type="text" name="param2"> <br>
매개변수3:<input type="text" name="param3"> <br>
<input type="submit" value="업로드">
</form>
</body>
</html>