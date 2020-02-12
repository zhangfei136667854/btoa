layui.use(['table','form','layer'],function(){
	var $ = layui.$;
	var form = layui.form ;
	var table = layui.table;
	var layer = layui.layer;
	form.render();
	  table.render({
		    elem: '#demo'
		    ,height: 312//设置高度
		    ,url: 'user' //数据接口
		    ,page: true //开启分页
		 , where: $("#form-search").serialize(), //加除了分页外的额外数据（所条件查询）
		    cols: [[ //表头
		      {field: 'rowId', title: 'ID', width:80, sort: true, fixed: 'left'}
		      ,{field: 'userName', title: '用户名称', width:180}
		      ,{field: 'userCode', title: '用户账号', width:180} 
		      ,{field: 'userKind', title: '用户等级', width:180, templet:'#roleKindTpl'} 
		      ,{field: 'userPhone', title: '用户手机', width:180} 
		      ,{field: 'lastLoginIP', title: '登陆地址', width: 120, sort: true}
		      ,{field: '', title: '操作', width:200,templet:'#caozuo'}
		     
		    ]]
		  });
	  //对表格的按钮进行绑定
	  table.on('tool(user_table)',function(obj){
		  var data = obj.data ;
		  var layEvent = obj.event;
		  var rowId = data.rowId;
		  switch(layEvent){
		  case "edit":
			openLayerUser(rowId);
			  break;
		  case "delete":
			  layer.confirm("你确定要删除吗?",function(index){
				
				  $.ajax({
					  url:"user/"+rowId,
					  type:'delete',
					  success:function(result){
						  if(result){
							 // layer.close(index);
							  table.reload("demo");
							  layer.closeAll();
						  }
					  }
				  });
				  
			  });
			  break;
		   default:
			   break;
		  }
	  });
	  //绑定新增按钮
	  $("#btn_add").off('click').on('click',function(){
		  alert("新增");
		  openLayerUser();
	  });
	  function openLayerUser(rowId){
		  var titleVal = rowId==null?'用户新增':'用户修改';
		  $.ajax({
			  url:'user/goadd',
			  success:function(htmlData){
				  layer.open({
					  type:1,
					  title:titleVal,
					  area:'800px',
					  content:htmlData,
					  success:function(){
						  if(rowId){
							  $.ajax({
								  type:'get',
								  url:'user/get/'+rowId,
								  success:function(user){
									  form.val("form_add_edit",user);
									  $("#passUser").attr('style','display:none')
									  $("#userName").data('old',user.userName);
									  form.render(null,'form_add_edit');
								  }
							  });
						  }
						  else{
							  form.render(null,'form_add_edit');
						  }
					  }
				  });
			  }
		  });
	  }
	  
	  //绑定多条件查询提交按钮，重新渲染数据
	  form.on("submit(btn-search)",function(data){
		  //重新渲染table表格数据
		  table.reload('demo',{
			  page:{
				  curr:1//重新从第一页开始
			  }
		  , where:$("#form-search").serialize()
		  },'data');
		  return false ;
	  });
	
		  
		});


</script>