package com.ezen.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.MemberDao;
import com.ezen.dto.MemberDto;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dp = request.getRequestDispatcher("member/joinForm.jsp");
		dp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = new MemberDto();
		
		// 전달된 파라미터들을 각 변수에 저장합니다
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		// 각 변수들은 mdto에 저장합니다
		mdto.setAdmin(Integer.parseInt( request.getParameter("admin")) );
		mdto.setUserid(request.getParameter("userid"));
		mdto.setName(name);
		mdto.setEmail(email);
		mdto.setPhone(phone);
		mdto.setPwd(pwd);
		
		// 회원가입 메서드 이름은 insertMember로 하세요
		int result = mdao.insertMember( mdto );
		
		// 회원가입을 마친 후 loginForm.jsp 로 되돌아갑니다. 이때, 회원가입 결과를 message에 담아서 갑니다.
		if(result==1) request.setAttribute("message", "회원가입이 완료되었습니다. 로그인하세요");
		else request.setAttribute("message", "회원가입이 실패하였습니다. 관리자에게 문의하세요");
		
		RequestDispatcher dp = request.getRequestDispatcher("member/loginForm.jsp");
		dp.forward(request, response);
		
		//response.sendRedirect("loginForm.jsp");
		
	}

}
