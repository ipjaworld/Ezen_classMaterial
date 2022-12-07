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

		// 전달된 값들을 BoardDto에 넣고 updateBoard를 실행해서 BoardView.jsp 로 되돌아 가되,
		// board.do?command=boardViewWithoutCount	로 돌아가기 위해 command 와 class 를 추가하세요
		
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
		// 조회수 증가와 게시물 조회를 하나의 메서드에서 실행. -> 권장하지 않음.

		String url = "board.do?command=boardViewWithoutCount&num=" +bdto.getNum();
	
		RequestDispatcher dp = request.getRequestDispatcher(url);
	    dp.forward(request, response);
	    
	}

}
