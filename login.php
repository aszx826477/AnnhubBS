<?php 

    include 'modules/class/authenticate.php';

    if(check_cookie() == 0) {
        header('Location: manage_index.php');
    }
?>

<!DOCTYPE html>
<html lang="zh">
    <head>
        <?php include 'modules/ui/header.php'; ?>
        
        <!-- vector map CSS -->
        <link href="vendors/bower_components/jasny-bootstrap/dist/css/jasny-bootstrap.min.css" rel="stylesheet" type="text/css"/>

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
        
        <div class="wrapper pa-0" >
        
            <!-- Main Content -->
            
            <div class="page-wrapper pa-0 ma-0">
                <div class="container-fluid">
                    <!-- Row -->
                    
                    <div class="table-struct full-width full-height">
                        <div class="table-cell vertical-align-middle">
                            <div class="auth-form  ml-auto mr-auto no-float">
                                <div>
                                    <img src="dist/img/logo.png" style="height: 100px; width: 135px; position: relative;left: 35%"/>
                                </div>
                                <div class="panel panel-default card-view mb-0">

                                    <div class="panel-heading">
                                        <div class="pull-left">
                                            <h4 class="txt-dark">登录</h4>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="panel-wrapper collapse in">
                                        <div class="panel-body">
                                            <div class="row">
                                                <div class="col-sm-12 col-xs-12">
                                                    <div class="form-wrap">                             
                                                        <form id="login_form" name="login_form" method="post" action="modules/class/authenticate.php?fun=login">
                                                            <div class="form-group">
                                                                <label class="control-label mb-10" for="email">邮箱地址</label>
                                                                <div class="input-group">
                                                                    <input name="email" type="email" class="form-control" required="" id="email" placeholder="email address">
                                                                    <div class="input-group-addon"><i class="icon-envelope-open"></i></div>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="control-label mb-10" for="password">密码</label>
                                                                <div class="input-group">
                                                                    <input name="password" type="password" class="form-control" required="" id="password" placeholder="password">
                                                                    <div class="input-group-addon"><i class="icon-lock"></i></div>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <button id="login_button" class="btn btn-success btn-block">登录</button>
                                                            </div>
                                                            <div class="form-group mb-0">
                                                                <span class="inline-block pr-5">没有账户？</span>
                                                                <a class="inline-block txt-danger" href="signup.php">注册</a>
                                                            </div>  
                                                            <div>
                                                                <a class="txt-danger pull-right" href="index.php">->返回主页</a>
                                                            </div>
                                                        </form>
                                                        
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
                
            </div>
            <!-- /Main Content -->
        
        </div>
        <!-- /#wrapper -->
        
        <!-- JavaScript -->
        
        <!-- jQuery -->
        <script src="vendors/bower_components/jquery/dist/jquery.min.js"></script>
        <script src="dist/js-custom/jquery.form.js"></script>
        
        <!-- Bootstrap Core JavaScript -->
        <script src="vendors/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="vendors/bower_components/jasny-bootstrap/dist/js/jasny-bootstrap.min.js"></script>
        
        <!-- Slimscroll JavaScript -->
        <script src="dist/js/jquery.slimscroll.js"></script>
    
        <!-- Fancy Dropdown JS -->
        <script src="dist/js/dropdown-bootstrap-extended.js"></script>
        
        <!-- Init JavaScript -->
        <script src="dist/js/init.js"></script>

        <!-- Sweet-Alert  -->
        <script src="vendors/bower_components/sweetalert/dist/sweetalert.min.js"></script>


        <!-- 自定义的js -->
        <script src="dist/js-custom/login-custom.js"></script>
    
    </body>
</html>
