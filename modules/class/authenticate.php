<?php
if (isset($_GET['fun'])) {
		switch($_GET['fun']) {
			case 'login':
				login();
				break;
			case 'logout':
				logout();
				break;
			case 'send_verify_code':
				send_verify_code();
				break;
			default:
				break;
		}
}


	//登录
	function login() {
		$email = $_POST['email'];
		$password = $_POST['password'];
		$post_url = "http://www.annhub.cn/php/user/user_login.php";
		$curl_timeout = 3;
		$post = [
			"email" => "$email",
			"password" => "$password"
		];

		$curl = curl_init();
		curl_setopt($curl, CURLOPT_URL, $post_url);
		curl_setopt($curl, CURLOPT_POSTFIELDS, $post);
		curl_setopt($curl, CURLOPT_TIMEOUT, $curl_timeout);	
		curl_setopt($curl, CURLOPT_HTTPHEADER, null);
		curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
		$res = json_decode(curl_exec($curl), true); //true参数将对象转换为关联数组
		curl_close($curl);

		$state_message = $res['state_message'];
		if($state_message == 0) {
			$content = $res['info']['content'];
			$time = $res['info']['time'];
			setcookie('Annhub', $content, $time, '/');
			header('Location: ../../manage_index.php');
		} else {
			header("Location: error.php?code=$state_message");
		}

	}

	//登出
	function logout() {
		
		$post_url = "http://www.annhub.cn/php/user/user_logout.php";
		$curl_timeout = 3;
		$cookie = $_COOKIE['Annhub'];
		$header = [
			"Cookie:Annhub=$cookie"
		];

		$curl = curl_init();
		curl_setopt($curl, CURLOPT_URL, $post_url);
		curl_setopt($curl, CURLOPT_POSTFIELDS, null);
		curl_setopt($curl, CURLOPT_TIMEOUT, $curl_timeout);	
		curl_setopt($curl, CURLOPT_HTTPHEADER, $header);
		curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
		$res = json_decode(curl_exec($curl), true);
		curl_close($curl);

		$state_message = $res['state_message'];
		if($state_message == 0) {
			$content = $res['info']['content'];
			$time = $res['info']['time'];
			setcookie('Annhub', $content, $time, '/');
			header('Location: ../../login.php');
		} else {
			header("Location: error.php?code=$state_message");
		}
		
	}

	//发送邮箱验证码
	function send_verify_code() {
		$email = $_POST['email'];
		$post_url = "http://www.annhub.cn/php/user/user_verify.php";
		$curl_timeout = 3;
		$post = [
			"email" => "$email"
		];

		$curl = curl_init();
		curl_setopt($curl, CURLOPT_URL, $post_url);
		curl_setopt($curl, CURLOPT_POSTFIELDS, $post);
		curl_setopt($curl, CURLOPT_TIMEOUT, $curl_timeout);	
		curl_setopt($curl, CURLOPT_HTTPHEADER, null);
		curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
		$res = json_decode(curl_exec($curl), true); //true参数将对象转换为关联数组
		curl_close($curl);

		$state_message = $res['state_message'];
		
		if($state_message == 0) {
			echo "<script> alert('验证码已成功发送至邮箱，请查收'); history.go(-1); </script>";
		} else {
			header("Location: error.php?code=$state_message");
		}


	}


?>