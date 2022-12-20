package com.ezenac.shop.controller.action.qna;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenac.shop.controller.action.Action;
import com.ezenac.shop.dao.QnaDao;
import com.ezenac.shop.dto.MemberVO;
import com.ezenac.shop.dto.QnaVO;
import com.ezenac.shop.util.Paging;

public class QnaListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "qna/qnaList.jsp";
		
		// 로그인 체크
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		if(mvo == null) {
			url = "shop.do?command=loginForm";
		}else {
			// 로그인한 아이디로 qna 목록을 조회하고 리턴받습니다 (메서드 이름 selectQna)
			QnaDao qdao = QnaDao.getInstance();
			//ArrayList<QnaVO> list = qdao.selectQna( mvo.getId() );
			int page = 1;
			if(request.getParameter("page") != null) {
				page = Integer.parseInt( request.getParameter("page") );
				session.setAttribute("page", page);
			}else if( session.getAttribute("page")!=null) {
				page = (Integer)session.getAttribute("page");
			}else {
				session.removeAttribute("page"); // 세션에서 페이지 삭제
			}
			Paging paging = new Paging();
			paging.setPage(page);
			int count = qdao.getAllcount( mvo.getId() );	// 로그인 아이디로 검색한 QnA 게시물의 갯수를 구합니다
			paging.setTotalCount(count);
			ArrayList<QnaVO> list = qdao.selectQna( mvo.getId(), paging);// 현재 페이지에 표시할 게시물(5개)을 조회해서 list로 리턴받습니다
			
	
			request.setAttribute("qnaList", list);
			request.setAttribute("paging", paging);// paging 객체도 request에 담습니다
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
