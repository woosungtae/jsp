package sec03.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member2/*")
public class MemberController extends HttpServlet {
	
	MemberDAO memberDAO;
	
	public void init(ServletConfig config) throws ServletException {
		memberDAO =new MemberDAO();
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
		
		if (action ==null || action.equals("/listMembers.do")) {
			List<MemberVo> membersList = memberDAO.listMember();
			request.setAttribute("membersList", membersList);
			nextPage = "/test03/listMembers.jsp";
		}else if(action.equals("/addMember.do")) {
			String id=request.getParameter("id");
			String pwd=request.getParameter("pwd");
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			MemberVo memberVo = new MemberVo(id,pwd,name,email);
			memberDAO.addMember(memberVo);
			request.setAttribute("msg","addMember");
			nextPage = "/member2/listMembers.do";
		}else if (action.equals("/memberForm.do")) {
			nextPage = "/test03/memberForm.jsp";
		}else if (action.equals("/modMemberForm.do")) 
		 {
			String id = request.getParameter("id");
			MemberVo memInfo = memberDAO.findMember(id);
			request.setAttribute("memInfo", memInfo);
			nextPage = "/test03/modMemberForm.jsp";
		}else if(action.equals("/modMember.do"))
		{
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVo memberVo = new MemberVo(id,pwd,name,email);
			memberDAO.modMember(memberVo);
			request.setAttribute("msg", "modified");
			nextPage = "/member2/listMembers.do";
		}else if (action.equals("/delMember.do")) { 
			String id =request.getParameter("id");
			memberDAO.delMember(id);
			request.setAttribute("msg", "deleted");
			nextPage="/member2/listMembers.do";
	}else{
		List<MemberVo> membersList = memberDAO.listMember();
	request.setAttribute("membersList", membersList);
	nextPage ="/test03/listMembers.jsp";
	}
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
}
		
}




