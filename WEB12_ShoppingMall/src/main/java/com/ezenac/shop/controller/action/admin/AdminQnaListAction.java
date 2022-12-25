package com.ezenac.shop.controller.action.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenac.shop.controller.action.Action;
import com.ezenac.shop.dao.AdminDao;
import com.ezenac.shop.dto.QnaVO;
import com.ezenac.shop.util.Paging;

public class AdminQnaListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/qna/qnaList.jsp";
		
		HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("loginAdmin");
		if( adminId == null)
			url = "shop.do?command=admin";
		else {
			AdminDao adao = AdminDao.getInstance();
			if(request.getParameter("start")!=null) {
				session.removeAttribute("page");
				session.removeAttribute("key");
			}

			int page = 1;	
			if(request.getParameter("page") != null) {	
				page = Integer.parseInt( request.getParameter("page") );
				session.setAttribute("page", Integer.parseInt( request.getParameter("page")));
			}else if( session.getAttribute("page")!=null) {
				page = (Integer)session.getAttribute("page");
			}else { session.removeAttribute("page"); }
			
			String key = "";
			if( request.getParameter("key")!=null) {
				key = request.getParameter("key");
				session.setAttribute("key", key);
			}else if( session.getAttribute("key")!=null) {
				key = (String)session.getAttribute("key");
			}else {
				session.removeAttribute("key");
			}
			
			String logInId = (String)session.getAttribute("id");
			
			Paging paging = new Paging();
			paging.setPage(page);	
			
			int count = adao.getIDAllcount(key);
			paging.setTotalCount(count);		
			
			ArrayList<QnaVO> qnaList = adao.selectQna(paging, key);
			request.setAttribute("paging", paging);
			request.setAttribute("qnaList", qnaList);
			request.setAttribute("key", key);
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}