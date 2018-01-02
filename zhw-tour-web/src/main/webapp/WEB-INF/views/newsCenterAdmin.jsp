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

					新闻名称： <input type="text" class="form-control" id="hyCode"/>
					<button type="button" class="btn btn-info" onclick="query()">查询</button>
				</form>
				<div class='mb20'> 
				<a class='' href="<%=basePath%>home/toNewsCenterDetails.do"> [公司公告]【漫游神湖】一日游</a>
				<a class='a-operation' href="<%=basePath%>home/toNewsCenterDetails.do"><i class='glyphicon glyphicon-pencil'></i>编辑</a>
				<a class='a-operation' href="<%=basePath%>home/toNewsCenterDetails.do"><i class='glyphicon glyphicon-remove'></i>删除</a>
				</div>
				 <button  id="add" class='btn btn-primary'><i class='glyphicon glyphicon-plus'></i>添加</button>
				    
			</div>	
			<!--添加新闻  -->
				<div class='cover'></div>
				<div class='panel-cover'>
					<div class="panel-heading">
						<h3 class="panel-title">添加新闻</h3>
					</div>
					<form  class='form-horizontal'>
						<div class="form-group">
							<label class="col-lg-3 control-label">新闻标题：</label>
							<div class="col-lg-3">
								<input type="text" class="form-control" name="title" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-3 control-label">添加图片：</label>
							<div class="col-lg-3">
								<input type='file' accept="image/*">
							</div>
						</div>
						<div class="col-md-4 col-md-push-2 text-center">
						<button class='btn btn-primary'>添加</button>
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
 })
</script>
