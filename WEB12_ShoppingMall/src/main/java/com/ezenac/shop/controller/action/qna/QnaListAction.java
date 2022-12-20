package com.ezenac.shop.controller.action.qna;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenac.shop.controller.action.Action;
import com.ezenac.shop.dao.QnaDao;
import com.ezenac.shop.dto.MemberVO;
import com.ezenac.shop.dto.QnaVO;
import com.ezenac.shop.util.Paging;

public class QnaListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "qna/qnaList.jsp";
		
		// �α��� üũ
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		if(mvo == null) {
			url = "shop.do?command=loginForm";
		}else {
			// �α����� ���̵�� qna ����� ��ȸ�ϰ� ���Ϲ޽��ϴ� (�޼��� �̸� selectQna)
			QnaDao qdao = QnaDao.getInstance();
			//ArrayList<QnaVO> list = qdao.selectQna( mvo.getId() );
			int page = 1;
			if(request.getParameter("page") != null) {
				page = Integer.parseInt( request.getParameter("page") );
				session.setAttribute("page", page);
			}else if( session.getAttribute("page")!=null) {
				page = (Integer)session.getAttribute("page");
			}else {
				session.removeAttribute("page"); // ���ǿ��� ������ ����
			}
			Paging paging = new Paging();
			paging.setPage(page);
			int count = qdao.getAllcount( mvo.getId() );	// �α��� ���̵�� �˻��� QnA �Խù��� ������ ���մϴ�
			paging.setTotalCount(count);
			ArrayList<QnaVO> list = qdao.selectQna( mvo.getId(), paging);// ���� �������� ǥ���� �Խù�(5��)�� ��ȸ�ؼ� list�� ���Ϲ޽��ϴ�
			
	
			request.setAttribute("qnaList", list);
			request.setAttribute("paging", paging);// paging ��ü�� request�� ����ϴ�
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
