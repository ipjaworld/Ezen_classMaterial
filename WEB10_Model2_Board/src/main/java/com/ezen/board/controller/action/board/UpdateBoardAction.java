package com.ezen.board.controller.action.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.board.controller.action.Action;
import com.ezen.board.dao.BoardDao;
import com.ezen.board.dto.BoardDto;

public class UpdateBoardAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// ���޵� ������ BoardDto�� �ְ� updateBoard�� �����ؼ� BoardView.jsp �� �ǵ��� ����,
		// board.do?command=boardViewWithoutCount	�� ���ư��� ���� command �� class �� �߰��ϼ���
		
		String num = request.getParameter("num");
		BoardDao bdao = BoardDao.getInstance();
		BoardDto bdto = new BoardDto();
		
		bdto.setUserid( request.getParameter("userid") );
		bdto.setPass( request.getParameter("pass") );
		bdto.setEmail( request.getParameter("email") );
		bdto.setTitle( request.getParameter("title") );
		bdto.setContent( request.getParameter("content") );
		bdto.setNum( Integer.parseInt(request.getParameter("num") ));
		
		bdao.updateBoard(bdto);
		

		//BoardDto bdto = bdao.selectBoardOne(num);
		// ��ȸ�� ������ �Խù� ��ȸ�� �ϳ��� �޼��忡�� ����. -> �������� ����.

		String url = "board.do?command=boardViewWithoutCount&num=" +bdto.getNum();
	
		RequestDispatcher dp = request.getRequestDispatcher(url);
	    dp.forward(request, response);
	    
	}

}
