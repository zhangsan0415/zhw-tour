<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="menuHead.jsp" %>
<!-- MAIN -->
<div class="main">
	<!-- MAIN CONTENT -->
	<div class="main-content">
		<div class="panel ">
			<div class="panel-heading">
				<h3 class="panel-title">会员</h3>
			</div>

			<form id="add_hy_form" role="form" action="#" class="form-horizontal" action="#">
				<div class="form-group">
					<label class="col-lg-3 control-label text-danger">所属报单中心：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" name="fwCenter" value="${sessionScope.userInfo.hyCode}"  readonly="readonly"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label text-danger">推荐人：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" name="tjMan" value="${sessionScope.userInfo.hyCode}"  readonly="readonly"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label text-danger">接点人：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" name="jdMan" value="${requestScope.tjMan}"  readonly="readonly" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label text-danger">会员编号：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" name="hyCode" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">所在区域：</label>
					<div class="col-lg-2">
						<select name="zyArea" class="form-control">
							<option value="0">左区</option>
							<option value="1">右区</option>
						</select>
					</div>
				</div>
				<!-- <legend></legend> -->
				<div class="form-group">
					<label class="col-lg-3 control-label text-danger">一级密码：</label>
					<div class="col-lg-2">
						<input type="password" name="yjPwd" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label text-danger">确认一级密码：</label>
					<div class="col-lg-2">
						<input type="password" class="form-control" name="confimYjPwd" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label text-danger">二级密码：</label>
					<div class="col-lg-2">
						<input type="password" class="form-control" name="ejPwd" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label text-danger">确认二级密码：</label>
					<div class="col-lg-2">
						<input type="password" class="form-control" name="confirmEjPwd" />
					</div>
				</div>
				<!-- <legend></legend> -->
				<div class="form-group">
					<label class="col-lg-3 control-label">开户银行：</label>
					<div class="col-lg-2">
						<select name="khBankName" class="form-control">
							<c:forEach var="item" items="${requestScope.bankList}">
								<option value="${item.typeCode}">${item.typeName}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">银行卡号：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" name="khCardCode" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">开户姓名：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" name="khName" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">开户省市：</label>
					<div class="col-lg-2">
						<select name="khProvince" class="form-control" onchange="getCities(this)">
							<c:forEach var="item" items="${requestScope.provinces}">
								<option value="${item.pkId}">${item.areaName}</option>
							</c:forEach>
						</select>
						<!-- <input type="text" name="khProvince" class="form-control" placeholder="省"
							data-stripe="exp-month" /> -->
					</div>
					<div class="col-lg-2">
						<select id="sign_in_cities" name="khCity" class="form-control">
							<c:forEach var="item" items="${requestScope.cities}">
								<option value="${item.pkId}">${item.areaName}</option>
							</c:forEach>
						</select>
						<%--<input type="text" name="khCity" class="form-control" placeholder="市"
							data-stripe="exp-year" />--%>
					</div>
				</div>
				<!--  <legend></legend> -->
				<div class="form-group">
					<label class="col-lg-3 control-label">身份证号：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" name="sfzCardCode" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">E-Mail：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" name="yxEmail" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">手机号码：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" name="sjMobile" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">申请级别：</label>
					<div class="col-lg-5">
						<div class="radio">
							<label> <input type="radio" name="hyLevel" value="1" />
								1000元
							</label> <label> <input type="radio" name="hyLevel" value="2" />
								5000元
							</label> <label> <input type="radio" name="hyLevel" value="3" />
								8000元
							</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-4 control-label">
						<input type="button" class="btn btn-primary" onclick="registerHyCode(this)" value="注册" data-toggle="popover"/>
						<!-- <button id="hy_mem_register" >注册</button>  -->
						<input type="reset" class="btn btn-primary" value="重置" />
					</label>
				</div>

			</form>

		</div>
	</div>
	<!-- END MAIN -->
	<div class="clearfix"></div>
</div>

<%@include file="menuBottom.jsp" %>

<script type="text/javascript">
/* 点击注册按钮 */
function registerHyCode(btn){
	var url = "<%=basePath%>hyManager/addHy.do";
	var params = $("#add_hy_form").serialize();
	$.post(url,params,function(data){
		var obj = JSON.parse(result);
		$(btn).alert(obj.msg)
	});
	
	
	
}
/* 获取城市列表 */
function getCities(obj){
	var citySelector =  $("#sign_in_cities");
	$("option",citySelector).remove(); //清空原有的选项 
	var url = "<%=basePath%>hyManager/getCities.do";
	var params = {"provinceId":obj.value};
	$.post(url,params,function(result){
		var obj = JSON.parse(result);
		if(obj.status != 0)	return;
		$.each(obj.obj,function(index,item){
			var option = "<option value='" + item['pkId'] + "'>" + item['areaName'] + "</option>";
			citySelector.append(option);
		});
		
	});
}

$("#subMarket").prev().addClass('active');/*一级  */
$("#subMarket").addClass("in");
$("#toSignIn").addClass('active');/* 二级 */
</script>
