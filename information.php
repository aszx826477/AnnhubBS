<?php 
    #Include data.php and authenticate.php
    include 'modules/class/authenticate.php';
    include 'modules/class/data.php';

    if(check_cookie() == 0) {
        session_start();
        $user_info = get_user_info();
    } else {
        $code = check_cookie();
        header("Location: modules/class/error.php?code=$code");
    }

?>

<!DOCTYPE html>
<html lang="zh">
<head>
	<?php include 'modules/ui/header.php'; ?>
		
	<!-- Table CSS -->
	<link href="dist/css/table.css" rel="stylesheet" type="text/css"/>

	<!--alerts CSS -->
	<link href="vendors/bower_components/sweetalert/dist/sweetalert.css" rel="stylesheet" type="text/css">
		
	<!-- Custom CSS -->
	<link href="dist/css/style.css" rel="stylesheet" type="text/css">
</head>

<body>
	<!--Preloader-->
	<div class="preloader-it">
		<div class="la-anim-1"></div>
	</div>
	<!--/Preloader-->
    <div class="wrapper">
		<?php include 'modules/ui/top_menu_items.php' ?>
		<?php include 'modules/ui/left_sidebar_menu.php' ?>

        <!-- Main Content -->
			<div class="page-wrapper">
				<div class="container-fluid">
					<!-- Title -->
					<div class="row heading-bg  bg-green">
						<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
						  <h5 class="txt-light">信息与设置</h5>
						</div>
					</div>
					<!-- /Title -->
					<!-- Row -->
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default card-view">
							<div class="panel-wrapper collapse in">
								<div class="panel-body">
									<div class="mail-box">
										<div class="row">
											<script>
												function change_password() {
													document.getElementById('set_new_pwd_form').action = "modules/class/user.php?fun=change_password";
												}
												function send_verify_code() {
													document.getElementById('set_new_email_form').action = "modules/class/authenticate.php?fun=send_verify_code";
												}
												function change_email() {
													document.getElementById('set_new_email_form').action = "modules/class/user.php?fun=change_email";
												}
												function change_nickname() {
													document.getElementById('set_new_name_form').action = "modules/class/user.php?fun=change_nickname";
												}
												
											</script>
											
											<aside class="col-md-3">
												<div class="user-head text-center">
													<a class="inbox-avatar block" >
														<img  src="<?php echo $user_info['head_url']; ?>" alt="user" style="width: 80px; height: 80px"/>
													</a>
													<div class="user-name">
														<h5><a> <?php echo $user_info['nickname']; ?> </a></h5>
														<span><a> <?php echo $user_info['email']; ?> </a></span>
													</div>
												</div>
												<div class="clearfix"></div>
												
												<div class="mb-30">
													<div>
														<form id="head_upload_form" method="post" action="" enctype="multipart/form-data">
															<div class="fileupload btn btn-primary btn-anim btn-block ">
																<i class="fa fa-upload"></i>
																<span class="btn-text">选择头像(jpg,大小<1MB)</span>
																<input name="file" id="fileSelector" type="file" class="upload">
															</div>

															<button id="head_upload_btn" type="submit" class="btn btn-success btn-block" title="只允许上传jpg格式的文件">上传</button>
														</form>
													</div>
													


													<div  class="panel-wrapper collapse in">
														<div  class="panel-body">
															<div id="set-new-pwd-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
																<div class="modal-dialog">
																	<div class="modal-content">
																		<div class="modal-header">
																			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
																			<h5 class="modal-title">修改密码</h5>
																		</div>
																		<form id="set_new_pwd_form" action="" method="post">
																			<div class="modal-body">
																				<div class="form-group">
																					<label for="new_pwd" class="control-label mb-10">新密码</label>
																					<input name="password" id="new_pwd" type="text" class="form-control" placeholder="new password(6-16)" minlength="6" maxlength="16">
																				</div>
																				<div class="form-group">
																					<label for="new_pwd_again" class="control-label mb-10" >重复输入新密码</label>
																					<input name="password_again" id="new_pwd_again" type="text" class="form-control" placeholder="new password again(6-16)" minlength="6" maxlength="16">
																				</div>
																			</div>

																			<div class="modal-footer">
																				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
																				<button id="set_new_pwd_button" type="submit" class="btn btn-danger" onclick="change_password()">提交</button>
																			</div>
																		</form>
																	</div>
																</div>
															</div>
															<a alt="default" data-toggle="modal" data-target="#set-new-pwd-modal" title="进行修改密码的操作" class="btn btn-danger btn-block mt-20">
																修改密码
															</a>
														</div>
													</div>	


												</div>												
											</aside>
											
											<aside class="col-md-9">
												<div class="inbox-head  mb-30">
													<div class="row">
														<h3 class="col-sm-3">个人信息</h3>
														<div  class="col-sm-offset-4 col-sm-5">
															<form role="search">
																<div class="input-group mb-15">
																	<input type="text" id="example-input1-group21" name="example-input1-group21" class="form-control" placeholder="Search">
																	 <span class="input-group-btn">
																		<button type="button" class="btn  btn-success"><i class="fa fa-search"></i></button>
																	</span>
																</div>
															</form>
														</div>
													</div>
												</div>
												<div>
													<hr class="mt-25 mb-15"/>
													<table class="table-1" style="width: 100%">
														<tr>
															<th>类别</th>
															<th>信息</th>
														</tr>
														<tr>
															<td>用户名</td>
															<td>
																<div class="panel-wrapper collapse in">
																	<div class="panel-body">
																		<div id="set-new-name-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
																			<div class="modal-dialog">
																				<div class="modal-content" style="text-align: left;">
																					<div class="modal-header">
																						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
																						<h5 class="modal-title">修改用户名</h5>
																					</div>

																					<form id="set_new_name_form" action="" method="post">
																						<div class="modal-body">
																							<div class="form-group">
																								<label for="new_nickname" class="control-label mb-10">新用户名</label>
																								<input name="nickname" id="new_nickname" type="text" class="form-control" placeholder="new nickname(4-16 char needed not space)" minlength="4" maxlength="16">
																							</div>
																						</div>
																						<div class="modal-footer">
																							<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
																							<button id="set_new_name_button" class="btn btn-danger" onclick="change_nickname()">提交</button>
																						</div>
																					</form>
																				</div>
																			</div>
																		</div>
																		<?php echo $user_info['nickname']; ?>
																		<a alt="default" data-toggle="modal" data-target="#set-new-name-modal" class="fa fa-pencil-square-o pull-right" style="padding: 5px">
																			修改
																		</a>
																	</div>
																</div>	
															</td>
														</tr>	
														<tr>
															<td>邮箱</td>
															<td>
																<div class="panel-wrapper collapse in">
																	<div class="panel-body">
																		<div id="set-new-email-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
																			<div class="modal-dialog">
																				<div class="modal-content" style="text-align: left;">
																					<div class="modal-header">
																						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
																						<h5 class="modal-title">修改邮箱</h5>
																					</div>
																					
																					<form id="set_new_email_form" action="" method="post">
																						<div class="modal-body">
																							<div class="form-group">
																								<label for="new_email" class="control-label mb-10">新邮箱</label>
																								<input name="email" id="new_email" type="text" class="form-control" placeholder="new email">
																							</div>
																							<div class="form-group">
																								<label for="new_verify" class="control-label mb-10">验证码</label>
																								<input name="verification_code" id="new_verify" type="text" class="form-control" placeholder="verify code">
																							</div>
																							<button id="new_verify_button" type="submit" class="btn btn-success" onclick="send_verify_code()">将验证码发至邮箱</button>
																						</div>
																						<div class="modal-footer">
																							<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
																							<button id="set_new_email_button" type="submit" class="btn btn-danger" onclick="change_email()">提交</button>
																						</div>
																					</form>
																				</div>
																			</div>
																		</div>
																		<?php echo $user_info['email']; ?>
																		<a alt="default" data-toggle="modal" data-target="#set-new-email-modal" class="fa fa-pencil-square-o pull-right" style="padding: 5px">
																			修改
																		</a>
																	</div>
																</div>	
															</td>
														</tr>	
														<tr>
															<td>注册时间</td>
															<td><?php echo $user_info['register_date']; ?></td>
														</tr>
																		
													</table>
												</div>
											</aside>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- /Row -->
				</div>
			
			
			<?php include 'modules/ui/footer.php'; ?>
			
		</div>
        <!-- /Main Content -->

    </div>
    <!-- /#wrapper -->
	
	<!-- JavaScript -->
		
		<?php include 'modules/ui/js_public.php'; ?>

		<!-- Slimscroll JavaScript -->
		<script src="dist/js/jquery.slimscroll.js"></script>

		<!-- Sweet-Alert  -->
		<script src="vendors/bower_components/sweetalert/dist/sweetalert.min.js"></script>

		<!-- Fancy Dropdown JS -->
		<script src="dist/js/dropdown-bootstrap-extended.js"></script>
				
		<!-- Init JavaScript -->
		<script src="dist/js/init.js"></script>

        <!-- 自定义的js -->
        <script src="dist/js-custom/information-custom.js"></script>

	



</body>
</html>
