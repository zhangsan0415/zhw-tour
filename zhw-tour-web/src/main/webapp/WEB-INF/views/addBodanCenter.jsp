<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="menuHead.jsp"%>
<!-- MAIN -->
<div class="main">
	<!-- MAIN CONTENT -->
	<div class="main-content">
		<!-- RIGHT COLUMN -->
		<div class="container-fluid panel">
		<div class="alert alert-warning alert-dismissible mt10"  role="alert">
				<i class="fa fa-warning"></i> 汇款信息：银行帐号：中国光大银行 银行卡号：6226623700288651 开户名：刘小勇 开户地址：甘肃省兰州七里河支行
			</div>
			<div class="profile-info ">
				<h4 class="heading">报单中心</h4>
				<form id="defaultForm1" method="post" class="form-horizontal" 
				action="#">
				<div class='row text-red'>申请服务中心需缴纳 3000 元，公司补贴 0 元 购物积分（购物积分可以用于系统商城购物）</div>
				<div class="row">
						<div class="col-md-2 text-right line-height-30">会员编号 ：</div>
						<div class="col-md-10 text-left line-height-30">${sessionScope.scoreInfo.bdScore}</div>
						
				        <div class="col-md-2 text-right line-height-30">申请服务中心状态：</div>
						<div class="col-md-10 text-left line-height-30">${sessionScope.scoreInfo.xjScore}</div>
						<div class="col-md-2 text-right line-height-30">申请服务中心时间：</div>
						<div class="col-md-10 text-left line-height-30">${sessionScope.scoreInfo.xjScore}</div>
						<div class="col-md-2 text-right line-height-30">开通服务中心状态：</div>
						<div class="col-md-10 text-left line-height-30">${sessionScope.scoreInfo.xjScore}</div>
						 
						
						<div class="col-md-2 text-right line-height-30" >已汇款金额 ：</div>
						<div class="col-md-10 text-left line-height-30" >
							<input type="text" class="form-control input-sm" id="cz_money" style="width: 20%"/>
						</div>
					<div class="col-md-2 text-right line-height-30" >已汇款到账号 ：</div>
						<div class="col-md-10 text-left line-height-30" >
							<input type="text" class="form-control input-sm" disabled id="cz_account" style="width: 20%"/>
						</div>
						<div class="col-md-2 text-right line-height-30" >汇款时间 ：</div>
						<div class="col-md-10 text-left line-height-30" >
							<input type="text" class="form-control" style="width: 20%" value="6226623700288651"  readonly="readonly"/>
						</div>
					</div>
         	 </form>
          <div class="col-md-3 text-right margin-top-30  padding-bottom-10">
						<input type="button" value="申请" class="btn btn-primary" onclick="recharge()"/>
			</div>
				<div class="row">
					<div class="col-md-12">
						<table class="table table-striped" id="czScore_list">
						</table>
						<div id="example" style="text-align: center"> <ul id="pageLimit"></ul> </div>
					</div>
				</div>
			</div> 
		</div>
	</div>
</div>
			<!-- END RIGHT COLUMN -->

<%@include file="menuBottom.jsp"%>
<script>
//充值按钮
function recharge(){
	var type = $("#selected_id").val();
	var money = $("#cz_money").val();
//	var czTime = $("#time_id").val();
	var url = "<%=basePath%>score/rechargeScore.do";
	var params = {"zzType":type,"zzMoney":money};
	$.post(url,params,function(data){
		var obj = JSON.parse(data);
		Ewin.alert({message: obj.msg}).on(function(){
			if(obj.status==0){
				$(location).attr('href', '<%=basePath%>home/toScoreRecharge.do');
			}
		});
	});
}
/* 初始化显示分页 */
function queryPage(){
	var pageUrl = '<%=basePath%>score/getScoreRecharge.do';
	var tableHead = ['会员编号','汇款金额','汇款类型','汇款时间','汇款账号','状态'];
	var dataIndex = ['hyCode','zzMoney','zzTime','zzType','czStatus'];
	var hyCode = "${sessionScope.scoreInfo.hyCode}";
	var params ={"hyCode":hyCode}
	var options = {tableId:'czScore_list',clientPageId:'pageLimit',url:pageUrl,tableHead:tableHead,dataIndex:dataIndex,params:params};
	ZHW_Page.paging(options);
}

queryPage();


queryPage();
$("#subIntegral").prev().addClass('active');/*一级  */
$("#subIntegral").addClass("in");
$("#toScoreRecharge").addClass('active');/* 二级 */
</script>