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
				<form action="#" class="form-inline" role="form">
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
					<input id="chufa_date" class="form-control" size="16" type="text" readonly>
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
	var params = {areaType:areaType,tourType:tourType,cfDate:cfDate==null?'':cfDate.trim()};
	var pageUrl = '<%=basePath%>tour/getTourList.do';
	var tableHead = ['姓名','身份证','姓别','户籍','航班号/列车号','电话','收费','出行日期','备注','状态'];
	var dataIndex = ['bmName','bmCardCode','sexName','bmHjAddress','bmCarCode','bmPhone','bmPrice','cfDate','bmComment','confirmStatusName'];
	var options = {tableId:'score_list',clientPageId:'pageLimit',url:pageUrl,tableHead:tableHead,dataIndex:dataIndex,params:params};
	ZHW_Page.paging(options);
}

queryPage();
$("#subEnter").prev().addClass('active');/*一级  */
$("#subEnter").addClass("in");
$("#toViewTourRecord").addClass('active');/* 二级 */
</script>