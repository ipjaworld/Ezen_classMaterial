package com.ezen.board.controller.action.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.board.controller.action.Action;
import com.ezen.board.dao.BoardDao;

public class DelRepAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ���޵� ��� ��ȣ�� ����� �����ϰ�, ���޵� �Խù���ȣ�� ��ȸ�� ���� ���� �ǵ��ư��ϴ�.
		// deleteReply
		String bnum = request.getParameter("boardnum");
		String rpnum = request.getParameter("replynum");
		
		BoardDao bdao = BoardDao.getInstance();
		bdao.deleteReply( rpnum );
		
		String url = "board.do?command=boardViewWithoutCount&num=" + bnum;
		
		//response.sendRedirect(url);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
	}

}
