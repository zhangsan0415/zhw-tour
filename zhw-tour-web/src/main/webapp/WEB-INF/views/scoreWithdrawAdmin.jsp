<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="menuHead.jsp" %>
<!-- MAIN -->
<div class="main">
	<!-- MAIN CONTENT -->

		<!--lock end-->

		<div class="panel panel-headline demo-icons">
			<div class="panel-heading">
				<h3 class="panel-title">积分提现审核</h3>
			</div>
			<div class="panel-body">
				<form action="" class="form-inline">

					会员编号： <input type="text" class="form-control" id="hy_Code"/>
					确认状态：<select name="" id="txstatus" class="form-control">
							<option value=""></option>
							<option value="0">未确认</option>
							<option value="1">已确认</option>
						</select>
					<button type="button" class="btn btn-info" onclick="queryPage()">查询</button>
				</form>
			
				<table id="score_list" class="table table-striped">
				</table>
				<div id="example" style="text-align: center"> <ul id="pageLimit"></ul> </div>
			</div>
		</div>
	</div>
	<!-- END MAIN -->
	<div class="clearfix"></div>

<%@include file="menuBottom.jsp"%>
<script>
//确认信息
function confirmInfo(pkId){
	var url = '<%=basePath%>manager/conScoreWithdraw.do';
	var params = {pkId:pkId};
	$.post(url,params,function(result){
		var obj = JSON.parse(result); 
		Ewin.alert({message: obj.msg}).on(function(){
			if(obj.status == 0)	queryPage();
		});
	});
}

//删除信息
function delInfo(pkId){
	var url = '<%=basePath%>manager/delScoreWithdraw.do';
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
	var pageUrl = '<%=basePath%>manager/scoreWithdraw.do';
	var tableHead = ['会员编号','提现金额','实发金额','提现时间','提现类型','银行卡号','提现类型','操作'];
	var op_arr = [{text:"确认",func:"confirmInfo",index:"pkId"},{text:"删除",func:"delInfo",index:"pkId"}];
	var dataIndex = ['hyCode','zzMoney','realMoney','zzTime','zzType','khCardCode','txStatus',op_arr];
	var hyCode = $("#hy_Code").val();
	var status = $("#txstatus").val();
	var params ={"hyCode":hyCode,"txStatus":status};
	var options = {tableId:'score_list',clientPageId:'pageLimit',url:pageUrl,tableHead:tableHead,dataIndex:dataIndex,params:params};
	ZHW_Page.paging(options);
}
queryPage();


$("#subServer").prev().addClass('active');/*一级  */
$("#subServer").addClass("in");
$("#scoreWithdrawAdmin").addClass('active');/* 二级 */
</script>