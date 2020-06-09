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
				//$sql = mysqli_connect($MYSQL_ADDRESS, $MYSQL_USER, $MYSQL_PASSWORD, $MYSQL_DATABASE);
				//mysqli_set_charset($sql,'utf8');
				$mysqli = new mysqli($MYSQL_ADDRESS, $MYSQL_USER, $MYSQL_PASSWORD, $MYSQL_DATABASE);
				$mysqli -> set_charset('utf8');
				//if($sql) {
				if(!$mysqli -> connect_error) {
					$email = explode(' ', $_COOKIE["Annhub"])[0];
					$head_url = "https://".$COS_bucket.".cos.".$COS_region.".myqcloud.com".$uri;

					$stmt = $mysqli -> prepare("update user set head_url = ? where email = ?");
					$stmt -> bind_param('ss', $head_url, $email);
					//if(!mysqli_query($sql, "update user set head_url = '$head_url' where email = '$email'")) {
					if(!$stmt -> execute()) {
						$state_message = 405;
					}
					$stmt -> close();
				}
				else {
					$state_message = 401;
					$return = array($state_message);
				}
				//mysqli_close($sql);
				$mysqli -> close();
			}
		}
	}
	$return = array("state_message" => $state_message, "head_name" => $uri);
	echo json_encode($return);
?>