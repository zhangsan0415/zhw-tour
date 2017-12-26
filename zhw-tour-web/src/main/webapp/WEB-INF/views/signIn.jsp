<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="menuHead.jsp" %>
<!-- MAIN -->
<div class="main">
	<!-- MAIN CONTENT -->
	<div class="main-content">
		<div class="panel ">
			<div class="panel-heading">
				<h3 class="panel-title">会员</h3>
			</div>


			<form id="add_hy_form" method="post" class="form-horizontal"
				action="">
				<div class="form-group">
					<label class="col-lg-3 control-label text-danger">所属服务中心：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" name="username"  readonly="readonly"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label text-danger">推荐人：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" name="username"  readonly="readonly" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label text-danger">接点人：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" name="username"  readonly="readonly" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label text-danger">会员编号：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" name="username" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">所在区域：</label>
					<div class="col-lg-2">
						<select name="" class="form-control">
							<option value="0">左区</option>
							<option value="1">右区</option>
						</select>
					</div>
				</div>
				<!-- <legend></legend> -->
				<div class="form-group">
					<label class="col-lg-3 control-label text-danger">一级密码：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" name="username" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label text-danger">确认一级密码：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" name="username" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label text-danger">二级密码：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" name="username" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label text-danger">确认二级密码：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" name="username" />
					</div>
				</div>
				<!-- <legend></legend> -->
				<div class="form-group">
					<label class="col-lg-3 control-label">开户银行：</label>
					<div class="col-lg-2">
						<select name="" id="" class="form-control">
							<option value="">农业银行</option>
							<option value="">工商银行</option>
							<option value="">建设银行</option>
							<option value="">中国银行</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">银行卡号：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" name="username" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">开户姓名：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" name="username" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">开户省市：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" placeholder="省"
							data-stripe="exp-month" />
					</div>
					<div class="col-lg-2">
						<input type="text" class="form-control" placeholder="市"
							data-stripe="exp-year" />
					</div>
				</div>
				<!--  <legend></legend> -->
				<div class="form-group">
					<label class="col-lg-3 control-label">身份证号：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" name="username" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">E-Mail：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" name="username" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">手机号码：</label>
					<div class="col-lg-2">
						<input type="text" class="form-control" name="username" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">申请级别：</label>
					<div class="col-lg-5">
						<div class="radio">
							<label> <input type="radio" name="gender" value="1" />
								1000元
							</label> <label> <input type="radio" name="gender" value="2" />
								5000元
							</label> <label> <input type="radio" name="gender" value="3" />
								8000元
							</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-4 control-label">
						<button class="btn btn-primary">注册</button> <input type="reset"
						class="btn btn-primary" value="重置" />
					</label>
				</div>

			</form>

		</div>
	</div>
	<!-- END MAIN -->
	<div class="clearfix"></div>

</div>
<%@include file="menuBottom.jsp" %>
