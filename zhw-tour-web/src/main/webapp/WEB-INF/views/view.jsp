<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="menuHead.jsp" %>
<!-- MAIN -->
<div class="main">
	<!-- MAIN CONTENT -->
		<!--lock end-->

		<div class="panel panel-headline demo-icons">
			<div class="panel-heading">
				<h3 class="panel-title">查看</h3>
			</div>
			<div class="panel-body">
				<form action="" class="form-inline">

					会员编号： <input type="text" class="form-control" id="hy_Code"/>
					开通状态：<select name="" id="jh_status" class="form-control">
							<option value="0">已开通</option>
							<option value="1">未开通</option>
						</select>
					<button type="button" class="btn btn-info" onclick="queryPage()">查询</button>
				</form>
			
				<table id="view_list" class="table table-striped">
				</table>
				<div id="example" style="text-align: center"> <ul id="pageLimit"></ul> </div>
			</div>
		</div>
	</div>
	<!-- END MAIN -->
	<div class="clearfix"></div>

<%@include file="menuBottom.jsp"%>
<script>
/* 初始化显示分页 */
function queryPage(){
	var pageUrl = '<%=basePath%>person/getMemeberList.do';
	var tableHead = ['会员编号','联系电话','注册时间','开通状态','投资金额','会员级别'];
	var dataIndex = ['hyCode','sjMobile','zcTime','flag','money','levelName'];
	var params = {hyCode:$("#hy_Code").val().trim(),jhStatus:$("#jh_status").val().trim()};
	var options = {tableId:'view_list',clientPageId:'pageLimit',url:pageUrl,tableHead:tableHead,dataIndex:dataIndex,params:params};
	ZHW_Page.paging(options);
}

queryPage();
$("#subServer").prev().addClass('active');/*一级  */
$("#subServer").addClass("in");
$("#toUnActiveHyList").addClass('active');/* 二级 */
</script>