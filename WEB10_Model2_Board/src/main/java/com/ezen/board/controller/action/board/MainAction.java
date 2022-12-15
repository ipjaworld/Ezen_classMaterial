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
		
		
		// ���� �Խ����� ó�� ���������� �ε��Ѵٸ� , ���������� ǥ�õ� ������������ 1������ �Դϴ�
		int page = 1;
		
		HttpSession session = request.getSession();
		// ���� �Խ����� ó�� ���������� �ε� �ϴ°� �ƴ϶�, 2, 3, 4 ... �� ���� �ٸ� �������� Ŭ���ؼ� ����Ŭ������
		// execute �� ����ȴٸ�, �Ķ���ͷ� ���޵� ���� ���� ǥ���� �������� �˴ϴ�.
		if( request.getParameter("page") != null ) {
			page = Integer.parseInt( request.getParameter("page") );
			session.setAttribute("page", page);
		} else if( session.getAttribute("page")!=null ) {
			page = (Integer)session.getAttribute("page");
		}else {
			session.removeAttribute("page");
		}
		
		
		// �׷��� ������ ���������� ��ȣ��  Paging ��ü�� ����� ��������� �����մϴ�
		Paging paging = new Paging();
		paging.setPage(page);
		
		// �����ͺ��̽��� �����ؼ� ���ڵ�(�Խù�) �Ѱ����� ���Ϲ޽��ϴ�
		int count = bdao.getAllCount();
		
		// ���Ϲ��� ���ڵ� ������ Paging ��ü�� ������� totalCount�� �����մϴ�
		paging.setTotalCount(count);
		// �̶� ����޼����� paging() �޼��尡 ���� ȣ��˴ϴ�.  -> �� ����������� ���
		
		//ArrayList<BoardDto> list = bdao.selectAll();
		//ArrayList<BoardDto> list = bdao.selectAll( paging.getStartNum(), paging.getEndNum() );
		ArrayList<BoardDto> list = bdao.selectAll( paging );
		
		
		// ����Ʈ�� �Խù� �ϳ��� ������, �Խù� ��ȣ�� ��� ������ ��ȸ����,
		// �� ������ dto �� replycnt ������ �����մϴ�
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







