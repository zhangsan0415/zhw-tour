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
				action="#">
				<div class="form-group">
					<label class="col-lg-3 control-label text-danger">一级密码：</label>
					<div class="col-lg-2">
						<input type="password" class="form-control" id="firstpwd" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label text-danger">确认一级密码：</label>
					<div class="col-lg-2">
						<input type="password" class="form-control" id="confirmfirstpwd" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label text-danger">二级密码：</label>
					<div class="col-lg-2">
						<input type="password" class="form-control" id="secondpwd"  />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label text-danger">确认二级密码：</label>
					<div class="col-lg-2">
						<input type="password" class="form-control" id="confirmsecondpwd" />
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
//修改密码逻辑
function onSave(){
	var first = $("#firstpwd").val();//一级密码
	var confirmFirst = $("#confirmfirstpwd").val();
	var second = $("#secondpwd").val();
	var confirmSecond = $("#confirmsecondpwd").val();
	var hyCode="${sessionScope.scoreInfo.hyCode}";
	
		//验证通过
		var url = "<%=basePath%>person/doModifyPwd.do";
		var params = {"yjPwd":first,"confimYjPwd":confirmFirst,"ejPwd":second,"confirmEjPwd":confirmSecond,"hyCode":hyCode};
		$.post(url,params,function(data){
			var obj = JSON.parse(data);
			Ewin.alert({message: obj.msg}).on(function(){
				if(obj.status==0){
					document.getElementById("defaultForm").reset();
			
				}
			});
		});
		
	
}
$("#subManage").prev().addClass('active');/*一级  */
$("#subManage").addClass("in");
$("#toModifyPwd").addClass('active');/* 二级 */
</script>
</html>
<%@include file="menuBottom.jsp" %>