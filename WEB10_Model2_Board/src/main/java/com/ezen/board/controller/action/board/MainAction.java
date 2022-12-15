package com.ezen.board.controller.action.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.board.controller.action.Action;
import com.ezen.board.dao.BoardDao;
import com.ezen.board.dto.BoardDto;
import com.ezen.board.util.Paging;

public class MainAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDao bdao = BoardDao.getInstance();
		
		
		// 현재 게시판을 처음 웹페이지에 로딩한다면 , 웹페이지에 표시될 현재페이지는 1페이지 입니다
		int page = 1;
		
		HttpSession session = request.getSession();
		// 현재 게시판을 처음 웹페이지에 로딩 하는게 아니라, 2, 3, 4 ... 와 같은 다른 페이지를 클릭해서 현재클래스의
		// execute 가 실행된다면, 파라미터로 전달된 값이 현재 표시할 페이지가 됩니다.
		if( request.getParameter("page") != null ) {
			page = Integer.parseInt( request.getParameter("page") );
			session.setAttribute("page", page);
		} else if( session.getAttribute("page")!=null ) {
			page = (Integer)session.getAttribute("page");
		}else {
			session.removeAttribute("page");
		}
		
		
		// 그렇게 결정된 현재페이지 번호를  Paging 객체를 만들고 멤버변수에 저장합니다
		Paging paging = new Paging();
		paging.setPage(page);
		
		// 데이터베이스에 접근해서 레코드(게시물) 총갯수를 리턴받습니다
		int count = bdao.getAllCount();
		
		// 리턴받은 레코드 갯수를 Paging 객체의 멤버변수 totalCount에 저장합니다
		paging.setTotalCount(count);
		// 이때 멤버메서드인 paging() 메서드가 같이 호출됩니다.  -> 각 멤버변수값이 계산
		
		//ArrayList<BoardDto> list = bdao.selectAll();
		//ArrayList<BoardDto> list = bdao.selectAll( paging.getStartNum(), paging.getEndNum() );
		ArrayList<BoardDto> list = bdao.selectAll( paging );
		
		
		// 리스트의 게시물 하나씩 꺼내서, 게시물 번호로 댓글 갯수를 조회한후,
		// 그 갯수를 dto 의 replycnt 변수에 저장합니다
		for( BoardDto bdto : list) {
			int cnt = bdao.getReplyCnt( bdto.getNum() );
			bdto.setReplycnt(cnt);
		}
		
		
		request.setAttribute("bList", list);
		request.setAttribute("paging", paging);
		
		RequestDispatcher rd = request.getRequestDispatcher("board/main.jsp");
		rd.forward(request, response);

	}

}







