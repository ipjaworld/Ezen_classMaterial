package com.ezenac.shop.controller.action.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenac.shop.controller.action.Action;
import com.ezenac.shop.dao.QnaDao;
import com.ezenac.shop.dto.MemberVO;
import com.ezenac.shop.dto.QnaVO;

public class QnaWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "shop.do?command=qnaList";
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		
		if(mvo == null) {
			url = "shop.do?command=loginForm";
		}else {
			QnaVO qvo = new QnaVO();
			QnaDao qdao = QnaDao.getInstance();
			
			qvo.setId( mvo.getId() );
			qvo.setSubject( request.getParameter("subject") );
			qvo.setContent( request.getParameter("content") );
			//qvo.setIndate( request.getParameter("subject") );
			//qvo.setQseq( Integer.parseInt(request.getParameter("qseq") ));

			
			qdao.insertQna( qvo );
			
		}

		//request.getRequestDispatcher(url).forward(request, response);
		response.sendRedirect(url);
	}

}
