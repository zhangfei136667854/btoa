<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form class="layui-form" lay-filter="form_role_add_edit">
	<!-- layui的隐藏域  -->
	<input class="layui-hide" name="rowId"/>
	<div class="layui-form-item">
		<label class="layui-form-label">角色类型</label>
		<div class="layui-input-block">
			<select name="roleKind">
			<option value=""></option>
				<option value="1">超级角色</option>
				<option value="0">普通角色</option>
			</select>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">角色名称</label>
		<div class="layui-input-block">
			<!-- lay-verify 这个layui的自定义属性 ，设置表单的校验，多个校验 用 ‘|’ 隔开  -->
			<input name="roleName" lay-verify="required|checkrolename" id="roleName" placeholder="请输入角色名称" autocomplete="off" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item layui-form-text">
		<label class="layui-form-label">角色信息</label>
		<div class="layui-input-block">
			<textarea name="roleInfo" lay-verify="required" placeholder="请输入角色信息" class="layui-textarea"></textarea>
		</div>
	</div>
	<div class="layui-form-item">
		<div class="layui-input-block">
			<button class="layui-btn" lay-submit lay-filter="but_submit">提交</button>
			<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		</div>
	</div>
</form>
<!-- 引入自定义的JS脚本 -->
<script src="assert/pages/js/sys/role_add_edit.js"></script>
