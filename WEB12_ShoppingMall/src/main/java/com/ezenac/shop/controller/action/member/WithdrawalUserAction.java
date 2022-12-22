package com.ezenac.shop.controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenac.shop.controller.action.Action;
import com.ezenac.shop.dao.MemberDao;
import com.ezenac.shop.dto.MemberVO;

public class WithdrawalUserAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "shop.do?command=loginForm";
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if(mvo == null) {
			// url = "shop.do?command=loginForm";
			request.setAttribute("message", "로그인이 필요한 서비스입니다.");
		}else {
			MemberDao mdao = MemberDao.getInstance();
			mdao.withDrawUser( mvo.getId() );
			
			request.setAttribute("message", 
					"탈퇴가 성공적으로 이루어졌습니다. 탈퇴 회원의 정보는 3개월간 보관되며 그 기간안에 별도의 가입 없이 계정 복구가 가능합니다.");
			session.removeAttribute("loginUser");
		}

		request.getRequestDispatcher(url).forward(request, response);
	}

}
