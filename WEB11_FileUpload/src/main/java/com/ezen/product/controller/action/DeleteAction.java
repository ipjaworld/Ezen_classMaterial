package com.ezen.product.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.product.dao.ProductDao;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 전달된 code 값을 이용하여 해당 상품을 삭제하고 메인페이지로 돌아가도록 코딩하세요
		int code = Integer.parseInt( request.getParameter("code") );
		
		ProductDao pdao = ProductDao.getInstance();
		pdao.deleteProduct( code );
		
		RequestDispatcher rd = request.getRequestDispatcher("product.do?command=index");
		rd.forward(request, response);
		
	}

}
