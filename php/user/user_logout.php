<?php
	/*
	Author:ALi
	20180527
	*/
	include "../annhub_func.php";
	$state_message = check_cookie();
	if($state_message == 0) {
		$email = explode(' ', $_COOKIE["Annhub"])[0];
		$return = disabled_cookie($email);
	} else {
		$return = array("state_message" => $state_message);
	}


	echo json_encode($return);
?>