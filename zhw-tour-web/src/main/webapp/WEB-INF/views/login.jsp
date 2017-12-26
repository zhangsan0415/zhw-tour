<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en" class="fullscreen-bg">

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<head>
	<title>登录</title>



	<link rel="stylesheet" href="<%=basePath%>static/assets/css/bootstrap.css"/>


	<link rel="stylesheet" href="<%=basePath%>static/assets/vendor/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%=basePath%>static/assets/vendor/linearicons/style.css">
	<link rel="stylesheet" href="<%=basePath%>static/assets/css/main.css">
	<link rel="stylesheet" href="<%=basePath%>static/assets/css/style.css">
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">



	<link rel="stylesheet" href="<%=basePath%>static/assets/css/bootstrapValidator.css"/>
	<script type="text/javascript" src="<%=basePath%>static/assets/scripts/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/assets/scripts/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/assets/scripts/bootstrapValidator.js"></script>
	</head>
	<body>

	<!-- WRAPPER -->
	<div id="wrapper">
		<div class="vertical-align-wrap">
			<div class="vertical-align-middle">
				<div class="auth-box ">
					<div class="left">
						<div class="content">
							<div class="header">
								<!--<div class="logo text-center"><img src="assets/img/logo-dark.png" alt="Klorofil Logo"></div>-->
								<p class="lead">欢迎登陆</p>
							</div>
							<form id="login_form" class="form-auth-small" method="post" action="#">
								<div class="form-group">
									<label for="signin-email" class="control-label sr-only">会员编号</label>
									<input type="text" name="hyCode" class="form-control" id="hy_code" value="" placeholder="会员编号" onblur="checkUserCode(this)"/>
								</div>
								<div class="form-group">
									<label for="signin-password" class="control-label sr-only">密码</label>
									<input type="password" name="password" class="form-control" id="signin-password" value="" placeholder="密码">
								</div>
								<div class="form-group">
									<label for="signin-password" class="control-label sr-only">验证码</label>
									<input type="text" name="checkCode" class="form-control code-input" id="signin-code" value="" placeholder="验证码">
									<img src="<%=basePath%>login/createCheckCode.do?t=Math.random()" alt="" class="codePng" alt="验证码" title="点击刷新" onclick="imageRefresh(this)"/>
								</div>
								<button type="button" onclick="doLogin()" class="btn btn-primary btn-lg btn-block">登录</button>
								<div class="bottom">
									<span class="helper-text"><i class="fa fa-lock"></i> <a href="#">忘记密码?</a></span>
								</div>
							</form>
						</div>
					</div>
					<div class="right">
						<div class="overlay"></div>
						<div class="content text">
							<h1 class="heading">会员管理系统</h1>
							<!--<p>by The Develovers</p>-->
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- END WRAPPER -->

</body>

<script type="text/javascript">
	//点击登录按钮
	function doLogin(){
		var hyCode = $("#hy_code").val();
		var pwd = $("#signin-password").val();
		var checkCode = $("#signin-code").val();
		
		if(isEmpty(hyCode)||isEmpty(pwd)||isEmpty(checkCode)) return;
		
		var url = "<%=basePath%>login/doLogin.do";
		var params = {"hyCode":hyCode,"password":pwd,"checkCode":checkCode};
		$.post(url,params,function(result){
			var obj = JSON.parse(result);
			if(obj.status != 0){ alert(obj.msg == null ? "系统繁忙，请稍候重试！":obj.msg);  	return;}
			
			$(location).attr('href', '<%=basePath%>login/toHome.do');
		});
	}
	
	//验证会员编号是否存在
	function checkUserCode(input){
		var value = input.value;
		if(isEmpty(value))	return;
		var url="<%=basePath%>login/checkHyCode.do";
		$.post(url,{"hyCode":value},function(result){
			var obj = JSON.parse(result);
			if(obj.status != 0) alert(obj.msg == null ? "系统繁忙，请稍候重试！":obj.msg);
		});
	}
	
	//点击刷新验证码
	function imageRefresh(image){
		image.src="<%=basePath%>login/createCheckCode.do?t="+ Math.random();
	}
	
	function isEmpty(str){
		if(str == null || str == '') return true;
		return false;
	}
	
	$(document).ready(function() {
		$('#defaultForm').bootstrapValidator({
			message: '填写不正确',
			feedbackIcons: {
				valid: 'glyphicon glyphicon-ok',
				invalid: 'glyphicon glyphicon-remove',
				validating: 'glyphicon glyphicon-refresh'
			},
			fields: {
			memberCode: {
				message: '无效会员编号',
				validators: {
					notEmpty: {
						message: '会员编号不能为空'
					},
				<%--stringLength: {--%>
					<%--min: 6,--%>
					<%--max: 30,--%>
					<%--message: '用户名长度在6-30之间'--%>
					<%--}--%>
				}
				},
				password: {
					validators: {
					notEmpty: {
						message: '密码不能为空'
						}
					}
				},
				code:{
					validators:{
						notEmpty:{
							messsage:'验证码不能为空'
						}
					}
				}
			}
		});
	 });
</script>


</html>
