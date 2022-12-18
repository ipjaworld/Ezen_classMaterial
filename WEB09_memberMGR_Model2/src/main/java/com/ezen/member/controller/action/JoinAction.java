package com.ezen.member.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.member.dao.MemberDao;
import com.ezen.member.dto.MemberDto;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전달인수들을 모두 dto 객체에 담습니다
		MemberDto mdto = new MemberDto();
		mdto.setName( request.getParameter("name") );
		mdto.setUserid( request.getParameter("userid") );
		mdto.setPwd( request.getParameter("pwd") );
		mdto.setEmail( request.getParameter("email") );
		mdto.setPhone( request.getParameter("phone") );
		mdto.setAdmin(Integer.parseInt(request.getParameter("admin")) );

		// dao에 insertMember 를 만들고, dto 객체를 보내서 레코드를 추가힙니다
		MemberDao mdao = MemberDao.getInstance();
		int result = mdao.insertMember(mdto);
		
		HttpSession session = request.getSession();
		// 회원가입 결과 메세지를 갖고 loginForm.jsp 로 되돌아 갑니다.
		if(result == 1) session.setAttribute("message", "회원가입 완료. 로그인하세요");
		else  session.setAttribute("message", "회원가입 실패. 관리자에게 문의하세요");

//		RequestDispatcher dp = request.getRequestDispatcher("member/loginForm.jsp");
//		dp.forward(request, response);
		
		response.sendRedirect("member/loginForm.jsp");
	}

}
