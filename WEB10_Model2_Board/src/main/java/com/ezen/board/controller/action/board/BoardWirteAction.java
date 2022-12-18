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

public class BoardWirteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// �����μ��� ���޵Ǵ� ������  BoardDto ��ü�� ���,
		BoardDto bdto = new BoardDto();
		BoardDao bdao = BoardDao.getInstance();
		
		/*bdto.setUserid( request.getParameter("userid") ) ;
		bdto.setPass( request.getParameter("pass") );
		bdto.setTitle( request.getParameter("title") );
		bdto.setEmail( request.getParameter("email") );
		bdto.setContent( request.getParameter("content") );
		*/
		
		// MultipartRequest �� �����ϰ� ��ü�� �̿��ؼ� boardDto �� ä���  insert �ǵ��� �����մϴ�
		// insertBoard ���� imgfileName  ���嵵 �߰��մϴ�
		
		
		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		String path=context.getRealPath("upload");

		MultipartRequest multi = new MultipartRequest(
			request, path, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy()
		);
		bdto.setUserid( multi.getParameter("userid") );
		bdto.setPass( multi.getParameter("pass") );
		bdto.setTitle( multi.getParameter("title") );
		bdto.setEmail( multi.getParameter("email") );
		bdto.setContent( multi.getParameter("content") );
		bdto.setImgfilename(  multi.getFilesystemName("uploadFile")  );
				
		
		// insertBoard �޼��带 �̿��ؼ� ���ڵ带 �߰��ϰ�
		bdao.insertBoard( bdto );
		
		// main.jsp �� �ǵ��� ���ϴ�.
		response.sendRedirect("board.do?command=main");
		
	}

}
