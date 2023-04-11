package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
	String new_id = request.getParameter("new_id");
	String new_pw = request.getParameter("new_pw");
	String user_name = request.getParameter("user_name");
	String user_mail = request.getParameter("user_mail");
	String user_tel = request.getParameter("user_tel");
	System.out.println("아이디" + user_id);
	System.out.println("비밀번호" + user_pw);
	System.out.println("새로운 아이디:" + new_id);
	System.out.println("비밀번호:" + new_pw);
	System.out.println("이름:" + user_name);
	System.out.println("메일주소:" + user_mail);
	System.out.println("번호:" + user_tel);
	}
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}

	
}