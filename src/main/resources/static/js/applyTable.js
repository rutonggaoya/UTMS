$(function() {
	
	
	$('#applytable').bootstrapTable('destroy');
	// 初始化表格
	InitMainTable();

	
	

	
});

// 初始化bootstrap-table的内容
function InitMainTable() {
	// 记录页面bootstrap-table全局变量$table，方便应用
	var index;
	//var getSelectRows = $("#table").bootstrapTable('getSelections');
	
	$('#applytable')
			.bootstrapTable(
					{
						url : '../../static/js/data2.json',// 请求后台的URL，数据传输需注意中文乱码问题
					//	method : 'get', // 请求方式（*）
						 dataType: "json",
						// contentType : "application/x-www-form-urlencoded",
						//toolbar : '#toolbar', // 工具按钮用哪个容器
						striped : true, // 是否显示行间隔色
						cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
						pagination : false, // 是否显示分页（*）
						sortable : false, // 是否启用排序
						// sortOrder : "asc", // 排序方式
						sidePagination : "client", // 分页方式：client客户端分页，server服务端分页（*）
						pageNumber : 1, // 初始化加载第一页，默认第一页,并记录
						pageSize : 10, // 每页的记录行数（*）
						//pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
						search : false, // 是否显示表格搜索
						strictSearch : false,
						showColumns : true, // 是否显示所有的列（选择显示的列）
						showRefresh : false, // 是否显示刷新按钮
						minimumCountColumns : 0, // 最少允许的列数
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
								//studentID : $('#search_form input[name=\'studentID\']').val(), // 请求时向服务端传递的参数
						

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
									field : 'studentID',  //需与model 一致
									title : '学号',
									sortable : true
								},
								{
									field : 'studentName', //需与model 一致
									title : '姓名'
								},
								{
									field : 'status', //需与model 一致
									title : '状态',
									sortable : true
								},
					
								{
									title : '操作',
									field : 'fuction',
									align : 'center',
									formatter : function(value, row, index) {// 自定义显示可以写标签哦~
										//var ID = row.ID+"";   //该行的项目ID,可做参数传递
										var mya = '<a href="#" onclick="add()" >允许申请 </a>+onclick="reject()" >拒绝申请 </a>'
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

