<?php
	/*
	Author:ALi
	20180527
	*/
	include "../conf.php";
	include "../annhub_func.php";

	$state_message = check_cookie();
	if($state_message == 0) {
		//$post_names = array("http_method", "http_parameters", "http_headers");
		//$state_message = post_isset($post_names);//检查参数完整
		/*
			$http_method = $_POST["http_method"];
			$http_parameters = $_POST["http_parameters"];
			$http_headers = $_POST["http_headers"];
			if($http_method == "put" || $http_method == "post") {
				if($http_parameters == "null") {
					$http_parameters = "";
				}
				if($http_headers == "null") {
					$http_headers = "";
				}
				*/
				
		$email = explode(' ', $_COOKIE["Annhub"])[0];
		$message = create_head_name();
		$state_message = $message[0];
		if($state_message == 0) {
			
			$head_name = $message[1];
			$info = array("head_name" => $head_name);
			//$uri = $COS_head_uri.$head_name;
			//$signature = create_COS_signature($http_method, $uri, $http_parameters, $http_headers, 300);
			//$return = array("state_message" => $state_message, "uri" => $uri,"signature" => $signature);
			$return = array("state_message" => $state_message, "info" => $info);
		} else {
			$state_message = -101;
		}
		
	}

	if($state_message != 0) {
		$return = array("state_message" => $state_message);
	}


	echo json_encode($return);
?>