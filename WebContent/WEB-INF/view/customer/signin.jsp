<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" href="${css}/customer/signin.css" />
<div class="grid-item" id="side_menu">
	<h1><font style="font-size: 30px">회원 접속</font></h1>
</div>
<div class="grid-item" id="content">
<form id="form" name="form" >
	<div class="grid-container">
	<!-- customerId, customerName, password, address, city, postalCode, ssn -->
	    <div class="grid-item" id="item_1">아이디</div>
	    <div class="grid-item" id="item_2"><input type="text" id="customerId" name="customerId" value="anat12"></div>
	    <div class="grid-item" id="item_3">비밀번호</div>
	    <div class="grid-item" id="item_4"><input type="text" id="password" name="password" value="123" ></div>
	    <div class="grid-item" id="item_11"><input type="submit" id="confirm_btn" value='확 인'></div>
	    <div class="grid-item" id="item_12"><input type="reset" id="cancel_btn" value='취 소'> </div>
	    <input type="hidden" name="cmd" value="signin" />
	    <input type="hidden" name="dir" value="category" />
	    <input type="hidden" name="page" value="main" />
	</div>
</form>
</div>
<jsp:include page="../home/bottom.jsp"/>
<script>
$('#confirm_btn').click(function(){
	var customerId = $('#customerId').val();
	var password = $('#password').val();
	$('#form')
	.attr('action', '${ctx}/customer.do')
	.submit();
});
</script>