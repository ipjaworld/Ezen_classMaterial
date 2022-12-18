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
		
		// ���޵� ��۹�ȣ��  ����� �����ϰ�, ���޵� �Խù���ȣ�� ��ȸ�� ���� ���� �ǵ��ư��ϴ�.
		String replynum = request.getParameter("replynum");
		String boardnum = request.getParameter("boardnum");
		
		BoardDao bdao = BoardDao.getInstance();
		bdao.deleteReply( replynum );
		
		String url = "board.do?command=boardViewWithoutCount&num=" + boardnum;
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
