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
/* 初始化显示分页 */
var pageUrl = '<%=basePath%>hyManager/getActivedList.do';
var tableHead = ['会员编号','联系电话','注册时间','开通时间','投资金额','状态'];
var dataIndex = ['hyCode','sjMobile','zcTime','ktTime','money','flag'];
var params = {hyCode:$("#hy_Code").val().trim()};
var options = {tableId:'actived_hy_list',clientPageId:'pageLimit',url:pageUrl,tableHead:tableHead,dataIndex:dataIndex,params:params};
ZHW_Page.paging(options);

$("#subServer").prev().addClass('active');/*一级  */
$("#subServer").addClass("in");
$("#toUnActiveHyList").addClass('active');/* 二级 */
</script>