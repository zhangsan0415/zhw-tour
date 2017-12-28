<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<%@include file="menuHead.jsp" %>
<!-- MAIN -->
<html lang="en" class="fullscreen-bg">

<body>
<div class="main">
	<!-- MAIN CONTENT -->
	<div class="main-content">
		<div class="panel panel-headline demo-icons">
			<div class="panel-heading">
				<h3 class="lead">修改资料</h3>
			</div>
			<form id="defaultForm" method="post" class="form-horizontal" 
				action="#">
				<div class="form-group" >
					<label class="col-lg-3 control-label">开户银行：</label>
					<div class="col-lg-2">
					<!-- 	<select name="select" id="card-name" class="form-control" >
							<option value="">农业银行</option>
							<option value="">工商银行</option>
							<option value="">建设银行</option>
							<option value="">中国银行</option>
						</select> -->
							<select name="khBankName" id="card-name" class="form-control">
							<c:forEach var="item" items="${requestScope.bankList}">
								<option value="${item.typeCode} }">${item.typeName}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">银行卡号：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" id="card-number" value="${MemberBankInfo.khCardCode}"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">开户姓名：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" id="user-name" value="${MemberBankInfo.khName}"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">开户省市：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" placeholder="省"
							data-stripe="exp-month" id="province-id" value="${MemberBankInfo.khProvince}"/>
					</div>
					<div class="col-lg-2">
						<input type="text" class="form-control" placeholder="市"
							data-stripe="exp-year" id="city-id" value="${MemberBankInfo.khCity}" />
					</div>
				</div>
				<!--  <legend></legend> -->
				<div class="form-group">
					<label class="col-lg-3 control-label">身份证号：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" id="card-id" value="${sessionScope.userInfo.sfzCardCode}" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">E-Mail：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" id="email-id" value="${sessionScope.userInfo.yxEmail}" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">手机号码：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" id="phone-id" value="${sessionScope.userInfo.sjMobile}"/>
					</div>
				</div>
				<div class="form-group" style="margin-left: 30%">
				<button type="button" class="btn btn-primary" onclick="saveHyInfo()">保存</button>
				
				</div>
				
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
</body>
<script type="text/javascript">

//点击保存修改

function saveHyInfo() {
	var cardname = $("#card-name option:selected").text();//开户银行
	var cardnumber = $("#card-number").val();//银行卡号
	var username = $("#user-name").val();//开户姓名
	var province = $("#province-id").val();//开户省
	var city = $("#city-id").val();//开户市
	var card = $("#card-id").val();//身份证号
	var email = $("#email-id").val();//邮箱
	var phone = $("#phone-id").val();//手机号
	var hyCode = "${sessionScope.scoreInfo.hyCode}";//会员编号
	
	var url = "<%=basePath%>person/doModifyInfo.do";
	var params = {"khBankName":cardname,"khCardCode":cardnumber,"khName":username,"khProvince":province,"khCity":city,
			"sfzCardCode":card,"yxEmail":email,"sjMobile":phone,"hyCode":hyCode};
	$.post(
			url,
			params,
			function(result){
				
				var obj = JSON.parse(result);
				if(obj.status != 0){ 
					alert(obj.msg == null ? "系统繁忙，请稍候重试！":obj.msg);
				}else{
					 alert("修改成功！");
				}
	
	});
}

function isEmpty(str){
	if(str == null || str == '') return true;
	return false;
}


$("#subMarket").prev().addClass('active');/*一级  */
$("#subMarket").addClass("in");
$("#toSignIn").addClass('active');/* 二级 */
</script>
</html>
<!-- END WRAPPER -->


		
<%@include file="menuBottom.jsp"%>


