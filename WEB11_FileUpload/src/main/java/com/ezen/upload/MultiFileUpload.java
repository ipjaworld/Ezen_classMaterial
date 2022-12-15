package com.ezen.upload;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class MultiFileUpload
 */
@WebServlet("/upload2.do")
public class MultiFileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultiFileUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath("upload");
		
		MultipartRequest multi = new MultipartRequest( 	
			request, 
			uploadFilePath ,	
			5*1024*1024 , 
			"UTF-8", 
			new DefaultFileRenamePolicy()	
		);
		// ���ȿ� �ִ�  <input type="file"> �� ���ϵ��� MultipartRequest ������ �ѹ��� ���ε� �˴ϴ�
		
		// �ѹ��� ���޵� "�����̸���"�� Enumeration �� ����Ͽ� ���޹ް�,  �ϳ��� ������ ����մϴ�
		Enumeration files = multi.getFileNames(); 
		// ���� �̸���("uploadFile01" , "uploadFile02", "uploadFile03")���� Enumeration �� ����
		
		int i = 1;
		while(  files.hasMoreElements() ) {  // ���� ����� ���� ��ŭ �ݺ�����
			String file = (String) files.nextElement();     // �ϳ��� ���Ͽ�� ����
			
			// ���ε�� �����̸� ����(���ε���)
			String file_name = multi.getFilesystemName(file);    
			// (���ε� ��) DefaultFileRenamePolicy �� ���� ���е� ���� ���� �̸� ����
			String ori_file_name = multi.getOriginalFileName(file);  
			
			// �����ϴ� ���ڸ� �̿��Ͽ� ��Ʈ����Ʈ �̸� ����
			request.setAttribute("file_system_name" + i , file_name); 
			request.setAttribute("ori_file_name" + i , ori_file_name);
			i++;
		}
		RequestDispatcher dp = request.getRequestDispatcher("02_result.jsp");
		dp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
