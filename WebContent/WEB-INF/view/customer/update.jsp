<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../home/top.jsp"/>
<div class="grid-item" id="navi_bar">
	<jsp:include page="../employee/nav.jsp"/>
</div>
<div class="grid-item" id="side_menu">
 	<img src="${img}/default_image.png" />
</div>
<form id="update_form">
<div class="grid-item">
	<div>
	검색한 사람의 정보<br />
	<!-- 1번 각각 hidden으로 값을 전부 보냄 -->
	<!-- 2번 id만 hidden으로 보냄 -->
	아이디 : ${cust.customerId}<br />
	<input type="hidden" name="default_Id" value="${cust.customerId}"/>
	이름 : ${cust.customerName}<br />
	성별 : 남<br />
	임시 비밀번호 : <input type="text" name="password" placeholder="임시 비밀번호"/><br />
	전화번호 : <input type="text" name="phone" placeholder="${cust.phone}"/><br />
	주소 : <input type="text" name="city" placeholder="${cust.city}"/><br />
	상세주소 : <input type="text" name="address" placeholder="${cust.address}"/><br />
	우편번호 : <input type="text" name="postal_code" placeholder="${cust.postalCode}"/>
	<input type="hidden" name="cmd" value="cust_update" />
	<input type="hidden" name="page" value="detail" />
	</div>
	<div>
		<span id="confirm_btn" class="label label-success">확인</span>
		<span id="cancel_btn" class="label label-danger">취소 </span>
	</div>
</div>
</form>
<jsp:include page="../home/bottom.jsp"/>
<script>
$('#confirm_btn').click(()=>{
	var form = $('#update_form');
	form.attr('action','${ctx}/customer.do');
	form.attr('method','post');
	form.submit();
});
$('#cancel_btn').click(()=>{
	alert('취소');
});

</script>