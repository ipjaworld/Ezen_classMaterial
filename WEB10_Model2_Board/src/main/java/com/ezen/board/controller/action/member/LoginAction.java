package com.ezen.board.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.board.controller.action.Action;
import com.ezen.board.dao.MemberDao;
import com.ezen.board.dto.MemberDto;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = mdao.getMember(userid);
		
		String url = "member/loginForm.jsp";
		
		if( mdto == null ) request.setAttribute("message", "���̵� �����ϴ�");
		else if( mdto.getPwd() == null ) request.setAttribute("message", "DB����. �����ڿ��� �����ϼ���");
		else if( !mdto.getPwd().equals(pwd) ) request.setAttribute("message", "��й�ȣ�� Ʋ���ϴ�");
		else if( mdto.getPwd().equals(pwd) ) {
			url = "board.do?command=main";
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mdto );
		}else request.setAttribute("message", "�� �α����� �ȵǴ��� ���� �� �𸣰ڽ��ϴ�.");
		
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);

	}

}
