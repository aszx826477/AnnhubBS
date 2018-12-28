<?php
	include 'modules/class/authenticate.php';
	include 'modules/class/error.php';
	include 'modules/class/file.php';
	include 'modules/class/user.php';

	$authenticate = new authenticate();
	$error = new error();
	$file = new file();
	$user = new user();

	if(isset($_COOKIE['Annhub']) && isset($_GET["fun"])) {
		$fun = $_GET["fun"];
		switch ($fun) {
			case 'logout':
				$authenticate -> logout();
				break;
			case 'login':
				$authenticate -> login();
				break;
			case 'send_verify_code':
				$state_code = $authenticate -> send_verify_code();
				if($state_code == 0) {
					echo "<script> alert('验证码已发送至邮箱'); history.go(-1);</script>";
				} else {
					$error->error_code_handle($state_code);
				}
				break;
			case 'upload_head':
				$file -> upload_head();
				break;
			case 'upload_app':
				$file -> upload_app();
				break;
			case 'delete_app':
				$file -> delete_app();
				break;
			case 'register':
				$state_code = $user -> register();
				if($state_code == 0) {
					header('Location: manage_index.php');
				} else {
					$error->error_code_handle($state_code);
				}
				break;
			case 'change_password':
				$state_code = $user -> change_password();
				if($state_code == 0) {
					echo "<script> alert('您已成功修改密码');</script>";
					header('Location: information.php');
				} else {
					$error->error_code_handle($state_code);
				}
				break;
			case 'change_email':
				$state_code = $user -> change_email();
				if($state_code == 0) {
					header('Location: information.php');
				} else {
					$error->error_code_handle($state_code);
				}
				break;
			case 'change_nickname':
				$state_code = $user -> change_nickname();
				if($state_code == 0) {
					header('Location: information.php');
				} else {
					$error->error_code_handle($state_code);
				}
				break;
			default:
				
				break;
		}
	}

?>