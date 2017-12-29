<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class='panel' id='panel1'>
			<div class='panel-heading'>二级密码</div>
			<div class='panel-body'>
				<div class='input-group col-md-3'>
					<input class='form-control' type='text'>
					<span class='input-group-btn'>
						<button id='checkErPwd' class='btn btn-primary'>确定</button>
					</span>
				</div>
			</div>
</div> 
<script>
$("#checkErPwd").bind('click',function (){
	$("#panel1").hide();
	$("#panel2").show();
	pageInit();//新页面内方法
})
</script>