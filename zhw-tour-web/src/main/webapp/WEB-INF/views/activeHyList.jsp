<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="menuHead.jsp" %>
<!-- MAIN -->
<div class="main">
	<!-- MAIN CONTENT -->

		<!--lock end-->

		<div class="panel panel-headline demo-icons">
			<div class="panel-heading">
				<h3 class="panel-title">已开通会员</h3>
			</div>
			<div class="panel-body">
				<form action="" class="form-inline">

					会员编号： <input type="text" class="form-control" id="hyCode"/>
					<button type="button" class="btn btn-info" onclick="query()">查询</button>
				</form>
			
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
                           <c:forEach items="${openHyList}" var="item" >
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
				<p class="text-center">
					总条数: <span>2</span> 当前页:<span> 1/1 </span> <a href="">快进</a> <a
						href="">尾页</a>
				</p>
				  <div id="example" style="text-align: center"> <ul id="pageLimit"></ul> </div>
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
/* 初始化显示分页 */
  function pageInit(){
	
	  $.ajax(
              {
                 url:'task_list_page',
                 type:'POST',
                  data:{'hyCode':$("#hyCode").val(),'page':1,'count':12},
                 dataType:'JSON',
                 success:function (callback) {
                    var page_count=callback.page_count;
                      var page_cont=callback.page_content;/* table内容 */
                     $('tbody').append(page_cont);
                    $('#last_page').text(page_count)
                 }
             }
     )
}
  pageInit();


/* 分页 */

 $('#pageLimit').bootstrapPaginator({
     currentPage:2,
     totalPages: 5,
     size:"normal",
     bootstrapMajorVersion: 3,
     alignment:"right",
     numberOfPages:8,
     itemTexts: function (type, page, current) {
         switch (type) {
         case "first": return "首页";
         case "prev": return "上一页";
		   case "next": return "下一页";
         case "last": return "末页";
         case "page": return page;
         }//默认显示的是第一页。
     },
         onPageClicked: function (event, originalEvent, type, page){//给每个页眉绑定一个事件，其实就是ajax请求，其中page变量为当前点击的页上的数字。
             $.ajax({
                 url:'/task_list_page/',
                 type:'POST',
                 data:{'hyCode':$("#hyCode").val(),'count':12,'page':page},
                 dataType:'JSON',
                 success:function (callback) {
                         $('tbody').empty();
                         var page_count=callback.page_count;
                         var page_cont=callback.page_content;
                        $('tbody').append(page_cont);
                        $('#last_page').text(page_count)
                     }
             })
         }
 }); 






</script>