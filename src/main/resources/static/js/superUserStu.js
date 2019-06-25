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
