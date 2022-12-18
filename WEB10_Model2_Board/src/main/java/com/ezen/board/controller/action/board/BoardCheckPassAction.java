package com.ezen.board.controller.action.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.board.controller.action.Action;
import com.ezen.board.dao.BoardDao;
import com.ezen.board.dto.BoardDto;

public class BoardCheckPassAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num = request.getParameter("num");
		String pass = request.getParameter("pass");
		
		BoardDao bdao = BoardDao.getInstance();
		BoardDto bdto = bdao.getBoard( num );
		
		String url = null;
		if( bdto.getPass() == null ) {	 // �����ͺ��̽� ����
			request.setAttribute("message", "��й�ȣ���� �������� ���� �ϼ���");
			url = "board/boardCheckPass.jsp";
		}else if( bdto.getPass().equals(pass) ) {	 // ���� ���ٸ�, checkSuccess.jsp �� �̵�
			url = "board/checkSuccess.jsp";
		}else {
			request.setAttribute("message", "��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			url = "board/boardCheckPass.jsp";
		}
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

}
