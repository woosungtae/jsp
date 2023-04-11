<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*,sec01.ex03.*" pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="wst" class="sec01.ex03.CalculatorBean" scope="page" />
<jsp:setProperty name="wst" property="*" />

<%
CalculatorDAO calculatorDAO = new CalculatorDAO();
calculatorDAO.addNumber(wst);
List numbersList = calculatorDAO.listNumbers();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table align="center" width="100%">
		<tr align="center">
			<td width="7%">숫자1</td>
			<td width="5%">기호</td>
			<td width="7%">숫자2</td>
			<td width="3%">=</td>
			<td width="7%">정답</td>
		</tr>
		<%
		if (numbersList.size() == 0) {
		%>
		<tr>
			<td colspan="5">
				<p align="center">
					<b><span style="font-size: 9pt;"></span></b>
				</p>
			</td>
		</tr>
		<%
		} else {
		for (int i = 0; i < numbersList.size(); i++) {
			CalculatorBean bean = (CalculatorBean) numbersList.get(i);
		%>
		<tr align="center">
		<td align="center"><%=bean.getNum1()%></td>
		<td align="center"><%=bean.getMark()%></td>
		<td align="center"><%=bean.getNum2()%></td>
		<td align="center"><%= "=" %></td>
		<td align="center"><%=bean.getAnswer()%></td>
		
		<%
		}
		}
		%>
		<tr height="1" >
			<td colspan="5"></td>
		</tr>
		
	</table>
</body>
</html>