
//姓名
$("#name").hover(function() {

	$("#nameBtn").removeClass("Field-modify-hidden");

}, function() {
	$("#nameBtn").addClass("Field-modify-hidden");

});
function setName() {
	$("#nameSet").css('display', 'block');
	$("#name").css('display', 'none');
	$("#userNameu").val("");
};

function nameSave() {
	$("#nameSet").css('display', 'none');
	$("#name").css('display', 'block');
	var val = $('input[name="userName"]').val();
	// document.getElementById("mysex").innerText=val;
	$("#name h3").text(val);
	// alert(val);
};

function nameCancel() {
	$("#nameSet").css('display', 'none');
	$("#name").css('display', 'block');

};

// 职工号

$("#ID").hover(function() {

	$("#IDBtn").removeClass("Field-modify-hidden");

}, function() {
	$("#IDBtn").addClass("Field-modify-hidden");

});
function setID() {
	$("#IDset").css('display', 'block');
	$("#ID").css('display', 'none');
	$("#userIDu").val("");
};

function idSave() {
	$("#IDset").css('display', 'none');
	$("#ID").css('display', 'block');
	var val = $('input[name="userID"]').val();
	// document.getElementById("mysex").innerText=val;
	$("#ID span").text(val);
	// alert(val);
};

function idCancel() {
	$("#IDset").css('display', 'none');
	$("#ID").css('display', 'block');

};

// 性别
$("#sex").hover(function() {

	$("#sexBtn").removeClass("Field-modify-hidden");

}, function() {
	$("#sexBtn").addClass("Field-modify-hidden");

});

function setSex() {
	$("#sexRadio").css('display', 'block');
	$("#sex").css('display', 'none');
};
function sexSave() {
	$("#sexRadio").css('display', 'none');
	$("#sex").css('display', 'block');
	var val = $('input[name="gender"]:checked').val();
	// document.getElementById("mysex").innerText=val;
	$("#sex span").text(val);
	// alert(val);
};

function sexCancel() {
	$("#sexRadio").css('display', 'none');
	$("#sex").css('display', 'block');

};

// 院系
$("#department").hover(function() {

	$("#dpBtn").removeClass("Field-modify-hidden");

}, function() {
	$("#dpBtn").addClass("Field-modify-hidden");

});
function setDP() {
	$("#departmentSet").css('display', 'block');
	$("#department").css('display', 'none');
	$("#dpu").val("");
};

function dpSave() {
	$("#departmentSet").css('display', 'none');
	$("#department").css('display', 'block');
	var val = $('input[name="dp"]').val();
	// document.getElementById("mysex").innerText=val;
	$("#department span").text(val);
	// alert(val);
};

function dpCancel() {
	$("#departmentSet").css('display', 'none');
	$("#department").css('display', 'block');

};

// 职称
$("#title").hover(function() {

	$("#titleBtn").removeClass("Field-modify-hidden");

}, function() {
	$("#titleBtn").addClass("Field-modify-hidden");

});
function setTitle() {
	$("#titleSet").css('display', 'block');
	$("#title").css('display', 'none');
	$("#titleu").val("");
};

function titleSave() {
	$("#titleSet").css('display', 'none');
	$("#title").css('display', 'block');
	var val = $('input[name="ititle"]').val();
	// document.getElementById("mysex").innerText=val;
	$("#title span").text(val);
	// alert(val);
};

function titleCancel() {
	$("#titleSet").css('display', 'none');
	$("#title").css('display', 'block');

};

// 手机号
$("#phone").hover(function() {

	$("#phoneBtn").removeClass("Field-modify-hidden");

}, function() {
	$("#phoneBtn").addClass("Field-modify-hidden");

});
function setPhone() {
	$("#phoneSet").css('display', 'block');
	$("#phone").css('display', 'none');
	$("#phoneu").val("");
};

function phoneSave() {
	$("#phoneSet").css('display', 'none');
	$("#phone").css('display', 'block');
	var val = $('input[name="iphone"]').val();
	// document.getElementById("mysex").innerText=val;
	$("#phone span").text(val);
	// alert(val);
};

function phoneCancel() {
	$("#phoneSet").css('display', 'none');
	$("#phone").css('display', 'block');

};

// 邮箱
$("#mail").hover(function() {

	$("#mailBtn").removeClass("Field-modify-hidden");

}, function() {
	$("#mailBtn").addClass("Field-modify-hidden");

});
function setMail() {
	$("#mailSet").css('display', 'block');
	$("#mail").css('display', 'none');
	$("#mailu").val("");
};

function mailSave() {
	$("#mailSet").css('display', 'none');
	$("#mail").css('display', 'block');
	var val = $('input[name="imail"]').val();
	// document.getElementById("mysex").innerText=val;
	$("#mail span").text(val);
	// alert(val);
};

function mailCancel() {
	$("#mailSet").css('display', 'none');
	$("#mail").css('display', 'block');

};

 //修改密码按钮的事件
$("#passwdBtn").click(function () {
     $("#myModalLabel").text("修改密码");
     $("#newPasswdu").val("") ;
     $("#checkpwdu").val("") ;
    $('#myModal').modal({backdrop:"static"});
 });

function savePwd(){
	var newpwd=$("#newPasswdu").val() ;
	var checkpwd=$("#checkpwdu").val() ;
	if(newpwd!==checkpwd){
		alert("两次密码输入不相同");
	}
	else{
		alert("修改成功");
	}
	
}



