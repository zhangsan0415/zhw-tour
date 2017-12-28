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
                <div class="panel-body">
                    <form action="" class="form-inline">

                        会员编号：
                        <input type="text" class="form-control"/>
                        <button class="btn btn-info">查询</button>
                    </form>
                    <table id="tree" class="table table-striped">

                    </table>
                    <h5 class="text-danger">代理商（1000） 金卡代理商（5000） 钻石代理商（8000）</h5>
                    <h6 >
                        说明：
                        <span class="glyphicon glyphicon-yen text-primary"></span>服务中心
                        <span class="glyphicon glyphicon-yen text-warning"></span>已开通
                        <span class="glyphicon glyphicon-yen text-danger"></span>未开通
                    </h6>
                </div>

            </div>



        </div>
        <!-- END MAIN -->
        <div class="clearfix"></div>

    </div>


<%@include file="menuBottom.jsp" %>
<script>
$("#subMarket").prev().addClass('active');/*一级  */
$("#subMarket").addClass("in");
$("#toRelation").addClass('active');/* 二级 */
</script>