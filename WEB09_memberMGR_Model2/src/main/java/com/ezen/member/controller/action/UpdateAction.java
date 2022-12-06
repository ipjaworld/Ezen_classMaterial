package com.ezen.member.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.member.dao.MemberDao;
import com.ezen.member.dto.MemberDto;

public class UpdateAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // �����μ� mdto�� �־ �ش�ȸ���� �������ּ���
      
   
      MemberDto mdto= new MemberDto();
      
      mdto.setName(request.getParameter("name"));
      mdto.setUserid(request.getParameter("userid"));
      mdto.setPwd(request.getParameter("pwd"));
      mdto.setEmail(request.getParameter("email"));
      mdto.setPhone(request.getParameter("phone"));
      mdto.setAdmin(Integer.parseInt (request.getParameter("admin")));
      
      MemberDao mdao= MemberDao.getInstance();
      
      int result=mdao.updateMember(mdto);
      if(result==1) {
         HttpSession session = request.getSession();
         session.setAttribute("loginUser",mdto);// ���� �α��� ������ ������ �������� ��ü
      }
      
   
      // �����Ŀ� main.jsp�� �̵��մϴ�.
      
      // ���������� ������ ��ܿ� ���뿡 �ٷ� ����ǰ� ���ǰ��� �������ּ���
      String url = "member.do?command=main";
      RequestDispatcher dp = request.getRequestDispatcher(url);
      dp.forward(request, response);
      
      
      // �����Ŀ��� main.jsp �� ���ư��ϴ�.

   }

}