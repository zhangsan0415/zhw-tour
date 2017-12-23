<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<head>
    <title>会员管理</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!-- VENDOR CSS -->
    <link rel="stylesheet" href="<%=basePath%>static/assets/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>static/assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=basePath%>static/assets/vendor/linearicons/style.css">
    <!--	<link rel="stylesheet" href="assets/vendor/chartist/css/chartist-custom.css">-->
    <!-- MAIN CSS -->
    <link rel="stylesheet" href="<%=basePath%>static/assets/css/main.css">
    <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
    <link rel="stylesheet" href="<%=basePath%>static/assets/css/demo.css">

    <link rel="stylesheet" href="<%=basePath%>static/assets/css/style.css">
    <!-- GOOGLE FONTS -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
    <!-- ICONS -->
    <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
</head>

<body>
<!-- WRAPPER -->
<div id="wrapper">
    <!-- NAVBAR -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="brand">
            <a href="home.html">
                <!--<img src="assets/img/logo-dark.png" alt="Klorofil Logo" class="img-responsive logo">-->
                会员管理系统
            </a>
        </div>
        <div class="container-fluid">
            <div class="navbar-btn">
                <button type="button" class="btn-toggle-fullwidth"><i class="lnr lnr-arrow-left-circle"></i></button>
            </div>
            <div id="navbar-menu">
                <ul class="nav navbar-nav navbar-right">
                    <li  class="dropdown">
                        <a href="#" class="dropdown-toggle icon-menu" data-toggle="dropdown">
                            <i class="lnr lnr-question-circle"></i>
                            会员
                        </a>
                    </li>
                    <li  class="dropdown">
                        <a href="#" class="dropdown-toggle icon-menu" data-toggle="dropdown">
                            <i class="lnr lnr-question-circle"></i>
                            开通会员
                        </a>
                    </li>
                    <li  class="dropdown">
                        <a href="#" class="dropdown-toggle icon-menu" data-toggle="dropdown">
                            <i class="lnr lnr-question-circle"></i>
                            积分互转
                        </a>
                    </li>
                    <li  class="dropdown">
                        <a href="#" class="dropdown-toggle icon-menu" data-toggle="dropdown">
                            <i class="lnr lnr-question-circle"></i>
                            提现申请
                        </a>
                    </li>
                    <li  class="dropdown">
                        <a href="#" class="dropdown-toggle icon-menu" data-toggle="dropdown">
                            <i class="lnr lnr-question-circle"></i>
                            信息反馈
                        </a>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="assets/img/user.png" class="img-circle" alt="Avatar">
                            <span>用户名</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
                        <ul class="dropdown-menu">
                            <li><a href="#"><i class="lnr lnr-user"></i> <span>退出</span></a></li>
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
                    会员编号：SDMHX7981
                </dt>
                <dt>
                    会员级别：钻石代理商
                </dt>
                <dt>
                    报单积分：100.00
                </dt>
                <dt>
                    购物积分：7297.00
                </dt>
                <dt>
                    旅游积分：0.00
                </dt>
                <dt>
                    奖金积分：35.40
                </dt>
                <dt>
                    现金积分：0.00
                </dt>
            </dl>
            <nav>
                <ul class="nav">
                    <li><a href="home.html" class="active"><i class="lnr lnr-home"></i> <span>系统首页</span></a></li>
                    <li>
                        <a href="#subManage" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>个人资料</span>
                            <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                        <div id="subManage" class="collapse ">
                            <ul class="nav">
                                <li><a href="modifyInfo.html" class="">修改资料</a></li>
                                <li><a href="modifPassword.html" class="">修改密码</a></li>
                            </ul>
                        </div>
                    </li>

                    <li>
                        <a href="#subMarket" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>市场管理</span>
                            <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                        <div id="subMarket" class="collapse ">
                            <ul class="nav">
                                <li><a href="member.html" class="">注册会员</a></li>
                                <!--<li><a href="system.html" class="">系统图</a></li>-->
                                <li><a href="relation.html" class="">关系图</a></li>
                                <li><a href="check.html" class="">查看</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="#subServer" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>服务中心</span>
                            <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                        <div id="subServer" class="collapse ">
                            <ul class="nav">
                                <li><a href="activationMember.html" class="">已开通会员</a></li>
                                <li><a href="noActivationMember.html" class="">未开通会员</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="#subEnter" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>旅游报名</span>
                            <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                        <div id="subEnter" class="collapse ">
                            <ul class="nav">
                                <li><a href="userTourismInside.html" class="">国内旅游报名</a></li>
                                <li><a href="userTourismOutside.html" class="">出境旅游报名</a></li>
                                <li><a href="checkUser.html" class="">查看报名记录</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="#newsCenter" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>新闻公告</span>
                            <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                        <div id="newsCenter" class="collapse ">
                            <ul class="nav">
                                <li><a href="userTourismInside.html" class="">新闻中心</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="#subIntegral" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>积分管理</span>
                            <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                        <div id="subIntegral" class="collapse ">
                            <ul class="nav">
                                <li><a href="integralSearch.html" class="">积分查询</a></li>
                                <li><a href="integralDetails.html" class="">积分明细</a></li>
                                <li><a href="integralChange.html" class="">积分互转</a></li>
                                <li><a href="integralRecharge.html" class="">充值积分</a></li>
                                <li><a href="integralApply.html" class="">充值积分</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="#adminIntegral" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>积分</span>
                            <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                        <div id="adminIntegral" class="collapse ">
                            <ul class="nav">
                                <li><a href="adminIntegralRecharge.html" class="">积分充值</a></li>
                                <li><a href="adminIntegralApply.html" class="">积分提现</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="#adminMember" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>会员</span>
                            <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                        <div id="adminMember" class="collapse ">
                            <ul class="nav">
                                <li><a href="adminRegMember.html" class="">注册会员</a></li>
                                <li><a href="adminOpenMember.html" class="">开通会员</a></li>
                            </ul>
                        </div>
                    </li>
                    <li><a href="adminTourReg.html" class=" "><i class="lnr lnr-home"></i> <span>旅游报名</span></a></li>
                    <li><a href="adminNews.html" class=" "><i class="lnr lnr-home"></i> <span>新闻</span></a></li>

                </ul>
            </nav>
        </div>
    </div>
    <!-- END LEFT SIDEBAR -->
    <!-- MAIN -->
    <div class="main">
        <!-- MAIN CONTENT -->
        <div class="main-content">
            <div class="panel panel-headline demo-icons">
                <div class="panel-heading">
                    <h3 class="panel-title">国内旅游报名</h3>
                </div>
                <div class="panel-body">
                    <form action="" class="form-inline">
                        行程：
                        <select name="" id="" class="form-control">
                                 <option value="">北京+天津4天3晚</option>
                                 <option value="">云南6天5晚常规</option>
                                 <option value="">海南5天4晚</option>
                            </select>
                        出团日：
                        <input type="text" class="form-control"/>
                    </form>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th style="width:6%;">序号</th>
                            <th style="width:12%;">姓名</th>
                            <th style="width:19%;">身份证</th>
                            <th style="width:7%;">性别</th>
                            <th style="width:10%;">户籍</th>
                            <th style="width:13%;">航班号/列车号</th>
                            <th style="width:15%;">电话</th>
                            <th style="width:5%;">收费</th>
                            <th style="width:10%;">备注</th>
                        </tr>
                        </thead>
                        <tbdoy>
                            <tr>
                                <td>1</td>
                                <td><input type="text" class="form-control"/></td>
                                <td><input type="text" class="form-control"/></td>
                                <td><select name="" class="form-control">
                                    <option value="">男</option>
                                    <option value="">女</option>
                                </select></td>
                                <td><input type="text" class="form-control"/></td>
                                <td><input type="text" class="form-control"/></td>
                                <td><input type="text" class="form-control"/></td>
                                <td>666</td>
                                <td><input type="text" class="form-control"/></td>

                            </tr>
                        </tbdoy>
                    </table>
                    <button class="btn btn-info">添加一个乘客</button>
                    <button class="btn btn-info">保存</button>
                </div>

            </div>



        </div>
        <!-- END MAIN -->
        <div class="clearfix"></div>

    </div>

</div><!-- END WRAPPER -->
<!-- Javascript basic -->
<script src="<%=basePath%>static/assets/scripts/jquery.min.js"></script>
<script src="<%=basePath%>static/assets/scripts/bootstrap.min.js"></script>
<script src="<%=basePath%>static/assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="<%=basePath%>static/assets/scripts/klorofil-common.js"></script>

</body>

</html>
