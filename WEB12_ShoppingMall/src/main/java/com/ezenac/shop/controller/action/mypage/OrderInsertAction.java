package com.ezenac.shop.controller.action.mypage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenac.shop.controller.action.Action;
import com.ezenac.shop.dao.CartDao;
import com.ezenac.shop.dao.OrderDao;
import com.ezenac.shop.dto.CartVO;
import com.ezenac.shop.dto.MemberVO;

public class OrderInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 로그인 이후에만 올 수 있는 페이지이기 때문에 세션의 정보를 얻어옵니다*/
		String url = "";
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		if(mvo == null) {
			url = "shop.do?command=loginForm";
		}else {
			// 주문자 아이디로 검색한 카트 목록(지금 주문 처리할) 목록을 먼저 조회합니다.(cdao 생성 필요)
			CartDao cdao = CartDao.getInstance();
			ArrayList<CartVO> cartList = cdao.selectCart( mvo.getId() );
			
			// 조회한 list와 주문자의 아이디를 갖고 OrderDao의 insertOrder 메서드로 orders와 order_detail 테이블에
			// 데이터를 추가합니다.
			OrderDao odao = OrderDao.getInstance();
			int oseq = odao.insertOrder( cartList, mvo.getId() );
			
			// 방금 주문에 성공한 주문 번호를 갖고 오더 리스트로 이동하여 주문번호로 주문 내역을 다시 조회하고
			// jsp 로 이동합니다.
			url = "shop.do?command=orderList&oseq="+ oseq;
		}
		response.sendRedirect(url);
	}

}
