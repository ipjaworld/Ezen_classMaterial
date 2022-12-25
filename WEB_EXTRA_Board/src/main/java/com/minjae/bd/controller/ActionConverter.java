package com.minjae.bd.controller;

import com.minjae.bd.controller.action.Action;
import com.minjae.bd.controller.action.IndexAction;

public class ActionConverter {
	
	private ActionConverter() {}
	private static ActionConverter itc = new ActionConverter();
	public static ActionConverter getInstance() { return itc; }

	public Action getAction(String command) {
		
		Action ac = null;
		
		if( command.equals("index") )
			ac = new IndexAction();
		
		return ac;
	}

	
	
}
