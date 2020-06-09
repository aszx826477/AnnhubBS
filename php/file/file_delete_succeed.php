<?php
    /*
    YellowBeee
    2018-6-13
    */
    include "../conf.php";
    include "../annhub_func.php";
    $state_message = check_cookie();
    if($state_message == 0) {

        $btn_code = $_POST['btn_code'];

        $message = ensure_apk_name($btn_code);
        $state_message = $message[0];
        if($state_message == 0) {
            $apk_name = $message[1];
            $url = "/apk/".$apk_name;
            //Web服务器进行COS删除操作后，后端负责check是否删除成功，若成功删除则返回的state_message = 0
            $state_message = COS_check($url); 

            //301：COS Check对象不存在-->删除成功
            if($state_message == 301) {
                $mysqli = new mysqli($MYSQL_ADDRESS, $MYSQL_USER, $MYSQL_PASSWORD, $MYSQL_DATABASE);
                $mysqli -> set_charset('utf8');
                if(!$mysqli -> connect_error) {
                    //将apk表中对应的apk信息删除掉
                    $stmt = $mysqli -> prepare("delete from apk where apk_name = ?");
                    $stmt -> bind_param('s', $apk_name);

                    //有可能用户上传的apk没有进行扫描，所以判断scanned字段的值
                    $stmt_6 = $mysqli -> prepare("select scanned from apk where apk_name = ?");
                    $stmt_6 -> bind_param('s', $apk_name);
                    $stmt_6 -> execute();
                    $res_6 = $stmt_6 -> get_result();
                    $stmt_6 -> close();
                    $row_6 = $res_6 ->fetch_array(MYSQLI_ASSOC);
                    $scanned = $row_6['scanned'];
                    if($scanned == 1) {
                        $stmt_5 = $mysqli -> prepare("delete from report where apk_name = ?");
                        $stmt_5 -> bind_param('s', $apk_name);
                        $stmt_5 -> execute();
                        $stmt_5 -> close();
                    }
                   
                    if($stmt -> execute() ) {
                        //查询该用户总共拥有的apk数
                        $email = explode(' ', $_COOKIE["Annhub"])[0];
                        $stmt_2 = $mysqli -> prepare("select user_id from user where email = ?");
                        $stmt_2 -> bind_param('s', $email);
                        $stmt_2 -> execute();
                        $res_2 = $stmt_2 -> get_result();
                        $stmt_2 -> close();
                        $row_2 = $res_2 -> fetch_array(MYSQLI_ASSOC);
                        $user_id = $row_2['user_id'];


                        $stmt_3 = $mysqli -> prepare("select apk_id from apk where user_id = ?");
                        $stmt_3 -> bind_param('i', $user_id);
                        $stmt_3 -> execute();
                        $res_3 = $stmt_3 -> get_result();
                        $stmt_3 -> close();
                        $file_num = $res_3 -> num_rows;

                        //更新user表中的应用总数
                        $stmt_4 = $mysqli -> prepare("update user set file_num = ? where user_id = ?");
                        $stmt_4 -> bind_param('ii', $file_num, $user_id);
                        if($stmt_4 -> execute()) {
                            $state_message = 0;
                        } else {
                            $state_message = 405;//405
                        }
                        $stmt_4 -> close();
                    } else {
                        $state_message = 403;
                    }
                    $stmt -> close();
                }
                else {
                    $state_message = 401;
                }

                $mysqli -> close();
                
            }
            
        }
    }
    $return = array('state_message' => $state_message);
    echo json_encode($return);
?>