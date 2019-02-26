var ctx = "${ctx}";


$('#mypage a').click(()=>{
	location.assign('${ctx}/customer.do?cmd=cust_retrieve&page=detail&customer_id=${customer.customerId}');
})

$('.page').click(function(){
	alert('2페이지 누름' + $(this).text());
	//page_num, pageSize
	//?cmd=list&page=list&page_num=2&page_size=5
	location.assign('${ctx}/customer.do?cmd=cust_list&page=list&page_num='+$(this).text());
}); 

$('#cate_register').click(()=>{
	$('#cate_side_menu > li').attr('style','background-color: white');
	$('#cate_register').attr('style','background-color: #fddaf396');
	$('#content').html('<form id="form">'
	+'  <div class="form-group">'
	+'    <label for="text">카테고리 이름 :</label>'
	+'    <input type="text" class="form-control" id="email">'
	+'  </div>'
	+'  <div class="form-group">'
	+'    <label for="text">상세설명 :</label>'
	+'    <textarea rows="4" cols="50" class="form-control" id="pwd"></textarea>'
	+'  </div>'
	+'  <button type="submit" class="btn btn-default">Submit</button>'
	+'</form>');
});
$('#cate_search').click(()=>{
	$('#cate_side_menu > li').attr('style','background-color: white');
	$('#cate_search').attr('style','background-color: #fddaf396');
	$('#content').html('<form id="form">'
	+'  <div class="form-group">'
	+'    <label for="text">카테고리 검색 :</label>'
	+'    <select>'
	+' 		 <option name="cate_id" value="volvo">스마트폰</option>'
	+' 		 <option name="cate_id" value="saab">데스크탑</option>'
	+'		 <option name="cate_id" value="opel">노트북</option>'
	+'    </select>'	
	+'    <button type="submit" class="btn btn-default">Submit</button>'
	+'  </div>'
	+'</form>');
});
$('#cate_delete').click(()=>{
	$('#cate_side_menu > li').attr('style','background-color: white');
	$('#cate_delete').attr('style','background-color: #fddaf396');
	$('#content').html('<form id="form">'
	+'  <div class="form-group">'
	+'    <label for="text">카테고리 삭제 :</label><br />'
	+'    <input type="checkbox" name="vehicle1" value="Bike"> Smart Phone<br>'
	+'    <input type="checkbox" name="vehicle2" value="Car"> Laptop<br>'
	+'    <input type="checkbox" name="vehicle3" value="Boat"> Desktop<br><br>'
	+'    <input type="submit" value="Submit">'
	+'  </div>'
	+'</form>');
});
$('#cate_update').click(()=>{
	$('#cate_side_menu > li').attr('style','background-color: white');
	$('#cate_update').attr('style','background-color: #fddaf396');
	$('#content').html('<form id="form">'
	+'  <div class="form-group">'
	+'    <label for="text">카테고리 수정 :</label><br />'
	+'    <input type="radio" name="gender" value="male"> 스마트폰<br>'
	+'      <input type="radio" name="gender" value="female"> 데스크탑<br>'
	+'      <input type="radio" name="gender" value="other"> 노트북<br>'
	+'    <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">수정</button>'
	+'    <div class="modal fade" id="myModal" role="dialog">'
	+'     <div class="modal-dialog">'
   	+'      <div class="modal-content">'
   	+'        <div class="modal-header">'
   	+'          <button type="button" class="close" data-dismiss="modal">&times;</button>'
   	+'          <h4 class="modal-title">카테고리 수정</h4>'
   	+'        </div>'
   	+'        <div class="modal-body form-group">'
	+'   		<label for="text">카테고리 이름 :</label>'
	+'    		<textarea rows="4" cols="50" class="form-control" id="pwd"></textarea>'
	+'   		<label for="text">상세설명 :</label>'
	+'    		<textarea rows="4" cols="50" class="form-control" id="pwd"></textarea>'
   	+'        </div>'
   	+'        <div class="modal-footer">'
   	+'          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>'
   	+'        </div>'
   	+'      </div>'
   	+'    </div>'
   	+'   </div>'
	+'  </div>'
	+'</form>');
});