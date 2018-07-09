<?php
	/*
	Author:ALi && YellowBee
	20180530 && 2018-6-12
	*/
	include "../conf.php";
	include "../annhub_func.php";
	$state_message = check_cookie();
	if($state_message == 0) {
		$message = create_apk_name();
		$state_message = $message[0];
		if($state_message == 0) {
			$apk_name = $message[1];
			$info = array('apk_name' => $apk_name);
			$return = array('state_message' => $state_message, 'info' => $info);
		} else {
			$state_message = -101;
		}
	}	

	if($state_message != 0) {
		$return = array("state_message" => $state_message);
	}

	echo json_encode($return);
?>