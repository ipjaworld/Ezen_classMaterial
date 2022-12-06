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
		
		// 전달된 command 값을 변수에 저장합니다
		String command = request.getParameter("command");
		System.out.println(command); // command 값의 정확한 전달을 확인하기위한 출력
		
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
			// 위의 loginForm.jsp 로 이동하기 위한 코드들을  갖는 클래스와 멤버 메서드를 만들고 그 객체를 생성해서 메서드를 호출합니다
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
		// ActionFactory 클래스의 멤버메서드인 getAction 을 통해  command 값별로  해당 클래스 인스턴스가 저장된 Action 인터페이스의
		// 레퍼런스 값을 리턴받습니다.
		
		if( ac != null )ac.execute(request, response);
		else System.out.println("현재 command : " + command + " - command 값을 확인하세요");
		
		// command 에 전달된 값이 따라 어떤 작업을 할지가 결정이 되어 실행됩니다
		// 각 command 별 실행할 작업들은  해당 실행코드가 들어있는 클래스 내부에, 그 중에서도 execute 메서드안에 있습니다.
		// Model2 방식은 각 기능별로 클래스가 제작되어 실행되기를 기다리고, command 값에 따라 선택되어 실행되는 형식입니다
		
		// 각 기능이 내장된 객체들의 인스턴스들은 클래스들이 상속(implements)받은 부모 인터페이스(Action)의 
		// 레퍼런스 변수에 저장하고, 레퍼런스 변수명.execute 로 실행합니다
		
		// 각 클래스에 있는 execute  메서드는 Action 인터페이스에 존재하는 추상메서드를 오버라이딩한 메서드입니다
		// 각 클래스가 Action 인터페이스를 상속(implement) 하여, execute 메서드가 오버라이딩되면
		//Action  인터페이스의 레퍼런스 변수로 자식 클래스의  execute  메서드를 호출하여 사용합니다.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
