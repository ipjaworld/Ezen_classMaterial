package com.ezen.board.controller;

import com.ezen.board.controller.action.Action;
import com.ezen.board.controller.action.board.BoardViewAction;
import com.ezen.board.controller.action.board.BoardWriteAction;
import com.ezen.board.controller.action.board.BoardWriteFormAction;
import com.ezen.board.controller.action.board.MainAction;
import com.ezen.board.controller.action.member.LoginAction;
import com.ezen.board.controller.action.member.LoginFormAction;

public class ActionFactory {
	private ActionFactory(){}
	private static ActionFactory itc = new ActionFactory();
	public static ActionFactory getInstance() { return itc; }
	
	public Action getAction(String command) {
		Action ac = null;
		
		if( command.equals("loginForm") ) ac = new LoginFormAction();
		else if( command.equals("login")) ac = new LoginAction();
		else if( command.equals("main")) ac = new MainAction();
		else if( command.equals("boardView")) ac = new BoardViewAction();
		else if( command.equals("boardWriteForm") ) ac = new BoardWriteFormAction();
		else if( command.equals("boardWrite") ) ac = new BoardWriteAction();
		
		return ac;
	}
}
