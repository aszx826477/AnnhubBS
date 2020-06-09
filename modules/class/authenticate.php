<?php
    include_once "utils.php";

    if (isset($_GET['fun'])) {
        switch($_GET['fun']) {
            case 'login':
                login();
                break;
            case 'logout':
                logout();
                break;
            case 'send_verify_code':
                send_verify_code();
                break;
            default:
                break;
        }
    }


    //登录
    function login() {
        $email = $_POST['email'];
        $password = $_POST['password'];
        $post_url = "http://www.annhub.cn/php/user/user_login.php";
        $curl_timeout = 3;
        $post = [
            "email" => "$email",
            "password" => "$password"
        ];

        $res = send_post($post_url, null, $post);
        $state_message = $res['state_message'];

        if($state_message == 0) {
            $content = $res['info']['content'];
            $time = $res['info']['time'];
            setcookie('Annhub', $content, $time, '/');
            //header('Location: ../../manage_index.php');
            //echo json_encode($state_message);
        } //else {
            //header("Location: error.php?code=$state_message");
            echo json_encode($state_message);
        //}

    }

    //登出
    function logout() {
        
        $post_url = "http://www.annhub.cn/php/user/user_logout.php";
        $curl_timeout = 3;
        $cookie = $_COOKIE['Annhub'];
        $header = [
            "Cookie:Annhub=$cookie"
        ];

        $res = send_post($post_url, $header, null);
        $state_message = $res['state_message'];

        if($state_message == 0) {
            $content = $res['info']['content'];
            $time = $res['info']['time'];
            setcookie('Annhub', $content, $time, '/');
            header('Location: ../../login.php');
            //echo json_encode($state_message);
        } //else {
            //header("Location: error.php?code=$state_message");
        echo json_encode($state_message);
        //}
        
    }
    
    //发送邮箱验证码
    function send_verify_code() {
        $email = $_POST['email'];
        $post_url = "http://www.annhub.cn/php/user/user_verify.php";
        $curl_timeout = 3;
        $post = [
            "email" => "$email"
        ];
        $header = [
            "Cookie:Annhub=$cookie"
        ];

        $res = send_post($post_url, $header, $post);
        $state_message = $res['state_message'];
        
        if($state_message == 0) {
            //echo "<script> alert('验证码已成功发送至邮箱，请查收'); history.go(-1); </script>";
            $state_message = 1; //验证码已成功发送至邮箱，请查收
            echo json_encode($state_message); 
        } else {
            echo json_encode($state_message);
            //header("Location: error.php?code=$state_message");
        }


    }

    //检查cookie
    function check_cookie() {
        $post_url = "http://www.annhub.cn/php/user/user_auth.php";
        $curl_timeout = 3;
        $state_message = 0;
        if(isset($_COOKIE['Annhub'])) {
            $cookie = $_COOKIE['Annhub'];
            $header = [
                "Cookie:Annhub=$cookie"
            ];

            $res = send_post($post_url, $header, null);
            $state_message = $res['state_message'];

        } else {
            $state_message = 203; //cookie过期或无cookie
        }

        return $state_message;
        
    }


?>