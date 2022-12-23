package com.ezenac.shop.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenac.shop.controller.action.Action;
import com.ezenac.shop.dao.AdminDao;

public class AdminQnaRepSaveAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "shop.do?command=adminQnaDetail";
		
		HttpSession session = request.getSession();
		String avo = (String)session.getAttribute("loginAdmin");
		if( avo == null) url = "shop.do?command=admin";
		else {
			// 현재 reply는 null 인 상태인데, 전의 페이지의 내용을 가져와서 넣어주면 되겠다.
			AdminDao adao = AdminDao.getInstance();
		
			int qseq = Integer.parseInt( request.getParameter("qseq"));
			String qnaReply = request.getParameter("reply");
			
			adao.updateQna(qnaReply, qseq );
			url = url + "&qseq=" + qseq;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
