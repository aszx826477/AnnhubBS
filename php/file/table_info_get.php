<?php
	/*
	YellowBee
	2018-6-11
	*/
	include "../conf.php";
	include "../annhub_func.php";

	$state_message = check_cookie();
	$info = array();
	if($state_message == 0) {	
		$email = explode(' ', $_COOKIE["Annhub"])[0];
		$sql = mysqli_connect($MYSQL_ADDRESS, $MYSQL_USER, $MYSQL_PASSWORD, $MYSQL_DATABASE);
		mysqli_set_charset($sql,'utf8');
		if($sql) {
			$query = mysqli_query($sql, "select user_id from user where email = '$email'");
			$result = mysqli_fetch_array($query);
			$user_id = $result['user_id'];

			$query_app = mysqli_query($sql, "select apk_name, apk_real_name, protected, scanned from apk where user_id = '$user_id'");
			$app_total_num = mysqli_num_rows($query_app);
			$report = array();
			//$row = mysqli_fetch_array($query_app);
			for($i = 0; $i < $app_total_num; $i ++) {
				$row = mysqli_fetch_array($query_app);
				$apk_real_name = $row['apk_real_name'];
				$apk_name = $row['apk_name'];
				$protected =  $row['protected'];
				$scanned = $row['scanned'];
				//使用apk_name来查找
				$query_report = mysqli_query($sql, "select apk_real_name, high, middle, low, warning, total, score, level from report where apk_name = '$apk_name' and state = 0");
				$row_report = mysqli_fetch_array($query_report);

				//而apk_real_name是用于前端展示给用户的名称
				$report[$i] = array(
					'apk_real_name' => $row_report['apk_real_name'],
					'protected' => $protected,
					'scanned' => $scanned,
					'high' => $row_report['high'],
					'middle' => $row_report['middle'],
					'low' => $row_report['low'],
					'warning' => $row_report['warning'],
					'total' => $row_report['total'],
					'score' => $row_report['score'],
					'level' => $row_report['level']
				);
			}
			$info = array(
				'app_total_num' => $app_total_num,
				'report' => $report
			);
		} else {
			$state_message = 401;
		}
		
	}

	if($state_message != 0) {
		$return = array('state_message' => $state_message);
	}
	$return = array('state_message' => $state_message, 'info' => $info);
	echo json_encode($return);


?>