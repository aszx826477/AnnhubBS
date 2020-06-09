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
                          <h5 class="txt-light">我的应用</h5>
                        </div>
                    </div>
                    <!-- /Title -->
                    <!-- Row -->
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default card-view">
                                <div class="panel-wrapper collapse in">
                                    <div class="panel-body">
                                        <div class="row">
                                            <div class="col-md-3">
                                                <div class="ibox float-e-margins">
                                                    <div class="ibox-content">
                                                        <div class="file-manager">
                                                            <h5 class="mb-10">文件类型：</h5>
                                                            <a>只允许上传APK文件(<100M)</a>
                                                            
                                                            <form id="file_upload_form" enctype="multipart/form-data" action="modules/class/file.php?fun=upload_app" method="post" target="hidden_iframe">
                                                                <input type="hidden" name="<?php echo ini_get('session.upload_progress.name'); ?>" value="test" />
                                                                <div class="fileupload btn btn-primary btn-anim  mt-30 mb-30"><i class="fa fa-upload"></i><span class="btn-text">选择文件</span>
                                                                    <input name="file" id="fileSelector" type="file" class="upload">
                                                                </div>
                                                                <button id="file_upload_btn" type="submit" class="btn btn-success" title="选择apk后点击上传">上传</button>
                                                            </form>




                                                            <iframe id="hidden_iframe" name="hidden_iframe" src="about:blank" style="display:none;"></iframe>
                                                            <div class="progress progress-lg">
                                                                <div id="progress" class="progress-bar progress-bar-danger" style="width: 0%;" role="progressbar">0%</div>
                                                            </div>




                                                            <h5 class="mb-10">说明：</h6>
                                                            <a>(1)为了防止上传恶意文件，Annhub将会对上传的文件将会进行安全检测</a>
                                                            <br/><br/>
                                                            <a>(2)请保证上传的APK未经过混淆和加密，否则Annhub将无法保证能够提供所述的检测和加固服务</a>
                                                            <br/><br/>
                                                            
                                                            <div class="clearfix"></div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- //php填充部分 -->
                                            
                                            
                                            <div class="col-md-9">
                                                <div class="row">
                                                    <div class="col-lg-12">
                                                        <div class="file-box">
                                                            <div class="file">
                                            
                                                                <div class="icon">
                                                                    <i class="fa fa-file"></i>
                                                                </div>
                                                                <div class="file-name" style="height: 80px">
                                                                    <?php echo get_app_name_demo(); ?>
                                                                    <br>
                                                                    <span> <?php echo get_app_date_demo(); ?></span>
                                                                </div>
                                                                <div class="dropdown">
                                                                    <!-- Single button -->
                                                                    <button class="btn btn-info dropdown-toggle col-xs-12 col-sm-12 col-md-12" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                                        操作
                                                                        <span class="caret"></span>
                                                                    </button>
                                                                    <ul class="dropdown-menu col-xs-12 col-sm-12 col-md-12">
                                                                        <li><a href="<?php echo get_app_demo(); ?>">下载</a></li>
                                                                        <li><a href="<?php echo get_report_demo(); ?>" target="_blank" >查看检测报告</a></li>

                                                                        <li class="divider"></li>
                                                                        <li><a href="<?php echo get_app_protect_demo(); ?>">下载加固包</a></li> 
                                                                        <li class="divider"></li>
                                                                        <li><a href="#">无法移除</a></li>
                                                                    </ul>
                                                                </div>  
                                                            </div>                              
                                                        </div>

                                                        <?php output_app_list(); ?>
                                                    
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
        
        <!--  include 'modules/ui/js_public.php';  -->
        <!-- jQuery -->
<script src="vendors/bower_components/jquery/dist/jquery.min.js"></script>
<script src="dist/js-custom/jquery.form.js"></script>
        
<!-- Bootstrap Core JavaScript -->
<script src="vendors/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

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

        <?php output_btn_script(); ?>

        <!--my-app-custom.js里边是包含了另一部分的js代码，由于下方的js代码中还嵌入了php的代码，所以如果写在单独的js文件里会出现错误-->
        <script src="dist/js-custom/my-app-custom.js"></script>

        <script type="text/javascript">

            function fetch_progress(){
                $.get('modules/class/progress.php',{ '<?php echo ini_get("session.upload_progress.name"); ?>' : 'test'}, function(data){
                    var progress = parseInt(data);
                    $('#progress').html(progress + '%');
                    $('#progress').css('width', progress + '%');
                    if(progress < 100){
                        setTimeout('fetch_progress()', 1000);
                    }
                    if(progress == 100){
                        $('#progress').html('0%');
                        $('#progress').css('width', '0%');
                        swal({   
                            title: "上传成功，正在检验",   
                            //type: "success", 
                            text: "校验成功后，您将会收到提醒，请勿关闭页面",
                            //confirmButtonColor: "#3cb878",
                            //timer: 1000,   
                            showConfirmButton: false 
                        });
                        return false;
                    }
                }, 'html');
            }

          
        </script>

    
</body>
</html>
