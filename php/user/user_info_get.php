<?php
    /*
    Author:ALi
    20180527
    */
    include "../conf.php";
    include "../annhub_func.php";
    $state_message = check_cookie();
    if($state_message == 0) {
        $email = explode(' ', $_COOKIE["Annhub"])[0];
        //$sql = mysqli_connect($MYSQL_ADDRESS, $MYSQL_USER, $MYSQL_PASSWORD, $MYSQL_DATABASE);
        //mysqli_set_charset($sql,'utf8');
        //if($sql) {
        $mysqli = new mysqli($MYSQL_ADDRESS, $MYSQL_USER, $MYSQL_PASSWORD, $MYSQL_DATABASE);
        $mysqli -> set_charset('utf8');
        if(!$mysqli -> connect_error) {
            //$query_1 = mysqli_query($sql, "select nickname, head_url, file_num, file_protected_num, file_scan_num, file_leak_num, register_time, register_date from user where email = '$email'");
            //$result_1 = mysqli_fetch_array($query_1);
            $stmt = $mysqli -> prepare("select nickname, head_url, file_num, file_protected_num, file_scan_num, file_leak_num, register_time, register_date from user where email = ?");
            $stmt -> bind_param('s', $email);
            $stmt -> execute();
            $res = $stmt -> get_result();
            $stmt -> close();
            $result_1 = $res -> fetch_array(MYSQLI_ASSOC);
            $info = array(
                "nickname" => $result_1["nickname"], 
                "head_url" => $result_1["head_url"], 
                "file_num" => (int)$result_1["file_num"], 
                "file_protected_num" => (int)$result_1["file_protected_num"], 
                "file_scan_num" => (int)$result_1["file_scan_num"],
                "file_leak_num" => (int)$result_1["file_leak_num"],
                "register_time" => (int)$result_1["register_time"],
                "register_date" => $result_1["register_date"]
            );
            $return = array("state_message" => $state_message, "info" => $info);
        } else {
            $state_message = 401;
        }
        //mysqli_close($sql);
        $mysqli -> close();
    }
    if($state_message != 0) {
        $return = array("state_message" => $state_message);
    }
    echo json_encode($return);
?>