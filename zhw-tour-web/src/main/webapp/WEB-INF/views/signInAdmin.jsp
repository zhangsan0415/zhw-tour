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
			<p style="color:red">申请报单中心需缴纳 3000 元，公司补贴 0 元 购物积分（购物积分可用于系统商城购物）</p>
			<div class="profile-info ">
				<h4 class="heading">申请报单中心</h4>
				<form id="defaultForm1" method="post" class="form-horizontal" action="#" onsubmit="return false">
					<div class="row">
							<div class="col-md-2 text-right line-height-30">会员编号：</div>
							<div class="col-md-10 text-left line-height-30">${sessionScope.userInfo.hyCode}</div>
							
					        <div class="col-md-2 text-right line-height-30">申请服务中心状态：</div>
					        <c:if test="${sessionScope.userInfo.ifBdCenter == 1 }">
							<div class="col-md-10 text-left line-height-30"><p style="color:red">未申请报单中心</p></div>
							</c:if>
							<c:if test="${sessionScope.userInfo.ifBdCenter == 0 }">
							<div class="col-md-10 text-left line-height-30"><p style="color:red">已为报单中心</p></div>
							</c:if>
							<c:if test="${sessionScope.userInfo.ifBdCenter == 2 }">
							<div class="col-md-10 text-left line-height-30"><p style="color:red">申请中</p></div>
							</c:if>
							
							<div class="col-md-2 text-right line-height-30">申请报单中心时间：</div>
							<div class="col-md-10 text-left line-height-30"></div>
							
							<div class="col-md-2 text-right line-height-30">开通报单中心时间：</div>
							<div class="col-md-10 text-left line-height-30"></div>
							
							<div class="col-md-2 text-right line-height-30">已汇款金额：</div>
							<c:if test="${sessionScope.userInfo.ifBdCenter == 1 }">
							<div class="col-md-10 text-left line-height-30"><input type="text"></div>
							</c:if>
							<c:if test="${sessionScope.userInfo.ifBdCenter != 1 }">
							<div class="col-md-10 text-left line-height-30">${requestScope.info.hyCode}</div>
							</c:if>
							
							<div class="col-md-2 text-right line-height-30">已汇款到帐号：</div>
							<div class="col-md-10 text-left line-height-30">6226 6237 0028 8651</div>
							
							<c:if test="${sessionScope.userInfo.ifBdCenter == 1 }">
							<div class="col-md-2 text-right line-height-30">请选择汇款时间：</div>
							<div class="col-md-10 text-left line-height-30"></div>
							</c:if>
							
							<c:if test="${sessionScope.userInfo.ifBdCenter != 1 }">
							<div class="col-md-2 text-right line-height-30">汇款时间：</div>
							<div class="col-md-10 text-left line-height-30">${requestScope.info.hyCode}</div>
							</c:if>
							
							<div class="col-md-2 text-right line-height-30">备注：</div>
							<c:if test="${sessionScope.userInfo.ifBdCenter == 1}">
							<div class="col-md-10 text-left line-height-30"><textarea>${requestScope.info.hyCode}</textarea></div>
							</c:if>
							<c:if test="${sessionScope.userInfo.ifBdCenter != 1}">
							<div class="col-md-10 text-left line-height-30"><textarea readOnly="readOnly">${requestScope.info.hyCode}</textarea></div>
							</c:if>
					</div>
	        	</form>
	         	<div class="col-md-3 text-right margin-top-30  padding-bottom-10">
						<input type="button" value="申请" class="btn btn-primary" onclick="recharge()"/>
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
	var tableHead = ['会员编号','充值金额','充值时间','充值类型','充值状态'];
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