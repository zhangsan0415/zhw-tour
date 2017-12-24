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
    <link rel="stylesheet" href="<%=basePath%>static/assets/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=basePath%>static/assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=basePath%>static/assets/vendor/linearicons/style.css">
    <link rel="stylesheet" href="<%=basePath%>static/assets/vendor/chartist/css/chartist-custom.css">
    <!-- MAIN CSS -->
    <link rel="stylesheet" href="<%=basePath%>static/assets/css/main.css">
    <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
    <link rel="stylesheet" href="<%=basePath%>static/assets/css/demo.css">

    <link rel="stylesheet" href="<%=basePath%>static/assets/css/style.css">
    <!-- GOOGLE FONTS -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
    <!-- ICONS -->
    <link rel="apple-touch-icon" sizes="76x76" href="<%=basePath%>static/assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="<%=basePath%>static/assets/img/favicon.png">
</head>

<body>
<!-- WRAPPER -->
<div id="wrapper">
    <!-- NAVBAR -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="brand">
            <a href="home.html">
                <!--<img src="<%=basePath%>static/assets/img/logo-dark.png" alt="Klorofil Logo" class="img-responsive logo">-->
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
                            <img src="<%=basePath%>static/assets/img/user.png" class="img-circle" alt="Avatar">
                            <span>用户名</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
                        <ul class="dropdown-menu">
                            <li><a href="#"><i class="lnr lnr-user"></i> <span>My 修改密码</span></a></li>
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
                        <a href="#subManage" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>个人管理</span>
                            <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                        <div id="subManage" class="collapse ">
                            <ul class="nav">
                                <li><a href="page-profile.html" class="">修改资料</a></li>
                                <li><a href="page-login.html" class="">修改密码</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="#subIntegral" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>积分管理</span>
                            <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                        <div id="subIntegral" class="collapse ">
                            <ul class="nav">
                                <li><a href="page-profile.html" class="">积分查询</a></li>
                                <li><a href="page-login.html" class="">积分明细</a></li>
                                <li><a href="page-lockscreen.html" class="">积分互转</a></li>
                                <li><a href="page-lockscreen.html" class="">充值积分</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="#subMarket" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>市场管理</span>
                            <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                        <div id="subMarket" class="collapse ">
                            <ul class="nav">
                                <li><a href="page-profile.html" class="">会员</a></li>
                                <li><a href="page-login.html" class="">系统图</a></li>
                                <li><a href="page-profile.html" class="">关系图</a></li>
                                <li><a href="page-login.html" class="">查看</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="#subServer" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>市场管理</span>
                            <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                        <div id="subServer" class="collapse ">
                            <ul class="nav">
                                <li><a href="page-profile.html" class="">未开通会员</a></li>
                                <li><a href="page-login.html" class="">已开通会员</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="#subEnter" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>市场管理</span>
                            <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                        <div id="subEnter" class="collapse ">
                            <ul class="nav">
                                <li><a href="page-profile.html" class="">国内旅游报名</a></li>
                                <li><a href="page-login.html" class="">出境旅游报名</a></li>
                                <li><a href="page-login.html" class="">查看报名记录</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="#subEmall" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>积分专区</span>
                            <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                        <div id="subEmall" class="collapse ">
                            <ul class="nav">
                                <li><a href="page-profile.html" class="">积分商场</a></li>
                                <li><a href="page-login.html" class="">查看</a></li>
                                <li><a href="page-lockscreen.html" class="">我的订单</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="#subWords" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>留言管理</span>
                            <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                        <div id="subWords" class="collapse ">
                            <ul class="nav">
                                <li><a href="page-profile.html" class="">收件箱</a></li>
                                <li><a href="page-login.html" class="">发件箱</a></li>
                                <li><a href="page-lockscreen.html" class="">写邮件</a></li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
    <!-- END LEFT SIDEBAR -->
    <!-- MAIN -->
    <div class="main">
        <!-- MAIN CONTENT -->
        <div class="main-content">
            <!-- RIGHT COLUMN -->
            <div class="container-fluid">
             <div class="panel panel-headline">
                 <div class="profile-detail">
                     <div class="profile-info">
                         <h4 class="lead">积分查询</h4>
                         <ul class="list-unstyled ">
                             <li>账户编号 ：<span class="text-primary">SDMHX7981</span></li>
                             <li>推荐人数 ： <span class="text-primary">5人</span></li>
                             <li>会员级别  ：<span class="text-primary">钻石代理商</span></li>
                             <li>累计总积分  ：<span class="text-primary">2451.6</span></li>
                             <li>旅游积分  ：<span class="text-primary">100</span></li>
                             <li>报单积分  ：<span class="text-primary">7200</span></li>
                             <li>购物积分  ：<span class="text-primary">0.00</span></li>
                             <li>现金积分  ：<span class="text-primary">0.00</span></li>
                             <li>报单中心  ：<span class="text-primary">是</span></li>
                         </ul>
                     </div>
                 </div>
             </div>


            </div>
            <!-- END RIGHT COLUMN -->

            <!-- END MAIN CONTENT -->
        </div>
        <!-- END MAIN -->
        <div class="clearfix"></div>
        <footer>
            <div class="container-fluid">
                <p class="copyright">&copy; 2017 会员系统

                </p>
            </div>
        </footer>
    </div>
    <!-- END WRAPPER -->
    <!-- Javascript -->
    <script src="<%=basePath%>static/assets/vendor/jquery/jquery.min.js"></script>
    <script src="<%=basePath%>static/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>static/assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
    <script src="<%=basePath%>static/assets/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js"></script>
    <script src="<%=basePath%>static/assets/vendor/chartist/js/chartist.min.js"></script>
    <script src="<%=basePath%>static/assets/scripts/klorofil-common.js"></script>

</body>

</html>
