<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="menuHead.jsp" %>
    <!-- MAIN -->
    <div class="main">
        <!-- MAIN CONTENT -->

        <div class="main-content">
            <div  class="panel panel-headline demo-icons">
                <div class="panel-heading">
                    <h3 class="panel-title">关系图</h3>
                </div>

			<!-- START  -->
 			<div class="panel-body">
 			<table style="border:0;height:600px;align:left;">
				<TR>
					<TD width=260px align=left valign=top >
						<ul id="tree" class="ztree" style="width:260px; overflow:auto;"></ul>
					</TD>
				</TR>
			</table>
				
				<h5 class="text-danger">代理商（1000） 金卡代理商（5000） 钻石代理商（8000）</h5>
                    <h6 >
                        	说明：
                        <span class="glyphicon glyphicon-yen text-primary"></span>服务中心
                        <span class="glyphicon glyphicon-yen text-warning"></span>已开通
                        <span class="glyphicon glyphicon-yen text-danger"></span>未开通
                    </h6>
				</div>
				<!-- END -->
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
$("#toRelation").addClass('active');/* 二级 */


var zTree;
var demoIframe;
/*配置*/
var setting = {
	view: {
		dblClickExpand: false,
		showLine: true,
		selectedMulti: false
	},
	data: {
		simpleData: {
			enable:true,
			idKey: "id",
			pIdKey: "pId",
			rootPId: ""
		}
	},
	callback: {
		beforeClick: function(treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("tree");
			if (treeNode.isParent) {
				zTree.expandNode(treeNode);
				return false;
			} else {
				demoIframe.attr("src",treeNode.file + ".html");
				return true;
			}
		}
	}
};
/*数据*/
var zNodes =[
	{id:1, pId:0, name:"[core] 基本功能 演示", open:true},
	{id:2, pId:0, name:"[core] 基本功能 演示", open:true},
	{id:101, pId:1, name:"最简单的树 --  标准 JSON 数据", file:"core/standardData"},
	{id:102, pId:1, name:"最简单的树 --  简单 JSON 数据", file:"core/simpleData"},
	{id:122, pId:1, name:"33333333", file:"core/otherMouse"},
	{id:423, pId:1, name:"33333333", file:"core/otherMouse"},
	{id:131, pId:423, name:"44444", file:"core/otherMouse"},
	{id:132, pId:131, name:"5555", file:"core/otherMouse"},
];

$(document).ready(function(){
	var url = "<%=basePath%>hyManager/relation.do";
	$.post(url,null,function(data){
		var t = $("#tree");
		t = $.fn.zTree.init(t, setting, JSON.parse(data));
		//t = $.fn.zTree.init(t, setting, zNodes);
		demoIframe = $("#testIframe");
	});

});

</script>