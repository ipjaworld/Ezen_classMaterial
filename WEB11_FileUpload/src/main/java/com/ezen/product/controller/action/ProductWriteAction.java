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
		
		// 현재 작성 영역은 서블릿이 아니고 자바 클래스이며, 서블릿에서 전달된 request 를 전달받아 진행되는 곳 이므로
		HttpSession session = request.getSession();
		
		// request  에서 세션을 추출한 후 session.getServletContext() 를 사용 합니다.
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














