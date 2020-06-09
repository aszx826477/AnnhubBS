<?php
	/*
	YellowBee
	2018-6-13
	*/
	include "../conf.php";
	include "../annhub_func.php";
	$state_message = check_cookie();
	if($state_message == 0) {
		$btn_code = $_POST['btn_code'];

		$message = ensure_apk_name($btn_code);
		$state_message = $message[0];

		if($state_message == 0) {
			$apk_name = $message[1];
			$info = array('apk_name' => $apk_name);
			$return = array('state_message' => $state_message, 'info' => $info);
		}
		
	}	

	if($state_message != 0) {
		$return = array("state_message" => $state_message);
	}

	echo json_encode($return);
?>