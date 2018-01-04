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
							<input type="text" class="form-control input-sm" id="money" style="width: 20%"/>
						</div>
						<div class="col-md-10 text-left  padding-bottom-10 text-danger">
						<h6 class="text-danger">提现手续费 5 %，提现金额倍数为 100 。</h6>
						</div>
					</div>
				<%-- <div class="row">
					<div class="col-md-2 text-right line-height-30">奖金积分 ：</div>
					<div class="col-md-10 text-left line-height-30">${sessionScope.scoreInfo.jjScore}</div>
					 <div class="col-md-2 text-right line-height-30">旅游积分 ：</div>
					<div class="col-md-10 text-left line-height-30">${sessionScope.scoreInfo.lyScore}</div>
					<div class="col-md-10 text-left  padding-bottom-10 text-danger">
						<h6 class="text-danger">提现手续费 5 %，提现金额倍数为 100 。</h6>
					</div>
					<div class="col-md-2 text-right line-height-30">提现类型 ：</div>
					<div class="col-md-10 text-left line-height-30">
						<select name="" id="selected" class="form-control" style="width: 20%">
							<option value=""></option>
							<option value="1016">提取奖金积分</option>
							<option value="1017">提取旅游积分</option>
						</select>
					</div>
						<div class="col-md-2 text-right line-height-30" >金额 ：</div>
						<div class="col-md-10 text-left line-height-30" >
							<input type="text" class="form-control input-sm" id="money" style="width: 20%"/>
						</div>
					<div class="col-md-3 text-right margin-top-30  padding-bottom-10">
						<input type="button" value="申请提现" class="btn btn-primary" onclick="withdraw()"/>
					</div>
				</div> --%>
          </form>
          <div class="col-md-3 text-right margin-top-30  padding-bottom-10">
						<input type="button" value="申请提现" class="btn btn-primary" onclick="withdraw()"/>
			</div>
				<div class="row">
					<div class="col-md-12">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>会员编号</th>
									<th>提现金额</th>
									<th>实发金额</th>
									<th>提现时间</th>
									<th>提现类型</th>
									<th>银行卡号</th>
									<th>提现状态</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>2</td>
									<td>3</td>
									<td>4</td>
									<td>5</td>
									<td>4</td>
									<td>5</td>
								</tr>
								
							</tbody>
						</table>
						<p class="text-center">
							总条数: <span>2</span> 当前页:<span> 1/1 </span> <a href="">快进</a> <a
								href="">尾页</a>
						</p>
					</div>
				</div>
			</div>

			<!-- END RIGHT COLUMN -->

			<!-- END MAIN CONTENT -->
		</div>
	</div>
	<!-- END MAIN -->
	<div class="clearfix"></div>
	<footer>
		<div class="container-fluid">
			<p class="copyright">&copy; 2017 会员系统</p>
		</div>
	</footer>
</div>
<%@include file="menuBottom.jsp"%>
<script>

//提现按钮
function withdraw(){
	var type = $("#selected").val();
	var money = $("#money").val();
	var url = "<%=basePath%>score/withdrawScore.do";
	var params = {"zzType":type,"zzMoney":money};
	$.post(url,params,function(data){
		var obj = JSON.parse(data);
		Ewin.alert({message: obj.msg}).on(function(){
		});
	});
}

$("#subIntegral").prev().addClass('active');/*一级  */
$("#subIntegral").addClass("in");
$("#toScoreWithdraw").addClass('active');/* 二级 */
</script>