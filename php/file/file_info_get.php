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

			$query_app = mysqli_query($sql, "select apk_real_name, upload_date, protected, scanned, app, report, report_pdf, app_protect, report_protect, report_protect_pdf from apk where user_id = '$user_id'");
			$app_total_num = mysqli_num_rows($query_app);
			$app = array();
			//$row = mysqli_fetch_array($query_app);
			for($i = 0; $i < $app_total_num; $i ++) {
				$row = mysqli_fetch_array($query_app);
				$app[$i] = array(
					'apk_real_name' => $row['apk_real_name'],
					'upload_date' => $row['upload_date'],
					'protected' => $row['protected'],
					'scanned' => $row['scanned'],

					'app' => $row['app'],
					'report' => $row['report'],
					'report_pdf' => $row['report_pdf'],

					'app_protect' => $row['app_protect'],
					'report_protect' => $row['report_protect'],
					'report_protect_pdf' => $row['report_protect_pdf']
					
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