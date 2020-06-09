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
		
	<!--alerts CSS -->
	<link href="vendors/bower_components/sweetalert/dist/sweetalert.css" rel="stylesheet" type="text/css">
	
	<!-- Custom CSS -->
	<link href="dist/css/style.css" rel="stylesheet" type="text/css">

	<!-- xenon-core CSS -->
	<link href="dist/css/nav.css" rel="stylesheet" type="text/css">
	<link href="dist/css/xenon-components.css" rel="stylesheet" type="text/css">
	<link href="dist/css/xenon-core.css" rel="stylesheet" type="text/css">
</head>

<body>
	<!--Preloader-->
	<div class="preloader-it">
		<div class="la-anim-1"></div>
	</div>
	<!--/Preloader-->
    <div class="wrapper">
		<?php include 'modules/ui/top_menu_items.php'; ?>
		<?php include 'modules/ui/left_sidebar_menu.php'; ?>
			

        <!-- Main Content -->
			<div class="page-wrapper">
				<div class="container-fluid">
					<!-- Title -->
					<div class="row heading-bg  bg-green">
						<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
						  <h5 class="txt-light">文档下载</h5>
						</div>
					</div>
					<!-- /Title -->
					<!-- Row -->
					<div class="row">
						<div class="col-md-12">
							<div class="panel panel-default card-view">
								<div class="panel-wrapper collapse in">
									<div class="panel-body">
										<div class="mb-30">
											<div class="row">
												<h3 class="col-sm-3">文档中心</h3>
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
										<hr class="mt-25 mb-15"/>

										<div class="col-sm-3">
                    						<div class="xe-widget xe-conversations box2 label-info" onclick="window.open('document/safety_value_calculate_mode.pdf', '_blank')" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="一种基于指数函数的应用安全系数计算模型.pdf">
                        						<div class="xe-comment-entry">
                            						<a class="xe-user-img">
                                						<img src="dist/img/logos/value.png" class="img-circle" width="40">
                            						</a>
                            						<div class="xe-comment">
                                						<a href="#" class="xe-user-name overflowClip_1">
                                    						<strong>安全系数模型</strong>
                                						</a>
                                						<p class="overflowClip_2">应用安全系数的计算模型的说明文档。</p>
                            						</div>
                        						</div>
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


		<!-- Progressbar Animation JavaScript -->
		<script src="vendors/bower_components/waypoints/lib/jquery.waypoints.min.js"></script>
	
		<!-- Fancy Dropdown JS -->
		<script src="dist/js/dropdown-bootstrap-extended.js"></script>	

		<!-- Init JavaScript -->
		<script src="dist/js/init.js"></script>


	
</body>
</html>
