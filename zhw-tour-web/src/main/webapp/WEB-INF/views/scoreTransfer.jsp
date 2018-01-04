<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="menuHead.jsp" %>
<!-- MAIN -->
<div class="main">
	<!-- MAIN CONTENT -->
	<div class="main-content">
		<!-- RIGHT COLUMN -->
		<div class="container-fluid panel">
			<div class="profile-info ">
				<h4 class="heading">积分互转</h4>
				<form id="defaultForm" method="post" class="form-horizontal" 
				action="#">
					<div class="row">
						<div class="col-md-2 text-right line-height-30">奖金积分 ：</div>
						<div class="col-md-10 text-left line-height-30">${sessionScope.scoreInfo.jjScore}</div>
						<div class="col-md-2 text-right line-height-30">报单积分 ：</div>
						<div class="col-md-10 text-left line-height-30">${sessionScope.scoreInfo.bdScore}</div>
						<div class="col-md-2 text-right line-height-30">购物积分 ：</div>
						<div class="col-md-10 text-left line-height-30">${sessionScope.scoreInfo.gwScore}</div>
				        <div class="col-md-2 text-right line-height-30">旅游积分 ：</div>
						<div class="col-md-10 text-left line-height-30">${sessionScope.scoreInfo.lyScore}</div>
						<div class="col-md-2 text-right line-height-30">现金积分 ：</div>
						<div class="col-md-10 text-left line-height-30">${sessionScope.scoreInfo.xjScore}</div>
						<div class="col-md-2 text-right line-height-30">转换类型 ：</div>
						<div class="col-md-10 text-left line-height-30">
							<select name="khBankName" class="form-control" id="tranfer_id"  style="width: 20%" onchange="hideHycode()">
								<c:forEach var="item" items="${requestScope.zzTypeList}">
									<option value="${item.typeCode}">${item.typeName}</option>
								</c:forEach>
							</select>
						</div>
						
						<div class="col-md-2 text-right line-height-30" id="d1">会员编号 ：</div>
						<div class="col-md-10 text-left line-height-30" id="d2">
							<input type="text" class="form-control input-sm" id="hycode" style="width:20% "/>
						</div>
					
						<div class="col-md-2 text-right line-height-30" >金额 ：</div>
						<div class="col-md-10 text-left line-height-30" >
							<input type="text" class="form-control input-sm" id="money" style="width: 20%"/>
						</div>
					</div>
				</form>
				<div class="col-md-3 text-right margin-top-30  padding-bottom-10">
						<input type="button" value="确认转账" class="btn btn-primary"  onclick="transfer()"/>
				</div>
			</div>
<form id="form1" method="post" class="form-horizontal" >
			<div class="row">
				<div class="col-md-12">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>借方会员编号</th>
								<th>贷方会员编号</th>
								<th>时间</th>
								<th>交易额</th>
								<th>类型</th>
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
</form>

		</div>

	</div>
	<!-- END RIGHT COLUMN -->

	<!-- END MAIN CONTENT -->

	<!-- END MAIN -->
	<div class="clearfix"></div>
	<footer>
		<div class="container-fluid">
			<p class="copyright">&copy; 2017 会员系统</p>
		</div>
	</footer>
</div>
<%@include file="menuBottom.jsp" %>

<script>
//根据选择框的值控制会员编号的显示，只有1010转给其他会员时显示
function hideHycode(){
	var type = $("#tranfer_id").val();
	switch(type){
	case '1010':$("#d1,#d2").show(); break;
	case '1011':$("#d1,#d2").hide(); break;
	case '1012':$("#d1,#d2").hide(); break;
	case '1013':$("#d1,#d2").hide(); break;
	case '1014':$("#d1,#d2").hide(); break;
	case '1015':$("#d1,#d2").hide(); break;
	}
	
}
//确认转账
function transfer(){
	var type = $("#tranfer_id").val();
	var dfCode = $("#hycode").val();
	var money = $("#money").val();
	var url = "<%=basePath%>score/zzScore.do";
	var params = {"zzType":type,"dfCode":dfCode,"zzMoney":money};
	$.post(url,params,function(data){
		var obj = JSON.parse(data);
		Ewin.alert({message: obj.msg}).on(function(){
		});
	});
}

$("#subIntegral").prev().addClass('active');/*一级  */
$("#subIntegral").addClass("in");
$("#toScoreTransfer").addClass('active');/* 二级 */
</script>