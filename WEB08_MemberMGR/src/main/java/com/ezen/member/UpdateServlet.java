package com.ezen.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.dao.MemberDao;
import com.ezen.dto.MemberDto;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 회원 정보 수정의 보통은 회원 아이디를 전달받아 아이로 조회한 결과를 회원수정폼으로 같이 갖고 갑니다
//		String userid = request.getParameter("userid");
//		MemberDao mdao = MemberDao.getInstance();
//		MemberDto mdto = mdao.getMember(userid);
//		request.setAttribute("curUser", mdto);
		
		// 그러나 현재는 로그인한 유저를 수정할 예정이며, 로그인 유저의 정보는 세션에 저장되어 있고, jsp 페이지에서도
		// 세션값을 언제나 접근할 수 있으며로 현재는 조회코드가 생략됩니다.
		RequestDispatcher dp = request.getRequestDispatcher("member/updateForm.jsp");
		dp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		MemberDto mdto = new MemberDto();

		// 전달되는 내용들로 해당 회원의 정보를 수정하세요
		//if(mdao!=null && session.getAttribute("loginUser") == request.getParameter("userid")
		//		&& session.getAttribute("pwd") == session.getAttribute("pwd_check"))

		mdto.setEmail(request.getParameter("email"));
		mdto.setAdmin(Integer.parseInt(request.getParameter("admin")));
		mdto.setName(request.getParameter("name"));
		mdto.setPhone(request.getParameter("phone"));
		mdto.setPwd(request.getParameter("pwd"));
		mdto.setUserid(request.getParameter("userid"));

		MemberDao mdao = MemberDao.getInstance();
		
		String url = "main.do";
		int result = mdao.updateMember(mdto);
		if(result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mdto);	// 세션 로그인 정보를 수정된 내용으로 교체
		}
		
		// 수정 후에 main.jsp 로 이동합니다.
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
		// 수정내용이 페이지 상단에 내용에 바로 적용되게 세션값을 수정해주세요.
		
	}

}
