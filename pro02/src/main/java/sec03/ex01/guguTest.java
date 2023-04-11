package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gutest")
public class guguTest extends HttpServlet {
	public void init() {
		System.out.println("init 메서드 호출");
	}


	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int gugudan = Integer.parseInt(request.getParameter("gugudan"));
        
		for(int i=0; i<=9; i++) {
			out.print(gugudan + "X" + i + "=");            			
			out.print(i*gugudan + "입니다 <br>");
		}
      	
	}
}