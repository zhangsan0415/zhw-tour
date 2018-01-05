<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="menuHead.jsp" %>
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
				<h4 class="heading">积分充值</h4>
				<form id="defaultForm" method="post" class="form-horizontal" 
				action="#">
					<div class="row">
						<%-- <div class="col-md-2 text-right line-height-30">奖金积分 ：</div>
						<div class="col-md-10 text-left line-height-30">${sessionScope.scoreInfo.jjScore}</div> --%>
						<div class="col-md-2 text-right line-height-30">报单积分 ：</div>
						<div class="col-md-10 text-left line-height-30">${sessionScope.scoreInfo.bdScore}</div>
						<div class="col-md-2 text-right line-height-30">购物积分 ：</div>
						<div class="col-md-10 text-left line-height-30">${sessionScope.scoreInfo.gwScore}</div>
				       <%--  <div class="col-md-2 text-right line-height-30">旅游积分 ：</div>
						<div class="col-md-10 text-left line-height-30">${sessionScope.scoreInfo.lyScore}</div> --%>
						<div class="col-md-2 text-right line-height-30">现金积分 ：</div>
						<div class="col-md-10 text-left line-height-30">${sessionScope.scoreInfo.xjScore}</div>
						<div class="col-md-2 text-right line-height-30">购买币种 ：</div>
						<div class="col-md-10 text-left line-height-30">
							<select name="buy" class="form-control" id="tranfer_id"  style="width: 20%" onchange="hideHycode()">
								<option value=''>报单积分</option>
								<option value=''>购物积分</option>
								<option value=''>现金金粉</option>
							</select>
						</div>
						
						<div class="col-md-2 text-right line-height-30 mt10">已汇款到账户 ：</div>
						<div class="col-md-10 text-left line-height-30 mt10">6225210265895214</div>
					
						<div class="col-md-2 text-right line-height-30" >汇款时间：</div>
						<div class="col-md-10 text-left line-height-30" >
							<input type="text" class="form-control input-sm time-input" id="year"/> 年
							<input type="text" class="form-control input-sm time-input" id="month"/> 月
							<input type="text" class="form-control input-sm time-input" id="date"/> 日
							<input type="text" class="form-control input-sm time-input" id="hours"/> 时
							<input type="text" class="form-control input-sm time-input" id="minutes"/> 分
							<input type="text" class="form-control input-sm time-input" id="seconds"/> 秒
							<span class='text-danger'>(请输入汇款时间)</span>
						</div>
					</div>
				</form>
				<div class="col-md-3 text-right margin-top-30  padding-bottom-10">
						<input type="button" value="确认充值" class="btn btn-primary"  onclick="transfer()"/>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>会员编号	</th>
								<th>充值金额</th>
								<th>充值类型</th>
								<th>购买时间</th>
								<th>汇款数额</th>
								<th>汇到账号</th>
								<th>充值状态</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${zzList}" var="item" >
								<tr>
								    <td>${item.hyCode}</td>
								    <td>${item.dfCode}</td>
								    <td >${item.zzTime}</td>
								    <td >${item.zzMoney}</td>
								    <td >${item.zzType}</td>
								  
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

		</div>
	</div>
	<!-- END MAIN -->
	<div class="clearfix"></div>
</div>
<%@include file="menuBottom.jsp" %>
<script>
//给input设置当天时间
var date=new Date();
$("#year").val(date.getFullYear())
$("#month").val((date.getMonth()+1)<10?"0"+(date.getMonth()+1):(date.getMonth()+1))
$("#date").val((date.getDate())<10?"0"+(date.getDate()):(date.getDate()))

//确认充值
function transfer(){
	var type = $("#buy").val(),
		 year = $("#year").val(),
		month = $("#month").val(),
		date=$('#date').val(),
		hours=$("#hours").val(),
		minutes=$('minutes').val(),
		seconds=$('#seconds').val();
		
	
	var url = "<%=basePath%>score/zzScore.do";
	var params = {"type":type,"year":year,"month":month,"date":date,"hours":hours,"minutes":minutes,"seconds":seconds};
	$.post(url,params,function(data){
		var obj = JSON.parse(data);
		Ewin.alert({message: obj.msg}).on(function(){
		});
	});
}
/* 初始化显示分页 */
function queryPage(){
	var pageUrl = '<%=basePath%>hyManager/getActivedList.do';
	var tableHead = ['会员编号','充值金额','充值类型','购买时间','汇款数额','汇到账号','充值状态'];
	var dataIndex = ['hyCode','sjMobile','zcTime','ktTime','money','flag'];
//	var params = {hyCode:$("#hy_Code").val().trim()};
	var params ={hyCode:$("#buy").val()};
	var options = {tableId:'actived_hy_list',clientPageId:'pageLimit',url:pageUrl,tableHead:tableHead,dataIndex:dataIndex,params:params};
	ZHW_Page.paging(options);
}

queryPage();
$("#subIntegral").prev().addClass('active');/*一级  */
$("#subIntegral").addClass("in");
$("#toScoreRecharge").addClass('active');/* 二级 */
</script>