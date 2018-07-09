<?php
	/*
	YellowBee
	2018-6-11
	*/
	include "../conf.php";
	include "../annhub_func.php";

	$state_message = check_cookie();
	if($state_message == 0) {	
		$email = explode(' ', $_COOKIE["Annhub"])[0];
		$sql = mysqli_connect($mysql_address, $mysql_user, $mysql_password, $mysql_database);
		if($sql) {
			$query = mysqli_query($sql, "select user_id from user where email = '$email'");
			$result = mysqli_fetch_array($query);
			$user_id = $result['user_id'];

			$query_app = mysqli_query($sql, "select apk_real_name, upload_date, report_path, file_path from apk where user_id = '$user_id'");
			$app_total_num = mysqli_num_rows($query_app);
			$app = array();
			for($i = 0; $i < $app_total_num; $i ++) {
				$row = mysqli_fetch_array($query_app);
				$app[$i] = array(
					'app_name' => $row['apk_real_name'],
					'app_date' => $row['upload_date'],
					'app_report_url' => $row['report_path'],
					'app_download_url' => $row['file_path']
				);
			}
			$info = array(
				'app_total_num' => $app_total_num,
				'app' => $app
			);
		} else {
			$state_message = -4002;
		}
		
	}

	if($state_message != 0) {
		$return = array('state_message' => $state_message);
	}
	$return = array('state_message' => $state_message, 'info' => $info);
	echo json_encode($return);


?>