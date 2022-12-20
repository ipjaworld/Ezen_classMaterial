package com.ezenac.shop.controller;

import com.ezenac.shop.controller.action.Action;
import com.ezenac.shop.controller.action.IndexAction;
import com.ezenac.shop.controller.action.member.ContractAction;
import com.ezenac.shop.controller.action.member.EditFormAction;
import com.ezenac.shop.controller.action.member.FindZipNumAction;
import com.ezenac.shop.controller.action.member.IdCheckFormAction;
import com.ezenac.shop.controller.action.member.JoinAction;
import com.ezenac.shop.controller.action.member.JoinFormAction;
import com.ezenac.shop.controller.action.member.LoginAction;
import com.ezenac.shop.controller.action.member.LoginFormAction;
import com.ezenac.shop.controller.action.member.LogoutAction;
import com.ezenac.shop.controller.action.member.MemberUpdateAction;
import com.ezenac.shop.controller.action.mypage.CartDeleteAction;
import com.ezenac.shop.controller.action.mypage.CartInsertAction;
import com.ezenac.shop.controller.action.mypage.CartListAction;
import com.ezenac.shop.controller.action.mypage.MypageAction;
import com.ezenac.shop.controller.action.mypage.OrderAllAction;
import com.ezenac.shop.controller.action.mypage.OrderDetailAction;
import com.ezenac.shop.controller.action.mypage.OrderInsertAction;
import com.ezenac.shop.controller.action.mypage.OrderListAction;
import com.ezenac.shop.controller.action.product.CategoryAction;
import com.ezenac.shop.controller.action.product.ProductDetailAction;
import com.ezenac.shop.controller.action.qna.QnaListAction;

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
		else if( command.equals("findZipNum") ) ac = new FindZipNumAction();
		else if( command.equals("join") ) ac = new JoinAction();
		else if( command.equals("editForm") ) ac = new EditFormAction();
		else if( command.equals("memberUpdate") ) ac = new MemberUpdateAction();
		
		else if( command.equals("category") ) ac = new CategoryAction();
		else if( command.equals("productDetail") ) ac = new ProductDetailAction();
		
		else if( command.equals("cartInsert") ) ac = new CartInsertAction();
		else if( command.equals("cartList") ) ac = new CartListAction();
		else if( command.equals("cartDelete") ) ac = new CartDeleteAction();
		else if( command.equals("orderInsert") ) ac = new OrderInsertAction();
		else if( command.equals("orderList") ) ac = new OrderListAction();
		else if( command.equals("mypage") ) ac = new MypageAction();
		else if( command.equals("orderAll") ) ac = new OrderAllAction();
		else if( command.equals("orderDetail") ) ac = new OrderDetailAction();
		
		else if( command.equals("qnaList") ) ac = new QnaListAction();
		
		
		return ac;
	}
	
	
}
