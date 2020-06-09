<?php
	include_once "utils.php";

	if (isset($_GET['fun'])) {
		switch($_GET['fun']) {
			case 'register':
				register();
				break;
			case 'change_password':
				change_password();
				break;
			case 'change_nickname';
				change_nickname();
				break;
			case 'change_email':
				change_email();
				break;
			default:
				break;
		}
	}

	//注册新用户
	function register() {
		$email = $_POST['email'];
		$verification_code = $_POST['verification_code'];
		$password = $_POST['password'];
		$password_again = $_POST['password_again'];
		$post_url = "http://www.annhub.cn/php/user/user_register.php";
		$curl_timeout = 3;
		$post = [
			"email" => "$email",
			"verification_code" => "$verification_code",
			"password" => "$password",
			"password_again" => "$password_again"
		];

		$res = send_post($post_url, null, $post);
		$state_message = $res['state_message'];

		if($state_message == 0) {
			$content = $res['info']['content'];
			$time = $res['info']['time'];
			setcookie('Annhub', $content, $time, '/');
			//header('Location: ../../manage_index.php');
		} //else {
			//header("Location: error.php?code=$state_message");
			echo json_decode($state_message);
		//}
	}

	//修改密码
	function change_password() {
		$password = $_POST['password'];
		$password_again = $_POST['password_again'];
		$post_url = "http://www.annhub.cn/php/user/user_password_change.php";
		$curl_timeout = 3;
		$post = [
			"password" => $password,
			"password_again" => $password_again
		];
		$cookie = $_COOKIE['Annhub'];
		$header = [
			"Cookie: Annhub=$cookie"
		];

		$res = send_post($post_url, $header, $post);
		$state_message = $res['state_message'];

		if($state_message == 0) {
			$content = $res['info']['content'];
			$time = $res['info']['time'];
			setcookie('Annhub', $content, $time, '/');
			//header('Location: ../../information.php');
		} //else {
			//header("Location: error.php?code=$state_message");
			echo json_decode($state_message);
		//}
	}

	//修改邮箱
	function change_email() {
		$email = $_POST['email'];
		$verification_code = $_POST['verification_code'];
		$post_url = "http://www.annhub.cn/php/user/user_email_change.php";
		$curl_timeout = 3;
		$post = [
			"email" => $email,
			"verification_code" => $verification_code
		];
		$cookie = $_COOKIE['Annhub'];
		$header = [
			"Cookie: Annhub=$cookie"
		];

		$res = send_post($post_url, $header, $post);
		$state_message = $res['state_message'];

		if($state_message == 0) {
			$content = $res['info']['content'];
			$time = $res['info']['time'];
			setcookie('Annhub', $content, $time, '/');
			//header('Location: ../../information.php');
		} //else {
			//header("Location: error.php?code=$state_message");
			echo json_decode($state_message);
		//}
	}

	//修改昵称
	function change_nickname() {
		$nickname = $_POST['nickname'];
		$post_url = "http://www.annhub.cn/php/user/user_nickname_change.php";
		$curl_timeout = 3;
		$post = [
			"nickname" => $nickname,
		];
		$cookie = $_COOKIE['Annhub'];
		$header = [
			"Cookie: Annhub=$cookie"
		];

		$res = send_post($post_url, $header, $post); //注意一定要包含头部
		$state_message = $res['state_message'];

		//if($state_message == 0) {
			//header('Location: ../../information.php');
		//} else {
			//header("Location: error.php?code=$state_message");
			echo json_decode($state_message);
		//}
	}


?>