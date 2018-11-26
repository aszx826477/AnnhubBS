<?php
	/*
	Author:ALi
	20180525
	*/
	include "../conf.php";
	include "../annhub_func.php";
	$state_message = 0;
	$post_names = array("email", "password");
	$state_message = post_isset($post_names);//检查参数完整性
	$return = array();
	if($state_message == 0) {
		$email = $_POST["email"];
		$password = $_POST["password"];
		$min = array(6, 6);
		$max = array(32, 16);
		$patterns = array("/^[\w]+[@\w][\.\w]+$/", "/^[\S]+$/");
		$subjects = array($email, $password);
		$state_message = post_match($min, $max, $patterns, $subjects);
		if($state_message == 0) {
			$sql = mysqli_connect($mysql_address, $mysql_user, $mysql_password, $mysql_database);//链接数据库
			if($sql) {
				$password_hash = hash("sha256", $password);
				$query_1 = mysqli_query($sql, "select password from user where email = '$email'");
				$result_1 = mysqli_fetch_array($query_1);
				if(mysqli_num_rows($query_1) != 0 && $password_hash == $result_1["password"]) {//检查密码
					$return = set_cookie($email, $password_hash, "login");
				}
				else {
					$state_message = -105;
				}
			}
			else {
				$state_message = -402;
			}
			mysqli_close($sql);
		}
	}
	if($state_message != 0) {
		$return = array("state_message" => $state_message);
	}
	echo json_encode($return);
?>