<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="menuHead.jsp" %>
<!-- MAIN -->
<div class="main">
	<!-- MAIN CONTENT -->
	<div class="main-content">
		<div class="panel panel-headline demo-icons">
			<div class="panel-heading">
				<h3 class="panel-title">旅游报名管理</h3>
			</div>
			<div class="panel-body">
				<form action="" class="form-inline">
					 编号： 
					<input type="text" class="form-control" />
					<button class='btn btn-primary'>查询</button>
				</form>
				<table class="table table-striped" id="tab">
					<thead>
						<tr>
							<th style="width: 12%;">类别</th>
							<th style="width: 19%;">行程</th>
							<th style="width: 7%;">出行日期</th>
							<th style="width: 5%;">发起人</th>
							<th style="width: 10%;">报名费用</th>
							<th style="width: 13%;">状态</th>
							<th style="width: 15%;">操作</th>
						</tr>
					</thead>
					<tbody>
					<tr>
						<td><input type="text" class="form-control" /></td>
						<td><input type="text" class="form-control" /></td>
						<td><select name="" class="form-control">
								<option value="">男</option>
								<option value="">女</option>
						</select></td>
						<td><input type="text" class="form-control" /></td>
						<td><input type="text" class="form-control" /></td>
						<td><input type="text" class="form-control" /></td>
						<td>666</td>
						<td><input type="text" class="form-control" /></td>

					</tr>
					</tbody>
				</table>
				<table id ="tab2" style="display:none">
					<tbody>
					<tr>
						<td>1</td>
						<td><input type="text" class="form-control" /></td>
						<td><input type="text" class="form-control" /></td>
						<td><select name="" class="form-control">
								<option value="">男</option>
								<option value="">女</option>
						</select></td>
						<td><input type="text" class="form-control" /></td>
						<td><input type="text" class="form-control" /></td>
						<td><input type="text" class="form-control" /></td>
						<td>666</td>
						<td><input type="text" class="form-control" /></td>

					</tr>
					</tbody>
				
				</table>
				<button class="btn btn-info" onclick="addPerson()">添加一个乘客</button>
				<button class="btn btn-info" onclick="onSave()">保存</button>
			</div>

		</div>



	</div>
	<!-- END MAIN -->
	<div class="clearfix"></div>

</div>
<%@include file="menuBottom.jsp" %>
<script>

$("#tourEntryAdmin").addClass("active");

</script>