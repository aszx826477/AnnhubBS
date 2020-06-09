<?php
    /*
    Author:ALi
    20180522
    */

    function post_isset($post_names) {//检查post值的完整性
        $state_message = 0;
        for($i = 0;$i < count($post_names);$i++) {
            if(!isset($_POST[$post_names[$i]])) {
                $state_message = 106;
                break;
            }
        }
        return $state_message;
    }

    function post_match($min, $max, $patterns, $subjects) {//检查值的合法性
        $state_message = 0;
        for($i = 0;$i < count($subjects);$i++) {
            if(!preg_match($patterns[$i], $subjects[$i]) || strlen($subjects[$i]) < $min[$i] || strlen($subjects[$i]) > $max[$i]) {
                $state_message = 101;
                break;
            }
        }
        return $state_message;
    }

    function send_mail($sendmailto, $verification_code) {
        require_once "func/smtp.php";//外部SMTP包
        include "conf.php";
        $smtpserver = $smtp_server;//SMTP服务器
        $smtpserverport = $smtp_port;//SMTP服务器端口
        $smtpusermail = $smtp_usermail;//SMTP服务器的用户邮箱
        $smtpemailto = $sendmailto;//发送给谁
        $smtpmailfrom = $smtp_nick;
        $smtpuser = $smtp_user;//SMTP服务器的用户帐号
        $smtppass = $smtp_password;//SMTP服务器的用户密码
        $mailtitle = $smtp_title;//邮件主题
        $mailcontent = $smtp_mail;//邮件内容
        $mailtype = "HTML";//邮件格式（HTML/TXT）,TXT为文本邮件
        $smtp = new smtp($smtpserver,$smtpserverport,true,$smtpuser,$smtppass);//这里面的一个true是表示使用身份验证,否则不使用身份验证
        $smtp->debug = false;//是否显示发送的调试信息
        $state = $smtp->sendmail($smtpemailto, $smtpusermail, $smtpmailfrom, $mailtitle, $mailcontent, $mailtype);//发送邮件
        if($state == "") {
            return 107;
        }
        else {
            return 0;
        }



    }

    function create_token($email, $password, $token_time_end) {//创建token
        $chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$%^&*()-_[]{}<>~`+=,.;:/?|' ";
        //暂时不能生成单引号和空格，改成参数化查询后便可以
        $length = strlen($chars)-1;
        $token_key = "";
        for($i = 0; $i < 16; $i++) {
            $token_key = $token_key.$chars[rand(0, $length)];
        }
        //$token_key = $token_key.'\'';
        $token[0] = 'NULL';
        $token[1] = 'NULL';
        $token[2] = 'NULL';
        $token = base64_encode(openssl_encrypt($email.' '.hash("sha256", $email.$token_key.$token_time_end).' '.$token_time_end, "AES-128-CFB", $password));
        return array($token, $token_key);
    }

    function check_token($token, $email, $password, $token_key, $token_time_end) {//检查token
        $state_message = 0;
        $token_message[0] = 'NULL';
        $token_message[1] = 'NULL';
        $token_message[2] = 'NULL';
        $token_message = explode(' ', openssl_decrypt(base64_decode($token), "AES-128-CFB", $password));
        $token_hash = hash("sha256", $token_message[0].$token_key.$token_message[2]);

        if(count($token_message) != 3 || $email != $token_message[0] || $token_hash != $token_message[1] || $token_time_end != $token_message[2]) {
            $state_message = 201;
        } 

        
        return $state_message;
    }

    //生成cookie，处理跨域的问题
    function set_cookie($email, $password, $mode) {
        include "conf.php";
        $state_message = 0;
        //$sql = mysqli_connect($MYSQL_ADDRESS, $MYSQL_USER, $MYSQL_PASSWORD, $MYSQL_DATABASE);
        $mysqli = new mysqli($MYSQL_ADDRESS, $MYSQL_USER, $MYSQL_PASSWORD, $MYSQL_DATABASE);
        //mysqli_set_charset($sql,'utf8');
        $mysqli -> set_charset('utf8');
        if(!$mysqli -> connect_error) {
            switch ($mode) {
                case "register":
                    $token_time_end = time()+3600;
                    $token_array = create_token($email, $password, $token_time_end);
                    $token = $token_array[0];
                    $token_key = $token_array[1];
                    $register_time = time();
                    $register_date = date("Y-m-d");
                    $stmt = $mysqli -> prepare("insert into user(email, password, token_key, token_time_end, nickname, head_url, file_num, file_protected_num, file_scan_num, file_leak_num, register_time, register_date) values(?, ?, ?, ?, '$NICKNAME_DEFAULT', '$HEAD_URL_DEFAULT', 0, 0, 0, 0, ?, ?");
                    $stmt -> bind_param('sssiis', $email, $password, $token_key, $token_key_end, $register_time, $register_date);
                    $stmt_2 = $mysqli -> prepare("delete from verify where email = ?");
                    $stmt_2 = $mysqli -> bind_param('s', $email);
                    if($stmt -> execute() && $stmt_2 -> execute()) {
                    //if(mysqli_query($sql, "insert into user(email, password, token_key, token_time_end, nickname, head_url, file_num, file_protected_num, file_scan_num, file_leak_num, register_time, register_date) values('$email', '$password', '$token_key', '$token_time_end', '$NICKNAME_DEFAULT', '$HEAD_URL_DEFAULT', 0, 0, 0, 0, '$register_time', '$register_date')") && mysqli_query($sql, "delete from verify where email = '$email'")) {
                        $info = array("content" => $email.' '.$token, "time" => $token_time_end);
                        $return = array("state_message" => $state_message, "info" => $info);
                    } else {
                        $state_message = 406;
                    }
                    $stmt -> close();
                    $stmt_2 -> close();
                    break;
                case "login":
                    $token_time_end = time() + 3600;
                    $token_array = create_token($email, $password, $token_time_end);
                    $token = $token_array[0];
                    $token_key = $token_array[1];
                    $stmt_3 = $mysqli -> prepare("update user set token_key = ?, token_time_end = ? where email = ?");
                    $stmt_3 -> bind_param('sis', $token_key, $token_time_end, $email);
                    //if(mysqli_query($sql, "update user set token_key = '$token_key', token_time_end = '$token_time_end' where email = '$email'") === TRUE) {
                    if($stmt_3 -> execute()) {
                        $info = array("content" => $email.' '.$token, "time" => $token_time_end);
                        $return = array("state_message" => $state_message, "info" => $info);
                    } else {
                        $state_message = 405;
                    }
                    $stmt_3 -> close();
                    break;
                default:
                    break;
            }
            
        } else {
            $state_message = 401;
        }
        //mysqli_close($sql);
        $mysqli -> close();

        if($state_message != 0) {
            $return = array("state_message" => $state_message);
        }
        return $return;
    }

    //使cookie失效
    function disabled_cookie($email) {
        include "conf.php";
        $state_message = 0;
        //$sql = mysqli_connect($MYSQL_ADDRESS, $MYSQL_USER, $MYSQL_PASSWORD, $MYSQL_DATABASE);
        $mysqli = new mysqli($MYSQL_ADDRESS, $MYSQL_USER, $MYSQL_PASSWORD, $MYSQL_DATABASE);
        //mysqli_set_charset($sql,'utf8');
        $mysqli -> set_charset('utf8');
        //if($sql) {
        if(!$mysqli -> connect_error) {
            $stmt = $mysqli -> prepare("select password from user where email = ?");
            $stmt -> bind_param('s', $email);
            //$query_1 = mysqli_query($sql, "select password from user where email = '$email'");
            $stmt -> execute();
            $res = $stmt -> get_result();
            $stmt -> close();
            $row = $res -> fetch_array(MYSQLI_ASSOC);
            //$result_1 = mysqli_fetch_array($query_1);
            //$token_array = create_token($email, $result_1["password"], 0);
            $token_array = create_token($email, $row["password"], 0);
            $token = $token_array[0];
            $token_key = $token_array[1];

            $stmt_2 = $mysqli -> prepare("update user set token_key = ?, token_time_end = 0 where email = ?");
            $stmt_2 -> bind_param('ss', $token_key, $email);

            //if(mysqli_query($sql, "update user set token_key = '$token_key', token_time_end = 0 where email = '$email'") === TRUE) {
            if($stmt_2 -> execute()) {
                $info = array("content" => $email.' '.$token, "time" => 1);
                $return = array("state_message" => $state_message, "info" => $info);
            }
            else {
                $state_message = 405;
            }
            $stmt_2 -> close();

        } else {
            $state_message = 401;
        }
        //mysqli_close($sql);
        $mysqli -> close();

        if($state_message != 0) {
            $return = array("state_message" => $state_message);
        }
        return $return;
    }

    //检查cookie
    function check_cookie() {
        include "conf.php";
        $state_message = 0;
        $cookie = $_COOKIE['Annhub'];
        $cookie_message = explode(' ', $cookie);
        if(count($cookie_message) == 2) {
            $email = $cookie_message[0];
            $token = $cookie_message[1];
            //$sql = mysqli_connect($MYSQL_ADDRESS, $MYSQL_USER, $MYSQL_PASSWORD, $MYSQL_DATABASE);
            //mysqli_set_charset($sql,'utf8');
            //if($sql) {
            $mysqli = new mysqli($MYSQL_ADDRESS, $MYSQL_USER, $MYSQL_PASSWORD, $MYSQL_DATABASE);
            $mysqli -> set_charset('utf8');
            if(!$mysqli -> connect_error) {
                //$query_1 = mysqli_query($sql, "select password, token_key, token_time_end from user where email = '$email'");
                //$result_1 = mysqli_fetch_array($query_1);
                $stmt = $mysqli -> prepare("select password, token_key, token_time_end from user where email = ?");
                $stmt -> bind_param('s', $email);
                $stmt -> execute();
                $res = $stmt -> get_result();
                $stmt -> close();
                $result_1 = $res -> fetch_array(MYSQLI_ASSOC);
                $state_message = check_token($token, $email, $result_1["password"], $result_1["token_key"], $result_1["token_time_end"]);
            }
            else {
                $state_message = 401;
            }
            //mysqli_close($sql);
            $mysqli -> close();
        }
        else {
            $state_message = 106;
        }
        return $state_message;
    }

    //创建用户头像名
    function create_head_name() {
        include "conf.php";
        $state_message = 0;
        //$sql = mysqli_connect($MYSQL_ADDRESS, $MYSQL_USER, $MYSQL_PASSWORD, $MYSQL_DATABASE);
        //mysqli_set_charset($sql,'utf8');
        //if($sql) {
        $mysqli = new mysqli($MYSQL_ADDRESS, $MYSQL_USER, $MYSQL_PASSWORD, $MYSQL_DATABASE);
        $mysqli -> set_charset('utf8');
        if(!$mysqli -> connect_error) {
            $email = explode(' ', $_COOKIE["Annhub"])[0];
            //$query_1 = mysqli_query($sql, "select user_id, register_time from user where email = '$email'");
            //$result_1 = mysqli_fetch_array($query_1);
            $stmt = $mysqli -> prepare("select user_id, register_time from user where email = ?");
            $stmt -> bind_param('s', $email);
            $stmt -> execute();
            $res = $stmt -> get_result();
            $stmt -> close();
            $result_1 = $res -> fetch_array(MYSQLI_ASSOC);
            $head_name = hash("sha256", openssl_encrypt($email, "AES-128-CFB", $result_1["user_id"]))."-".$result_1["register_time"].".jpg";
            $return = array($state_message, $head_name);
        }
        else {
            $state_message = 401;
            $return = array($state_message);
        }
        //mysqli_close($sql);
        $mysqli -> close();
        return $return;
    }


    //生成apk的名称
    function create_apk_name() {
        include "conf.php";
        $state_message = 0;
        //$sql = mysqli_connect($MYSQL_ADDRESS, $MYSQL_USER, $MYSQL_PASSWORD, $MYSQL_DATABASE);
        //mysqli_set_charset($sql,'utf8');
        //if($sql) {
        $mysqli = new mysqli($MYSQL_ADDRESS, $MYSQL_USER, $MYSQL_PASSWORD, $MYSQL_DATABASE);
        $mysqli -> set_charset('utf8');
        if(!$mysqli -> connect_error) {
            $email = explode(' ', $_COOKIE["Annhub"])[0];
            //$query_1 = mysqli_query($sql, "select user_id, register_time from user where email = '$email'");
            //$result_1 = mysqli_fetch_array($query_1);
            $stmt = $mysqli -> prepare("select user_id, register_time from user where email = ?");
            $stmt -> bind_param('s', $email);
            $stmt -> execute();
            $res = $stmt -> get_result();
            $stmt -> close();
            $result_1 = $res -> fetch_array(MYSQLI_ASSOC);
            
            //$query = mysqli_query($sql, "select AUTO_INCREMENT from INFORMATION_SCHEMA.TABLES where TABLE_NAME='apk'");
            //$res = mysqli_fetch_array($query);
            $stmt_2 = $mysqli -> prepare("select AUTO_INCREMENT from INFORMATION_SCHEMA.TABLES where TABLE_NAME='apk'");
            $stmt_2 -> execute();
            $res_2 = $stmt_2 -> get_result();
            $row_2 = $res_2 -> fetch_array(MYSQLI_ASSOC);

            //获取apk表中的下一个自增id，作为apk的code
            //$apk_code = $res['AUTO_INCREMENT'];
            $apk_code = $row_2['AUTO_INCREMENT'];

            $apk_name = hash("sha256", openssl_encrypt($email, "AES-128-CFB", $result_1["user_id"])) . "-" . $result_1["register_time"] . "-" . $apk_code . ".apk";
            $return = array($state_message, $apk_name);
        } else {
            $state_message = 401;
            $return = array($state_message);
        }
        //mysqli_close($sql);
        $mysqli -> close();
        return $return;
    }

    //根据点击的apk，确定其名称
    function ensure_apk_name($btn_code) {
        include "conf.php";
        $state_message = 0;
      
        $mysqli = new mysqli($MYSQL_ADDRESS, $MYSQL_USER, $MYSQL_PASSWORD, $MYSQL_DATABASE);
        $mysqli -> set_charset('utf8');
        if(!$mysqli -> connect_error) {
            $email = explode(' ', $_COOKIE["Annhub"])[0];
            
            $stmt = $mysqli -> prepare("select user_id, register_time from user where email = ?");
            $stmt -> bind_param('s', $email);
            $stmt -> execute();
            $res = $stmt -> get_result();
            $stmt -> close();
            $row = $res -> fetch_array(MYSQLI_ASSOC);
           
            $user_id = $row['user_id'];


            $stmt_2 = $mysqli -> prepare("select apk_id from apk where user_id = ?");
            $stmt_2 -> bind_param('i', $user_id);
            $stmt_2 -> execute();
            $res_2 = $stmt_2 -> get_result();
            $max_bound = $res_2 -> num_rows;

            if($btn_code >= 0 && $btn_code < $max_bound) { //防止delete参数越界
                for($i = 0; $i <= $btn_code; $i ++) { //循环取出对应的apk_id
                   
                    $res_apk = $res_2 -> fetch_array(MYSQLI_ASSOC);
                }
                
                $apk_name = hash("sha256", openssl_encrypt($email, "AES-128-CFB", $row["user_id"])) . "-" . $row["register_time"] . "-" . $res_apk['apk_id'] . ".apk";
                $return = array($state_message, $apk_name);
            } else {
                $state_message = 202; //delete参数越界
            }
            

            
        } else {
            $state_message = 401;
            $return = array($state_message);
        }
        //mysqli_close($sql);
        $mysqli -> close();
        return $return;
    }


    function COS_check($file_name) {
        include "conf.php";
        require(__DIR__.DIRECTORY_SEPARATOR."COS/cos-autoloader.php");
        $state_message = 0;
        $cosClient = new Qcloud\Cos\Client(
            array(
                "region" => $COS_region, 
                "credentials" => array(
                    "appId" => $COS_appid , 
                    "secretId" => $COS_secret_id, 
                    "secretKey" => $COS_secret_key
                )
            )
        );
        try {
            
            $result = $cosClient->headObject(array(
                'Bucket' => $COS_bucket, 
                'Key' => $file_name,
            ));

            if(!strpos($result, "[ETag] => \"")) {
                $state_message = 304;//检查[ETag]的完整性，即使上传成功，对象也可能损坏
            }

        }
        catch (Exception $e) {
            $state_message = 301;//COS headObject出错 --> 对象不存在
        }
        return $state_message;
    }

?>