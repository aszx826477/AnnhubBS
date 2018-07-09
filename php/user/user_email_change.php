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
				$sql = mysqli_connect($mysql_address, $mysql_user, $mysql_password, $mysql_database);//链接数据库
				if($sql) {
					$query_1 = mysqli_query($sql, "select verification_code, time from verify where email = '$email'");
					$result_1 = mysqli_fetch_array($query_1);
					if(mysqli_num_rows($query_1) != 0 && $result_1["time"] <= time()-300) {//检查验证码是否过期
						$state_message = -103;
					}
					else {
						if($verification_code == $result_1["verification_code"]) {//检查验证码
							$email_old = explode(' ', $_COOKIE["Annhub"])[0];
							$query_2 = mysqli_query($sql, "select password from user where email = '$email_old'");
							$result_2 = mysqli_fetch_array($query_2);

							//新旧邮箱的问题产生的Bug
							$query_3 = mysqli_query($sql, "select password from user where email = '$email'");

							if(mysqli_num_rows($query_3) == 0) {
								if(mysqli_query($sql, "update user set email = '$email' where email = '$email_old'") && mysqli_query($sql, "delete from verify where email = '$email'")) {
									$return = set_cookie($email, $result_2["password"], "login");
								}
								else {
									$state_message = -400;
								}
							}
							else {
								$state_message = -102;
							}
						}
						else {
							$state_message = -103;
						}
					}
				}
				else {
					$state_message = -400;
				}
				mysqli_close($sql);
			}
		}
	}
	if($state_message != 0) {
		$return = array("state_message" => $state_message);
	}
	echo json_encode($return);
?>