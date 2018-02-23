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
						<div class="col-md-2 text-right line-height-30">会员编号：</div>
						<div class="col-md-10 text-left line-height-30">${sessionScope.userInfo.hyCode}</div>
				        
				        <div class="col-md-2 text-right line-height-30">申请服务中心状态：</div>
				        <c:if test="${requestScope.data.ifBdCenter == 1 }">
						<div class="col-md-10 text-left line-height-30"><p style="color:red">未申请报单中心</p></div>
						</c:if>
						<c:if test="${requestScope.data.ifBdCenter == 0 }">
						<div class="col-md-10 text-left line-height-30"><p style="color:red">已为报单中心</p></div>
						</c:if>
						<c:if test="${requestScope.data.ifBdCenter == 2 }">
						<div class="col-md-10 text-left line-height-30"><p style="color:red">申请中</p></div>
						</c:if>
						
						<div class="col-md-2 text-right line-height-30">申请报单中心时间：</div>
						<div class="col-md-10 text-left line-height-30">${requestScope.data.sqTime}</div>
						
						<div class="col-md-2 text-right line-height-30">开通报单中心时间：</div>
						<div class="col-md-10 text-left line-height-30">${requestScope.data.ktTime}</div>
						
						<div class="col-md-2 text-right line-height-30">已汇款金额：</div>
						<c:if test="${requestScope.data.ifBdCenter == 1 }">
						<div class="col-md-10 text-left line-height-30">${requestScope.data.hkAmount}</div>
						</c:if>
						<c:if test="${requestScope.data.ifBdCenter != 1 }">
						<div class="col-md-10 text-left line-height-30">${requestScope.data.hkAmount}</div>
						</c:if>
						
						<div class="col-md-2 text-right line-height-30">已汇款到帐号：</div>
						<div class="col-md-10 text-left line-height-30">6226 6237 0028 8651</div>
						
						<%-- <c:if test="${requestScope.data.ifBdCenter == 1 }"> --%>
						<div class="col-md-2 text-right line-height-30">输入汇款时间：</div>
						<div class="col-md-10 text-left line-height-30"> 
						<input type='text' id='year' class='time-input'>年
						<input type='text' id='month' class='time-input'>月
						<input type='text' id='day' class='time-input'>日
						<input type='text' id='hours' class='time-input'>时
						<input type='text' id='min' class='time-input'>分
						<input type='text' id='seconds' class='time-input'>秒
						 <span class='text-red'>(请输入汇款时间)</span>
					
						
						</div>
						<%-- </c:if> --%>
						
						<%-- <c:if test="${requestScope.data.ifBdCenter != 1 }">
						<div class="col-md-2 text-right line-height-30">汇款时间：</div>
						<div class="col-md-10 text-left line-height-30">${requestScope.data.hkTime}</div>
						</c:if> --%>
						
						<div class="col-md-2 text-right line-height-30">备注：</div>
						<%-- <c:if test="${requestScope.data.ifBdCenter == 1}"> --%>
						<div class="col-md-10 text-left line-height-30"><textarea></textarea></div>
						<%-- </c:if> --%>
						<%-- <c:if test="${requestScope.data.ifBdCenter != 1}">
						<div class="col-md-10 text-left line-height-30"><textarea >${requestScope.data.comment}</textarea></div>
						</c:if> --%>
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

var d=new Date()
$("#year").val(d.getFullYear());
$('#month').val(1+d.getMonth());
$('#day').val(d.getDate());
$('#hours').val(d.getHours());
$('#min').val(d.getMinutes());
$('#seconds').val(d.getSeconds())

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
$("#subServer").prev().addClass('active');/*一级  */
$("#subServer").addClass("in");
$("#applyBdCenter").addClass('active');/* 二级 */
</script>