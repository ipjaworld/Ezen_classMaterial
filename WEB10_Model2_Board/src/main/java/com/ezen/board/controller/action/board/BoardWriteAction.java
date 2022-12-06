package com.ezen.board.controller.action.board;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.board.controller.action.Action;
import com.ezen.board.dao.BoardDao;
import com.ezen.board.dto.BoardDto;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// �����μ��� ���޵Ǵ� ������ BoardDto ��ü�� ���,
		// insertBoard �޼��带 �̿��ؼ� ���ڵ带 �߰��ϰ�
		// main.jsp �� �ǵ��ư��ϴ�.
		
		//String num = request.getParameter("num");
		
		BoardDto bdto = new BoardDto();
		
		bdto.setEmail(request.getParameter("email"));
		bdto.setNum(Integer.parseInt(request.getParameter("admin")));
		bdto.setContent(request.getParameter("name"));
		bdto.setPass(request.getParameter("phone"));
		bdto.setReadcount(Integer.parseInt(request.getParameter("pwd")));
		bdto.setReplycnt(Integer.parseInt(request.getParameter("userid")));
		bdto.setTitle(request.getParameter("userid"));
		bdto.setUserid(request.getParameter("userid"));
		bdto.setWritedate((Timestamp)request.getParameter("writedate"));

		BoardDao bdao = BoardDao.getInstance();
		
		//String url = "main.do";
		String url = "board/main.jsp";
		
		int result = bdao.insertBoard(bdto);

	    RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
