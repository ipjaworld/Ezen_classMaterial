package com.ezenac.shop.controller;

import com.ezenac.shop.controller.action.Action;
import com.ezenac.shop.controller.action.IndexAction;
import com.ezenac.shop.controller.action.member.ContractAction;
import com.ezenac.shop.controller.action.member.IdCheckFormAction;
import com.ezenac.shop.controller.action.member.JoinFormAction;
import com.ezenac.shop.controller.action.member.LoginAction;
import com.ezenac.shop.controller.action.member.LoginFormAction;
import com.ezenac.shop.controller.action.member.LogoutAction;

public class ActionFactory {

	private ActionFactory() {}
	private static ActionFactory itc = new ActionFactory();
	public static ActionFactory getInstance() { return itc; }
	
	public Action getAction(String command) {
		Action ac = null;
		
		if( command.equals("index") ) ac = new IndexAction();
		else if( command.equals("loginForm") ) ac = new LoginFormAction();
		else if( command.equals("login") ) ac = new LoginAction();
		else if( command.equals("logout") ) ac = new LogoutAction();
		else if( command.equals("contract") ) ac = new ContractAction();
		else if( command.equals("joinForm") ) ac = new JoinFormAction();
		else if( command.equals("idCheckForm") ) ac = new IdCheckFormAction();
		
		return ac;
	}
	
	
}
