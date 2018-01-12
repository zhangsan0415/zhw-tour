<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="menuHead.jsp" %>
<!-- MAIN -->
<div class="main">
	<!-- MAIN CONTENT -->
	<div class="main-content">
		<div class="panel panel-headline demo-icons">
			<div class="panel-heading">
				<h3 class="panel-title">报名记录确认</h3>
			</div>
			<div class="panel-body">
				<form action="#" class="form-inline" role='form'>
			    	类型：
					<select id="area_type" class="form-control" onchange="changeTourItems(this)">
						<option value="1">国内</option>
						<option value="2">国外</option>
					</select>
					行程： 
					<select id="tour_type" class="form-control">
						<c:forEach var="item" items="${requestScope.tourItems}">
								<option value="${item.pkId}">${item.tourItem}</option>
						</c:forEach>
					</select> 
					出团日：
					<input id="chufa_date" size="16" class="form-control" type="text" readonly>
					会员编码： 
					<input id="hy_code_confirm" class="form-control" type="text">
					<button type="button" class="btn btn-info" onclick="queryPage()">查询</button>
				</form>
				<table class="table table-striped" id="score_list"></table>
				<div id="example" style="text-align: center"> <ul id="pageLimit"></ul> </div>
			</div>

		</div>
	</div>
	<!-- END MAIN -->
	<div class="clearfix"></div>

</div>
<%@include file="menuBottom.jsp"%>
<script>
function changeTourItems(obj){
	var tourSelector =  $("#tour_type");
	$("option",tourSelector).remove(); //清空原有的选项 
	var url = "<%=basePath%>tour/getTourItems.do";
	var params = {"areaType":obj.value};
	$.post(url,params,function(result){
		var obj = JSON.parse(result);
		if(obj.status != 0)	return;
		$.each(obj.obj,function(index,item){
			var option = "<option value='" + item['pkId'] + "'>" + item['tourItem'] + "</option>";
			tourSelector.append(option);
		});
		
	});
}
$("#chufa_date").datetimepicker({
	format: 'yyyy-mm-dd',
	autoclose:true,
	minView:'month',
	language:  'zh-CN'
});
/* 初始化显示分页 */
function queryPage(){
	var areaType = $('#area_type').val();
	var tourType = $('#tour_type').val();
	var cfDate   = $('#chufa_date').val(); 
	var hyCode   = $('#hy_code_confirm').val(); 
	var params = {areaType:areaType,tourType:tourType,cfDate:cfDate==null?'':cfDate.trim(),hyCode:hyCode==null?'':hyCode.trim()};
	var pageUrl = '<%=basePath%>admin/queryTourList.do';
	var tableHead = ['所属会员','姓名','身份证','出行日期','航班号/列车号','电话','收费','备注','状态','操作'];
	var op_arr = [{text:"确认",func:"confirmInfo",index:"pkId"},{text:"删除",func:"delInfo",index:"pkId"}];
	var dataIndex = ['hyCode','bmName','bmCardCode','cfDate','bmCarCode','bmPhone','bmPrice','bmComment','confirmStatusName',op_arr];
	var options = {tableId:'score_list',clientPageId:'pageLimit',url:pageUrl,tableHead:tableHead,dataIndex:dataIndex,params:params};
	ZHW_Page.paging(options);
}

queryPage();

$("#tourEntryAdmin").prev().addClass('active');/*一级  */
$("#tourEntryAdmin").addClass("in");


$("#tourEntryAdmin").addClass('active');/* 二级 */

//确认
function confirmInfo(pkId){
	Ewin.confirm({ message: "确认要操作选择的数据吗？" }).on(
		function (e) { 
			if (!e) return; 
			var url = '<%=basePath%>admin/confirmTourInfo.do';
			var params = {pkId:pkId};
			$.post(url,params,function(result){
				var obj = JSON.parse(result); 
				Ewin.alert({message: obj.msg}).on(function(){
					if(obj.status == 0)	queryPage();
				});
			});
		});	
}
//删除操作
function delInfo(pkId){
	Ewin.confirm({ message: "确认要操作选择的数据吗？" }).on(
		function (e) { 
			if (!e) return; 
			var url = '<%=basePath%>admin/delTourInfo.do';
			var params = {pkId:pkId};
			$.post(url,params,function(result){
				var obj = JSON.parse(result); 
				Ewin.alert({message: obj.msg}).on(function(){
					if(obj.status == 0)	queryPage();
			});
		});
	});	
}

</script>
