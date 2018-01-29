<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="menuHead.jsp" %>
<!-- MAIN -->
<div class="main">
	<!-- MAIN CONTENT -->
	<div class="main-content">
		<div class="panel panel-headline demo-icons">
			<div class="panel-heading">
				<h3 class="panel-title"></h3>
			</div>
			<div class="panel-body">
				<ul class="list-unstyled row">

					<li class="col-md-2 col-sm-4 col-xs-6 text-center"><a
						class="often-use-link" href="<%=basePath%>home/toNewsCenter.do"><span
							class="glyphicon glyphicon-tags award-icon"></span> <span
							class="cssclass">新闻中心</span></a></li>

					<li class="col-md-2 col-sm-4 col-xs-6 text-center"><a
						class="often-use-link" href="<%=basePath%>home/toScoreWithdraw.do"><span
							class="glyphicon glyphicon-usd award-icon"></span> <span
							class="cssclass">提现申请</span></a></li>
					<li class="col-md-2 col-sm-4 col-xs-6 text-center"><a
						class="often-use-link" href="<%=basePath%>home/toRelation.do"><span
							class="glyphicon glyphicon-picture award-icon"></span> <span
							class="cssclass">关系图</span></a></li>
					<%-- <li class="col-md-2 col-sm-4 col-xs-6 text-center"><a
						class="often-use-link" href="<%=basePath%>home/toScoreList.do"><span
							class="glyphicon glyphicon-search award-icon"></span> <span
							class="cssclass">积分查询</span></a></li> --%>
					<li class="col-md-2 col-sm-4 col-xs-6 text-center"><a
						class="often-use-link" href="<%=basePath%>home/toScoreTransfer.do"><span
							class="glyphicon glyphicon-retweet award-icon"></span> <span
							class="cssclass">积分互转</span></a></li>
					<c:if test="${sessionScope.scoreInfo.ifAdmin==0}">
						<li class="col-md-2 col-sm-4 col-xs-6 text-center"><a
							class="often-use-link" href="<%=basePath%>home/toActiveHyAdmin.do"><span
								class="glyphicon glyphicon-user award-icon"></span> <span
								class="cssclass">开通会员</span></a></li>
					</c:if>
					<li class="col-md-2 col-sm-4 col-xs-6 text-center"><a
						class="often-use-link" href="<%=basePath%>home/toSignIn.do"><span
							class="glyphicon glyphicon-plus award-icon"></span> <span
							class="cssclass">注册会员</span></a></li>
				</ul>
			</div>
		</div>

		<div class="awards panel">


			<div class="custom-tabs-line tabs-line-bottom left-aligned">
				<ul class="nav" role="tablist">
					<li class="active"><a href="#tab-bottom-left1" role="tab"
						data-toggle="tab">新闻中心</a></li>
				</ul>
			</div>
			<div class="tab-content">
				<div class="tab-pane fade in active" id="tab-bottom-left1">
					<ul class="list-unstyled activity-timeline">
						<li><span class="glyphicon glyphicon-tag activity-icon"></span>
							<p>
								<a>【公司公告】</a> <a href="#">【漫游神湖】 一日游</a> <span class="timestamp">【2017-01-21】</span>
							</p></li>
						<li><span class="glyphicon glyphicon-tag activity-icon"></span>
							<p>
								<a>【公司公告】</a> <a href="#">【漫游神湖】 一日游</a> <span class="timestamp">【2017-01-21】</span>
							</p></li>
					</ul>

				</div>
			</div>
		</div>

	</div>
	<!-- END MAIN -->
	<div class="clearfix"></div>
</div>
<%@include file="menuBottom.jsp"%>

<script>
$("#toHome").addClass("in");
</script>

