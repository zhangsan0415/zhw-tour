<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="menuHead.jsp" %>
<!-- MAIN -->
<div class="main">
	<!-- MAIN CONTENT -->

		<!--lock end-->

		<div class="panel panel-headline demo-icons">
			<div class="panel-heading">
				<h3 class="panel-title">会员查询</h3>
			</div>
			<div class="panel-body">
				<form action="" class="form-inline">
					会员编号： 
					<input type="text" class="form-control" id="hy_Code"/>
					开通状态：
					<select id="kt_status" class="form-control">
						<option value=""></option>
						<c:forEach var="item" items="${requestScope.ktStatuses}">
							<option value="${item.typeCode}">${item.typeName}</option>
						</c:forEach>
					</select>
					报单中心：
					<select id="bd_center_query" class="form-control">
						<option value=""></option>
						<c:forEach var="item" items="${requestScope.bdCenters}">
							<option value="${item.typeCode}">${item.typeName}</option>
						</c:forEach>
					</select>
					<button type="button" class="btn btn-info" onclick="queryPage()">查询</button>
				</form>
				<table id="unactived_hy_list" class="table table-striped">
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
function queryPage() {
	var pageUrl = '<%=basePath%>admin/hyInfo.do';
	var tableHead = ['会员编号','推荐人','开通人','联系电话','注册时间','投资金额','开通状态','报单中心'];
	
	var dataIndex = ['hyCode','tjMan','ktMan','sjMobile','zcTime','money','jhStatusName','flag'];
	
	var hyCode = $("#hy_Code").val()==null?'':$("#hy_Code").val().trim();
	var jhStatus = $("#kt_status").val();
	var ifBdCenter = $("#bd_center_query").val();

	var params = {hyCode:hyCode,jhStatus:jhStatus,ifBdCenter:ifBdCenter};
	var options = {tableId:'unactived_hy_list',clientPageId:'pageLimit',url:pageUrl,tableHead:tableHead,dataIndex:dataIndex,params:params};
	ZHW_Page.paging(options);
}

queryPage();
$("#adminMember").prev().addClass('active');/*一级  */
$("#adminMember").addClass("in");
$("#toActiveHyAdmin").addClass('active');/* 二级 */
</script>