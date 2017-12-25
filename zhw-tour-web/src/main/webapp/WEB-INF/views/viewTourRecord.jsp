<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="menuHead.jsp" %>
<!-- MAIN -->
<div class="main">
	<!-- MAIN CONTENT -->
	<div class="main-content">
		<div class="panel panel-headline demo-icons">
			<div class="panel-heading">
				<h3 class="panel-title">报名记录</h3>
			</div>
			<div class="panel-body">
				<form action="" class="form-inline">
					会员编号： <input type="text" class="form-control" />
					<button class="btn btn-info">查询</button>
				</form>
				<table class="table table-striped">
					<thead>
						<tr>
							<td style="width: 6%;">ID</td>
							<td style="width: 12%;">会员编号</td>
							<td style="width: 19%;">行程路线</td>
							<td style="width: 7%;">报名时间</td>
							<td style="width: 10%;">确认时间</td>
							<td style="width: 13%;">查看游客明细</td>
							<td style="width: 15%;">总人数</td>
							<td style="width: 5%;">总费用</td>
							<td style="width: 10%;">状态</td>
						</tr>
					</thead>
					<tbody>
					<tr>
						<td>1</td>
						<td>1</td>
						<td>1</td>
						<td>1</td>
						<td>1</td>
						<td><a>查看游客明细</a></td>
						<td>1</td>
						<td>666</td>
						<td>1</td>

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
	<!-- END MAIN -->
	<div class="clearfix"></div>

</div>
<%@include file="menuBottom.jsp"%>
