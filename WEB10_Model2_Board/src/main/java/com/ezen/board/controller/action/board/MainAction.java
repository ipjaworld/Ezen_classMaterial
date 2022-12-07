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

public class MainAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDao bdao = BoardDao.getInstance();
		ArrayList<BoardDto> list = bdao.selectAll();
		
		// 리스트의 게시물 하나씩 꺼내서, 게시물 번호로 댓글 갯수를 조회한 후,
		// 그 갯수를 dto의 =replycnt 변수에 저장합니다
		for( BoardDto bdto : list) {
			//int cnt = bdao.getReplyCnt( bdto.getNum() );
			bdto.setReplycnt(0);
		}
		
		
		request.setAttribute("bList", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("board/main.jsp");
		rd.forward(request, response);
		
	}

}
