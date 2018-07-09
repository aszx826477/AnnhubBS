<?php
	/*
	Author:ALi
	20180522
	*/
	function post_isset($post_names) {//检查post值的完整性
		$state_message = 0;
		for($i = 0;$i < count($post_names);$i++) {
			if(!isset($_POST[$post_names[$i]])) {
				$state_message = -201;
				break;
			}
		}
		return $state_message;
	}

	function post_match($min, $max, $patterns, $subjects) {//检查值的合法性
		$state_message = 0;
		for($i = 0;$i < count($subjects);$i++) {
			if(!preg_match($patterns[$i], $subjects[$i]) || strlen($subjects[$i]) < $min[$i] || strlen($subjects[$i]) > $max[$i]) {
				$state_message = -101;
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
			return -401;
		}
		else {
			return 0;
		}
	}

	function create_token($email, $password, $token_time_end) {//创建token
		$chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$%^&*()-_ []{}<>~`+=,.;:/?|'";
		$length = strlen($chars)-1;
		$token_key = "";
		for($i = 0; $i < 16; $i++) {
			$token_key = $token_key.$chars[rand(0, $length)];
		}
		$token = base64_encode(openssl_encrypt($email.' '.hash("sha256", $email.$token_key.$token_time_end).' '.$token_time_end, "AES-128-CFB", $password));
		return array($token, $token_key);
	}

	function check_token($token, $email, $password, $token_key, $token_time_end) {//检查token
		$state_message = 0;
		$token_message = explode(' ', openssl_decrypt(base64_decode($token), "AES-128-CFB", $password));
		$token_hash = hash("sha256", $token_message[0].$token_key.$token_message[2]);

		if(count($token_message) != 3 || $email != $token_message[0] || $token_hash != $token_message[1] || $token_time_end != $token_message[2]) {
			$state_message = -106;
		} 

		
		return $state_message;
	}

	function set_cookie($email, $password, $mode) {//发送cookie
		include "conf.php";
		$state_message = 0;
		$sql = mysqli_connect($mysql_address, $mysql_user, $mysql_password, $mysql_database);
		if($sql) {
			if($mode == "register") {
				$token_time_end = time()+3600;
				$token_array = create_token($email, $password, $token_time_end);
				$token = $token_array[0];
				$token_key = $token_array[1];
				$register_time = time();
				$register_date = date("Y-m-d");
				if(mysqli_query($sql, "insert into user(email, password, token_key, token_time_end, nickname, head_url, file_num, file_protected_num, file_unprotected_num, file_scan_num, file_leak_num, register_time, register_date) values('$email', '$password', '$token_key', '$token_time_end', '$nickname_default', '$head_url_default', 0, 0, 0, 0, 0, '$register_time', '$register_date')") && mysqli_query($sql, "delete from verify where email = '$email'")) {
					$info = array("content" => $email.' '.$token, "time" => $token_time_end);
					$return = array("state_message" => $state_message, "info" => $info);
				}
				else {
					$state_message = -400;
				}
			}
			else if($mode == "login") {
				$token_time_end = time()+3600;
				$token_array = create_token($email, $password, $token_time_end);
				$token = $token_array[0];
				$token_key = $token_array[1];
				if(mysqli_query($sql, "update user set token_key = '$token_key', token_time_end = $token_time_end where email = '$email'")) {
					$info = array("content" => $email.' '.$token, "time" => $token_time_end);
					$return = array("state_message" => $state_message, "info" => $info);
				}
				else {
					$state_message = -400;
				}
			}
			else {
				$state_message = -400;
			}

			
		} else {
			$state_message = -400;
		}
		mysqli_close($sql);

		if($state_message != 0) {
			$return = array("state_message" => $state_message);
		}
		return $return;
	}

	function disabled_cookie($email) {
		include "conf.php";
		$state_message = 0;
		$sql = mysqli_connect($mysql_address, $mysql_user, $mysql_password, $mysql_database);
		if($sql) {
			$query_1 = mysqli_query($sql, "select password from user where email = '$email'");
			$result_1 = mysqli_fetch_array($query_1);
			$token_array = create_token($email, $result_1["password"], 0);
			$token = $token_array[0];
			$token_key = $token_array[1];
			if(mysqli_query($sql, "update user set token_key = '$token_key', token_time_end = 0 where email = '$email'")) {
				$info = array("content" => $email.' '.$token, "time" => 1);
				$return = array("state_message" => $state_message, "info" => $info);
			}
			else {
				$state_message = -400;
			}

		} else {
			$state_message = -400;
		}
		mysqli_close($sql);

		if($state_message != 0) {
			$return = array("state_message" => $state_message);
		}
		return $return;
	}

	function check_cookie() {//检查cookie
		include "conf.php";
		$state_message = 0;
		$cookie = $_COOKIE['Annhub'];
		$cookie_message = explode(' ', $cookie);
		if(count($cookie_message) == 2) {
			$email = $cookie_message[0];
			$token = $cookie_message[1];
			$sql = mysqli_connect($mysql_address, $mysql_user, $mysql_password, $mysql_database);
			if($sql) {
				$query_1 = mysqli_query($sql, "select password, token_key, token_time_end from user where email = '$email'");
				$result_1 = mysqli_fetch_array($query_1);
				$state_message = check_token($token, $email, $result_1["password"], $result_1["token_key"], $result_1["token_time_end"]);
			}
			else {
				$state_message = -400;
			}
			mysqli_close($sql);
		}
		else {
			$state_message = -106;
		}
		return $state_message;
	}

	//创建用户头像名
	function create_head_name() {
		include "conf.php";
		$state_message = 0;
		$sql = mysqli_connect($mysql_address, $mysql_user, $mysql_password, $mysql_database);
		if($sql) {
			$email = explode(' ', $_COOKIE["Annhub"])[0];
			$query_1 = mysqli_query($sql, "select user_id, register_time from user where email = '$email'");
			$result_1 = mysqli_fetch_array($query_1);
			$head_name = hash("sha256", openssl_encrypt($email, "AES-128-CFB", $result_1["user_id"]))."-".$result_1["register_time"].".jpg";
			$return = array($state_message, $head_name);
		}
		else {
			$state_message = -400;
			$return = array($state_message);
		}
		mysqli_close($sql);
		return $return;
	}


	//生成apk的名称
	function create_apk_name() {
		include "conf.php";
		$state_message = 0;
		$sql = mysqli_connect($mysql_address, $mysql_user, $mysql_password, $mysql_database);
		if($sql) {
			
			$email = explode(' ', $_COOKIE["Annhub"])[0];
			$query_1 = mysqli_query($sql, "select user_id, register_time from user where email = '$email'");
			$result_1 = mysqli_fetch_array($query_1);
			/*
			$user_id = $result_1['user_id'];

			$query_2 = mysqli_query($sql, "select apk_id from apk where user_id = '$user_id'");
			$apk_code = mysqli_num_rows($query_2) + 1; 
			*/
			$query = mysqli_query($sql, "select AUTO_INCREMENT from INFORMATION_SCHEMA.TABLES where TABLE_NAME='apk'");
			$res = mysqli_fetch_array($query);
			//获取apk表中的下一个自增id，作为apk的code
			$apk_code = $res['AUTO_INCREMENT'];

			$apk_name = hash("sha256", openssl_encrypt($email, "AES-128-CFB", $result_1["user_id"])) . "-" . $result_1["register_time"] . "-" . $apk_code . ".apk";
			$return = array($state_message, $apk_name);
		} else {
			$state_message = -400;
			$return = array($state_message);
		}
		mysqli_close($sql);
		return $return;
	}

	//生成用户指定删除的apk的名称
	function ensure_delete_apk_name($btn_code) {
		include "conf.php";
		$state_message = 0;
		$sql = mysqli_connect($mysql_address, $mysql_user, $mysql_password, $mysql_database);
		if($sql) {
			$email = explode(' ', $_COOKIE["Annhub"])[0];
			$query = mysqli_query($sql, "select user_id, register_time from user where email = '$email'");
			$res = mysqli_fetch_array($query);
			$user_id = $res['user_id'];

			$query_apk = mysqli_query($sql, "select apk_id from apk where user_id = '$user_id'");
			$max_bound = mysqli_num_rows($query_apk);

			if($btn_code >= 0 && $btn_code < $max_bound) { //防止delete参数越界
				for($i = 0; $i <= $btn_code; $i ++) { //循环取出对应的apk_id
					$res_apk = mysqli_fetch_array($query_apk); 
				}
				$apk_name = hash("sha256", openssl_encrypt($email, "AES-128-CFB", $res["user_id"])) . "-" . $res["register_time"] . "-" . $res_apk['apk_id'] . ".apk";
				$return = array($state_message, $apk_name);
			} else {
				$state_message = -888; //delete参数越界
			}
			

			
		} else {
			$state_message = -400;
			$return = array($state_message);
		}
		mysqli_close($sql);
		return $return;
	}

/*	
	//由于采用了COS_PHP_SDK，所以计算的具体过程略去
	function create_COS_signature($http_method, $http_uri, $http_parameters, $http_headers, $time) {
		include "conf.php";
		$time_start = time();
		$time_end = $time_start + $time;
		$sign_time = $time_start.';'.$time_end;
		$sign_key = hash_hmac("sha1", $sign_time, $COS_secret_key);
		$http_string = $http_method."\n".$http_uri."\n".$http_parameters."\n".$http_headers."\n";
		$http_string_sha1 = sha1($http_string);
		$string_to_sign = "sha1\n".$sign_time."\n".$http_string_sha1."\n";
		$signature = hash_hmac("sha1", $string_to_sign, $sign_key);
		return $signature;
	}

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
			$state_message = -301;
		}
		return $state_message;
	}
*/

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
				$state_message = -303;
			}

		}
		catch (Exception $e) {
			$state_message = -300;
		}
		return $state_message;
	}
?>