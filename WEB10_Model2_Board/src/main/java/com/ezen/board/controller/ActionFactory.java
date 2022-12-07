package com.ezen.board.controller;

import com.ezen.board.controller.action.Action;
import com.ezen.board.controller.action.board.AddReplyAction;
import com.ezen.board.controller.action.board.BoardCheckPassAction;
import com.ezen.board.controller.action.board.BoardPassFormAction;
import com.ezen.board.controller.action.board.BoardViewAction;
import com.ezen.board.controller.action.board.BoardViewWithoutCountAction;
import com.ezen.board.controller.action.board.BoardWriteAction;
import com.ezen.board.controller.action.board.BoardWriteFormAction;
import com.ezen.board.controller.action.board.DelRepAction;
import com.ezen.board.controller.action.board.DeleteBoardAction;
import com.ezen.board.controller.action.board.MainAction;
import com.ezen.board.controller.action.board.UpdateBoardAction;
import com.ezen.board.controller.action.board.UpdateBoardFormAction;
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
		else if( command.equals("boardPassForm") ) ac = new BoardPassFormAction();
		else if( command.equals("boardCheckPass") ) ac = new BoardCheckPassAction();
		else if( command.equals("updateBoardForm") ) ac = new UpdateBoardFormAction();
		else if( command.equals("updateBoard") ) ac = new UpdateBoardAction();
		else if( command.equals("boardViewWithoutCount") ) ac = new BoardViewWithoutCountAction();
		else if( command.equals("deleteBoard") ) ac = new DeleteBoardAction();
		else if( command.equals("addReply") ) ac = new AddReplyAction();
		else if( command.equals("delRep") ) ac = new DelRepAction();
		
		return ac;
	}
}
