<?php 

    include_once "utils.php";

    if(isset($_GET['fun'])) {
        switch($_GET['fun']) {
            case 'upload_head':
                upload_head();
                break;
            case 'upload_app':
                upload_app();
                break;
            case 'delete_app':
                if(isset($_GET['file'])) {
                    delete_app();
                }
                break;
            default:
                break;
        }
    }


    //上传至腾讯云的对象存储
    function COS_upload($file_name, $file_path) {
        include "conf.php";
        require(__DIR__.DIRECTORY_SEPARATOR."COS/cos-autoloader.php");
        $state_message = 0;
        $cosClient = new Qcloud\Cos\Client(array(
            "region" => $COS_region, 
            "credentials" => array(
                "appId" => $COS_appid, 
                "secretId" => $COS_secret_id, 
                "secretKey" => $COS_secret_key
            )
        ));
        $body = fopen($file_path, 'rb');
        try {
            $result = $cosClient->Upload(
                $COS_bucket, 
                $file_name, 
                $body
            );
        }
        catch (Exception $e) {
            $state_message = 302;
        }
        return $state_message;
    }

    //从对象存储云中删除文件
    function COS_delete($file_name) {
        include "conf.php";
        require(__DIR__.DIRECTORY_SEPARATOR."COS/cos-autoloader.php");
        $state_message = 0;
        $cosClient = new Qcloud\Cos\Client(array(
            "region" => $COS_region, 
            "credentials" => array(
                "appId" => $COS_appid, 
                "secretId" => $COS_secret_id, 
                "secretKey" => $COS_secret_key
            )
        ));
        try {
            $result = $cosClient->deleteObject(array(
                'Bucket' => $COS_bucket,
                'Key' => $file_name,
            ));
        }
        catch (Exception $e) {
            $state_message = 303;
        }
        return $state_message;
    }

    //上传头像
    function upload_head() {
        $filename = $_FILES["file"]["name"];
        $filepath = $_FILES["file"]["tmp_name"];
        $filetype = $_FILES["file"]["type"];
        $filesize = $_FILES["file"]["size"];
        $error = $_FILES["file"]["error"];
        if ($error > 0) {
            header("Location: error.php?code=$state_message");

        } else {
            /*
            echo "Upload: " . $filename . "<br />";
            echo "Type: " . $filetype . "<br />";
            echo "Size: " . ($filesize / 1024) . " Kb<br />";
            echo "Temp file: " . $filepath. "<br />";
            */
            
            //文件存入Web缓存后，向后端发起上传COS请求，获取头像唯一的文件名xxx.jpg
            if(is_uploaded_file($filepath)) {
                $post_url = "http://www.annhub.cn/php/user/user_head_upload_request.php";
                $curl_timeout = 3;
                $cookie = $_COOKIE['Annhub'];
                $header = [
                    "Cookie: Annhub=$cookie"
                ];

                $res = send_post($post_url, $header, null);
                $state_message = $res['state_message'];

                if($state_message == 0) {
                    $filename = $res['info']['head_name'];
                    $state_message = COS_upload("head/" . $filename, $filepath); //成功获取文件名后上传
                    
                    if($state_message == 0) {

                        $post_url = "http://www.annhub.cn/php/user/user_head_upload_succeed.php";
                        $curl_timeout = 3;
                        $cookie = $_COOKIE['Annhub'];
                        $header = [
                            "Cookie: Annhub=$cookie"
                        ];

                        $res = send_post($post_url, $header, null);
                        $state_message = $res['state_message'];
                    }
                }               
            } else {
                $state_message = 305; //没有使用http post方法上传文件
                
            }

        }

        //错误处理
        if($state_message == 0) {
            $return = array('$state_message' => $state_message);
            echo json_encode($return);
        } else {
            header("Location: error.php?code=$state_message");
        }
    }

    //上传应用
    function upload_app() {
        $filename = $_FILES["file"]["name"];
        $filepath = $_FILES["file"]["tmp_name"];
        $filetype = $_FILES["file"]["type"];
        $filesize = $_FILES["file"]["size"];
        $error = $_FILES["file"]["error"];
        if ($error > 0) {
            header("Location: error.php?code=$state_message");
            //return $state_message;
        } else {
            //文件存入Web缓存后，向后端发起上传COS请求，获取头像唯一的文件名xxx.jpg
            if(is_uploaded_file($filepath)) {
            
                $post_url = "http://www.annhub.cn/php/file/file_upload_request.php";
                $curl_timeout = 3;
                $cookie = $_COOKIE['Annhub'];
                $header = [
                    "Cookie: Annhub=$cookie"
                ];

                $res = send_post($post_url, $header, null);
                $state_message = $res['state_message'];
                $filename = $res['info']['apk_name'];

                if($state_message == 0) {
                    
                    $state_message = COS_upload("apk/" . $filename, $filepath); //成功获取文件名后上传
                    //使用COS工具上传文件时，大于8M的文件会自动调用分片上传的方法，需要使用到php-xml扩展
                    
                    if($state_message == 0) {
                        $post_url = "http://www.annhub.cn/php/file/file_upload_succeed.php";
                        $curl_timeout = 3;
                        $file_real_name = $_FILES["file"]["name"];
                        $post = [
                            "file_real_name" => $file_real_name
                        ];
                        $cookie = $_COOKIE['Annhub'];
                        $header = [
                            "Cookie: Annhub=$cookie"
                        ];

                        $res = send_post($post_url, $header, $post);
                        $state_message = $res['state_message'];
                    }   
                    
                } 
            } else {
                $state_message = 305; //没有使用http post方法上传文件
            }
            
        }

        //错误处理
        if($state_message == 0) {
            //$return = array('$state_message' => $state_message);
            //echo json_encode($return);
            echo json_encode($state_message);
        } else {
            header("Location: error.php?code=$state_message");
        }

    }
    //删除指定的应用
    function delete_app() {
        $post_url = "http://www.annhub.cn/php/file/file_delete_request.php";
        $curl_timeout = 3;
        $cookie = $_COOKIE['Annhub'];
        $header = [
            "Cookie: Annhub=$cookie"
        ];
        $btn_code = $_GET['file'];
        $post = [
            'btn_code' => $btn_code
        ];
        
        $res = send_post($post_url, $header, $post);
        $state_message = $res['state_message'];
        $apk_name = $res['info']['apk_name'];

        if($state_message == 0) {


            $state_message = COS_delete("apk/" . $apk_name); //进行COS删除操作    

            if($state_message == 0) {
                $post_url = "http://www.annhub.cn/php/file/file_delete_succeed.php";
                $curl_timeout = 3;
                $post = [
                    'btn_code' => $btn_code
                ];
                $cookie = $_COOKIE['Annhub'];
                $header = [
                    "Cookie: Annhub=$cookie"
                ];

                $res = send_post($post_url, $header, $post);
                $state_message = $res['state_message'];
            }
        }
        
        //错误处理
        if($state_message == 0) {
            //$return = array('$state_message' => $state_message);
            //echo json_encode($return);
            echo json_encode($state_message);
        } else {
            header("Location: error.php?code=$state_message");
        }
        
    }
?>