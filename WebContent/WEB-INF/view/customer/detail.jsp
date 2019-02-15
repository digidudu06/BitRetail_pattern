<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../home/top.jsp"/>

검색한 사람의 정보<br />
아이디 ${cust.customerId}<br />
이름 ${cust.customerName}<br />
성별 : 남<br />
전화번호 : ${cust.phone}<br />
주소 : ${cust.city}<br />
상세주소 : ${cust.address}<br />
우편번호 : ${cust.postalCode}
 
<jsp:include page="../home/bottom.jsp"/>
<script>
</script>