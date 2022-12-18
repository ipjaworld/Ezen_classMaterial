package com.ezen.product.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.product.dao.ProductDao;
import com.ezen.product.dto.ProductDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		String path = context.getRealPath("upload");  // 업로드 폴더 설정
		String code = "";
		
		ProductDto pdto = new ProductDto();
		
		try {
			MultipartRequest multi = new MultipartRequest(
				request, path, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy()
			);
			
			code = multi.getParameter("code");
			pdto.setCode( Integer.parseInt(code) );
			pdto.setName( multi.getParameter("name") );
			pdto.setPrice( Integer.parseInt( multi.getParameter("price") ) );
			pdto.setDescription( multi.getParameter("description") );
			
			if(  multi.getFilesystemName("pictureurl") == null )
				pdto.setPictureurl( multi.getParameter("oldPicture") );
			else
				pdto.setPictureurl( multi.getFilesystemName("pictureurl") );
			
			ProductDao pdao = ProductDao.getInstance();
			pdao.updateProduct(pdto);
		}catch(  Exception e ) {
			// 객체생성 실패에 대한 예외처리 or 파일업로드 실패 에 대한 예외처리
			System.out.println("파일업로드 실패 : " + e); 
		}
		
		String url = "product.do?command=productView&code=" + code;
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
		

	}

}
