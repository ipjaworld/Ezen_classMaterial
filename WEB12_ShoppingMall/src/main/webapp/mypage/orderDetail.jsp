<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_image_menu.jsp" %>


<article>
<h2>My Page(주문 상세 정보)</h2>
	<form>
		<h3>주문자 정보</h3>
		<table id="cartList">
			<tr><th>주문일자</th><th>주문번호</th><th>주문자</th><th>주문 총액</th></tr>
			<tr><td><fmt:formatDate value="${orderDetail.indate}" type="date"/></td>
						<td>${orderDetail.oseq}</td><td>${orderDetail.mname}</td>
						<td><fmt:formatNumber type="currency" value="${totalPrice}"/></td></tr>
			<tr><td colspan="4">배송주소 : ${orderDetail.address1}&nbsp;${orderDetail.address2}</td></tr>
		</table>
		
		<h3>주문 상품 정보</h3>
		<table id="cartList">
			<tr><th>상품명</th><th>상품별주문번호</th><th>수량</th><th>주문 가격</th><th>처리 상태</th></tr>
			<c:forEach items="${orderList}" var="orderVO">
				<tr><td>${orderVO.pname}</td><td>${orderVO.odseq}</td>
					<td>${orderVO.quantity}</td>
					<td><fmt:formatNumber type="currency" value="${orderVO.price2*orderVO.quantity}"/></td>
					<td>
						<c:choose>
							<c:when test="${orderVO.result=='1' }">결제완료</c:when>
							<c:when test="${orderVO.result=='2' }">배송중</c:when>
							<c:when test="${orderVO.result=='3' }">
								<span style="color:blue">배송완료</span>
								<input type="button" value="구매확정" onClick="orderEnd('${orderVO.odseq}');">
							</c:when>
							<c:otherwise><span style="color:red">구매 확정</span></c:otherwise>
						</c:choose></td>
			</c:forEach>
		</table>
		<div class="clear"></div>
		<div id="buttons" style="float:right">
			<input type="button" value="뒤로" class="cancel" onclick="history.go(-1)">
		</div>
		
	</form>

</article>



<%@ include file="../footer.jsp" %>