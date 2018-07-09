<?php
	/*
	YellowBee
	2018-6-10
	*/
	include "../conf.php";
	include "../annhub_func.php";
	$state_message = check_cookie();
	if($state_message == 0) {
		$post_names = array("nickname");
		$state_message = post_isset($post_names);//检查参数完整
		if($state_message == 0) {
			$nickname = $_POST["nickname"];
			
			$min = array(4);
			$max = array(16);
			$patterns = array("/^[\S]+$/");
			$subjects = array($nickname);
			$state_message = post_match($min, $max, $patterns, $subjects);//检查参数合法
			
			if($state_message == 0) {
				$sql = mysqli_connect($mysql_address, $mysql_user, $mysql_password, $mysql_database);//链接数据库
				if($sql) {
					$email = explode(' ', $_COOKIE["Annhub"])[0];
					if(! mysqli_query($sql, "update user set nickname = '$nickname' where email = '$email'")) {
						$state_message = -400;
					}
				} else {
					$state_message = -400;
				}
				mysqli_close($sql);
			} else {
				$state_message = -400;
			}
		}
	}

	$return = array("state_message" => $state_message);
	
	echo json_encode($return);

?>