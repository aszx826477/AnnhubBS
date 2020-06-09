<?php
    /*
    Author:ALi
    20180527
    */
    include "../conf.php";
    include "../annhub_func.php";
    $state_message = check_cookie();
    if($state_message == 0) {
        $post_names = array("email", "verification_code");
        $state_message = post_isset($post_names);//检查参数完整
        if($state_message == 0) {
            $email = $_POST["email"];
            $verification_code = $_POST["verification_code"];
            $min = array(6, 6);
            $max = array(32, 6);
            $patterns = array("/^[\w]+[@\w][\.\w]+$/", "/^[0-9]{6}$/");
            $subjects = array($email, $verification_code);
            $state_message = post_match($min, $max, $patterns, $subjects);//检查参数合法
            if($state_message == 0) {
                //$sql = mysqli_connect($MYSQL_ADDRESS, $MYSQL_USER, $MYSQL_PASSWORD, $MYSQL_DATABASE);
                //mysqli_set_charset($sql,'utf8');
                $mysqli = new mysqli($MYSQL_ADDRESS, $MYSQL_USER, $MYSQL_PASSWORD, $MYSQL_DATABASE);
                $mysqli -> set_charset('utf8');
                //if($sql) {
                if($mysqli -> connect_error) {
                    //$query_1 = mysqli_query($sql, "select verification_code, time from verify where email = $email");
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
                        if($verification_code == $row["verification_code"]) {
                            $email_old = explode(' ', $_COOKIE["Annhub"])[0];
                            //$query_2 = mysqli_query($sql, "select password from user where email = $email_old");
                            //$result_2 = mysqli_fetch_array($query_2);
                            $stmt_2 = $mysqli -> prepare("select password from user where email = ?");
                            $stmt_2 -> bind_param('s', $email_old);
                            $stmt_2 -> execute();
                            $res_2 = $stmt_2 -> get_result();
                            $stmt_2 -> close();
                            $row_2 = $res_2 -> fetch_array(MYSQLI_ASSOC);

                            //新旧邮箱的问题产生的Bug
                            //$query_3 = mysqli_query($sql, "select password from user where email = $email");
                            $stmt_3 = $mysqli -> prepare("select password from user where email = ?");
                            $stmt_3 -> bind_param('s', $email);
                            $stmt_3 -> execute();
                            $res_3 = $stmt_3 -> get_result();

                            //if(mysqli_num_rows($query_3) == 0) {
                            if($res_3 -> num_rows == 0) {
                                $stmt_4 = $mysqli -> prepare("update user set email = ? where email = ?");
                                $stmt_4 -> bind_param('ss', $email, $email_old);
                                $stmt_5 = $mysqli -> prepare("delete from verify where email = ?");
                                $stmt_5 -> bind_param('s', $email);
                                //if(mysqli_query($sql, "update user set email = $email where email = $email_old") && mysqli_query($sql, "delete from verify where email = $email")) {
                                if($stmt_4 -> execute() && $stmt_5 -> execute()) {
                                    //$return = set_cookie($email, $result_2["password"], "login");
                                    $return = set_cookie($email, $row_w['password'], 'login');
                                }
                                else {
                                    $state_message = 405;
                                }
                                $stmt_4 -> close();
                                $stmt_5 -> close();
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
        }
    }
    if($state_message != 0) {
        $return = array("state_message" => $state_message);
    }
    echo json_encode($return);
?>