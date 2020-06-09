<?php
    /*
    Author:ALi
    20180522
    */
    include "../conf.php";
    include "../annhub_func.php";
    $state_message = 0;
    $post_names = array("email", "verification_code", "password", "password_again");
    $state_message = post_isset($post_names);//检查参数完整
    if($state_message == 0) {
        $email = $_POST["email"];
        $verification_code = $_POST["verification_code"];
        $password = $_POST["password"];
        $password_again = $_POST["password_again"];
        $min = array(6, 6, 6, 6);
        $max = array(32, 6, 16, 16);
        $patterns = array("/^[\w]+[@\w][\.\w]+$/", "/^[0-9]{6}$/", "/^[\S]+$/", "/^[\S]+$/");
        $subjects = array($email, $verification_code, $password, $password_again);
        $state_message = post_match($min, $max, $patterns, $subjects);//检查参数合法
        if($state_message == 0) {
            $password_hash = hash("sha256", $password);
            $password_again_hash = hash("sha256", $password_again);
            if($password_hash == $password_again_hash) {//检查两次密码是否一致
                //$sql = mysqli_connect($MYSQL_ADDRESS, $MYSQL_USER, $MYSQL_PASSWORD, $MYSQL_DATABASE);
                //mysqli_set_charset($sql,'utf8');
                //if($sql) {
                $mysqli = new mysqli($MYSQL_ADDRESS, $MYSQL_USER, $MYSQL_PASSWORD, $MYSQL_DATABASE);
                $mysqli -> set_charset('utf8');
                if(!$mysqli -> connect_error) {
                    //$query_1 = mysqli_query($sql, "select verification_code, time from verify where email = '$email'");
                    //$result_1 = mysqli_fetch_array($query_1);
                    $stmt -> $mysqli -> prepare("select verification_code, time from verify where email = ?");
                    $stmt -> bind_param('s', $email);
                    $stmt -> execute();
                    $res = $stmt -> get_result();
                    $stmt -> close();
                    $row = $res -> fetch_array(MYSQLI_ASSOC);
                    //if(mysqli_num_rows($query_1) != 0 && $result_1["time"] <= time()-300) {//检查验证码是否过期
                    if($res -> num_rows != 0 && $row["time"] <= time() - 300) {
                        $state_message = 108;
                    }
                    else {
                        //if($verification_code == $result_1["verification_code"]) {//检查验证码
                        if($verification_code == $row["verification_code"]) {//检查验证码
                            //$query_2 = mysqli_query($sql, "select email from user where email = '$email'");
                            $stmt_2 -> $mysqli -> prepare("select email from user where email = ?");
                            $stmt_2 -> bind_param('s', $email);
                            $stmt_2 -> execute();
                            $res_2 = $stmt_2 -> get_result();
                            $stmt_2 -> close();
                            //if(mysqli_num_rows($query_2) == 0) {
                            if($res_2 -> num_rows == 0) {
                                $return = set_cookie($email, $password_hash, 'register');
                            }
                            else {
                                $state_message = 102;
                            }
                        }
                        else {
                            $state_message = 103;
                        }
                    }
                }
                else {
                    $state_message = 401;
                }
                //mysqli_close($sql);
                $mysqli -> close();
            }
            else {
                $state_message = 104;
            }
        }
    }
    if($state_message != 0) {
        $return = array("state_message" => $state_message);
    }
    echo json_encode($return);
?>