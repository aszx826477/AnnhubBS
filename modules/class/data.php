<?php 
    include_once "utils.php";

    //获取demoy的相关参数
    function get_app_name_demo() {
        include 'conf.php';
        return $app_name_demo;
    }
    function get_app_date_demo() {
        include 'conf.php';
        return $app_date_demo;
    }
    function get_app_demo() {
        include 'conf.php';
        return $app_demo;
    }
    function get_report_demo() {
        include 'conf.php';
        return $report_demo;
    }
    function get_report_pdf_demo() {
        include 'conf.php';
        return $report_pdf_demo;
    }
    function get_app_protect_demo() {
        include 'conf.php';
        return $app_protect_demo;
    }
    function get_report_protect_demo() {
        include 'conf.php';
        return $report_protect_demo;
    }
    function get_report_protect_pdf_demo() {
        include 'conf.php';
        return $report_protect_pdf_demo;
    }

    //获取用户信息
    function get_user_info() {
        $post_url = "http://www.annhub.cn/php/user/user_info_get.php";
        $curl_timeout = 3;
        $email = explode(' ', $_COOKIE['Annhub'])[0];
        $post = [
            "email" => $email
        ];
        $cookie = $_COOKIE['Annhub'];
        $header = [
            "Cookie: Annhub=$cookie"
        ];

        $res = send_post($post_url, $header, $post);
        $state_message = $res['state_message'];

        if($state_message == 0) {       
            $app_total_num = $res['info']['file_num'];
            $app_protect_num = $res['info']['file_protected_num'];
            $app_scan_num = $res['info']['file_scan_num'];
            $app_leak_num = $res['info']['file_leak_num'];
            $nickname = $res['info']['nickname'];
            $register_date = $res['info']['register_date'];
            $head_url = $res['info']['head_url'];

            $user_info = array(
                'app_total_num' => $app_total_num, 
                'app_protect_num' => $app_protect_num,
                'app_scan_num' => $app_scan_num,
                'app_leak_num' => $app_leak_num,
                'nickname' => $nickname,
                'register_date' => $register_date,
                'head_url' => $head_url,
                'email' => $email);

            return $user_info;
        } 

    }

    //输出manage_index的table列表
    function output_app_table() {
        
        $post_url = "http://www.annhub.cn/php/data/table_info_get.php";
        $curl_timeout = 3;
        $email = explode(' ', $_COOKIE['Annhub'])[0];
        $cookie = $_COOKIE['Annhub'];
        $header = [
            "Cookie: Annhub=$cookie"
        ];

        $res = send_post($post_url, $header, null);
        $state_message = $res['state_message'];

        if($state_message == 0) {
            $app_total_num = $res['info']['app_total_num'];
            $report = $res['info']['report'];

            if($app_total_num == 0) {
                echo '<td colspan="11"><center>您还没有上传应用<center></td>';
            }

            for($i = 0; $i < $app_total_num; $i ++) {
                $apk_real_name = $report[$i]['apk_real_name'];
                $protected = $report[$i]['protected'];
                $scanned = $report[$i]['scanned'];

                $high = $report[$i]['high'];
                $middle = $report[$i]['middle'];
                $low = $report[$i]['low'];
                $warning = $report[$i]['warning'];

                $total = $report[$i]['total']; 
                $score = $report[$i]['score'];
                $level = $report[$i]['level'];

                $num = $i + 1;

                echo <<<TABLE_OUTPUT1
                                                  <tr>
                                                    <td>$num</td>
                                                    <td>$apk_real_name</td>
TABLE_OUTPUT1;
                if($scanned ==  1) {
                echo <<<TABLE_OUTPUT2
                                                    <td>$high</td>
                                                    <td>$middle</td>
                                                    <td>$low</td>
                                                    <td>$warning</td>
                                                    <td>$total</td>
                                                    <td>$score</td>
TABLE_OUTPUT2;
                                                } else {
                echo <<<TABLE_OUTPUT3
                                                    <td>/</td>
                                                    <td>/</td>
                                                    <td>/</td>
                                                    <td>/</td>
                                                    <td>/</td>
                                                    <td>/</td>
TABLE_OUTPUT3;
                }
                if($scanned == 1) {
                    switch ($level) {
                        case -1:
                            echo '<td><span class="label label-success">安全</span></td>';
                            break;
                        case 0:
                            echo '<td><span class="label label-info">合格</span></td>';
                            break;
                        case 1:
                            echo '<td><span class="label label-warning">警告</span></td>';
                            break;
                        case 2:
                            echo '<td><span class="label label-danger">危险</span></td>';
                            break;
                        default:
                            echo '<td><span class="label label-danger">error</span></td>';
                            break;
                    }
                } else {
                    echo '<td>/</td>';
                }
                
                if($scanned == 1) {echo '<td>√</td>';} else {echo '<td>×</td>';}
                if($protected == 1) {echo '<td>√</td>';} else {echo '<td>×</td>';}
                echo '</tr>';
                                            

            }

        
        } 

    }

    //输出apk文件列表
    function output_app_list() {
        $post_url = "http://www.annhub.cn/php/file/file_info_get.php";
        $curl_timeout = 3;
        $email = explode(' ', $_COOKIE['Annhub'])[0];
        $cookie = $_COOKIE['Annhub'];
        $header = [
            "Cookie: Annhub=$cookie"
        ];

        $res = send_post($post_url, $header, null);
        $state_message = $res['state_message'];

        if($state_message == 0) {
            $app_total_num = $res['info']['app_total_num'];
            $app = $res['info']['app'];
            //$i = 2;
            for($i = 0; $i < $app_total_num; $i ++) {
            
                $apk_real_name = $app[$i]['apk_real_name'];
                $upload_date = $app[$i]['upload_date'];
                $protected = $app[$i]['protected'];
                $scanned = $app[$i]['scanned'];

                $app_url = $app[$i]['app']; //关于命名的小BUG
                $report = $app[$i]['report'];

                $app_protect = $app[$i]['app_protect'];
                $report_protect = $app[$i]['report_protect'];

                                                        echo <<<FILE_OUTPUT
                                                        
                                                        <div class="file-box">
                                                            <div class="file">      
                                                                <div class="icon">
                                                                    <i class="fa fa-file"></i>
                                                                </div>
                                                                <div class="file-name" style="height: 80px;">
                                                                    $apk_real_name <br/>
                                                    
                                                                    <span>$upload_date</span>
                                                                </div>
                                                                <div class="dropdown">
                                                                    <!-- Single button -->
                                                                        <button class="btn btn-info dropdown-toggle col-xs-12 col-sm-12 col-md-12" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                                            操作
                                                                            <span class="caret"></span>
                                                                        </button>
                                                                        <ul class="dropdown-menu col-xs-12 col-sm-12 col-md-12">
                                                                            <li><a href="$app_url">下载</a></li>
FILE_OUTPUT;
                                                                            if($scanned == 1) {
                                                                                //$report_demo = get_report_demo();
                                                                                //echo "<li><a href=\"$report_demo\" target=\"_blank\">查看检测报告</a></li>";
                                                                                echo "<li><a href=\"report.php?file=$i\" target=\"_blank\">查看检测报告</a></li>";
                                                                                //echo "<li><a href=\"$report\">下载检测报告</a></li>";
                                                                            } else {
                                                                                echo '<li><a href="#">正在扫描</a></li>';               
                                                                            }

                                                                            echo '<li class="divider"></li>';
                                                                            if($protected == 1) {
                                                                                $report_protect_demo = get_report_protect_demo();
                                                                                $report_protect_pdf_demo = get_report_pdf_demo();
                                                                                echo '<li><a href="http://www.annhub.cn/test/test_protect.apk">下载加固包</a></li>';
                                                                                
                                                                            } else {
                                                                                echo '<li><a href="#">正在加固</a></li>';
                                                                            }
                                                                                
                                                                            echo <<<FILE_OUTPUT1
                                                                            <li class="divider"></li>
                                                                            <li><a href="#" alt="alert" id="$i">移除</a></li>
                                                                        </ul>
                                                                </div>  
                                                            </div>                              
                                                        </div>
FILE_OUTPUT1;

            }

        
        } 
    }


    //输出apk delete btn点击事件的script
    function output_btn_script() {
        $post_url = "http://www.annhub.cn/php/file/file_info_get.php";
        $curl_timeout = 3;
        $email = explode(' ', $_COOKIE['Annhub'])[0];
        $cookie = $_COOKIE['Annhub'];
        $header = [
            "Cookie: Annhub=$cookie"
        ];

        $res = send_post($post_url, $header, null);
        $state_message = $res['state_message'];

        if($state_message == 0) {
            $app_total_num = $res['info']['app_total_num'];
            $app = $res['info']['app'];
            for($i = 0; $i < $app_total_num; $i ++) {
                echo <<<SCRIPT_TAG
        <script>
            $('#$i').on('click', function(e){
                swal({   
                    title: "确定移除选择的应用？",   
                    text: "您将不能恢复",   
                    type: "warning",   
                    showCancelButton: true,   
                    confirmButtonColor: "#fcb03b",   
                    confirmButtonText: "是的，我要移除",   
                    closeOnConfirm: false 
                }, function(){ 
                    $(this).ajaxSubmit({
                        type: "post",
                        url: "modules/class/file.php?fun=delete_app&file=$i",
                        dataType: "json",
                        success: function(msg) {

                            swal({
                                title: "您选择的应用",
                                text: "已删除",
                                type: "success"
                            }, function(){
                                location.reload();
                            }); 
                            
                        }
                    });
                });                     
            });
        </script>

SCRIPT_TAG;
            }
        
        } 
    }

    //获取报告的数据
    function get_report_data() {
        $post_url = "http://www.annhub.cn/php/data/report_data_get.php";
        $curl_timeout = 3;
        $email = explode(' ', $_COOKIE['Annhub'])[0];
        $cookie = $_COOKIE['Annhub'];
        $header = [
            "Cookie: Annhub=$cookie"
        ];

        $btn_code = $_GET['file'];
        $post = [
            'btn_code' => $btn_code
        ];

        $res = send_post($post_url, $header, $post);
        $state_message = $res['state_message'];

        if($state_message == 0) {
            
            $report_data = array(
                'apk_real_name' => $res['data']['apk_real_name'],
                'level' => $res['data']['level'],
                'score' => $res['data']['score'],
                'date' => $res['data']['date'],
                'high' => $res['data']['high'],
                'middle' => $res['data']['middle'],
                'low' => $res['data']['low'],
                'warning' => $res['data']['warning'],
                'file_size' => $res['data']['file_size'],
                'file_md5' => $res['data']['file_md5'],
                'package' => $res['data']['package'],
                'main_activity' => $res['data']['main_activity'],
                'min_sdk' => $res['data']['min_sdk'],
                'target_sdk' => $res['data']['target_sdk'],
                'permission' => $res['data']['permission'],
                'activity' => $res['data']['activity'],
                'service' => $res['data']['service'],
                'receiver' => $res['data']['receiver'],
                'provider' => $res['data']['provider'],
                'unsafe_items_num' => $res['data']['unsafe_items_num'],
                'unsafe_items' => $res['data']['unsafe_items']
            );

            return $report_data;
        }
    }



?>
