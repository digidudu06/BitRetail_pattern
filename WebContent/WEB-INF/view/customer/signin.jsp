<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" href="${css}/customer/signin.css" />
<div class="grid-item" id="side_menu">
	<h1><font style="font-size: 30px">회원 접속</font></h1>
</div>
<div class="grid-item" id="content">
<form id="form" name="form" >
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">아이디</span> 
			<input type="text" id="customerId" name="customerId"
				class="form-control" placeholder="Username"
				aria-describedby="basic-addon1">
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">비밀번호</span> 
			<input type="text" id="password" name="password"
				class="form-control" placeholder="Username"
				aria-describedby="basic-addon1">
		</div>
		<button type="button" class="btn btn-default btn-lg"  id="cancel_btn" value="CANCEL">
			<span class="glyphicon glyphicon-remove-circle" aria-hidden="true" ></span> 취 소
		</button>
		<button type="button" class="btn btn-default btn-lg" id="confirm_btn" value="SIGN-UP">
			<span class="glyphicon glyphicon-tent" aria-hidden="true" ></span> 확 인
		</button>
		
	    <input type="hidden" name="cmd" value="signin" />
	    <input type="hidden" name="dir" value="category" />
	    <input type="hidden" name="page" value="main" />
</form>
</div>
<jsp:include page="../home/bottom.jsp"/>
<script>
$('#confirm_btn').click(()=>{
	var customerId = $('#customerId').val();
	var password = $('#password').val();
	$('#form')
	.attr('action', '${ctx}/customer.do')
	.submit();
});
</script>