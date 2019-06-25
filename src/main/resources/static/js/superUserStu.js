function pass(){
	//处理
	$("#checkModal").modal('hide');
}

function failed(){
	//处理
	$("#checkModal").modal('hide');
}



$("#scoreBtn").click(function () {
	var score= $('input[name="score"]').val();
   alert(score);
	$("#scoreModal").modal('hide');
 });



function back(){
	window.location.href="../../templates/super/superUserStu.html";  //跳转到具体页面
}
