<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../home/top.jsp" />
<link rel="stylesheet" href="${css}/customer/signup.css" />
<div class="grid-item" id="side_menu">
	<h1>
		<font style="font-size: 30px">회원 등록</font>
	</h1>
</div>
<div class="grid-item" id="content">
	<form id="form" name="form">
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">아이디</span> <input
				type="text" id="customerId" name="customerId" class="form-control"
				placeholder="Username" aria-describedby="basic-addon1">
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">이 름</span> <input
				type="text" id="customerName" name="customerName"
				class="form-control" placeholder="Username"
				aria-describedby="basic-addon1">
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">비밀번호</span> <input
				type="text" id="password" name="password" class="form-control"
				placeholder="Username" aria-describedby="basic-addon1">
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">주민번호</span> <input
				type="text" id="ssn" name="ssn" class="form-control"
				placeholder="Username" aria-describedby="basic-addon1">
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">전화번호</span> <input
				type="text" id="phone" name="phone" class="form-control"
				placeholder="Username" aria-describedby="basic-addon1">
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">우편번호</span> <input
				type="text" id="postalCode" name="postalCode" class="form-control"
				placeholder="Username" aria-describedby="basic-addon1">
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">도시</span> <input
				type="text" id="city" name="city" class="form-control"
				placeholder="Username" aria-describedby="basic-addon1">
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">주소</span> <input
				type="text" id="address" name="address" class="form-control"
				placeholder="Username" aria-describedby="basic-addon1">
		</div>
		<button type="button" class="btn btn-default btn-lg"  id="cancel_btn" value="CANCEL">
			<span class="glyphicon glyphicon-remove-circle" aria-hidden="true" ></span> 취 소
		</button>
		<button type="button" class="btn btn-default btn-lg" id="confirm_btn" value="SIGN-UP">
			<span class="glyphicon glyphicon-tent" aria-hidden="true" ></span> 확 인
		</button>
		
		<input type="hidden" name="cmd" value="signup" /> 
		<input type="hidden" name="page" value="signin" />
	</form>
</div>
<jsp:include page="../home/bottom.jsp" />
<script>
	$('#confirm_btn').click(()=> {
		var customerId = $('#customerId').val();
		var customerName = $('#customerName').val();
		var password = $('#password').val();
		var address = $('#address').val();
		var city = $('#city').val();
		var postalCode = $('#postalCode').val();
		var ssn = $('#ssn').val();
		$('#form').attr('action', '${ctx}/customer.do').submit();
	});
</script>