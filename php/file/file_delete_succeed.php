<?php
	/*
	YellowBeee
	2018-6-13
	*/
	include "../conf.php";
	include "../annhub_func.php";
	$state_message = check_cookie();
	if($state_message == 0) {

		$btn_code = $_POST['btn_code'];

		$message = ensure_delete_apk_name($btn_code);
		$state_message = $message[0];
		if($state_message == 0) {
			$apk_name = $message[1];
			$url = "/apk/".$apk_name;
			//Web服务器进行COS删除操作后，后端负责check是否删除成功，若成功删除则返回的state_message = -300
			$state_message = COS_check($url); 
			
			if($state_message == -300) {
				$sql = mysqli_connect($mysql_address, $mysql_user, $mysql_password, $mysql_database);
				if($sql) {
					if(mysqli_query($sql, "delete from apk where apk_name = '$apk_name'")) {
						//查询该用户总共拥有的apk数
						$email = explode(' ', $_COOKIE["Annhub"])[0];
						$query = mysqli_query($sql, "select user_id from user where email = '$email'");
						$res =  mysqli_fetch_array($query);
						$user_id = $res['user_id'];
						$file_num = mysqli_num_rows(mysqli_query($sql, "select apk_id from apk where user_id = '$user_id'"));
						//更新user表中的应用总数
						if(mysqli_query($sql, "update user set file_num = '$file_num' where user_id = '$user_id'")) {
							$state_message = 0;
						} else {
							$state_message = -4001;
						}
					} else {
						$state_message = -4001;
					}
				}
				else {
					$state_message = -4002;
				}
				mysqli_close($sql);
				
			}
			
		}
	}
	$return = array('state_message' => $state_message);
	echo json_encode($return);
?>