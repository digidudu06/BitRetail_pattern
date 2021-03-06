<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="top.jsp"/>
<link rel="stylesheet" href="${css}/home/main.css" />
    <div class="grid-item" id="left">
    	고객 전용<br /><br />
    	<a href="#" id="cust_join" >회원가입</a><br />
    	<a href="#" id="cust_login" >로 그 인</a>
    </div>
    <div class="grid-item" id="right">
    	직원 전용<br /><br />
    	<a href="#" id="emp_register" >사원등록</a><br />
    	<a href="#" id="emp_access">접속승인</a>
    </div>
    <div class="grid-item" id="left">
    	고객 전용<br /><br />
    	<h1 style="margin-bottom: 100px">객체지향</h1><br />
    	<a href="#" id="oop_access" >접속하기</a>
    </div>
    <div class="grid-item" id="right">
    	직원 전용<br /><br />
    	<h1 style="margin-bottom: 100px">알고리즘</h1><br />
    	<a href="#" id="algo_access">접속하기</a>
    </div>
<jsp:include page="bottom.jsp"/>  
<script src="${js}/oop.js"></script>
<script>
$('#cust_join').click(()=>{
	location.assign('customer.do?cmd=move&page=signup');
});
$('#cust_login').click(()=>{
	location.assign('customer.do?cmd=move&page=signin');
});

$('#emp_register').click(()=>{
	location.assign('employee.do?cmd=move&page=register');
});

$('#emp_access').click(()=>{
	location.assign('employee.do?cmd=move&page=access');
});
$('#oop_access').click(function(){
/* 	encap.main();	 */
	test2.main();
});
</script>