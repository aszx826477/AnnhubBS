<?php
    /*
    Author:ALi
    20180525
    */
    include "../conf.php";
    include "../annhub_func.php";
    $state_message = check_cookie();
    if($state_message == 0) {
        $post_names = array("password", "password_again");
        $state_message = post_isset($post_names);//检查参数完整
        if($state_message == 0) {
            $password = $_POST["password"];
            $password_again = $_POST["password_again"];
            $min = array(6, 6);
            $max = array(16, 16);
            $patterns = array("/^[\S]+$/", "/^[\S]+$/");
            $subjects = array($password, $password_again);
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
                        $email = explode(' ', $_COOKIE["Annhub"])[0];
                        //if(mysqli_query($sql, "update user set password = '$password_hash' where email = '$email'")) {
                        $stmt = $mysqli -> prepare("update user set password = ? where email = ?");
                        $stmt -> bind_param('ss', $password_hash, $email);
                        if($stmt -> execute()) {
                            $return = set_cookie($email, $password_hash, "login");
                        }
                        else {
                            $state_message = 405;
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
    }
    if($state_message != 0) {
        $return = array("state_message" => $state_message);
    }
    echo json_encode($return);

?>