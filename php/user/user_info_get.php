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
		$sql = mysqli_connect($mysql_address, $mysql_user, $mysql_password, $mysql_database);
		if($sql) {
			$query_1 = mysqli_query($sql, "select nickname, head_url, file_num, file_protected_num, file_unprotected_num, file_scan_num, file_leak_num, register_time, register_date from user where email = '$email'");
			$result_1 = mysqli_fetch_array($query_1);
			$info = array(
				"nickname" => $result_1["nickname"], 
				"head_url" => $result_1["head_url"], 
				"file_num" => (int)$result_1["file_num"], 
				"file_protected_num" => (int)$result_1["file_protected_num"], 
				"file_unprotected_num" => (int)$result_1["file_unprotected_num"], 
				"file_scan_num" => (int)$result_1["file_scan_num"],
				"file_leak_num" => (int)$result_1["file_leak_num"],
				"register_time" => (int)$result_1["register_time"],
				"register_date" => $result_1["register_date"]
			);
			$return = array("state_message" => $state_message, "info" => $info);
		} else {
			$state_message = -400;
		}
		mysqli_close($sql);
	}
	if($state_message != 0) {
		$return = array("state_message" => $state_message);
	}
	echo json_encode($return);
?>