<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="menuHead.jsp" %>
<div class="main">
	<!-- MAIN CONTENT -->
	<div class="main-content">
		<div class="panel panel-headline demo-icons">
			<div class="panel-heading">
				<h3 class="panel-title">新闻编辑</h3>
			</div>
			
		 	<div class='panel-body'> 
				<form action="" class="form-inline mb20">

					新闻名称： <input type="text" class="form-control" id="news_title"/>
					<button type="button" class="btn btn-info" onclick="query()">查询</button>
				</form>
				<button  id="add" class='btn btn-primary'><i class='glyphicon glyphicon-plus'></i>添加</button>
				<table class="table table-striped" id="score_list"></table>
				<div id="example" style="text-align: center"> <ul id="pageLimit"></ul> </div>
				<%-- <div class='mb20'> 
				<a class='' href="<%=basePath%>home/toNewsCenterDetails.do"> [公司公告]【漫游神湖】一日游</a>
				<a class='a-operation' href="<%=basePath%>home/toNewsCenterDetails.do"><i class='glyphicon glyphicon-pencil'></i>编辑</a>
				<a class='a-operation' href="<%=basePath%>home/toNewsCenterDetails.do"><i class='glyphicon glyphicon-remove'></i>删除</a>
				</div> --%>
				 
				    
			</div>	
			<!--添加新闻  -->
				<div class='cover'></div>
				<div class='panel-cover'>
					<div class="panel-heading">
						<h3 class="panel-title">添加新闻</h3>
					</div>
					<form  class='form-horizontal' id="uploadForm"><!-- enctype="multipart/form-data" -->
						<div class="form-group">
							<label class="col-lg-3 control-label">新闻标题：</label>
							<div class="col-lg-3">
								<input type="text" class="form-control" id="title" name ="newsTitle"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-3 control-label">添加图片：</label>
							<div class="col-lg-3">
								<input type='file' accept="image/*" id="pic_id" name ="picture">
							</div>
						</div>
					<!-- 	<div id="filecheck" class="alert alert-danger"><strong>Warning!</strong>只能上传图片</div> -->
						<div class="col-md-4 col-md-push-2 text-center">
						<button class='btn btn-primary' type="button" onclick="doUpload()">添加</button>
						<span id='close' class='btn btn-primary ml20'>关闭</span>
						</div>
					</form>
				</div>
			<!--/添加新闻  -->
		</div>

	</div>
	<!-- END MAIN -->
	<div class="clearfix"></div>

</div>
<%@include file="menuBottom.jsp" %>
<script>
$("#toNewsCenterAdmin").addClass("in");
/* cover */
$("#add").bind('click',function (){ 
	 $('.cover').show();
	 $('.panel-cover').show();
})
 $('#close').bind('click',function (){
	 $('.cover').hide();
	 $('.panel-cover').hide();
	 $( "#pic_id" ).val("");
	 $("#title").val("");
 })
 $("#toNewsCenterAdmin").addClass("active");
 
 
 //保存
 function doUpload() {  
     var formData = new FormData($( "#uploadForm" )[0]);  
     $.ajax({  
          url: '<%=basePath%>admin/addNews.do' ,  
          type: 'POST',  
          data: formData,  
          async: false,  
          cache: false,  
          contentType: false,  
          processData: false,  
          success: function (data) { 
        	  var obj = JSON.parse(data);
        	  Ewin.alert({message: obj.msg}).on(function(){
        		  $("#pic_id").val("");
        		  $("#title").val("");
  			}); 
          },  
          error: function (data) {  
        	  var obj = JSON.parse(data);
        	  Ewin.alert({message: obj.msg}).on(function(){
  			}); 
          }  
     });  
}  
 //查看明细
 function queryDetail(pkId){
	 
 }
 function delInfo(pkId){
	 //删除
	 
 }
 function query(){
	var pageUrl = '<%=basePath%>admin/queryNews.do';
	var tableHead = ['新闻名称','操作'];
	var op_arr = [{text:"查看",func:"queryDetail",index:"pkId"},{text:"删除",func:"delInfo",index:"pkId"}];
	var dataIndex = ['newsTitle',op_arr];
	var title = $('#news_title').val();
	var params = {"newsTitle":title};
	var options = {tableId:'score_list',clientPageId:'pageLimit',url:pageUrl,tableHead:tableHead,dataIndex:dataIndex,params:params};
	ZHW_Page.paging(options);
 }
 query();
 //删除
</script>
