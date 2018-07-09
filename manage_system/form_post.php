<?php
	/*
	YellowBee
	2018-6-6
	*/

	include "manage_func.php";

	if(isset($_GET['op'])) {
		$op = $_GET['op'];
		switch($op) {
			case 1: //发送邮箱验证码
				send_verify_code();
				break;
			case 2: //注册
				register();
				break;
			case 3: //登录
				login();
				break;
			case 4:
				change_password();
				break;
			case 5:
				change_email();
				break;
			case 6:
				change_nickname();
				break;
			default:
				$state_message = -400;
				include "500.html";
				break;

		}
	}


?>