package com.ezen.upload;

import java.io.IOException;

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
 * Servlet implementation class UploadSevlet
 */
@WebServlet("/upload.do")
public class UploadSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// 1. ������ ���ε�� Ÿ�������� ����, String���� �����صӴϴ�
		String savePath = "upload";
				
		// 2. ���ε�� ������ �뷮�� �����ϱ� ���� �뷮����  int ������ �����صӴϴ�
		int uploadFileSizeLimit = 5 * 1024 * 1024; 
		// 1����Ʈ ����  1024byte = 1Kbyte
		// 1024KByte = 1MB
		// 1024MByte = 1GB
		// 1024GByte = 1TB
		// 1024TByte = 1PB
		
		// 3. ���ڵ� ����� String ������ �����صӴϴ�
		String encType = "UTF-8";
		
		//4. ���ε�� ������ ���� ������Ҹ� �����ϰ� �� �ȿ� "upload" ������ �����
		//    ���� ��θ� String ����(uploadFilePath)�� ������ �Ӵϴ�
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath( savePath );   //savePath : "upload"
		
		System.out.println(uploadFilePath);
		
		MultipartRequest multi = new MultipartRequest(
				request,    // jsp ���� ������  HttpServletRequest ��ü(�Ű�����)�� MultipartRequest �� �����մϴ�.
				// enctype="multipart/form-data" ���� ���޵� ���� ��� �Ķ���͵��� �Ϲ� request.getParameter() �� ���� ������ �����ϴ�
				// MultipartRequest  �� request �� �־ ���ջ���ؾ� ����ִ� ��ȿ�� ���� ������ �ֽ��ϴ�
				// ��������� multipart/form-data �� ���� �����͵��� MultipartRequest�θ� ������ �ֽ��ϴ�.
				// multipart/form-data �� ���� �����͵��� �Ϲ� request.getParameter �� ������ ���� ���� ��� null �� �˴ϴ�.
				
				uploadFilePath,    // �������� ���� �������
				uploadFileSizeLimit,    // �ִ���ε� �뷮 ����
				encType,   // �ѱ� ���ڵ� ���
				new DefaultFileRenamePolicy()   // ������ҿ� ���ε�Ǵ� �����̸� �ߺ��� �����ذ��ϴ� ��ü
		);
		//MultipartRequest ��ü�� �����Ǵ� ���� ���ε� �Ǵ� ������ �ش� ��ο� ���ε带 �Ϸ��մϴ�
		
		System.out.println("request �� ó�� - title : " + request.getParameter("title") );
		// �Ϲ� request��  multipart/form-data �� ���޵� �Ķ���Ͱ� ��� null �� ���ŵ˴ϴ�.
		System.out.println("MultipartRequest �� ó�� - title:  " + multi.getParameter("title") );
		
		String name = multi.getParameter("name");
		String title = multi.getParameter("title");
		String fileName = multi.getFilesystemName("uploadFile"); //  ���޵� �����̸�����
		
		request.setAttribute("name", name);
		request.setAttribute("title", title);
		request.setAttribute("fileName", fileName);
		
		RequestDispatcher dp = request.getRequestDispatcher("01_result.jsp");
		dp.forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
