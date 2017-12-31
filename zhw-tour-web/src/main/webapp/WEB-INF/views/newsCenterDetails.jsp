<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="menuHead.jsp" %>
<!-- MAIN -->
<div class="main">
	<!-- MAIN CONTENT -->
	<div class="main-content">
		<div class="panel panel-headline demo-icons">
			<div class="panel-heading">
				<h3 class="panel-title">详细内容<a href="<%=basePath%>home/toNewsCenter.do">返回列表</a></h3>
			</div>
			<div class='panel-body'> 
				
				 <img src='<%=basePath%>static/assets/img/news1.jpg'>
			</div>	
		 

		</div>



	</div>
	<!-- END MAIN -->
	<div class="clearfix"></div>

</div>
<%@include file="menuBottom.jsp" %>
<script>
$("#newsCenter").prev().addClass('active');/*一级  */
$("#newsCenter").addClass("in");
$("#toNewsCenter").addClass('active');/* 二级 */
</script>