
var prefix = "/information/companyInfo"
$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list", // 服务器数据的加载地址
					//	showRefresh : true,
					//	showToggle : true,
					//	showColumns : true,
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						// queryParamsType : "limit",
						// //设置为limit则会发送符合RESTFull格式的参数
						singleSelect : false, // 设置为true将禁止多选
						// contentType : "application/x-www-form-urlencoded",
						// //发送到服务器的数据编码类型
						pageSize : 10, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
						//search : true, // 是否显示搜索框
						showColumns : false, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
						queryParams : function(params) {
							return {
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
								limit: params.limit,
								offset:params.offset
					           // name:$('#searchName').val(),
					           // username:$('#searchName').val()
							};
						},
						// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
						// queryParamsType = 'limit' ,返回参数必须包含
						// limit, offset, search, sort, order 否则, 需要包含:
						// pageSize, pageNumber, searchText, sortName,
						// sortOrder.
						// 返回false将会终止请求
						columns : [
																{
									field : 'companyName', 
									title : '公司名称'
								},
								{
									field : 'address',
									title : '公司地址'
								},
								{
									field : 'phone',
									title : '公司电话'
								},
								{
									field : 'principal',
									title : '负责人'
								},
								{
									field : 'weixin',
									title : 'VX'
								},
								{
									field : 'url',
									title : '展示图片',
                                    formatter : function(value, row, index) {
                                        var e = '<div class="image"><img width="90" height="100" alt="image" class="img-responsive" src="' + value + '"></div>'
                                        return e;
                                    }
								},
																{
									field : 'updateTime', 
									title : '修改时间'
								},
																{
									field : 'createTime', 
									title : '发布时间' 
								},
																{
									title : '详细信息',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
										var f='<button type="button" class="btn  btn-xs btn-primary" onclick="companyYeWu('+row.id+')">可添加案例</button>    ';
                                        if(row.companyName.indexOf("装饰")>0)
											return  f;
                                        else
                                        	return "";
									}
								} ,
                            {
                                title : '操作',
                                field : 'id',
                                align : 'center',
                                formatter : function(value, row, index) {
                                    var g='<button type="button" class="btn  btn-xs btn-default" onclick="edit('+row.id+')">编辑</button>    ';
                                    var a='<button type="button" class="btn  btn-xs btn-danger" onclick="remove('+row.id+')">删除</button> ';
                                    if(row.companyName.indexOf("装饰")>0)
                                    	return g;
                                    else
                                    	return  g+ a;
                                }
                            } ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
function add() {
    var addPage=layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add' // iframe的url
	});
    layer.full(addPage);
}
function edit(id) {
    var addPage=layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
    layer.full(addPage);
}
function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix+"/remove",
			type : "post",
			data : {
				'id' : id
			},
			success : function(r) {
				if (r.code==0) {
					layer.msg(r.msg);
					reLoad();
				}else{
					layer.msg(r.msg);
				}
			}
		});
	})
}

function resetPwd(id) {
}

function companyShuoMing(id){
    var addPage =layer.open({
        type : 2,
        title : '公司说明',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : prefix + '/company/companyShuoMing/'+id
    });
    layer.full(addPage);
}

function companyYeWu(id){
	window.location.href="/information/companyGongcheng/"+id;
}