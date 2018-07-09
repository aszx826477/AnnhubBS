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
					$sql = mysqli_connect($mysql_address, $mysql_user, $mysql_password, $mysql_database);//链接数据库
					if($sql) {
						$email = explode(' ', $_COOKIE["Annhub"])[0];
						if(mysqli_query($sql, "update user set password = '$password_hash' where email = '$email'")) {
							$return = set_cookie($email, $password_hash, "login");
						}
						else {
							$state_message = -400;
						}
					}
					else {
						$state_message = -400;
					}
					mysqli_close($sql);
				}
				else {
					$state_message = -400;
				}
			}
		}
	}
	if($state_message != 0) {
		$return = array("state_message" => $state_message);
	}
	echo json_encode($return);

?>