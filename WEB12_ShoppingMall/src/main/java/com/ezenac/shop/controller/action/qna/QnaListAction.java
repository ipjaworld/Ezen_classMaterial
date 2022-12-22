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
			int page = 1;	// 페이지 설정 : request 나 session에 page 값이 있다면 그 값으로, 없다면 1로 현재 페이지를 설정
			if(request.getParameter("page") != null) {	// 리퀘스트에 파라미터로 page 가 전달된다면 page 변수값을 그 값으로 대체
				page = Integer.parseInt( request.getParameter("page") );
				session.setAttribute("page", page);
				// 2 이상의 페이지에서 게시물을 보다가 다시 게시판으로 돌아갈 때, 보던 페이지 번호를 잃어버리는 경우가 많아서
				// 현재 보고 있는 페이지 번호를 세션에 저장했다가 request에 파라미터가 없다면 한번 더 세션을 검사하여 페이지 번호를 대체할지를 결정합니다
			}else if( session.getAttribute("page")!=null) {
				// request에 파라미터가 없다면 한번 더 세션을 검사하여 페이지 번호를 대체할지를 결정합니다
				page = (Integer)session.getAttribute("page");
			}else {
				session.removeAttribute("page"); // 세션에서 페이지 삭제
			}
			Paging paging = new Paging();
			paging.setPage(page);	// 위에서 결정된 페이지번호 객체에 저장
			
			int count = qdao.getAllcount( mvo.getId() );	// 로그인 아이디로 검색한 QnA 게시물의 갯수를 구합니다
			paging.setTotalCount(count);		// 게시물 총갯수를 totalCount 변수에 저장합니다. 이때 paging() 메서드도 호출
			// 모든 객체의 멤버변수 준비 완료
			
			// 현재 페이지에 표시할 게시물(5개, 로그인한 유저가 작성한 startNum부터 endNum까지)을 조회해서 list로 리턴받습니다
			ArrayList<QnaVO> list = qdao.selectQna( mvo.getId(), paging);
			
			request.setAttribute("qnaList", list);
			request.setAttribute("paging", paging);// paging 객체도 request에 담습니다
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
