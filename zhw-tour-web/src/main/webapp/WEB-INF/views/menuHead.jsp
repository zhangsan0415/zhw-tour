
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
	<title>旅游会员系统</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	
	<!-- VENDOR CSS -->
	<link rel="stylesheet" href="<%=basePath%>static/assets/css/bootstrap.css">
	<!-- MAIN CSS -->
	<link rel="stylesheet" href="<%=basePath%>static/assets/css/main.css">
	<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
<%-- 	<link rel="stylesheet" href="<%=basePath%>static/assets/css/demo.css"> --%>

	<link rel="stylesheet" href="<%=basePath%>static/assets/css/ui.jqgrid.css">
	<link rel="stylesheet" href="<%=basePath%>static/assets/css/jquery-ui-1.8.16.custom.css">

	<link rel="stylesheet" href="<%=basePath%>static/assets/css/style.css">
	<link rel="stylesheet" href="<%=basePath%>static/assets/css/zTreeStyle.css">
	<!-- GOOGLE FONTS -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
	<!-- ICONS -->
	<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
	
	<link rel="stylesheet" href="<%=basePath%>static/assets/css/bootstrapValidator.css"/>
	
	<link href="<%=basePath%>static/assets/css/bootstrap-datetimepicker.min.css" rel="stylesheet" />
	
	<%-- <script src="<%=basePath%>static/assets/scripts/jquery.min.js"></script> --%>
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<script src="<%=basePath%>static/assets/scripts/bootstrap.min.js"></script>
	<script src="<%=basePath%>static/assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="<%=basePath%>static/assets/scripts/klorofil-common.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/assets/scripts/bootstrapValidator.js"></script>

	<script src="<%=basePath%>static/assets/scripts/paginator.js"></script>

	<script type="text/javascript" src="<%=basePath%>static/assets/scripts/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/assets/scripts/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
	
	<script src="<%=basePath%>static/assets/scripts/commonUtils.js"></script>

