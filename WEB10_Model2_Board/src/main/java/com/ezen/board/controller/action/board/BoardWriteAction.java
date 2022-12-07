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
		BoardDao bdao = BoardDao.getInstance();
		
		bdto.setEmail(request.getParameter("email"));
		bdto.setContent(request.getParameter("content"));
		bdto.setPass(request.getParameter("pass"));
		bdto.setTitle(request.getParameter("title"));
		bdto.setUserid(request.getParameter("userid"));

		
		bdao.insertBoard( bdto );

		//String url = "main.do";
		String url = "board.do?command=main";
		
		//int result = bdao.insertBoard(bdto);

	    //RequestDispatcher rd = request.getRequestDispatcher(url); �� ����Ʈ ���, �����带 �Ⱦ���.(��ΰ� ������ �� �� �־)
		//rd.forward(request, response);
		
		response.sendRedirect(url);

	}

}
