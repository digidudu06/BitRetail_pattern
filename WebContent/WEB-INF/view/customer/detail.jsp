<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../home/top.jsp"/>
<div class="grid-item" id="navi_bar">
	<jsp:include page="../employee/nav.jsp"/>
</div>
<div class="grid-item" id="side_menu">
 	<img src="${img}/default_image.png" />
</div>
<div class="grid-item">
	<div>
	검색한 사람의 정보<br />
	아이디 : ${cust.customerId}<br />
	이름 : ${cust.customerName}<br />
	성별 : 남<br />
	전화번호 : ${cust.phone}<br />
	주소 : ${cust.city}<br />
	상세주소 : ${cust.address}<br />
	우편번호 : ${cust.postalCode}
	</div>
	<div>
		<span id="update_btn" class="label label-success">수정</span>
		<span class="label label-danger">삭제</span>
	</div>
</div>
<jsp:include page="../home/bottom.jsp"/>
<script>
$('#update_btn').click(function(){
	location.assign('${ctx}/customer.do?cmd=cust_retrieve&page=update&customer_id=${cust.customerId}');
});

</script>