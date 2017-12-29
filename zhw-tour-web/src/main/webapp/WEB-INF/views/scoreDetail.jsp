<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="menuHead.jsp" %>
<!-- MAIN -->
<div class="main">
	<!-- MAIN CONTENT -->

		<!--lock end-->

		<div class="panel panel-headline demo-icons">
			<div class="panel-heading">
				<h3 class="panel-title">积分明细</h3>
			</div>
			<div class="anel-body">
				<h4 class="panel-title" style="text-align: right;padding-right: 50px">奖金总计：1000</h4>
			</div>
			<div class="panel-body">
				<form action="" class="form-inline">

					会员编号： <input type="text" class="form-control" id="hyCode"/>
					<button type="button" class="btn btn-info" onclick="query()">查询</button>
				</form>
			
				<table id="list" class="table table-striped">
					 <thead>
                        <tr>
                         
                            <td style="text-align:center;">结算时间</td>
                            <td style="text-align:center;">业务积分</td>
                            <td style="text-align:center;">市场积分</td>
                            <td style="text-align:center;">感恩积分</td>
          
                            <td style="text-align:center;">补助积分</td>
                            <td style="text-align:center;">管理积分</td>
                            <td style="text-align:center;">兑换积分</td>
                            <td style="text-align:center;">实发</td>
                            <td style="text-align:center;">详细</td>
                        </tr>
                        </thead>
                        <tbody>
                           <c:forEach items="${scoreList}" var="item" >
								<tr>
								    <td style="text-align:center;">${item.jsTime}</td>
								    <td style="text-align:center;">${item.ywScore}</td>
								    <td style="text-align:center;">${item.scScore}</td>
								    <td style="text-align:center;">${item.geScore}</td>
								    <td style="text-align:center;">${item.bzScore}</td>
								    <td style="text-align:center;">${item.glScore}</td>
								    <td style="text-align:center;">${item.dhScore}</td>
								    <td style="text-align:center;">${item.sfScore}</td>
								    <td style="text-align:center;">明细</td>
								 
								</tr>
							</c:forEach>
                       </tbody>
				</table>
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
<%--  var hyCode = $("#hyCode").val();

var url = "<%=basePath%>hyManager/doModifyPwd.do";
var params ={"hyCode":hyCode};
$.post(url,params,function(result){
	var obj = JSON.parse(result);
	if(obj.status != 0){
		alert(obj.msg == null ? "系统繁忙，请稍候重试！":obj.msg);  	return;
	}else{
	
		 //清空数据
		 document.getElementById("hyCode").reset();
	}
	 
}); --%>
$("#subServer").prev().addClass('active');/*一级  */
$("#subServer").addClass("in");
$("#toUnActiveHyList").addClass('active');/* 二级 */
</script>