$(function() {
	
	
	$('#table').bootstrapTable('destroy');
	// 初始化表格
	InitMainTable();

	
	// 搜索按钮触发事件
	$("#query").click(function() {
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
						// url : '../../static/js/data2.json',// 请求后台的URL，数据传输需注意中文乱码问题
						url : '/admin/getStudentsSubject',// 请求后台的URL，数据传输需注意中文乱码问题
					//	method : 'get', // 请求方式（*）
						 dataType: "json",
						// contentType : "application/x-www-form-urlencoded",
						toolbar : '#toolbar', // 工具按钮用哪个容器
						striped : true, // 是否显示行间隔色
						cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
						pagination : true, // 是否显示分页（*）
						sortable : false, // 是否启用排序
						// sortOrder : "asc", // 排序方式
						sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
						pageNumber : 1, // 初始化加载第一页，默认第一页,并记录
						pageSize : 10, // 每页的记录行数（*）
						pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
						search : false, // 是否显示表格搜索
						strictSearch : true,
						showColumns : true, // 是否显示所有的列（选择显示的列）
						showRefresh : true, // 是否显示刷新按钮
						minimumCountColumns : 2, // 最少允许的列数
						clickToSelect : true, // 是否启用点击选中行
						// height: 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
						uniqueId : "studentID", // 每一行的唯一标识，一般为主键列
						showToggle : false, // 是否显示详细视图和列表视图的切换按钮
						cardView : false, // 是否显示详细视图
						detailView : false, // 是否显示父子表
						locale: "zh-CN",
						// 得到查询的参数
						queryParams : function(params) {
							// 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
							var temp = {
								pageSize : params.limit, // 每页显示数量
								// offset : params.offset, // SQL语句偏移量
								// pageNo : params.pageNumber,
								pageNo : (params.offset / params.limit) + 1,
								studentID : $('#search_form input[name=\'studentID\']').val(), // 请求时向服务端传递的参数
						

							};
							return temp;
						},

						columns : [
								{
									checkbox : true,
									visible : true
								// 是否显示复选框
								},
								{
									field : 'sid',  //需与model 一致
									title : '学号',
									sortable : true
								},
								{
									field : 'name', //需与model 一致
									title : '姓名'
								},
								{
									field : 'subjName', //需与model 一致
									title : '课题',
									sortable : true
								},
								
								// {
								// 	field : 'submitTime', //需与model 一致
								// 	title : '提交时间',
								// 	sortable : true
								// },
								{
									field : 'similarityRate', //需与model 一致
									title : '查重率',
									sortable : true
								},
								{
									field : 'grade', //需与model 一致
									title : '答辩成绩',
									sortable : true
								},
								{
									title : '操作',
									field : 'function',
									align : 'center',
									formatter : function(value, row, index) {// 自定义显示可以写标签哦~
										//var ID = row.ID+"";   //该行的项目ID,可做参数传递
										var mya = '<a href="#" onclick="check()" >审核&nbsp;</a>' +
											'<a href="#" onclick="register('+ row.sid +')" >登记成绩&nbsp;</a>' +
											'<a href="#" onclick="detail('+ row.sid +')" >学生详情&nbsp;</a>'+
											'<a href="#" onclick="thesis()" >附件 </a>';
										return mya;
									}
								}, ],
								
							
						onLoadSuccess : function() {
							

						},
						onLoadError : function() {
							alert("数据加载失败！");
						},
						onClickRow : function(row, $element) {
							index = $element.data('index');
							
						    // alert(name); 
							//alert(rows[0]['name']);
							//alert(getSelectRows[0]);
							//alert(index);// 0,1,2...
						}
					})


}


function detail(SID){  //根据项目ID跳转到选择学生页面
	// window.location.href="/admin/studentInfo";  //跳转到具体页面
	window.open("/admin/studentInfo?SID="+SID);
};


function check(){  //根据项目ID跳转到选择学生页面
	
	 $('#checkModal').modal({backdrop:"static"});
	
};

function register(SID){  //根据项目ID跳转到选择学生页面
	$('input[name="score"]').val("");
	$('input[name="SID"]').val(""+SID);
	$('#scoreModal').modal({backdrop:"static"});
};




