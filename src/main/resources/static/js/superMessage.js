$("#btn_issue").click(function () {
	$('input[name="score"]').val("");
	 $('#issueModal').modal({backdrop:"static"});
	 
	
 });




$("#issueBtn").click(function () {
	var title= $('input[name="title"]').val();
	var content= $('input[name="content"]').val();
	$("#issueModal").modal('hide');
 });


$("#issueCancelBtn").click(function () {
	$("#issueModal").modal('hide');
 });



$("#inputFileBtn").click(function () {
	 $.post("写入需要跳转的url",$('#dataFrom').serialize(),function(data){
         //data中是服务端返回的数据
         //这里进行成功后的渲染。。。。。。
     });
     return false;//在这里返回false

 });