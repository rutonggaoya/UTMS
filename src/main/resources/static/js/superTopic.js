 //修改密码按钮的事件
$(".addBtn").click(function () {
   
     $("#stuIDu").val("") ;
     $("#stuNameu").val("") ;
     
    $('#addModal').modal({backdrop:"static"});
    
 });





$("#addStuBtn").click(function () {
	var stuID= $('input[name="stuID"]').val();
	var stuName= $('input[name="stuName"]').val();
	var $tr = $("<tr>"+
			"<td>"+stuID+"</td>"+
			"<td>"+"<a href=\"#\">"+stuName+"</a>"+"</td>"+
			"<td>尚未处理</td>"+
			"<td><button class=\"btn  btn-green\" onclick=\"apply(this)\">允许申请</button> " +
			"<button class=\"btn btn-default\" onclick=\"reject(this)\">拒接申请</button></td>"+
			"</tr>");
			var $table = $('#stuTable tbody');
			$table.append($tr);
   
	$("#addModal").modal('hide');
 });

function apply(button){

	
	if($(button).parent().parent().find("td").eq(2).text()=="已允许"){
		alert("请勿重复点击");
	}
	else{
		$(button).parent().parent().find("td").eq(2).text("已允许");
	}
} 
function reject(button){
	if($(button).parent().parent().find("td").eq(2).text()=="已拒绝"){
		alert("请勿重复点击");
	}
	else{
		$(button).parent().parent().find("td").eq(2).text("已拒绝");
	}

} 
	
	



$("#cancelStuBtn").click(function () {
   
	$("#addModal").modal('hide');
    
 });



$('.form_datetime').datetimepicker({
	//language:  'fr',
	weekStart : 1,
	todayBtn : 1,
	autoclose : 1,
	todayHighlight : 1,
	startView : 2,
	forceParse : 0,
	showMeridian : 1
});

