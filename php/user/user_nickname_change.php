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
				$sql = mysqli_connect($MYSQL_ADDRESS, $MYSQL_USER, $MYSQL_PASSWORD, $MYSQL_DATABASE);
				mysqli_set_charset($sql,'utf8');
				if($sql) {
					$email = explode(' ', $_COOKIE["Annhub"])[0];
					if(! mysqli_query($sql, "update user set nickname = '$nickname' where email = '$email'")) {
						$state_message = 405;
					}
				} else {
					$state_message = 401;
				}
				mysqli_close($sql);
			} 
			
		}
	}

	$return = array("state_message" => $state_message);
	
	echo json_encode($return);

?>