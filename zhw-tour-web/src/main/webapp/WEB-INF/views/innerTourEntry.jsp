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
				<form action="#" class="form-inline">
					行程：
					<select name="" id="tour_type" class="form-control">
						<c:forEach var="item" items="${requestScope.tourItems}">
								<option value="${item.pkId}">${item.tourItem}</option>
						</c:forEach>
					</select> 
					出团日： 					
					<input id="chufa_date" size="16" type="text" readonly>

				</form>
				<table class="table table-striped" id="inner_tab">
					<thead>
						<tr>
							<th style="width: 8%;">姓名</th>
							<th style="width: 15%;">身份证</th>
							<th style="width: 6%;">性别</th>
							<th style="width: 15%;">户籍</th>
							<th style="width: 10%;">航班号/列车号</th>
							<th style="width: 10%;">电话</th>
							<th style="width: 8%;">收费</th>
							<th style="width: 10%;">备注</th>
							<th style="width: 8%;">操作</th>
						</tr>
					</thead>
					<tbody>
					<tr>
						<!-- <td>1</td> -->
						<td><input type="text" name="bmName" class="form-control" /></td>
						<td><input type="text" name="bmCardCode" class="form-control" /></td>
						<td><select name="bmSex" class="form-control">
								<option value="0">男</option>
								<option value="1">女</option>
						</select></td>
						<td><input type="text" name="bmHjAddress" class="form-control" /></td>
						<td><input type="text" name="bmCarCode" class="form-control" /></td>
						<td><input type="text" name="bmPhone" class="form-control" /></td>
						<td><input type="text" name="bmPrice" class="form-control" /></td>
						<td><input type="text" name="bmComment" class="form-control" /></td>
						<td><input type="button"  value="删除" class="form-control"  onclick="deleteOne(this)"/></td>
					</tr>
					</tbody>
				</table>
				<button class="btn btn-info" onclick="addOne()">添加一个乘客</button>
				<button class="btn btn-info" onclick="saveTourInfo()">保存</button>
			</div>
		</div>



	</div>
	<!-- END MAIN -->
	<div class="clearfix"></div>

</div>
<%@include file="menuBottom.jsp" %>
<script>
$("#chufa_date").datetimepicker({
	format: 'yyyy-mm-dd',
	autoclose:true,
	minView:'month',
	language:  'zh-CN'
});
//添加乘客
function addOne(){
	var table = $("#inner_tab");
	var tr = '<tr>'
		+'<td><input type="text" name="bmName" class="form-control" /></td>'
		+'<td><input type="text" name="bmCardCode" class="form-control" /></td>'
		+'<td><select name="bmSex" class="form-control"><option value="0">男</option><option value="1">女</option></select></td>'
		+'<td><input type="text" name="bmHjAddress" class="form-control" /></td>'
		+'<td><input type="text" name="bmCarCode" class="form-control" /></td>'
		+'<td><input type="text" name="bmPhone" class="form-control" /></td>'
		+'<td><input type="text" name="bmPrice" class="form-control" /></td>'
		+'<td><input type="text" name="bmComment" class="form-control" /></td>'
		+'<td><input type="button" value="删除" class="form-control"  onclick="deleteOne(this)"/></td></tr>';
	table.append(tr);
}

function getTableData(tableId){
	var table = $('#'+tableId);
	var tbody = table.find('tbody');
	var trs = tbody.find('tr');
	
	var data = [];
	for(var i=0;i<trs.length;i++){
		var tds = trs.eq(i).find('td'); 
		var obj = {};
		for(var j=0;j<tds.length-1;j++){
			var td = tds.eq(j);
			var key = td.find("input").attr("name");
			var value = td.find("input").val();
			if(j == 2){
				key = td.find("select").attr("name");
				value = td.find("select").val();
			}
			if(value == null || value.trim() == '')	{
				Ewin.alert({message:"表格中存在空字段！"});
				return null;
			}
			obj[key]=value;
		}
		data.push(obj);
	}
	return data;
}

function deleteOne(tdObj){
	var td = $(tdObj);
	td.parents("tr").remove();  
}
//保存
function saveTourInfo(){
	var tableData = getTableData("inner_tab");
	if(!tableData)	return;
	
	var url = "<%=basePath%>tour/saveInnerTour.do";
	
	var tourType = $("#tour_type").val();
	var cfDate = $("#chufa_date").val();
	if(!cfDate) {
		Ewin.alert({message:"出发日期 不能为空！"});
		return;
	}
	var params = {"tourType":tourType,"cfDate":cfDate,"tourors":JSON.stringify(tableData)};
	$.ajax({
		type: 'POST',
	  	url: url,
		data: JSON.stringify(params),
		success: function(result){
			Ewin.alert({message: result.msg}).on(function(){
				if(result.status == 0){
					$(location).attr('href', '<%=basePath%>home/toInnerTourEntry.do');
				}
			}); 
		},
	  	dataType: "json" ,
	  	contentType: "application/json;charset=utf-8" 
	});
}
$("#subEnter").prev().addClass('active');/*一级  */
$("#subEnter").addClass("in");
$("#toInnerTourEntry").addClass('active');/* 二级 */
</script>