<?php
	/*
	Author:ALi
	20180527
	*/
	include "../conf.php";
	include "../annhub_func.php";

	$state_message = check_cookie();
	
	if($state_message == 0) {
		$email = explode(' ', $_COOKIE["Annhub"])[0];
		$message = create_head_name();
		$state_message = $message[0];
		if($state_message == 0) {
			$head_name = $message[1];
			$info = array("head_name" => $head_name);
			$return = array("state_message" => $state_message, "info" => $info);
		} 
		
	}

	if($state_message != 0) {
		$return = array("state_message" => $state_message);
	}


	echo json_encode($return);
?>