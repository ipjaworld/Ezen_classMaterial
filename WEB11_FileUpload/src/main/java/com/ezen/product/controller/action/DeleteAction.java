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
		
		// ���޵� code ���� �̿��Ͽ� �ش� ��ǰ�� �����ϰ� ������������ ���ư����� �ڵ��ϼ���
		int code = Integer.parseInt( request.getParameter("code") );
		
		ProductDao pdao = ProductDao.getInstance();
		pdao.deleteProduct( code );
		
		RequestDispatcher rd = request.getRequestDispatcher("product.do?command=index");
		rd.forward(request, response);
		
	}

}
