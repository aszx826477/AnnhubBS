<?php
    /*
    YellowBee
    2018-6-11
    */
    include "../conf.php";
    include "../annhub_func.php";

    $state_message = check_cookie();
    $info = array();
    if($state_message == 0) {   
        
        $mysqli = new mysqli($MYSQL_ADDRESS, $MYSQL_USER, $MYSQL_PASSWORD, $MYSQL_DATABASE);
        $mysqli -> set_charset('utf8');
        
        if(!$mysqli -> connect_error) {
            $email = explode(' ', $_COOKIE["Annhub"])[0];
            $stmt = $mysqli -> prepare("select user_id from user where email = ?");
            $stmt -> bind_param('s', $email);
            $stmt -> execute();
            $res = $stmt -> get_result();
            $stmt -> close();
            $row = $res -> fetch_array(MYSQLI_ASSOC);
            $user_id = $row['user_id'];

            
            $stmt_2 = $mysqli -> prepare("select apk_name, apk_real_name, protected, scanned from apk where user_id = ?");
            $stmt_2 -> bind_param('i', $user_id);
            $stmt_2 -> execute();
            $res_2 = $stmt_2 -> get_result();
            $stmt_2 -> close();
            $app_total_num = $res_2 -> num_rows;
            $report = array();

            for($i = 0; $i < $app_total_num; $i ++) {
                
                $row_2 = $res_2 -> fetch_array(MYSQLI_ASSOC);
                $apk_real_name = $row_2['apk_real_name'];
                $apk_name = $row_2['apk_name'];
                $protected =  $row_2['protected'];
                $scanned = $row_2['scanned'];
                //使用apk_name来查找
                
                $stmt_3 = $mysqli -> prepare("select apk_real_name, high, middle, low, warning, total, score, level from apk where apk_name = ? and upload = 1");
                $stmt_3 -> bind_param('s', $apk_name);
                $stmt_3 -> execute();
                $res_3 = $stmt_3 -> get_result();
                $stmt_3 -> close();
                $row_report = $res_3 -> fetch_array(MYSQLI_ASSOC);

                //而apk_real_name是用于前端展示给用户的名称
                $report[$i] = array(
                    'apk_real_name' => $row_report['apk_real_name'],
                    'protected' => $protected,
                    'scanned' => $scanned,
                    'high' => $row_report['high'],
                    'middle' => $row_report['middle'],
                    'low' => $row_report['low'],
                    'warning' => $row_report['warning'],
                    'total' => $row_report['total'],
                    'score' => $row_report['score'],
                    'level' => $row_report['level']
                );
            }
            $info = array(
                'app_total_num' => $app_total_num,
                'report' => $report
            );
        } else {
            $state_message = 401;
        }

        $mysqli -> close();
        
    }

    if($state_message != 0) {
        $return = array('state_message' => $state_message);
    }
    $return = array('state_message' => $state_message, 'info' => $info);
    echo json_encode($return);


?>