
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="menuHead.jsp" %>


<html lang="en" class="fullscreen-bg">
<body>

<div class="main">
	<!-- MAIN CONTENT -->
	<div class="main-content">
		<div class="panel panel-headline demo-icons">
			<div class="panel-heading">
				<h3 class="lead">修改密码</h3>
			</div>
			<form id="defaultForm" method="post" class="form-horizontal" 
				action="">
				<div class="form-group">
					<label class="col-lg-3 control-label text-danger">一级密码：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" id="firstpwd" value=""/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label text-danger">确认一级密码：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" id=confirmfirstpwd value="" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label text-danger">二级密码：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" id="secondpwd" value="" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label text-danger">确认二级密码：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" name="confirmsecondpwd" value=""/>
					</div>
				</div>
				<div class="form-group" style="margin-left: 30%">
				<button type="button" class="btn btn-primary" onclick="onSave()">保存</button>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
<script type="text/javascript">
debugger;
//修改密码逻辑
function onSave(){
	var first = $("#firstpwd").val();
	var confirmFirst = $("#confirmfirstpwd").val();
	var second = $("#secondpwd").val();
	var confirmSecond = $("#confirmsecondpwd").val();
	var hyCode="${sessionScope.scoreInfo.hyCode}";
	
	if(first == confirmFirst && second==confirmSecond){
		//验证通过
		var url = "<%=basePath%>person/doModifyPwd.do";
		var params = {"yjPwd":first,"confimYjPwd":confirmFirst,"ejPwd":second,"confirmEjPwd":confirmSecond,"hyCode":hyCode};
		$.post(url,params,function(result){
			var obj = JSON.parse(result);
			if(obj.status != 0){ alert(obj.msg == null ? "系统繁忙，请稍候重试！":obj.msg);  	return;}
			
			 return alert(obj.msg);
		});
		
	}else{
		return alert("");
	}
}

$("#subMarket").prev().addClass('active');/*一级  */
$("#subMarket").addClass("in");
$("#toSignIn").addClass('active');/* 二级 */
</script>
</html>
<%@include file="menuBottom.jsp" %>




