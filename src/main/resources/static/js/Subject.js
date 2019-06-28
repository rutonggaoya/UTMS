$(document).ready(function(){
  //新增课题
  $("#create-Subject").click(function () {
  $('#myModal').modal();
  });
  //查看修改课题
  $("#change_subj").mouseleave(function(){
    $(this).css('font-weight','normal');
  });
  $("#change_subj").mouseenter(function () {
    $(this).css('font-weight','bold');
  });
  $("#change_subj").click(function () {
    $("#ModalLabel_info").text("查看");
    $('#Modal_info').modal();
  });
  document.getElementById("btn_change").onclick = function() {
    var txt_name = document.getElementById("txt_subjname");
   
    var txt_limit = document.getElementById("txt_limitnum");
    var txt_Intro = document.getElementById("txt_intro");
    txt_name.readOnly=false;
    txt_limit.readOnly=false;
    txt_Intro.readOnly=false;
    var val_name =txt_name.innerHTML;
    var val_limit = txt_limit.innerHTML;
    var val_Intro = txt_Intro.innerHTML;
  };
  $("#stu_subj").live('click',function () {
    //学生端查看课题
    alert("a");
    $('#Modal_stusubj').modal();
    });
   
});