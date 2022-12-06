package com.ezen.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.member.controller.action.Action;
import com.ezen.member.controller.action.LogOutAction;
import com.ezen.member.controller.action.LoginFormAction;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/member.do")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// ���޵� command ���� ������ �����մϴ�
		String command = request.getParameter("command");
		System.out.println(command); // command ���� ��Ȯ�� ������ Ȯ���ϱ����� ���
		
		/*
		if( command.equals("loginForm") ) {
			String url = "member/loginForm.jsp";
			HttpSession session = request.getSession();
			if( session.getAttribute("loginUser") != null )
				url = "member.do?command=main";
			RequestDispatcher  dp = request.getRequestDispatcher(url);
			dp.forward(request, response);
		}else if( command.equals("logout" ) ){
			HttpSession session = request.getSession();
			session.invalidate();
			RequestDispatcher  dp = request.getRequestDispatcher("member/loginForm.jsp");
			dp.forward(request, response);
		}
		*/
		
		/*
		if( command.equals("loginForm") ) {
			// ���� loginForm.jsp �� �̵��ϱ� ���� �ڵ����  ���� Ŭ������ ��� �޼��带 ����� �� ��ü�� �����ؼ� �޼��带 ȣ���մϴ�
			LoginFormAction lfa = new LoginFormAction();
			lfa.execute(request, response);
		}else if( command.equals("logout" ) ){
			LogOutAction loa = new LogOutAction();
			loa.execute(request, response );
		}
		*/
		
		Action ac = null;
		
		// if( command.equals("loginForm") ) ac = new LoginFormAction();
		// else if( command.equals("logout" ) )	ac = new LogOutAction();
		
		ActionFactory af = ActionFactory.getInstance();
		ac = af.getAction( command );
		// ActionFactory Ŭ������ ����޼����� getAction �� ����  command ������  �ش� Ŭ���� �ν��Ͻ��� ����� Action �������̽���
		// ���۷��� ���� ���Ϲ޽��ϴ�.
		
		if( ac != null )ac.execute(request, response);
		else System.out.println("���� command : " + command + " - command ���� Ȯ���ϼ���");
		
		// command �� ���޵� ���� ���� � �۾��� ������ ������ �Ǿ� ����˴ϴ�
		// �� command �� ������ �۾�����  �ش� �����ڵ尡 ����ִ� Ŭ���� ���ο�, �� �߿����� execute �޼���ȿ� �ֽ��ϴ�.
		// Model2 ����� �� ��ɺ��� Ŭ������ ���۵Ǿ� ����Ǳ⸦ ��ٸ���, command ���� ���� ���õǾ� ����Ǵ� �����Դϴ�
		
		// �� ����� ����� ��ü���� �ν��Ͻ����� Ŭ�������� ���(implements)���� �θ� �������̽�(Action)�� 
		// ���۷��� ������ �����ϰ�, ���۷��� ������.execute �� �����մϴ�
		
		// �� Ŭ������ �ִ� execute  �޼���� Action �������̽��� �����ϴ� �߻�޼��带 �������̵��� �޼����Դϴ�
		// �� Ŭ������ Action �������̽��� ���(implement) �Ͽ�, execute �޼��尡 �������̵��Ǹ�
		//Action  �������̽��� ���۷��� ������ �ڽ� Ŭ������  execute  �޼��带 ȣ���Ͽ� ����մϴ�.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
