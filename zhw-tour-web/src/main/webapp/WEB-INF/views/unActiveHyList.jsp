<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="menuHead.jsp" %>
<!-- MAIN -->
<div class="main">
	<!-- MAIN CONTENT -->

		<!--lock end-->

		<div class="panel panel-headline demo-icons">
			<div class="panel-heading">
				<h3 class="panel-title">未开通会员</h3>
			</div>
			<div class="panel-body">
				<form action="" class="form-inline">

					会员编号： <input type="text" class="form-control" id="hyCode"/>
					<button type="button" class="btn btn-info" onclick="query()">查询</button>
					
				</form>
			<%-- 	<div class="form-group">
					<label class="col-lg-3 control-label">报单积分：100</label>
						<div class="col-lg-2">
							<input type="text" class="form-control" id="card-number" value="${sessionScope.scoreInfo.bdScore}"/>
						</div>
					</div> --%>
				<table id="list" class="table table-striped">
				
					 <thead>
                        <tr>
                         
                            <td style="text-align:center;">会员编号</td>
                            <td style="text-align:center;">联系电话</td>
                            <td style="text-align:center;">注册时间</td>
                            <td style="text-align:center;">开通时间</td>
                            <td style="text-align:center;">投资金额</td>
                            <td style="text-align:center;">状态</td>
                            
                        </tr>
                        </thead>
                        <tbody>
                           <c:forEach items="${noOpenHyList}" var="item" >
								<tr>
								    <td style="text-align:center;">${item.hyCode}</td>
								    <td style="text-align:center;">${item.sjMobile}</td>
								    <td style="text-align:center;">${item.zcTime}</td>
								    <td style="text-align:center;">${item.ktTime}</td>
								    <td style="text-align:center;">${item.money}</td>
								    <td style="text-align:center;">${item.flag}</td>
								</tr>
							</c:forEach>
                       </tbody>
				</table>
				  <button class="btn btn-info">开通会员</button>
                   <button class="btn btn-info">删除会员</button>
				<p class="text-center">
					总条数: <span>2</span> 当前页:<span> 1/1 </span> <a href="">快进</a> <a
						href="">尾页</a>
				</p>
			</div>
		</div>
	</div>
	<!-- END MAIN -->
	<div class="clearfix"></div>

<%@include file="menuBottom.jsp"%>
<script>
 var hyCode = $("#hyCode").val();

var url = "<%=basePath%>person/doModifyPwd.do";
var params ={"hyCode":hyCode};
$.post(url,params,function(result){
	var obj = JSON.parse(result);
	if(obj.status != 0)
		alert(obj.msg == null ? "系统繁忙，请稍候重试！":obj.msg);  	return;
	//清空数据
	document.getElementById("hyCode").reset();
}); 
$("#subServer").prev().addClass('active');/*一级  */
$("#subServer").addClass("in");
$("#toUnActiveHyList").addClass('active');/* 二级 */
</script>