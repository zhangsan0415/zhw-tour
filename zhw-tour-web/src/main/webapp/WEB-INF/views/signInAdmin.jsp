<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="menuHead.jsp" %>

<%@include file="menuBottom.jsp" %>
<script>
$("#adminMember").prev().addClass('active');/*一级  */
$("#adminMember").addClass("in");
$("#toSignInAdmin").addClass('active');/* 二级 */
</script>