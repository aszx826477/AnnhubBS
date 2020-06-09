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
                        <h5 class="txt-light">安全趋势</h5>
                    </div>
                </div>
                <!-- /Title -->
                
                <!-- Row -->
                <div class="row">
                    <div class="col-lg-7">
                        <div class="panel panel-default card-view">
                            <div class="panel-heading">
                                <div class="pull-left">
                                    <h6 class="panel-title txt-dark"><i class="icon-map mr-10"></i>Annhub安全中心威胁趋势统计</h6>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <div class="panel-wrapper collapse in">
                                <div class="panel-body">
                                    <canvas id="chart_1" height="150"></canvas>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-5">
                         <div class="panel panel-default card-view">
                            <div class="panel-heading">
                                <div class="pull-left">
                                    <h6 class="panel-title txt-dark"><i class="icon-chart mr-10"></i>Annhub安全中心应用威胁统计TOP-10</h6>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <div class="panel-wrapper collapse in">
                                <div class="panel-body">
                                    <canvas id="chart_2" height="250"></canvas>
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
    
    
    <!-- Morris Charts JavaScript -->
  
    
    <!-- ChartJS JavaScript -->
    <script src="vendors/chart.js/Chart.min.js"></script>
    <script src="dist/js/chartjs-data.js"></script>
    
    <!-- Jquery Toast JavaScript -->
    <script src="vendors/bower_components/jquery-toast-plugin/dist/jquery.toast.min.js"></script>
    
    <!-- Init JavaScript -->
    <script src="dist/js/init.js"></script>

</body>
</html>
