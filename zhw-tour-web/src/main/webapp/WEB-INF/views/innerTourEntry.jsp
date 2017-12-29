<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="menuHead.jsp" %>
<!-- MAIN -->
<div class="main">
	<!-- MAIN CONTENT -->
	<div class="main-content">
		<div class="panel panel-headline demo-icons">
			<div class="panel-heading">
				<h3 class="panel-title">国内旅游报名</h3>
			</div>
			<div class="panel-body">
				<form action="" class="form-inline">
					行程： <select name="" id="" class="form-control">
						<option value="">北京+天津4天3晚</option>
						<option value="">云南6天5晚常规</option>
						<option value="">海南5天4晚</option>
					</select> 出团日： <input type="text" class="form-control" />
				</form>
				<table class="table table-striped" id="tab">
					<thead>
						<tr>
							<th style="width: 6%;">序号</th>
							<th style="width: 12%;">姓名</th>
							<th style="width: 19%;">身份证</th>
							<th style="width: 7%;">性别</th>
							<th style="width: 10%;">户籍</th>
							<th style="width: 13%;">航班号/列车号</th>
							<th style="width: 15%;">电话</th>
							<th style="width: 5%;">收费</th>
							<th style="width: 10%;">备注</th>
						</tr>
					</thead>
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
//添加乘客
function addPerson(){
	debugger;
	  //获取要插入行的表格 
	  var $tr=$("#"+tab+" tr").eq(row);
	  var table = document.getElementById("tab");
	 table.de
	  var cloneTab = document.getElementById("tab2");
	  table.firstChild.appendChild(cloneTab.firstChild.cloneNode(true));
	  var v = table.firstChild.childNodes;
	  var len = v.length;
	  for (var i = 2; i < len; i++) {
		  v[i].childNodes[0].firstChild.id=i;//给第一个单元格id赋值 
	}
}
//保存
function onSave(){
	
}
$("#subEnter").prev().addClass('active');/*一级  */
$("#subEnter").addClass("in");
$("#toInnerTourEntry").addClass('active');/* 二级 */
</script>