<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="menuHead.jsp" %>
<!-- MAIN -->
<div class="main">
	<!-- MAIN CONTENT -->
	<div class="main-content">
		<div class="panel panel-headline demo-icons">
			<div class="panel-heading">
				<h3 class="panel-title" >新闻中心</h3>
			</div>
			<div class='panel-body'> 
				 
				 <a class='newsList' href="<%=basePath%>home/toNewsCenterDetails.do"> [公司公告]【漫游神湖】一日游</a>
				 <a class='newsList' href="<%=basePath%>home/toNewsCenterDetails.do"> [公司公告]【漫游神湖】一日游</a>
				  <a class='newsList' href="<%=basePath%>home/toNewsCenterDetails.do"> [公司公告]【漫游神湖】一日游</a>
				   <a class='newsList' href="<%=basePath%>home/toNewsCenterDetails.do"> [公司公告]【漫游神湖】一日游</a> 
				    
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