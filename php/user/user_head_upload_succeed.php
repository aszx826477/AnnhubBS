<?php
	/*
	Author:ALi
	20180529
	*/
	include "../conf.php";
	include "../annhub_func.php";
	$state_message = check_cookie();
	if($state_message == 0) {
		$message = create_head_name();
		$state_message = $message[0];
		if($state_message == 0) {
			$head_name = $message[1];
			$uri = "/head/".$head_name;
			$state_message = COS_check($uri);
			if($state_message == 0) {
				$sql = mysqli_connect($mysql_address, $mysql_user, $mysql_password, $mysql_database);
				if($sql) {
					$email = explode(' ', $_COOKIE["Annhub"])[0];
					$head_url = "https://".$COS_bucket.".cos.".$COS_region.".myqcloud.com".$uri;
					if(!mysqli_query($sql, "update user set head_url = '$head_url' where email = '$email'")) {
						$state_message = -4001;
					}
				}
				else {
					$state_message = -4002;
					$return = array($state_message);
				}
				mysqli_close($sql);
			}
		}
	}
	$return = array("state_message" => $state_message, "head_name" => $uri);
	echo json_encode($return);
?>