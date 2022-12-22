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
			int page = 1;	// ������ ���� : request �� session�� page ���� �ִٸ� �� ������, ���ٸ� 1�� ���� �������� ����
			if(request.getParameter("page") != null) {	// ������Ʈ�� �Ķ���ͷ� page �� ���޵ȴٸ� page �������� �� ������ ��ü
				page = Integer.parseInt( request.getParameter("page") );
				session.setAttribute("page", page);
				// 2 �̻��� ���������� �Խù��� ���ٰ� �ٽ� �Խ������� ���ư� ��, ���� ������ ��ȣ�� �Ҿ������ ��찡 ���Ƽ�
				// ���� ���� �ִ� ������ ��ȣ�� ���ǿ� �����ߴٰ� request�� �Ķ���Ͱ� ���ٸ� �ѹ� �� ������ �˻��Ͽ� ������ ��ȣ�� ��ü������ �����մϴ�
			}else if( session.getAttribute("page")!=null) {
				// request�� �Ķ���Ͱ� ���ٸ� �ѹ� �� ������ �˻��Ͽ� ������ ��ȣ�� ��ü������ �����մϴ�
				page = (Integer)session.getAttribute("page");
			}else {
				session.removeAttribute("page"); // ���ǿ��� ������ ����
			}
			Paging paging = new Paging();
			paging.setPage(page);	// ������ ������ ��������ȣ ��ü�� ����
			
			int count = qdao.getAllcount( mvo.getId() );	// �α��� ���̵�� �˻��� QnA �Խù��� ������ ���մϴ�
			paging.setTotalCount(count);		// �Խù� �Ѱ����� totalCount ������ �����մϴ�. �̶� paging() �޼��嵵 ȣ��
			// ��� ��ü�� ������� �غ� �Ϸ�
			
			// ���� �������� ǥ���� �Խù�(5��, �α����� ������ �ۼ��� startNum���� endNum����)�� ��ȸ�ؼ� list�� ���Ϲ޽��ϴ�
			ArrayList<QnaVO> list = qdao.selectQna( mvo.getId(), paging);
			
			request.setAttribute("qnaList", list);
			request.setAttribute("paging", paging);// paging ��ü�� request�� ����ϴ�
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
