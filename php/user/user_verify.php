<?php
	/*
	Author:ALi
	20180522
	*/
	include "../conf.php";
	include "../annhub_func.php";
	$state_message = 0;
	$post_names = array("email");
	$state_message = post_isset($post_names);//检查参数完整
	if($state_message == 0) {
		$email = $_POST["email"];
		$min = array(6);
		$max = array(32);
		$patterns = array("/^[\w]+[@\w][\.\w]+$/");
		$subjects = array($email);
		$state_message = post_match($min, $max, $patterns, $subjects);//检查参数合法
		if($state_message == 0) {
			$sql = mysqli_connect($mysql_address, $mysql_user, $mysql_password, $mysql_database);//链接数据库
			if($sql) {
				$query_1 = mysqli_query($sql, "select email from user where email = '$email'");//检查邮箱是否已被注册
				if(mysqli_num_rows($query_1) == 0) {
					$query_2 = mysqli_query($sql, "select verification_code, time from verify where email = '$email'");//检查是否已获取过验证码
					if(mysqli_num_rows($query_2) == 0) {
						$verification_code = rand(0, 9).rand(0, 9).rand(0, 9).rand(0, 9).rand(0, 9).rand(0, 9);//生成验证码
						$time = time();
						if(mysqli_query($sql, "insert into verify(email, verification_code, time) values('$email', '$verification_code', $time)")) {//邮箱和验证码写入数据库
							$state_message = send_mail($email, $verification_code);//发送邮件
						}
						else {
							$state_message = -400;
						}
					}
					else {
						$result_2 = mysqli_fetch_array($query_2);
						if($result_2["time"] <= time()-300) {//检查验证码是否失效
							$verification_code = rand(0, 9).rand(0, 9).rand(0, 9).rand(0, 9).rand(0, 9).rand(0, 9);//生成验证码
							$time = time();
							if(mysqli_query($sql, "update verify set verification_code = '$verification_code', time = $time where email = '$email'")) {//验证码写入数据库
								$state_message = send_mail($email, $verification_code);//发送邮件
							}
							else {
								$state_message = -400;
							}
						}
						else {
							$verification_code = $result_2["verification_code"];//读取验证码
							$state_message = send_mail($email, $verification_code);//发送邮件
						}
					}
				}
				else {
					$state_message = -102;
				}
			}
			else {
				$state_message = -400;
			}
			mysqli_close($sql);
		}
	}
	$return = array("state_message" => $state_message);
	echo json_encode($return);
?>