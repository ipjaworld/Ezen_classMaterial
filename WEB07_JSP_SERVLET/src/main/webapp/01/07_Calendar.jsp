<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>07_Calendar.jsp</title>
<style type="text/css">
	td{ font-weight:bold; font-size:110%}
	tr>td:first-child{color:red;}
	tr>td:last-child{color:blue;}
	a{text-decoration:none;}
</style>
</head>
<body>
	<% 
		Calendar sDay = Calendar.getInstance();
		Calendar eDay = Calendar.getInstance();
		
		int sYear = sDay.get(Calendar.YEAR);
		int sMonth = sDay.get(Calendar.MONTH);
		
		int sDate = sDay.get(Calendar.DATE);
		int fMonth = sMonth;
		int fYear = sYear;
		
		if( request.getParameter("sYear") != null ){
			sYear = Integer.parseInt(request.getParameter("sYear") );
		}
		if( request.getParameter("sMonth") != null ){
			sMonth = Integer.parseInt(request.getParameter("sMonth") );
			if(sMonth == 12){
				sMonth = 0;
				sYear++;
			}
			if(sMonth == -1){
				sMonth = 11;
				sYear--;
			}
		}
		if( request.getParameter("sDate") != null ){
			sDate = Integer.parseInt(request.getParameter("sDate") );
		}
		
		sDay.set( sYear, sMonth, 1);
		eDay.set( sYear, sMonth+1, 1);
		eDay.add( Calendar.DATE, -1);
		
		int START_WEEK = sDay.get( Calendar.DAY_OF_WEEK);	// 1:일요일, 2:월요일
	%>
	<table width="560px" align="left" cellspacing="1" bgcolor="black">
		<tr bgcolor="white" height="50px">
			<td colspan="7" align="center">
				<a href="07_Calendar.jsp?sYear=<%=sYear %>&sMonth=<%=sMonth-1%>">이전달</a>  
				&nbsp;&nbsp;&nbsp; <%=sYear %>년 <%=sMonth+1 %>월 &nbsp;&nbsp;&nbsp; 
				<a href="07_Calendar.jsp?sYear=<%=sYear %>&sMonth=<%=sMonth+1%>">다음달</a>
			</td>
		</tr>
		<tr bgcolor="white" height="50px">
			<td align="center" width="80px">일</td>
			<td align="center" width="80px">월</td>
			<td align="center" width="80px">화</td>
			<td align="center" width="80px">수</td>
			<td align="center" width="80px">목</td>
			<td align="center" width="80px">금</td>
			<td align="center" width="80px">토</td>
		</tr>
		
		<!-- 첫번째 행 : 1일자요일 전까지의 열에는 공백, 그 뒤의 열부터는 날짜가 1,2,3... -->
		<tr bgcolor="white" height="50">
		<% 
			int date = 1;
			int i;
			for(i = 1; i<START_WEEK; i++){
				// 첫칸부터 1일자의 요일 바로 전까지 빈칸
		%>
			<td>&nbsp;</td>
		<%
			}
			for( i = 1; i<=8-START_WEEK; i++){
				// 1이자부터 토요일까지는 날짜로 표시
		%>
			<td align="right"><%=date %></td>
		<%
			if(date == sDate && fMonth == sMonth && fYear == sYear){
		%>
			<td align="right" bgcolor="cyon"><%=date %></td>
		<%
			}
			date++;
			}
		%>
		</tr>
		
		
		<% 
			//date = 1;
			for(i = 1; i<=5; i++){
		%>
				<tr bgcolor="white" height="50px">
		<%
					for(int j = 1; j<=7; j++){
						if(date<=eDay.get( Calendar.DATE)){;
							if(date == sDate && fMonth == sMonth && fYear == sYear){
		%>
								<td align="right" bgcolor="cyon" width="80px"><%=date %></td>
		<%
							}else{
		%>
								<td align="right" width="80px"><%=date%></td>
		<%
							}
							date++;
						}else{
		%>					
							<td align="right" width="80px">&nbsp;</td>
		<%
						}
					}
		%>
				</tr>	
		<%
			}
		%>
	</table>
</body>
</html>