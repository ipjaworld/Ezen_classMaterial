package com.ezenac.shop.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenac.shop.controller.action.Action;
import com.ezenac.shop.dao.OrderDao;

public class OrderEndAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//command=orderEnd&odseq=" + odseq + "&oseq="+oseq
		String url = "shop.do?command=adminOrderList";
		HttpSession session = request.getSession();
		String avo = (String)session.getAttribute("loginAdmin");
		if( avo == null ) {
			url = "shop.do?command=admin";
		}else {
			int odseq = Integer.parseInt( request.getParameter("odseq") );
			
			OrderDao odao = OrderDao.getInstance();
			odao.updateOrderEnd( odseq );
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
