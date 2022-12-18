package com.ezen.member.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.member.dao.MemberDao;
import com.ezen.member.dto.MemberDto;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		String url = "member/loginForm.jsp";
		
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = mdao.getMember( userid );
		
		if( mdto == null ) {
			request.setAttribute("message", "입력하신 아이디가 존재하지 않습니다");
		}else if( !mdto.getPwd().equals(pwd) ) {
			request.setAttribute("message", "입력하신 비밀번호가 틀렸습니다");
		}else if( mdto.getPwd().equals(pwd) ) {
			url = "member.do?command=main";
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mdto);
		}else {
			request.setAttribute("message", "대체 왜 로그인이 안될까요 ?");
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

}
