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


	<!-- Morris Charts CSS -->
    <link href="vendors/bower_components/morris.js/morris.css" rel="stylesheet" type="text/css"/>
	<!-- Data table CSS -->
	<link href="vendors/bower_components/datatables/media/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>
	<link href="vendors/bower_components/jquery-toast-plugin/dist/jquery.toast.min.css" rel="stylesheet" type="text/css">

	<!-- Bootstrap table CSS -->
	<link href="vendors/bower_components/bootstrap-table/dist/bootstrap-table.css" rel="stylesheet" type="text/css"/>

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
			<?php include 'modules/ui/top_menu_items.php';?>
			
			<?php include 'modules/ui/left_sidebar_menu.php'; ?>
			
			

        <!-- Main Content -->
		<div class="page-wrapper">
            <div class="container-fluid">
				
				<!-- Title -->
				<div class="row heading-bg  bg-green">
					<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
						<h5 class="txt-light">控制台</h5>
					</div>
				</div>
				
				<!-- /Title -->
				<!-- Row -->
				<div class="row">
					<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
						<div class="panel panel-default card-view">
							<div class="panel-heading">
								<div class="pull-left">
									<h6 class="panel-title txt-dark">全部应用</h6>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="panel-wrapper collapse in">
								<div class="panel-body">
									<div class="sm-graph-box">
										<div class="row">
											<div class="col-xs-6">
												<div class="counter-wrap text-left">
													<span class="counter"> <?php echo $user_info['app_total_num']; ?> </span>
												</div>	
											</div>
											<div class="col-xs-6">
												<i class="fa fa-android" style="font-size: 60px; "> </i>
											</div>
											
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
						<div class="panel panel-default card-view">
							<div class="panel-heading">
								<div class="pull-left">
									<h6 class="panel-title txt-dark" >已加固应用</h6>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="panel-wrapper collapse in">
								<div class="panel-body">
									<div class="sm-graph-box">
										<div class="row">
											<div class="col-xs-6">
												<div class="counter-wrap text-left">
													<span class="counter"> <?php echo $user_info['app_protect_num']; ?> </span>
												</div>	
											</div>
											<div class="col-xs-6">
												<i class="fa fa-lock" style="font-size: 60px; "></i>
											</div>
											
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">	
						<div class="panel panel-default card-view">
							<div class="panel-heading">
								<div class="pull-left">
									<h6 class="panel-title txt-dark">已检测应用</h6>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="panel-wrapper collapse in">
								<div class="panel-body">
									<div class="sm-graph-box">
										<div class="row">
											<div class="col-xs-6">
												<div class="counter-wrap text-left">
													<span class="counter"> <?php echo $user_info['app_scan_num']; ?> </span>
												</div>	
											</div>
											<div class="col-xs-6">
												<i class="fa fa-search" style="font-size: 60px; "></i>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">	
						<div class="panel panel-default card-view">
							<div class="panel-heading">
								<div class="pull-left">
									<h6 class="panel-title txt-dark">应用存在的问题</h6>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="panel-wrapper collapse in">
								<div class="panel-body">
									<div class="sm-graph-box">
										<div class="row">
											<div class="col-xs-6">
												<div class="counter-wrap text-left">
													<span class="counter"> <?php echo $user_info['app_leak_num']; ?> </span>
												</div>	
											</div>
											<div class="col-xs-6">
												<i class="fa fa-bug" style="font-size: 60px; "></i>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- /Row -->
				<!-- Row -->
				<div class="row">
					<div class="col-xs-12">
                        <div class="panel panel-default card-view">
							<div class="panel-heading">
								<div class="pull-left">
									<h6 class="panel-title txt-dark"><i class="icon-map mr-10"></i>我的应用总览</h6>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="panel-wrapper collapse in">
								<div class="panel-body">
									<div class="table-wrap">
										
											<table data-toggle="table">
												<thead>
												  <tr>
													<th>#</th>
													<th>应用名</th>
													<th>高危</th>
													<th>中危</th>
													<th>低危</th>
													<th>警告</th>
													<th>风险总数</th>
													<th>安全评分</th>
													<th>安全等级</th>
													<th>已扫描</th>
													<th>已加固</th>
												  </tr>
												</thead>
												<tbody>

												  <?php output_app_table();?>
												  
												</tbody>
											</table>
										
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
    

	<!-- Data table JavaScript -->
	<script src="vendors/bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
	
	<!-- Slimscroll JavaScript -->
	<script src="dist/js/jquery.slimscroll.js"></script>
	
	<!-- Fancy Dropdown JS -->
	<script src="dist/js/dropdown-bootstrap-extended.js"></script>
	
	
	<!-- Bootstrap-table JavaScript -->
	<script src="vendors/bower_components/bootstrap-table/dist/bootstrap-table.min.js"></script>
	<script src="dist/js/bootstrap-table-data.js"></script>
  
	
	<!-- ChartJS JavaScript -->
	<script src="vendors/chart.js/Chart.min.js"></script>
	<script src="dist/js/chartjs-data.js"></script>
	
	<!-- Jquery Toast JavaScript -->
	<script src="vendors/bower_components/jquery-toast-plugin/dist/jquery.toast.min.js"></script>
	
	<!-- Init JavaScript -->
	<script src="dist/js/init.js"></script>


</body>
</html>
