package com.ezen.product.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.product.dao.ProductDao;
import com.ezen.product.dto.ProductDto;

public class UpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//  ���޵� �ڵ尪���� ��ǰ�� ��ȸ�ؼ� dto ��ü�� ���, �װ���  request �� �������ؼ�
		// updateForm.jsp �� �̵��մϴ�
		
		int code = Integer.parseInt( request.getParameter("code") );
		
		ProductDao pdao = ProductDao.getInstance();
		ProductDto pdto = pdao.getProduct(code);
		
		request.setAttribute( "product", pdto);
		
		RequestDispatcher rd = request.getRequestDispatcher("product/updateForm.jsp");
		rd.forward(request, response);

	}

}
