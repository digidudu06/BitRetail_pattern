<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../home/top.jsp"/>
<div class="grid-item" id="navi_bar">
	<jsp:include page="../employee/nav.jsp"/>
</div>
<div class="grid-item" id="side_menu">
	<form id="file_form">
 		<img src="${img}/${image.imgName}.${image.imgExtention}"/><br />
 		<input type="file" name="file_upload" />
 		<input type="submit" id="file_upload_btn" />
	</form>
 	<span id="photo_btn" class="label label-primary">프로필 변경</span>
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
		<span id="delete_btn" class="label label-danger">회원탈퇴</span>
	</div>
</div>
<jsp:include page="../home/bottom.jsp"/>
<script>
$('#update_btn').click(()=>{
	location.assign('${ctx}/customer.do?cmd=cust_retrieve&page=update&customer_id=${cust.customerId}');
});

$('#file_upload_btn').click(()=>{
	$('#file_form')
	.attr('method','post')
	.attr('action','${ctx}/customer.do?cmd=cust_file_upload&page=detail&customer_id=${cust.customerId}')
	.attr('enctype','multipart/form-data')
	.submit();
});

$('#delete_btn').click(()=>{
	location.assign('${ctx}/customer.do?cmd=cust_delete&dir=home&page=main&customer_id=${cust.customerId}');
});
</script>