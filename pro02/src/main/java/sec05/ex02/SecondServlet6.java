package sec05.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/second5_2")
public class SecondServlet6 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String name=request.getParameter("name");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("이름: "+name);
		out.println("<br>");
		out.println("dispatch를 이용한 foward 실습입니다");
		out.println("</body></html>");
	}

}
