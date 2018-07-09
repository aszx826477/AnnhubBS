<?php
	/*
	Author:ALi && YellowBeee
	201805230 && 2018-6-12
	*/
	include "../conf.php";
	include "../annhub_func.php";
	$state_message = check_cookie();
	if($state_message == 0) {

		$apk_real_name = $_POST['file_real_name'];

		$message = create_apk_name();
		$state_message = $message[0];
		if($state_message == 0) {
			$apk_name = $message[1];
			$url = "/apk/".$apk_name;
			$state_message = COS_check($url); //Web服务器上传成功后，后端负责check是否上传成功，若成功则进行数据库的更新操作
			if($state_message == 0) {
				$sql = mysqli_connect($mysql_address, $mysql_user, $mysql_password, $mysql_database);
				if($sql) {
					$email = explode(' ', $_COOKIE["Annhub"])[0];
					$query = mysqli_query($sql, "select user_id from user where email = '$email'");
					$result =  mysqli_fetch_array($query);
					$user_id = $result['user_id'];
					$upload_time = time();
					$upload_date = date("Y-m-d");
					$apk_url = "https://".$COS_bucket.".cos.".$COS_region.".myqcloud.com".$url;

					if(mysqli_query($sql, "insert into apk(user_id, apk_name, apk_real_name, upload_time, upload_date, upload, protected, scanned, report_path, file_path) values($user_id, '$apk_name', '$apk_real_name', $upload_time, '$upload_date', 1, 0, 0, '$report_path_default', '$apk_url')")) {
						//查询该用户总共拥有的apk数
						$file_num = mysqli_num_rows(mysqli_query($sql, "select apk_id from apk where user_id = '$user_id'"));
						//更新user表中的应用总数
						if(!mysqli_query($sql, "update user set file_num = '$file_num' where user_id = '$user_id'")) {
							$state_message = -4001;
						}
					} else {
						$state_message = -4001;
					}
					

				}
				else {
					$state_message = -4002;
					$return = array($state_message);
				}
				mysqli_close($sql);
			}
		}
	}
	$return = array("state_message" => $state_message);
	echo json_encode($return);
?>