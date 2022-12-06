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
		// �����μ����� ��� dto ��ü�� ����ϴ�
		MemberDto mdto = new MemberDto();
		mdto.setName( request.getParameter("name") );
		mdto.setUserid( request.getParameter("userid") );
		mdto.setPwd( request.getParameter("pwd") );
		mdto.setEmail( request.getParameter("email") );
		mdto.setPhone( request.getParameter("phone") );
		mdto.setAdmin(Integer.parseInt(request.getParameter("admin")) );

		// dao�� insertMember �� �����, dto ��ü�� ������ ���ڵ带 �߰����ϴ�
		MemberDao mdao = MemberDao.getInstance();
		int result = mdao.insertMember(mdto);
		
		HttpSession session = request.getSession();
		// ȸ������ ��� �޼����� ���� loginForm.jsp �� �ǵ��� ���ϴ�.
		if(result == 1) session.setAttribute("message", "ȸ������ �Ϸ�. �α����ϼ���");
		else  session.setAttribute("message", "ȸ������ ����. �����ڿ��� �����ϼ���");

//		RequestDispatcher dp = request.getRequestDispatcher("member/loginForm.jsp");
//		dp.forward(request, response);
		
		response.sendRedirect("member/loginForm.jsp");
	}

}
