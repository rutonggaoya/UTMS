$(function () {


    $('#table').bootstrapTable('destroy');
    // 初始化表格
    InitMainTable();

    // 搜索按钮触发事件
    $("#query").click(function () {
        $('#table').bootstrapTable(('refresh')); // 很重要的一步，刷新url！
    });


});

// 初始化bootstrap-table的内容
function InitMainTable() {
    // 记录页面bootstrap-table全局变量$table，方便应用
    var index;
    //var getSelectRows = $("#table").bootstrapTable('getSelections');
    $('#table')
        .bootstrapTable(
            {
                url: "/topics.do",// 请求后台的URL，数据传输需注意中文乱码问题
                // url : '../../static/js/data.json',// 请求后台的URL，数据传输需注意中文乱码问题
                method: 'get', // 请求方式（*）
                dataType: "json",
                contentType: "application/x-www-form-urlencoded",
                toolbar: '#toolbar', // 工具按钮用哪个容器
                striped: true, // 是否显示行间隔色
                cache: false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true, // 是否显示分页（*）
                sortable: false, // 是否启用排序
                // sortOrder : "asc", // 排序方式
                sidePagination: "server", // 分页方式：client客户端分页，server服务端分页（*）
                pageNumber: 1, // 初始化加载第一页，默认第一页,并记录
                pageSize: 10, // 每页的记录行数（*）
                pageList: [5, 20, 50, 100], // 可供选择的每页的行数（*）
                search: false, // 是否显示表格搜索
                strictSearch: true,
                showColumns: true, // 是否显示所有的列（选择显示的列）
                showRefresh: true, // 是否显示刷新按钮
                minimumCountColumns: 2, // 最少允许的列数
                clickToSelect: true, // 是否启用点击选中行
                // height: 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                uniqueId: "ID", // 每一行的唯一标识，一般为主键列
                showToggle: false, // 是否显示详细视图和列表视图的切换按钮
                cardView: false, // 是否显示详细视图
                detailView: false, // 是否显示父子表
                locale: "zh-CN",
                // 得到查询的参数
                queryParams: function (params) {
                    // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                    var temp = {
                        pageSize: params.limit, // 每页显示数量
                        // offset : params.offset, // SQL语句偏移量
                        // pageNo : params.pageNumber,
                        pageNo: (params.offset / params.limit) + 1,
                        submitTime: $('#search_form input[name=\'submitTime\']').val(), // 请求时向服务端传递的参数


                    };
                    return temp;
                },

                columns: [
                    {
                        checkbox: true,
                        visible: true
                        // 是否显示复选框
                    },
                    {
                        field: 'subjID',  //需与model 一致
                        title: 'SubjID',
                        sortable: true
                    },
                    {
                        field: 'name', //需与model 一致
                        title: '项目名称'
                    },
                    {
                        field: 'teaName', //需与model 一致
                        title: '指导老师',
                        sortable: true
                    },
                    {
                        field: 'statusName', //需与model 一致
                        title: '状态',
                        sortable: true
                    },
                    {
                        field: 'limitNum', //需与model 一致
                        title: '限选人数',
                        sortable: true
                    },
                    {
                        field: 'selectNum', //需与model 一致
                        title: '已选人数',
                        sortable: true
                    },
                    // {
                    // 	field : 'issueTime', //需与model 一致
                    // 	title : '发布时间',
                    // 	sortable : true
                    // },
                    {
                        title: '操作',
                        field: 'function',
                        align: 'center',
                        formatter: function (value, row, index) {// 自定义显示可以写标签哦~
                            var SubjID = row.subjID+"";   //该行的项目ID,可做参数传递
                            var mya = '<a class="detail" onclick="detail('+"\'"+SubjID+"\'"+')" >报名详情 </a>' + '<a onclick="content()" >项目附件 </a>'+'<a onclick="check()" >项目审核 </a>'
                            return mya;
                        }
                    },],


                onLoadSuccess: function () {


                },
                onLoadError: function () {
                    alert("数据加载失败！");
                },
                onClickRow: function (row, $element) {
                    index = $element.data('index');

                    // alert(name);
                    //alert(rows[0]['name']);
                    //alert(getSelectRows[0]);
                    //alert(index);// 0,1,2...
                }
            })


    // 删除按钮事件
    $("#delete").on("click", function () {
        if (!confirm("是否确认删除？"))
            return;
        var rows = $("#table").bootstrapTable('getSelections');// 获得要删除的数据
        if (rows.length == 0) {// rows 主要是为了判断是否选中，下面的else内容才是主要
            alert("请先选择要删除的记录!");
            return;
        } else {
            var ids = new Array();// 声明一个数组
            $(rows).each(function () {// 通过获得别选中的来进行遍历
                ids.push(this.id);// cid为获得到的整条数据中的一列
            });
            deleteMs(ids)
        }
    })

    function deleteMs(ids) {
        $.ajax({
            url: path + "/alarm",
            data: "ids=" + ids,
            type: "post",
            dataType: "json",
            success: function (data) {
                $('#table').bootstrapTable(('refresh')); // 很重要的一步，刷新url！
            }
        });
    }


    // 删除按钮事件
    $("#issue").on("click", function () {
        if (!confirm("是否确认发布？"))
            return;
        var rows = $("#table").bootstrapTable('getSelections');// 获得要删除的数据
        if (rows.length == 0) {// rows 主要是为了判断是否选中，下面的else内容才是主要
            alert("请先选择要发布的课题!");
            return;
        } else {
            var ids = new Array();// 声明一个数组
            $(rows).each(function () {// 通过获得别选中的来进行遍历
                ids.push(this.id);// cid为获得到的整条数据中的一列
            });
            issueMs(ids)
        }
    })

    function issueMs(ids) {
        $.ajax({
            url: path + "/alarm",
            data: "ids=" + ids,
            type: "post",
            dataType: "json",
            success: function (data) {
                $('#table').bootstrapTable(('refresh')); // 很重要的一步，刷新url！
            }
        });
    }


}


function detail(SubjID) {  //根据项目ID跳转到选择学生页面
    var data={SubjID:SubjID};
    var tbody = document.getElementById("modal_tbody");
    tbody.innerHTML="";
    $.ajax({
        type : "get",
        url : "/admin/topic",
        data: data,
        success : function(response) {
            $('#myModal').modal({backdrop: "static"});
            console.log(response);
            for (var i = 0; i < response.length; i++){
                var ss = response[i];
                var status = ss.status;
                if(ss.status === 0)
                    addLine(ss.sid, ss.stuName, '未审核', tbody, ss.subjID, i);
                if(ss.status === 1)
                    addLine(ss.sid, ss.stuName, '已允许', tbody, ss.subjID, i);
                if(ss.status === 2)
                    addLine(ss.sid, ss.stuName, '已拒绝', tbody, ss.subjID, i);
            }
        },
        error : function() {
            alert("請求失敗");
        }
    });

};

function addLine(SID, Name, Status, tbody, SubjID, index) {
    var $line = '<tr '+ "name='line' id='Subject_" + SubjID + "'>\n" +
        '<td>'+ SID +'</td>\n' +
        '<td>'+ Name +'</td>\n' +
        '<td>'+ Status +'</td>\n' +
        '<td>' +
        '<button class=\'btn  btn-green\' onclick=\'apply(this)\'>允许申请</button> ' +
        '<button class=\'btn btn-default\' onclick=\'reject(this)\'>拒接申请</button> ' +
        '</td>\n' +
        '</tr>';

    $("#modal_tbody").append($line);
    console.log(tbody);
}

function content() {

}

function check() {
    confirm("审核是否合格？")
}
