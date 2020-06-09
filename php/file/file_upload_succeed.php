<?php
    /*
    201805230   ALi
    创建文件
    2018-06-12  YellowBee
    2018-11-06  YellowBee
    数据库表结构变动

    */
    include "../conf.php";
    include "../annhub_func.php";
    $state_message = check_cookie();
    if($state_message == 0) {

        $apk_real_name = $_POST['file_real_name'];

        $message = create_apk_name();
        $state_message = $message[0];
        if($state_message == 0) {
            $apk_name = $message[1];
            $url = "/apk/".$apk_name;
            $state_message = COS_check($url); //Web服务器上传成功后，后端负责check是否上传成功，若成功则进行数据库的更新操作
            if($state_message == 0) {
                //$sql = mysqli_connect($MYSQL_ADDRESS, $MYSQL_USER, $MYSQL_PASSWORD, $MYSQL_DATABASE);
                //mysqli_set_charset($sql,'utf8');
                $mysqli = new mysqli($MYSQL_ADDRESS, $MYSQL_USER, $MYSQL_PASSWORD, $MYSQL_DATABASE);
                $mysqli -> set_charset('utf8');
                //if($sql) {
                if(!($mysqli->connect_error)) {
                    $email = explode(' ', $_COOKIE["Annhub"])[0];
                    $stmt = $mysqli -> prepare("select user_id from user where email = ?");
                    $stmt -> bind_param('s', $email);
                    $stmt -> execute();
                    $res = $stmt -> get_result();
                    $stmt -> close();
                    $row = $res -> fetch_array(MYSQLI_ASSOC);
                    $user_id = $row['user_id'];
                    //$query = mysqli_query($sql, "select user_id from user where email = '$email'");
                    //$result =  mysqli_fetch_array($query);
                    //$user_id = $result['user_id'];
                    $upload_time = time();
                    $upload_date = date("Y-m-d");
                    $apk_url = "https://".$COS_bucket.".cos.".$COS_region.".myqcloud.com".$url;

                    $stmt_2 = $mysqli -> prepare("insert into apk(user_id, apk_name, apk_real_name, upload_time, upload_date, upload, protected, scanned, app) values(?, ?, ?, ?, ?, 1, 0, 0, ?)");
                    $stmt_2 -> bind_param('ississ', $user_id, $apk_name, $apk_real_name, $upload_time, $upload_date, $apk_url);
                    //if(mysqli_query($sql, "insert into apk(user_id, apk_name, apk_real_name, upload_time, upload_date, upload, protected, scanned, app) values($user_id, '$apk_name', '$apk_real_name', $upload_time, '$upload_date', 1, 0, 0, '$apk_url')")) {
                    if($stmt_2 -> execute()) {
                        //查询该用户总共拥有的apk数
                        //$file_num = mysqli_num_rows(mysqli_query($sql, "select apk_id from apk where user_id = $user_id"));
                        $stmt_3 = $mysqli -> prepare("select apk_id from apk where user_id = ?");
                        $stmt_3 -> bind_param('i', $user_id);
                        $stmt_3 -> execute();
                        $res_3 = $stmt_3 -> get_result();
                        $stmt_3 -> close();
                        $file_num = $res_3 -> num_rows;

                        //更新user表中的应用总数
                        $stmt_4 = $mysqli -> prepare("update user set file_num = ? where user_id = ?");
                        $stmt_4 -> bind_param('ii', $file_num, $user_id);
                        //if(!mysqli_query($sql, "update user set file_num = $file_num where user_id = $user_id")) {
                        if(!$stmt_4 -> execute()) {
                            $state_message = 405;
                        }
                    } else {
                        $state_message = 402;
                    }
                    $stmt_2 -> close();

                }
                else {
                    $state_message = 401;
                    $return = array($state_message);
                }
                //mysqli_close($sql);
                $mysqli -> close();
            }
        }
    }
    $return = array("state_message" => $state_message);
    echo json_encode($return);
?>