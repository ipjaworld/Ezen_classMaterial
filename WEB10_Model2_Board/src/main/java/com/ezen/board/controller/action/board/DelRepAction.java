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
		
		// 전달된 댓글 번호로 댓글을 삭제하고, 전달된 게시물번호로 조회수 증가 없이 되돌아갑니다.
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
