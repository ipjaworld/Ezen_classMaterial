package com.minjae.bd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minjae.bd.controller.action.Action;

/**
 * Servlet implementation class umaQnaBoard
 */
@WebServlet("/uma.do")
public class UmaQnaBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UmaQnaBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// �ѱ� ���ڵ��� �����ϰ� �մϴ�.
		request.setCharacterEncoding("UTF-8");
		
		String command = request.getParameter("command");
		
		ActionConverter av = ActionConverter.getInstance();
		
		Action ac = av.getAction(command);
		
		if(ac!=null) ac.execute( request, response );
		else System.out.println("command�� null�Դϴ�. command�� Ȯ���ϼ���");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
