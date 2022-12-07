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
		
		// 전달인수로 전달되는 내용을 BoardDto 객체에 담고,
		// insertBoard 메서드를 이용해서 레코드를 추가하고
		// main.jsp 로 되돌아갑니다.
		
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

	    //RequestDispatcher rd = request.getRequestDispatcher(url); 이 포스트 방식, 포워드를 안쓴다.(경로가 노출이 될 수 있어서)
		//rd.forward(request, response);
		
		response.sendRedirect(url);

	}

}
