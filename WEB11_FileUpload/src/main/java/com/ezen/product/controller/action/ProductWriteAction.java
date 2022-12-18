package com.ezen.product.controller.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.product.dao.ProductDao;
import com.ezen.product.dto.ProductDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProductWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ���� �ۼ� ������ ������ �ƴϰ� �ڹ� Ŭ�����̸�, �������� ���޵� request �� ���޹޾� ����Ǵ� �� �̹Ƿ�
		HttpSession session = request.getSession();
		
		// request  ���� ������ ������ �� session.getServletContext() �� ��� �մϴ�.
		ServletContext context = session.getServletContext();
		String path = context.getRealPath("upload");

		MultipartRequest multi = new MultipartRequest(
				request,  path,  5*1024*1024,  "UTF-8",  new DefaultFileRenamePolicy()
		);
		
		ProductDto pdto = new ProductDto();
		
		pdto.setName( multi.getParameter("name")  );
		pdto.setPrice( Integer.parseInt( multi.getParameter("price") ) );
		pdto.setDescription( multi.getParameter("description") ) ;
		pdto.setPictureurl( multi.getFilesystemName("pictureurl") );
		
		ProductDao pdao = ProductDao.getInstance();
		pdao.insertProduct( pdto );
		response.sendRedirect("product.do?command=index");
		
	}

}














