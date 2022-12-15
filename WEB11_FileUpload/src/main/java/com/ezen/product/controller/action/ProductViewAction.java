package com.ezen.product.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.product.dao.ProductDao;
import com.ezen.product.dto.ProductDto;

public class ProductViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 전달된 code 값으로 프로덕트를 조회해서, request 에 담고   productView.jsp 로 이동합니다
		int code = Integer.parseInt( request.getParameter("code") );
		ProductDao pdao = ProductDao.getInstance();
		ProductDto pdto = pdao.getProduct( code );
		
		request.setAttribute("product", pdto);
		RequestDispatcher rd = request.getRequestDispatcher("product/productView.jsp");
		rd.forward(request, response);

	}

}
