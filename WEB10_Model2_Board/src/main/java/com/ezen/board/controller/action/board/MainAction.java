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
		
		// ����Ʈ�� �Խù� �ϳ��� ������, �Խù� ��ȣ�� ��� ������ ��ȸ�� ��,
		// �� ������ dto�� =replycnt ������ �����մϴ�
		for( BoardDto bdto : list) {
			//int cnt = bdao.getReplyCnt( bdto.getNum() );
			bdto.setReplycnt(0);
		}
		
		
		request.setAttribute("bList", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("board/main.jsp");
		rd.forward(request, response);
		
	}

}
