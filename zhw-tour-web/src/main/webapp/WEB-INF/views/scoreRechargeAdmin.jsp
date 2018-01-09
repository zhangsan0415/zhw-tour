<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="menuHead.jsp" %>
<!-- MAIN -->
<div class="main">
	<!-- MAIN CONTENT -->

		<!--lock end-->

		<div class="panel panel-headline demo-icons">
			<div class="panel-heading">
				<h3 class="panel-title">积分充值审核</h3>
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
	 dialog(conInfo,pkId)
}
function conInfo(pkId){
	var url = '<%=basePath%>manager/conScoreRecharge.do';
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
	 dialog(deleteInfo,pkId)
}
function deleteInfo(pkId){
	var url = '<%=basePath%>manager/delScoreRecharge.do';
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
	var pageUrl = '<%=basePath%>manager/scoreRecharge.do';
	var tableHead = ['会员编号','充值金额','充值时间','充值类型','充值状态','操作'];
	var op_arr = [{text:"确认",func:"confirmInfo",index:"pkId"},{text:"删除",func:"delInfo",index:"pkId"}];
	var dataIndex = ['hyCode','zzMoney','zzTime','zzType','czStatus',op_arr];
	var hyCode = $("#hy_Code").val();
	var status = $("#txstatus").val();
	var params ={"hyCode":hyCode,"czStatus":status};
	var options = {tableId:'score_list',clientPageId:'pageLimit',url:pageUrl,tableHead:tableHead,dataIndex:dataIndex,params:params};
	ZHW_Page.paging(options);
}
queryPage();
//自定义弹窗
function dialog(fun,params){
	  if ($("#myConfirm").length > 0) {
	        $("#myConfirm").remove();
	    } 
	 var html = "<div class='modal fade' id='myConfirm' >"
         + "<div class='modal-backdrop in' style='opacity:0; '></div>"
         + "<div class='modal-dialog' style='z-index:2901; margin-top:60px; width:400px; '>"
         + "<div class='modal-content'>"
     	 + "<div class='modal-header'  style='font-size:16px; '>"
         + "<span class='glyphicon glyphicon-envelope'>&nbsp;</span>提示<button type='button' class='close' data-dismiss='modal'>"
         + "<span style='font-size:20px;  ' class='glyphicon glyphicon-remove'></span><tton></div>" 
         + "<div class='modal-body text-center' id='myConfirmContent' style='font-size:18px; '>"
         + "是否要操作该数据？"
         + "</div>"
         + "<div class='modal-footer ' style=''>"
         + "<button class='btn btn-danger ' id='confirmOk' style='margin-left: 10%'>确定<tton>"
         + "<button class='btn btn-info ' data-dismiss='modal'style='margin-right: 20%'>取消<tton>"
         + "</div>" + "</div></div></div>";
 $("body").append(html);

 $("#myConfirm").modal("show");

 $("#confirmOk").on("click", function() {
     $("#myConfirm").modal("hide");
     fun(params); // 执行函数 
 });
}
$("#adminIntegral").prev().addClass('active');/*一级  */
$("#adminIntegral").addClass("in");
$("#toScoreRechargeAdmin").addClass('active');/* 二级 */
</script>