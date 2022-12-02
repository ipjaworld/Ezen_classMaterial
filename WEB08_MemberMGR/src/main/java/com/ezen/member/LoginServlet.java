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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "member/loginForm.jsp";
		
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser")!=null)
			url = "main.jsp";
		
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// 전달된 아이디 비번을 변수에 저장
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		// 전달된 아이디를 이용해서 회원 검색을 하고 리턴 받은 결과값에 의해 정상 로그인 또는 로그인 폼으로 복귀를 결정합니다.
		MemberDao mdao = MemberDao.getInstance();
		// 아이디를 전달인수로 보내고 회원의 모든 정보를 담은 MemberDto 객체를 리턴 받습니다.
		MemberDto mdto = mdao.getMember( userid );
		// 만약 회원의 아이디가 없는 아이디이면 mdto는 null 값을 리턴 받습니다
		
		String url = "member/loginForm.jsp";
		
		if(mdto == null) {
			request.setAttribute("message", "아이디가 없습니다.");
		}else if( mdto.getPwd() == null ) {
			request.setAttribute("message", "DB오류. 관리자에게 문의하세요");
		}else if( !mdto.getPwd().equals(pwd) ) {
			request.setAttribute("message", "비밀번호가 올바르지 않습니다.");
		}else if( mdto.getPwd().equals(pwd) ) {
			url = "main.jsp";
			// 로그인한 사람의 정보(mdto)를 세션에 저장합니다.
			// session은 각 페이지에 있는 request 객체를 통해서 얻어 쓸 수 있는데,  jsp 페이지에서는 그 페이지가 갖고 있는
			// session을 별도 작업없이 그냥 사용해도 되지만,
			// 서블릿에서는 jsp 파일이 갖고 있던 request를 전달인수로 받고 그를 통해서 얻어 사용하는 동작이 필요합니다.
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mdto);	
			// 이 부분에서 mdao->getMember( userid )->mdto 를 통해 db에서 가져온 정보들을 세션에 값을 설정한다!
		}else {
			request.setAttribute("message", "무슨 이유인지 알 수 없네요. 로그인이 되지 않아요. 관리자에게 문의하세요");
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
		
	}

}





