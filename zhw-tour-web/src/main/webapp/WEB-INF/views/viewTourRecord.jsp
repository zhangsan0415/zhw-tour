<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="menuHead.jsp" %>
<!-- MAIN -->
<div class="main">
	<!-- MAIN CONTENT -->
	<div class="main-content">
		<div class="panel panel-headline demo-icons">
			<div class="panel-heading">
				<h3 class="panel-title">报名记录</h3>
			</div>
			<div class="panel-body">
				<form action="" class="form-inline">
					会员编号： <input type="text" class="form-control" id="hy_Code"/>
					<button class="btn btn-info" onclick="queryPage()">查询</button>
				</form>
				<table class="table table-striped" id="score_list">
						</table>
						<div id="example" style="text-align: center"> <ul id="pageLimit"></ul> </div>
			</div>

		</div>
	</div>
	<!-- END MAIN -->
	<div class="clearfix"></div>

</div>
<%@include file="menuBottom.jsp"%>
<script>

/* 初始化显示分页 */
function queryPage(){
	var pageUrl = '<%=basePath%>tour/getTourList.do';
	var tableHead = ['ID','会员编号','行程路线','报名时间','确认时间','查看有课明细','总人数','总费用','状态'];
	var dataIndex = ['pkId','hyCode','zzTime','zzType','czStatus'];
	var params = {hyCode:$("#hy_Code").val().trim()};
	var options = {tableId:'score_list',clientPageId:'pageLimit',url:pageUrl,tableHead:tableHead,dataIndex:dataIndex,params:params};
	ZHW_Page.paging(options);
}

queryPage();
$("#subEnter").prev().addClass('active');/*一级  */
$("#subEnter").addClass("in");
$("#toViewTourRecord").addClass('active');/* 二级 */
</script>