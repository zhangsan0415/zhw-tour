<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="menuHead.jsp" %>
<!-- MAIN -->
<div class="main">
	<!-- MAIN CONTENT -->
		<!--lock end-->

		<div class="panel panel-headline demo-icons">
			<div class="panel-heading">
				<h3 class="panel-title">未开通会员</h3>
			</div>
			<div class="panel-body">
				<form action="" class="form-inline">
					会员编号： <input type="text" class="form-control" id="hy_Code"/>
					<button type="button" class="btn btn-info" onclick="queryPage()">查询</button>
				</form>
				<table id="unactived_hy_list" class="table table-striped">
				</table>
				<div id="example" style="text-align: center"> <ul id="pageLimit"></ul> </div>
				  <!-- <button class="btn btn-info">开通会员</button>
                   <button class="btn btn-info">删除会员</button> -->
			</div>
		</div>
	</div>
	<!-- END MAIN -->
	<div class="clearfix"></div>

<%@include file="menuBottom.jsp"%>
<script>

/* 初始化显示分页 */

function ktHy(hyCode) {
	var url = '<%=basePath%>hyManager/ktHyAction.do';
	var params = {hyCode:hyCode};
	$.post(url,params,function(result){
		var obj = JSON.parse(result); 
		Ewin.alert({message: obj.msg}).on(function(){
			if(obj.status == 0)	queryPage();
		});
	});
};
function delHy(hyCode) {
	var url = '<%=basePath%>hyManager/delHyAction.do';
	var params = {hyCode:hyCode};
	$.post(url,params,function(result){
		var obj = JSON.parse(result); 
		Ewin.alert({message: obj.msg}).on(function(){
			if(obj.status == 0)	queryPage();
		});
	});
};
function queryPage() {
	var pageUrl = '<%=basePath%>hyManager/getUnActivedList.do';
	var tableHead = ['会员编号','联系电话','注册时间','投资金额','状态','操作'];
	
	var op_arr = [{text:"开通",func:"ktHy",index:"hyCode"},{text:"删除",func:"delHy",index:"hyCode"}];
	var dataIndex = ['hyCode','sjMobile','zcTime','money','flag',op_arr];
	var params = {hyCode:$("#hy_Code").val().trim()};
	var options = {tableId:'unactived_hy_list',clientPageId:'pageLimit',url:pageUrl,tableHead:tableHead,dataIndex:dataIndex,params:params};
	ZHW_Page.paging(options);
}

queryPage();

$("#subServer").prev().addClass('active');/*一级  */
$("#subServer").addClass("in");
$("#toUnActiveHyList").addClass('active');/* 二级 */
</script>