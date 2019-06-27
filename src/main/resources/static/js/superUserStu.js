function pass(){
	//处理
	$("#checkModal").modal('hide');
}

function failed(){
	//处理
	$("#checkModal").modal('hide');
}



$("#scoreBtn").click(function (event) {
    console.log($('input[name="EGrade"]').val());
    console.log($('input[name="SID"]').val());
    $.ajax({
        url: "/admin/setScore",
        data: {
            "SID": $('input[name="SID"]').val(),
            "EGrade": $('input[name="EGrade"]').val()
        },
        type: "GET",
        success: function (res) {
            $("#scoreModal").modal('hide');
            alert("登记成功！");
            window.location.reload();
        },
        error: function (res) {
            console.log(res);
            alert("登记失败！请检查学生是否已经提交论文。");
        }
    })
});


function back(){
	window.close();
	// window.location.href="../../templates/super/superUserStu.html";  //跳转到具体页面
}
