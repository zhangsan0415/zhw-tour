<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="menuHead.jsp" %>
<!-- MAIN -->
<div class="main">
	<!-- MAIN CONTENT -->
		<!--lock end-->
		<div class="panel panel-headline demo-icons">
			<div class="panel-heading">
				<h3 class="panel-title">已开通会员</h3>
			</div>
			<div class="panel-body">
				<form action="#" class="form-inline">

					会员编号： <input type="text" class="form-control" id="hy_Code"/>
					<button type="button" class="btn btn-info" onclick="queryPage()">查询</button>
				</form>
			
				<table id="actived_hy_list" class="table table-striped">
				</table>
				<div id="example" style="text-align: center"> <ul id="pageLimit"></ul> </div>
			</div>
		</div>
	</div>
	<!-- END MAIN -->
	<div class="clearfix"></div>

<%@include file="menuBottom.jsp"%>
<script>
$("#subServer").prev().addClass('active');/*一级  */
$("#subServer").addClass("in");
$("#toActiveHyList").addClass('active');/* 二级 */

/* 初始化显示分页 */
function queryPage(){
	var pageUrl = '<%=basePath%>hyManager/getActivedList.do';
	var tableHead = ['会员编号','联系电话','注册时间','开通时间','投资金额','状态'];
	var dataIndex = ['hyCode','sjMobile','zcTime','ktTime','money','flag'];
	var params = {hyCode:$("#hy_Code").val().trim()};
	var options = {tableId:'actived_hy_list',clientPageId:'pageLimit',url:pageUrl,tableHead:tableHead,dataIndex:dataIndex,params:params};
	ZHW_Page.paging(options);
}

queryPage();
</script>