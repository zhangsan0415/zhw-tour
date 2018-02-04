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
				<table class="table table-striped" id="score_list"></table>
				<div id="example" style="text-align: center"> <ul id="pageLimit"></ul> </div> 
				<%--  <a class='newsList' href="<%=basePath%>home/toNewsCenterDetails.do"> [公司公告]【漫游神湖】一日游</a>
				 <a class='newsList' href="<%=basePath%>home/toNewsCenterDetails.do"> [公司公告]【漫游神湖】一日游</a>
				  <a class='newsList' href="<%=basePath%>home/toNewsCenterDetails.do"> [公司公告]【漫游神湖】一日游</a>
				   <a class='newsList' href="<%=basePath%>home/toNewsCenterDetails.do"> [公司公告]【漫游神湖】一日游</a>  --%>
				    
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

function queryDetail(pkId){
	window.location.href="<%=basePath%>home/toNewsCenterDetails.do?pkId=pkId"
<%-- 	var url = '<%=basePath%>home/toNewsCenterDetails.do';
	var params = {pkId:pkId};
	$.post(url,params,function(result){
		var obj = JSON.parse(result); 
		Ewin.alert({message: obj.msg}).on(function(){
			
		});
	}); --%>

}
function query(){
	var pageUrl = '<%=basePath%>admin/queryNews.do';
	var tableHead = ['公司公告'];
	var op_arr = [{text:"查看",func:"queryDetail",index:"pkId"}];
	var dataIndex = ['newsTitle',op_arr];
//	var title = $('#news_title').val();
	var params = {"newsTitle":""};
	var options = {tableId:'score_list',clientPageId:'pageLimit',url:pageUrl,tableHead:tableHead,dataIndex:dataIndex,params:params};
	ZHW_Page.paging(options);
 }
 query();
</script>