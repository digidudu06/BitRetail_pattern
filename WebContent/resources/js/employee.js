$('#confirm_btn').click(()=>{
	var empno = $('#empno').val();
	var name = $('#name').val();
	$('#form')
	.attr('action', '${ctx}/employee.do')
	.submit();
});
