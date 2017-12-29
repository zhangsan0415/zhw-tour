<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="menuHead.jsp" %>
<div class='main'>
<div class='main-content'>
		<%@include file="erPwd.jsp" %>
		<div class='panel display-none' id='panel2'>
			<div class="panel-heading">
                    <h3 class="panel-title">查看</h3>
            </div>
			<div class="panel-body">
			    <form action="" class="form-inline mb20">
				会员编号：<input type="text" class="form-control" />   
				<button class='btn btn-primary'>查询</button>
				</form>
		 		 <table id="list2" ></table> 
		 		  <div id="pager2"></div>
			</div>
		
		</div>
		 
	</div>	
</div>		
<%@include file="menuBottom.jsp" %>
<script src='<%=basePath%>static/assets/scripts/jquery.jqGrid.src.js'></script>
<script src='<%=basePath%>static/assets/scripts/grid.locale-cn.js'></script>
<script>
$("#subMarket").prev().addClass('active');/*一级  */
$("#subMarket").addClass("in");
$("#toView").addClass('active');/* 二级 */

function pageInit(){
	//创建jqGrid组件
	jQuery("#list2").jqGrid(
			{
				url : 'http://127.0.0.1:8089/api/returnJson',//组件创建完成之后请求数据的url
				datatype : "json",//请求数据返回的类型。可选json,xml,txt
				colNames : [ '会员编号', '联系电话', ' 注册时间', '开通时间', '注册金额','会员级别' ],//jqGrid的列显示名字
				colModel : [ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
				             {name : 'id',index : 'id'}, 
				             {name : 'invdate',index : 'invdate' }, 
				             {name : 'name',index : 'name ' }, 
				             {name : 'amount',index : 'amount' }, 
				             {name : 'tax',index : 'tax' }, 
				             {name : 'total',index : 'total' }
				            
				           ],
				rowNum : 20,//一页显示多少条
				rowList : [ 10, 20, 30 ],//可供用户选择一页显示多少条
				pager : '#pager2',//表格页脚的占位符(一般是div)的id
				 
			
				mtype : "get",//向后台请求数据的ajax的类型。可选post,get
				viewrecords : true,
				autowidth:true
			
			});
	/*创建jqGrid的操作按钮容器*/
	/*可以控制界面上增删改查的按钮是否显示*/
	jQuery("#list2").jqGrid('navGrid', '#pager2', {edit : false,add : false,del : false,search:false,refresh:false});
}

</script>