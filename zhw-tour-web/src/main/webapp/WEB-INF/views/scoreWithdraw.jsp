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
				<div class="row">
					<div class="col-md-2 text-right padding-bottom-10">奖金积分 ：</div>
					<div class="col-md-10 text-left text-danger padding-bottom-10 ">35.40</div>
					<div class="col-md-2 text-right padding-bottom-10">旅游积分 ：</div>
					<div class="col-md-10 text-left  padding-bottom-10 text-danger">
						0.0.6
						<h6 class="text-danger">提现手续费 5 %，提现金额倍数为 100 。</h6>
					</div>
					<div class="col-md-2 text-right padding-bottom-10">提现类型 ：</div>
					<div class="col-md-10 text-left padding-bottom-10">
						<select name="" id="" class="form-control">
							<option value=""></option>
							<option value="">提取奖金积分</option>
							<option value="">提取旅游积分</option>
						</select>
					</div>
					<div class="col-md-2 text-right padding-bottom-10">提现金额 ：</div>
					<div class="col-md-10 text-left padding-bottom-10">
						<input type="text" class="form-control input-sm" />
					</div>
					<div class="col-md-3 text-right margin-top-30  padding-bottom-10">
						<input type="button" value="申请提现" class="btn btn-primary" />
					</div>
				</div>

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
								<tr>
									<td>1</td>
									<td>2</td>
									<td>3</td>
									<td>4</td>
									<td>5</td>
								</tr>
								<tr>
									<td>1</td>
									<td>2</td>
									<td>3</td>
									<td>4</td>
									<td>5</td>
								</tr>
								<tr>
									<td>1</td>
									<td>2</td>
									<td>3</td>
									<td>4</td>
									<td>5</td>
								</tr>
								<tr>
									<td>1</td>
									<td>2</td>
									<td>3</td>
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
