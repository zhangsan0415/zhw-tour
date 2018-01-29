<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="menuHead.jsp" %>
<!-- MAIN -->
<div class="main">
	<!-- MAIN CONTENT -->
		<!--lock end-->
		<div class="panel panel-headline demo-icons">
			<div class="panel-heading">
				<h3 class="panel-title">旅游行程管理</h3>
			</div>
			<div class="panel-body">
				<form action="#" class="form-inline">
					类型：
					<select id="area_type" class="form-control">
						<option value="1">国内</option>
						<option value="2">国外</option>
					</select>
					<button type="button" class="btn btn-info" onclick="queryPage()">查询</button>
					<button type="button" class="btn btn-info" data-toggle="modal"  onclick="addTourItem()">添加行程</button>
				</form>
			
				<table id="tour_item_list" class="table table-striped">
				</table>
				<div id="example" style="text-align: center"> <ul id="pageLimit"></ul> </div>
			</div>
		</div>
	</div>
	<!-- END MAIN -->
	<div class="clearfix"></div>
	
	<div class="modal fade" id="add_modal" tableindex="-1" role="dialog" aria-hidden="true" aria-labelledby="myModalLabel">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" 
							aria-hidden="true">×
					</button>
					<h4 class="modal-title" id="myModalLabel">
						添加旅游行程
					</h4>
				</div>
				<div class="modal-body">
					<form role="form" id="add_tour_item_form">
						  <div class="form-group">
							    <label for="areaType">类型</label>
							    <select name="areaType" class="form-control">
									<option value="1">国内</option>
									<option value="2">国外</option>
								</select>
						  </div>
						  <div class="form-group">
							    <label for="tourItem">行程</label>
							    <input type="text" name="tourItem" class="form-control">
						  </div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" onclick="addItemAction()">确定</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>

<%@include file="menuBottom.jsp"%>
<script>

$("#tourEntryAdmin").prev().addClass('active');/*一级  */
$("#tourEntryAdmin").addClass("in");

$("#toTourItemAdmin").addClass('active');/* 二级 */

//点击克定按钮
function addItemAction(){
	$("#add_modal").modal('hide');
	var url = '<%=basePath%>admin/addTourItem.do';
	var params = $('#add_tour_item_form').serialize();
	$.post(url,params,function(result){
		var obj = JSON.parse(result);
		Ewin.alert({message:obj.msg}).on(function(){
			if(obj.status == 0)	
				$(location).attr('href', '<%=basePath%>home/toTourItemAdmin.do');
		});
	});
}

//添加行程
function addTourItem(){
	$("#add_modal").modal();
}
//删除操作
function delTourItems(pkId){
	var url = '<%=basePath%>admin/delTourItem.do';
	var params = {pkId:pkId};
	$.post(url,params,function(result){
		var obj = JSON.parse(result); 
		Ewin.alert({message: obj.msg}).on(function(){
			if(obj.status == 0)	queryPage();
		});
	});
}
/* 初始化显示分页 */
function queryPage(){
	var pageUrl = '<%=basePath%>admin/tourItems.do';
	var tableHead = ['编号','类型','行程','创建时间','操作'];
	var op_arr = [{text:"删除",func:"delTourItems",index:"pkId"}];
	var dataIndex = ['pkId','areaTypeName','tourItem','createTime',op_arr];
	var params = {areaType:$("#area_type").val().trim()};
	var options = {tableId:'tour_item_list',clientPageId:'pageLimit',url:pageUrl,tableHead:tableHead,dataIndex:dataIndex,params:params};
	ZHW_Page.paging(options);
}

queryPage();
</script>
