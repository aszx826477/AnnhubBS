<?php

	/*
	* @author:YellowBee
	* @date:2018-12-06
	*/
	include "../conf.php";
	include "../annhub_func.php";

	$state_message = 0;
	$state_message = check_cookie();
	$res = array("state_message" => $state_message);

	echo json_encode($res);


?>