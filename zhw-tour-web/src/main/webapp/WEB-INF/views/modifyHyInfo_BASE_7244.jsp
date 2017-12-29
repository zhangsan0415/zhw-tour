<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="menuHead.jsp" %>
<!-- MAIN -->
<div class="main">
	<!-- MAIN CONTENT -->
	<div class="main-content">
		<div class="panel panel-headline demo-icons">
			<div class="panel-heading">
				<h3 class="lead">修改资料</h3>
			</div>
			<form class="panel-body">
				<div class="form-group">
					<label for="exampleInputEmail1">您所填写的手机号（如手机号码有误请与管理员联系）</label> <input
						type="text" class="form-control" id="exampleInputEmail1"
						value="15615677981" disabled="disabled">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1" style="display: block">验证码</label>
					<input type="text" class="form-control" id="exampleInputPassword1"
						style="width: 15%; display: inline-block" placeholder="验证码">

					<button type="button" class="btn btn-default">发送验证码</button>
				</div>

				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
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
<!-- END WRAPPER -->
<%@include file="menuBottom.jsp"%>
<script>
$("#subManage").prev().addClass('active');/*一级  */
$("#subManage").addClass("in");
$("#toModifyHyInfo").addClass('active');/* 二级 */
</script>