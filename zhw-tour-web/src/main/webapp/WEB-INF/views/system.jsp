<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="menuHead.jsp" %>
    <!-- MAIN -->
    <div class="main">
        <!-- MAIN CONTENT -->
        <div class="main-content">
            <div  class="panel panel-headline demo-icons">
                <div class="panel-heading">
                    <h3 class="panel-title">系统图</h3>
                </div>
			<!-- START  -->
				<div class="profile-detail">
					<div class="profile-info">
						<ul class="list-unstyled ">
							<li>左区 ：<input class="text-primary" id="zuoqu" value="" readonly="readonly" style="border: 0;background: transparent;"></input></li>
							<li>右区： <input class="text-primary" id="youqu" value="" readonly="readonly" style="border: 0;background: transparent;"></input></li>
							<li><a id='toSignIn' href="<%=basePath%>home/toSignIn.do"class="">注册</a></li>
						</ul>
					</div>
				<!-- END -->
            </div>
        </div>
      </div>
        <!-- END MAIN -->
        <div class="clearfix"></div>

    </div>

<%@include file="menuBottom.jsp" %>

<script src='<%=basePath%>static/assets/scripts/jquery.ztree.core.js'></script>
<script>
$("#subMarket").prev().addClass('active');/*一级  */
$("#subMarket").addClass("in");
$("#toSystem").addClass('active');/* 二级 */
//自动加载数据
function query(){
	var url = "<%=basePath%>person/toSystem.do";
	var params = {"hyCode":""};
	$.post(url,params,function(data){
		var obj = JSON.parse(data);
		if(obj.status==0){
				//赋值
			$("#zuoqu").val(obj.obj.zMoney);
			$("#youqu").val(obj.obj.yMoney);
		};
	});
}
query();
</script>