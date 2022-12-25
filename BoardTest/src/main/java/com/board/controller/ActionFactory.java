package com.board.controller;

import com.board.controller.action.Action;
import com.board.controller.action.Board_List_Action;


public class ActionFactory {
	private ActionFactory() { }
	private static ActionFactory instance = new ActionFactory();
	public static ActionFactory getInstance() {	 return instance; }
	
	public Action getAction(String command) {
		Action ac = null;
		
		if( command.equals("boardList")) ac = new Board_List_Action();
				
		return ac;
	}
}
