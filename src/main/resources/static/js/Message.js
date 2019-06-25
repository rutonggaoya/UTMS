$(document).ready(function(){
    //私信界面的发送私信按钮
$("#btn_add").click(function () {
      $("#myModalLabel").text("私信");
      $('#myModal').modal();
  });
//私信界面的聊天列表按钮
  $("tr.chat").click(function () {
  // $("#myModalLabel").text("王翠花（对方姓名）");
      $('#myModal2').modal();
      ($('#msgList').children("table:last-child")[0]).scrollIntoView();
  });
  ($('#msgList').children("table:last-child")[0]).scrollIntoView();
  
   $("#btnSubmit").click(function(){   
               
        var txtVal=$("#msgInput").val();
        var mydate=new Date();
        //alert(txtVal);
        //如果没有内容就return
        if(txtVal==''){return false;}
      //有内容继续
      $('#msgList').append( '<table width="100%"  cellpadding="0" cellspacing="0">'+
                    '<tr><td><div class="messinfo">'+mydate.toLocaleString()
                    +'</div></td></tr>  <tr><td><div class="message">'+
                    txtVal+'</div></td></tr></table>');
        $("#scrolldIV").scrollTop($("#scrolldIV")[0].scrollHeight);

        //清空input
        document.getElementById('msgInput').value = "";
    })
   

});