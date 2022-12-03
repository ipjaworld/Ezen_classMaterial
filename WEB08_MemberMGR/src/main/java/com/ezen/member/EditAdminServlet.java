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
 * Servlet implementation class EditAdminServlet
 */
@WebServlet("/editadmin.do")
public class EditAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 아이디 현재 등급을 전달받아 변수에 저장합니다.
		request.setCharacterEncoding("UTF-8");
		
		MemberDto mdto = new MemberDto();
		String userid = request.getParameter("userid");
		int admin = Integer.parseInt( request.getParameter("admin"));
		
		// 현재 등급을 보고 수정할 등급으로 변수값을 수정합니다
		if(admin==0) admin=1;
		else admin=0;
		
		MemberDao mdao = MemberDao.getInstance();
		
		// 수정 메서드 이름은 editAdmin으로 하고 전달인수는 아이디와 수정할 등급 두개만 전달합니다.
		mdao.editAdmin(userid, admin);
		
		// 수정을 완료하면 main.jsp 로 돌아갑니다.
		RequestDispatcher dp = request.getRequestDispatcher("main.do");
		dp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
