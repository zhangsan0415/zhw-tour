<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="menuHead.jsp"%>
<!-- MAIN -->
<div class="main">
	<!-- MAIN CONTENT -->
	<div class="main-content">
		<!-- RIGHT COLUMN -->
		<div class="container-fluid panel">
			<div class="profile-info ">
				<h4 class="heading">积分提现</h4>
				<form id="defaultForm" method="post" class="form-horizontal" 
				action="#">
				<div class="row">
						<div class="col-md-2 text-right line-height-30">奖金积分 ：</div>
						<div class="col-md-10 text-left line-height-30">${sessionScope.scoreInfo.jjScore}</div>
						
				        <div class="col-md-2 text-right line-height-30">旅游积分 ：</div>
						<div class="col-md-10 text-left line-height-30">${sessionScope.scoreInfo.lyScore}</div>
						
						<div class="col-md-2 text-right line-height-30">转换类型 ：</div>
					
						<div class="col-md-10 text-left line-height-30">
						<select name="" id="selected" class="form-control" style="width: 20%">
							<option value="1016">提取奖金积分</option>
							<option value="1017">提取旅游积分</option>
						</select>
						</div>
						
						<div class="col-md-2 text-right line-height-30" >提现金额 ：</div>
						<div class="col-md-10 text-left line-height-30" >
							<input type="text" class="form-control input-sm" id="tx_money" style="width: 20%"/>
						</div>
						<div class="col-md-10 text-left  padding-bottom-10 text-danger">
						<h6 class="text-danger">提现手续费 5 %，提现金额倍数为 100 。</h6>
						</div>
					</div>
         	 </form>
          <div class="col-md-3 text-right margin-top-30  padding-bottom-10">
						<input type="button" value="申请提现" class="btn btn-primary" onclick="withdraw()"/>
			</div>
				<div class="row">
					<div class="col-md-12">
				<table class="table table-striped" id="score_list">

						</table>
						<div id="example" style="text-align: center"> <ul id="pageLimit"></ul> </div>
					</div>
				</div>
			</div> 

			<!-- END RIGHT COLUMN -->

			<!-- END MAIN CONTENT -->
		</div>
	</div>
	<!-- END MAIN -->
	<div class="clearfix"></div>
	
</div>
<%@include file="menuBottom.jsp"%>
<script>
//提现按钮
function withdraw(){
	var type = $("#selected").val();
	var money = $("#tx_money").val();
	var url = "<%=basePath%>score/withdrawScore.do";
	var params = {"zzType":type,"zzMoney":money};
	$.post(url,params,function(data){
		var obj = JSON.parse(data);
		Ewin.alert({message: obj.msg}).on(function(){
			if(obj.status==0){
				$(location).attr('href', '<%=basePath%>home/toScoreWithdraw.do');
			}
		});
	});
}
/* 初始化显示分页 */
function queryPage(){
	var pageUrl = '<%=basePath%>score/getScoreWithdraw.do';
	var tableHead = ['会员编号','提现金额','实发金额','提现时间','提现类型','银行卡号','提现类型'];
	var dataIndex = ['hyCode','zzMoney','realMoney','zzTime','zzType','khCardCode','txStatus'];
	var hyCode = "${sessionScope.scoreInfo.hyCode}";
	var params ={"hyCode":hyCode}
	var options = {tableId:'score_list',clientPageId:'pageLimit',url:pageUrl,tableHead:tableHead,dataIndex:dataIndex,params:params};
	ZHW_Page.paging(options);
}
queryPage();

$("#subIntegral").prev().addClass('active');/*一级  */
$("#subIntegral").addClass("in");
$("#toScoreWithdraw").addClass('active');/* 二级 */
</script>