</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<!-- NAVBAR -->
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="brand">
				<a href="<%=basePath%>login/toHome.do">
					<!--<img src="assets/img/logo-dark.png" alt="Klorofil Logo" class="img-responsive logo">-->
					会员管理系统
				</a>
			</div>
			<div class="container-fluid">
				<div class="navbar-btn">
					<button type="button" class="btn-toggle-fullwidth">
						<!--<i class="lnr lnr-arrow-left-circle"></i>-->
						<span class="glyphicon  glyphicon-option-horizontal" aria-hidden="true"></span>
					</button>
				</div>
				<div id="navbar-menu">
					<ul class="nav navbar-nav navbar-right">
						<%-- <li  class="dropdown">
							<a href="#" class="dropdown-toggle icon-menu" data-toggle="dropdown">
								会员
							</a>
						</li>
						<c:if test="${sessionScope.userInfo.ifBdCenter==0}">
							<li class="dropdown"><a
								href="<%=basePath%>home/toUnActiveHyList.do"
								class="dropdown-toggle icon-menu" data-toggle="dropdown">
									开通会员 </a></li>
						</c:if>
						<li  class="dropdown">
							<a href="<%=basePath%>home/toScoreTransfer.do" class="dropdown-toggle icon-menu" data-toggle="dropdown">
								积分互转
							</a>
						</li>
						<li  class="dropdown">
							<a href="<%=basePath%>home/toScoreWithdraw.do" class="dropdown-toggle icon-menu" data-toggle="dropdown">
								提现申请
							</a>
						</li>
						<li  class="dropdown">
							<a href="#" class="dropdown-toggle icon-menu" data-toggle="dropdown">
								信息反馈
							</a>
						</li> --%>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								<span class="glyphicon glyphicon-user"></span>
								<span>${sessionScope.scoreInfo.hyCode}</span> <span class="glyphicon glyphicon-menu-down"></span></a>
							<ul class="dropdown-menu">
								<li><a href="<%=basePath%>login/logout.do"><i class="lnr lnr-user"></i> <span>退出</span></a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</nav>
		<!-- END NAVBAR -->
		<!-- LEFT SIDEBAR -->
		<div id="sidebar-nav" class="sidebar">
			<div class="sidebar-scroll">
				<dl>
					<dt>
						会员编号：${sessionScope.scoreInfo.hyCode}
					</dt>
					<dt>
						会员级别：${sessionScope.scoreInfo.hyLevelName}
					</dt>
					<dt>
						报单积分：${sessionScope.scoreInfo.bdScore}
					</dt>
					<dt>
						购物积分：${sessionScope.scoreInfo.gwScore}
					</dt>
					<dt>
						旅游积分：${sessionScope.scoreInfo.lyScore}
					</dt>
					<dt>
						奖金积分：${sessionScope.scoreInfo.jjScore}
					</dt>
					<dt>
						现金积分：${sessionScope.scoreInfo.xjScore}
					</dt>
				</dl>
				<nav>
					<ul class="nav">
						<c:if test="${sessionScope.userInfo.ifAdmin!=0}">
							<li id='toHome'><a href="<%=basePath%>login/toHome.do" class=""><i class="lnr lnr-home"></i> <span>系统首页</span></a></li>
							<li><a href="#subManage" data-toggle="collapse"
								class="collapsed "> <span>个人信息管理</span> <span
									class="icon-submenu glyphicon glyphicon-menu-down"></span></a>
								<div id="subManage" class="collapse ">
									<ul class="nav">
										<li><a id='toModifyHyInfo'
											href="<%=basePath%>home/toModifyHyInfo.do" class="">修改资料</a></li>
										<li><a id='toModifyPwd'
											href="<%=basePath%>home/toModifyPwd.do" class="">修改密码</a></li>
									</ul>
								</div></li>

							<li><a href="#subMarket" data-toggle="collapse"
								class="collapsed"><i class="lnr lnr-file-empty"></i> <span>市场管理</span>
									<span class="icon-submenu glyphicon glyphicon-menu-down"></span></a>
								<div id="subMarket" class="collapse ">
									<ul class="nav">
										<li><a id='toSignIn' href="<%=basePath%>home/toSignIn.do"
											class="">注册会员</a></li>
										<li><a id='toSystem' href="<%=basePath%>home/toSystem.do"
											class="">系统图</a></li>
										<li><a id='toRelation'
											href="<%=basePath%>home/toRelation.do" class="">关系图</a></li>
										<c:if test="${sessionScope.userInfo.ifBdCenter!=0}">
											<li><a id='toView' href="<%=basePath%>home/toView.do"
												class="">查看</a></li>
										</c:if> 
										
									</ul>
								</div></li>
							<c:if test="${sessionScope.userInfo.ifBdCenter==0}">
								<li><a href="#subServer" data-toggle="collapse"
									class="collapsed"><i class="lnr lnr-file-empty"></i> <span>报单中心</span>
										<span class="icon-submenu glyphicon glyphicon-menu-down"></span></a>
									<div id="subServer" class="collapse ">
										<ul class="nav">
											<li><a id='toUnActiveHyList'
												href="<%=basePath%>home/toUnActiveHyList.do" class="">未开通会员</a></li>
											<li><a id='toActiveHyList'
												href="<%=basePath%>home/toActiveHyList.do" class="">已开通会员</a></li>
										</ul>
									</div></li>
							</c:if>
							<li><a href="#subEnter" data-toggle="collapse"
								class="collapsed"><i class="lnr lnr-file-empty"></i> <span>旅游报名</span>
									<span class="icon-submenu glyphicon glyphicon-menu-down"></span></a>
								<div id="subEnter" class="collapse ">
									<ul class="nav">
										<li><a id='toInnerTourEntry'
											href="<%=basePath%>home/toInnerTourEntry.do" class="">国内旅游报名</a></li>
										<li><a id='toOuterTourEntry'
											href="<%=basePath%>home/toOuterTourEntry.do" class="">出境旅游报名</a></li>
										<li><a id='toViewTourRecord'
											href="<%=basePath%>home/toViewTourRecord.do" class="">查看报名记录</a></li>
									</ul>
								</div></li>
							<li><a href="#newsCenter" data-toggle="collapse"
								class="collapsed"><i class="lnr lnr-file-empty"></i> <span>新闻公告</span>
									<span class="icon-submenu glyphicon glyphicon-menu-down"></span></a>
								<div id="newsCenter" class="collapse ">
									<ul class="nav">
										<li><a id='toNewsCenter'
											href="<%=basePath%>home/toNewsCenter.do" class="">新闻中心</a></li>
									</ul>
								</div></li>
							<li><a href="#subIntegral" data-toggle="collapse"
								class="collapsed"><i class="lnr lnr-file-empty"></i> <span>积分</span>
									<span class="icon-submenu glyphicon glyphicon-menu-down"></span></a>
								<div id="subIntegral" class="collapse ">
									<ul class="nav">
										<li><a id='toScoreDetail'
											href="<%=basePath%>home/toScoreDetail.do" class="">积分明细</a></li>
										<li><a id='toScoreTransfer'
											href="<%=basePath%>home/toScoreTransfer.do" class="">积分互转</a></li>
										<li><a id='toScoreRecharge'
											href="<%=basePath%>home/toScoreRecharge.do" class="">积分充值</a></li>
										<li><a id='toScoreWithdraw'
											href="<%=basePath%>home/toScoreWithdraw.do" class="">积分提现</a></li>
									</ul>
								</div></li>
						</c:if>
						<%-- <c:if test="${sessionScope.userInfo.ifAdmin==0}"> --%>
							<li>
								<a href="#adminIntegral" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>积分管理</span>
									<span class="icon-submenu glyphicon glyphicon-menu-down"></span></a>
								<div id="adminIntegral" class="collapse ">
									<ul class="nav">
										<li><a id='toScoreRechargeAdmin' href="<%=basePath%>home/toScoreRechargeAdmin.do" class="">积分充值审核</a></li>
										<li><a id='toScoreWithdrawAdmin' href="<%=basePath%>home/toScoreWithdrawAdmin.do" class="">积分提现审核</a></li>
									</ul>
								</div>
							</li>
							<li>
								<a href="#adminMember" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>会员管理</span>
									<span class="icon-submenu glyphicon glyphicon-menu-down"></span></a>
								<div id="adminMember" class="collapse ">
									<ul class="nav">
										<li><a id='toActiveHyAdmin' href="<%=basePath%>home/toActiveHyAdmin.do" class="">开通会员审核</a></li>
										<li><a id='toSignInAdmin' href="<%=basePath%>home/toBdAdmin.do" class="">开通报单中心</a></li>
									</ul>
								</div>
							</li>
							<li >
								<a href="#tourEntryAdmin" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>旅游管理</span>
									<span class="icon-submenu glyphicon glyphicon-menu-down"></span></a>
								<div id="tourEntryAdmin" class="collapse ">
									<ul class="nav">
										<li><a id='toTourItemAdmin' href="<%=basePath%>home/toTourItemAdmin.do" class="">旅游行程管理</a></li>
										<li><a id='toTourConfirmAdmin' href="<%=basePath%>home/tourEntryAdmin.do" class="">旅游报名确认</a></li>
									</ul>
								</div>
							</li>
							
							<li><a   id='toNewsCenterAdmin' href="<%=basePath%>home/toNewsCenterAdmin.do" class=" "><i class="lnr lnr-home"></i> <span>新闻编辑</span></a></li>
						<%-- </c:if> --%>
					</ul>
				</nav>
			</div>
		</div>
		<!-- END LEFT SIDEBAR -->
