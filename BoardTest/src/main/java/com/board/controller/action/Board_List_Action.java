package com.board.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.dao.BoardDao;
import com.board.dto.BoardDto;
import com.board.util.Paging;

public class Board_List_Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "main.jsp";
				
		BoardDao bdao = BoardDao.getInstance();
		HttpSession session = request.getSession();
		int page = 1;	
		if(request.getParameter("page") != null) {	
			page = Integer.parseInt( request.getParameter("page") );
			session.setAttribute("page", Integer.parseInt( request.getParameter("page")));
		}else if( session.getAttribute("page")!=null) {
			page = (Integer)session.getAttribute("page");
		}else { session.removeAttribute("page"); }
		
		Paging paging = new Paging();
		paging.setPage(page);	
		paging.setDisplayPage(8);
		paging.setDisplayRow(5);
		
		int count = bdao.getAllcount();
		paging.setTotalCount(count);		
		
		ArrayList<BoardDto> list = bdao.selectAll(paging);
		request.setAttribute("boardList", list);	
		request.setAttribute("paging", paging);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
