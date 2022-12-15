package com.ezen.board.controller.action.board;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.board.controller.action.Action;
import com.ezen.board.dao.BoardDao;
import com.ezen.board.dto.BoardDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 전달인수로 전달되는 내용을 BoardDto 객체에 담고,
		// insertBoard 메서드를 이용해서 레코드를 추가하고
		// main.jsp 로 되돌아갑니다.
		
		//String num = request.getParameter("num");
		
		BoardDto bdto = new BoardDto();
		BoardDao bdao = BoardDao.getInstance();
		
		/*
		bdto.setEmail(request.getParameter("email"));
		bdto.setContent(request.getParameter("content"));
		bdto.setPass(request.getParameter("pass"));
		bdto.setTitle(request.getParameter("title"));
		bdto.setUserid(request.getParameter("userid"));
		*/
		
		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		String path = context.getRealPath("upload");
		
		MultipartRequest multi = new MultipartRequest(
				request, path, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy()
		);
		bdto.setUserid( multi.getParameter("userid") );
		bdto.setPass( multi.getParameter("pass") );
		bdto.setTitle( multi.getParameter("title") );
		bdto.setEmail( multi.getParameter("email") );
		bdto.setContent( multi.getParameter("content") );
		bdto.setImgfilename( multi.getParameter("uploadFile") );
		

		bdao.insertBoard( bdto );

		String url = "board.do?command=main";

		response.sendRedirect(url);

	}

}
