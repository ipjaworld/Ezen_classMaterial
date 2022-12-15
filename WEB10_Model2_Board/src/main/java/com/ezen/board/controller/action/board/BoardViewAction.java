package com.ezen.board.controller.action.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.board.controller.action.Action;
import com.ezen.board.dao.BoardDao;
import com.ezen.board.dto.BoardDto;
import com.ezen.board.dto.ReplyDto;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num = request.getParameter("num");
		
		BoardDao bdao = BoardDao.getInstance();
		// ��ȸ�� ������ �Խù� ��ȸ�� �ϳ��� �޼��忡�� ����. -> �������� ����.
		//BoardDto bdto = bdao.selectBoardOne(num);
		
		// 1. �ش� �Խù��� ��ȸ���� 1 ������ŵ�ϴ�. �޼����̸� readCountPlusOne
		bdao.readCountPlusOne(num);
		// 2. num ���� �ش��ϴ� �Խù��� ��ȸ�ؼ� ���Ϲ޽��ϴ�. �޼��� �̸� getBoard
		BoardDto bdto = bdao.getBoard(num);
		
		ArrayList<ReplyDto> list = bdao.selectReply( num );		
		
		request.setAttribute("board", bdto);
		request.setAttribute("replyList", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("board/boardView.jsp");
		rd.forward(request, response);

	}

}
