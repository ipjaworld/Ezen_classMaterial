<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_image_menu.jsp" %>

<!-- 게시판을 1:1 고객에게만 보여주고 싶어할지 다 보여줄지 공개로 갈지....
게시판에 대해서 기능을 분리하는게 좋을거라는 생각
게시판 자체는 전체 공개로 하되, 비공개 게시글 기능을 넣어두는게 좋다고 생각합니다. -->

<article>
<h2>1:1 고객 게시판</h2>
<h3>고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h3>
<form name="formm" method="post">
<table id="cartList">
	<tr><th>번호</th><th>제목</th><th>등록일</th><th>답변 여부</th></tr>
	<c:forEach items="${qnaList}" var="qnaVO">
		<tr><td>${qnaVO.qseq}</td>
			<td><a href="shop.do?command=qnaView&qseq=${qnaVO.qseq}">${qnaVO.subject}</a></td>
			<td><fmt:formatDate value="${qnaVO.indate}" type="date"/></td>
			<td><c:choose>
				<c:when test="${qnaVO.rep==1}">no</c:when>
				<c:when test="${qnaVO.rep==1}">yes</c:when>
			</c:choose></td>
	
	</c:forEach>
</table><div class="clear"></div>


<div id="paging" style="margin-left:300px; font-size:120%; font-weight:bold">
	<c:url var="action" value="shop.do?command=qnaList" />
		<c:if test="${paging.prev}" >
			<a href="${action}&page=${paging.beginPage-1}">◀</a>&nbsp;
		</c:if>

		<c:forEach begin="${paging.beginPage}" end="${paging.endPage}" var="index">
			<c:choose>
				<c:when test="${index==paging.page}">
					<span style="color:red">${index}&nbsp;</span>
				</c:when>
				<c:otherwise>
					<a href="${action}&page=${index}">${index}&nbsp;</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<c:if test="${paging.next}">
			<a href="${action}&page=${paging.endPage+1}">▶</a>&nbsp;
		</c:if>
	</div>	<div class="clear"></div><br>
	<div id="buttons" style="float:right">
		<input type="button" value="질문하기" class="submit" onClick="location.href='shop.do?command=qnaWriteFrom'">
		<input type="button" value="쇼핑 계속하기" class="cancel" onClick="location.href='shop.do?command=index'">
	</div>
	<div class="clear"></div><br>
</form>

</article>



<%@ include file="../footer.jsp" %>