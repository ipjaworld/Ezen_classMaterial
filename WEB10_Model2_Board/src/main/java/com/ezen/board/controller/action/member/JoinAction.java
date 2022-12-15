package com.ezen.board.controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.board.controller.action.Action;
import com.ezen.board.dao.MemberDao;
import com.ezen.board.dto.MemberDto;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �����μ����� ���  Dto �� �ְ� insertMember �� �����ݴϴ�
		MemberDto mdto = new MemberDto();
		mdto.setUserid(request.getParameter("userid"));
		mdto.setName(request.getParameter("name"));
		mdto.setPwd(request.getParameter("pwd"));
		mdto.setEmail(request.getParameter("email"));
		mdto.setPhone(request.getParameter("phone"));
		mdto.setAdmin( Integer.parseInt( request.getParameter("admin") ) );
						
		MemberDao mdao = MemberDao.getInstance();
		int result = mdao.insertMember( mdto );
		
		HttpSession session = request.getSession();
		if( result==1) session.setAttribute("message", "ȸ�������� �Ϸ�Ǿ����ϴ�. �α����ϼ���");
		else session.setAttribute("message", "ȸ�������� �����߽��ϴ�. �����ڿ��� �����ϼ���");

		response.sendRedirect( 	"board.do?command=loginForm" );
	}

}
