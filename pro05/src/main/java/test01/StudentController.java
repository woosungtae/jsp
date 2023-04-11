package test01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/studentlists/*")
public class StudentController extends HttpServlet {
	
	StudentsDAO studentsDAO;
	
	public void init(ServletConfig config) throws ServletException {
		studentsDAO =new StudentsDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo();
		System.out.println("action:" + action);
		
		if(action == null || action.equals("/listStudents.do"))
         {
			List<StudentsVO> studentslist = studentsDAO.liststudents();
			request.setAttribute("studentslist", studentslist);
			nextPage = "/test/studentslist.jsp";
		}else if(action.equals("/addstudents.do"))
		{
			String username = request.getParameter("username");
			String univ = request.getParameter("univ");
			String birth = request.getParameter("birth");
			String email = request.getParameter("email");
			StudentsVO studentsVO = new StudentsVO(username,univ,birth,email);
			studentsDAO.addstudents(studentsVO);
			nextPage ="/board/studentlists/listStudents.do";
		}else if (action.equals("/studentsForm.do"))
		{ 
	      nextPage ="/test/studentsForm.jsp";
	}else
	{
		List<StudentsVO> studentslist = studentsDAO.liststudents();
	request.setAttribute("studentslist", studentslist);
	nextPage ="/test/studentslist.jsp";
	}
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
}
}


