//尝试书写公用的JS脚本
layui.use([ 'layer', 'table', 'form' ], function() {
	var $ = layui.$;
	var layer = layui.layer;
	var table = layui.table;
	var form = layui.form;
	//为了统一的处理页面上的CRUD，现对页面中出现的各种元素的id,或filter,或class 规定如下。
	// 页面中使用的URL 用隐藏域 id="hideURL" 提供。
	// 页面中的数据标题 用隐藏域 id="hideTitle"提供
	// 新增表单按钮  class ="layui-btn-add"
	// 弹出的表单的filter lay-filter="form_add_edit"
	// 表格的id和filter  <table id="filter_table" lay-filter="filter_table"/>
	//绑定新增按钮
	$(document).off('click', '.layui-btn-add').on('click', '.layui-btn-add',function() {
		var url = $('#hideURL').val();
		var title = $('#hideTitle').val();
		$.ajax({
			url : url+'/form',
			success : function(htmlData) {
				//通过layer的open方法打开弹出层
				layer.open({
					type : 1, //0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）。 
					title : title+'新增',
					area : '800px', //设置宽度，高度自适应
					content : htmlData,// 这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
					success : function() { //弹出层打开成功以后
						// 让form表单渲染一下。 form_add_edit = <form lay-filter="form_add_edit">
						form.render(null, 'form_add_edit');
					}
				});
			}
		});
	});
	
	// 监听提交动作  submit(but_submit) = <button class="layui-btn" lay-submit lay-filter="but_submit">
	form.on('submit(but_submit)', function(data) {
		//data.field //当前容器的全部表单字段，名值对形式：{name: value}
		var rowId = data.field.rowId;
		//默认为新增
		var type='post';
		if(rowId){ // 如果rowId有值,则执行修改
			type='put';
		}
		$.ajax({
			type:type,
			url:$('#hideURL').val(),
			data:$(data.form).serialize(),
			success:function(result){
				if(result){
					// 关闭弹出层
					//layer.close(layer.index);
					layer.closeAll(); //疯狂模式，关闭所有层
					//请求table重新加载数据 filter_table = <table id="filter_table"/>
					table.reload('filter_table');
				}
			}
		});
		
		//不用忘记 return false ,讲按钮原来的功能给屏蔽掉。
		return false;
	});
	
	//绑定搜索按钮
	form.on('submit(btn_search)', function(data) {
		//重新渲染table数据
	    table.reload('filter_table', {
	        page: {
	          curr: 1 //重新从第 1 页开始
	        }
	        ,where: $('#form_search').serialize() //重新配置查询额外的数据
	      }, 'data');
		return false;
	});
});