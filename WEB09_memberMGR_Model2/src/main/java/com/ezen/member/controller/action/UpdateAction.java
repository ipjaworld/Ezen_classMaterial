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
      // 전달인수 mdto에 넣어서 해당회원을 수정해주세요
      
   
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
         session.setAttribute("loginUser",mdto);// 세션 로그인 정보를 수정된 내용으로 교체
      }
      
   
      // 수정후에 main.jsp로 이동합니다.
      
      // 수정내용이 페이지 상단에 내용에 바로 적용되게 세션값을 수정해주세요
      String url = "member.do?command=main";
      RequestDispatcher dp = request.getRequestDispatcher(url);
      dp.forward(request, response);
      
      
      // 수정후에는 main.jsp 로 돌아갑니다.

   }

}