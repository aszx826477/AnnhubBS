<?php
    /*
    Author:ALi
    20180522
    */
    include "../conf.php";
    include "../annhub_func.php";
    $state_message = 0;
    $post_names = array("email");
    $state_message = post_isset($post_names);//检查参数完整
    if($state_message == 0) {
        $email = $_POST["email"];
        $min = array(6);
        $max = array(32);
        $patterns = array("/^[\w]+[@\w][\.\w]+$/");
        $subjects = array($email);
        $state_message = post_match($min, $max, $patterns, $subjects);//检查参数合法
        if($state_message == 0) {
            //$sql = mysqli_connect($MYSQL_ADDRESS, $MYSQL_USER, $MYSQL_PASSWORD, $MYSQL_DATABASE);
            $mysqli = new mysqli($MYSQL_ADDRESS, $MYSQL_USER, $MYSQL_PASSWORD, $MYSQL_DATABASE);
            $mysqli -> set_charset('utf8');
            //$stmt = $mysqli -> stmt_init();
            //mysqli_set_charset($sql,'utf8');
            //if($sql) {
            if(!$mysqli -> connect_error) {
                $stmt = $mysqli -> prepare("select email from user where (email = ?)");
                $stmt -> bind_param('s', $email);
                $stmt -> execute();
                $result = $stmt -> get_result();
                $stmt -> close();
                //$query_1 = mysqli_query($sql, "select email from user where email = '$email'");//检查邮箱是否已被注册
                //if(mysqli_num_rows($query_1) == 0) {
                if($result -> num_rows == 0) {
                    //$query_2 = mysqli_query($sql, "select verification_code, time from verify where email = '$email'");//检查是否已获取过验证码
                    $stmt_2 = $mysqli -> prepare("select verification_code, time from verify where email = ?");
                    $stmt_2 -> bind_param('s', $email);
                    $stmt_2 -> execute();
                    $result_2 = $stmt_2 -> get_result();
                    $stmt_2 -> close();
                    //$stmt_2 -> store_result();
                    //if(mysqli_num_rows($query_2) == 0) {
                    if($result_2 -> num_rows == 0) {
                        $verification_code = rand(0, 9).rand(0, 9).rand(0, 9).rand(0, 9).rand(0, 9).rand(0, 9);//生成验证码
                        $time = time();
                        $stmt_3 = $mysqli -> prepare("insert into verify(email, verification_code, time) values(?, ?, ?)");
                        $stmt_3 -> bind_param('ssi', $email, $verification_code, $time);
                        //if(mysqli_query($sql, "insert into verify(email, verification_code, time) values('$email', '$verification_code', $time)")) {//邮箱和验证码写入数据库
                        if($stmt_3 -> execute()) {//邮箱和验证码写入数据库
                            $state_message = send_mail($email, $verification_code);//发送邮件

                        }
                        else {
                            $state_message = 402;
                        }
                        $stmt_3 -> close();
                    }
                    else {
                        //$result_2 = mysqli_fetch_array($query_2);
                        
                        $row_2 = $result_2 -> fetch_array(MYSQLI_ASSOC);
                        //if($result_2["time"] <= time()-300) {//检查验证码是否失效
                        if($row_2["time"] <= time()-300) {//检查验证码是否失效
                            $verification_code = rand(0, 9).rand(0, 9).rand(0, 9).rand(0, 9).rand(0, 9).rand(0, 9);//生成验证码
                            $time = time();
                            $stmt_4 = $mysqli -> prepare("update verify set verification_code = ?, time = ? where email = ?");
                            $stmt_4 -> bind_param('sis', $verification_code, $time, $email);

                            //if(mysqli_query($sql, "update verify set verification_code = '$verification_code', time = $time where email = '$email'")) {//验证码写入数据库
                            if($stmt_4 -> execute()) {//验证码写入数据库
                                $state_message = send_mail($email, $verification_code);//发送邮件
    
                            }
                            else {
                                $state_message = 405;
                            }
                            $stmt_4 -> close();
                        }
                        //else if ($result_2["time"] >= time()-60) {//验证码发送过于频繁，限定一分钟只能发送一次
                        else if ($row_2["time"] >= time()-60) {//验证码发送过于频繁，限定一分钟只能发送一次
                            $state_message = 109;
                        }
                        else{
                            //$verification_code = $result_2["verification_code"];//读取验证码
                            $verification_code = $row_2["verification_code"];//读取验证码
                            $state_message = send_mail($email, $verification_code);//发送邮件

                        }
                    }
                }
                else {
                    $state_message = 102;
                }
            }
            else {
                $state_message = 401;
            }
            //mysqli_close($sql);
            $mysqli -> close();
        }
    }
    $return = array("state_message" => $state_message);
    echo json_encode($return);
?>