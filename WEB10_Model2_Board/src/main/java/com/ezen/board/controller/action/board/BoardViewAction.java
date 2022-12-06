package com.ezen.board.controller.action.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.board.controller.action.Action;
import com.ezen.board.dao.BoardDao;
import com.ezen.board.dto.BoardDto;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num = request.getParameter("num");
		
		BoardDao bdao = BoardDao.getInstance();
		//BoardDto bdto = bdao.selectBoardOne(num);
		// ��ȸ�� ������ �Խù� ��ȸ�� �ϳ��� �޼��忡�� ����. -> �������� ����.
		
		// 1. �ش� �Խù��� ��ȸ���� 1 ������ŵ�ϴ�. �޼��� �̸� readCountPlusOne
		bdao.readCountPlusOne(num);
		// 2. num ���� �ش��ϴ� �Խù��� ��ȸ�ؼ� ���Ϲ޽��ϴ�. �޼��� �̸� getBoard
		BoardDto bdto = bdao.getBoard(num);
		
		
		
		request.setAttribute("board", bdto); 
		RequestDispatcher dp = request.getRequestDispatcher("board/boardView.jsp");
	    dp.forward(request, response);

	}

}
