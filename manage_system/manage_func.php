<?php
	/*
	YellowBee
	2018-5-30

	变量含义说明与示例
	$state_message = 0;						//状态码
	$nickname = "test";						//用户昵称
	$head_url = "www.baidu.com";			//头像的url
	$register_time = "2018-01-02";			//用户注册时间
	$app_total_num = 0;						//应用总数
	$app_protect_num = 0;					//已加固应用数
	$app_scan_num = 0;						//已扫描应用数
	$app_leak_num = 0;						//应用漏洞总数
	$register_time = "2018-01-02";			//用户注册时间

	$app_name = "demo.apk";								
	$app_upload_time = "2018-05-23-10-25";
	$app_download_url = "www.baidu.com";
	$report_url = "www.baidu.com";

	*/

	//根据状态码进行处理
	function error_code_handle($state_message) {
		switch($state_message) {
			case -1:
				$error_info = "失败";
				include "500.html";
				break;
			case -101:
				echo "<script> alert('您输入的信息非法'); history.go(-1); </script>"; 
				break;
			case -102:
				echo "<script> alert('该邮箱已被注册'); history.go(-1); </script>";
				break;
			case -103:
				echo "<script> alert('您输入的验证码有误'); history.go(-1); </script>";
				break;
			case -104:
				echo "<script> alert('两次密码输入不一致'); history.go(-1); </script>";
				break;
			case -105:
				echo "<script> alert('您输入的账号或密码有误'); history.go(-1); </script>";
				break;
			case -106:
				$error_info = "cookie无效";
				include "500.html";
				break;
			case -201:
				echo "<script> alert('参数不完整'); history.go(-1); </script>";
				break;
			case -401:
				echo "<script> alert('邮件发送失败'); history.go(-1); </script>"; 
				break;
			case -300:
				$error_info = "COS headObject出错";
				include "500.html";
				break;
			case -301:
				$error_info = "COS upload出错";
				include "500.html";
				break;
			case -302:
				$erroe_info = "COS delete出错";
				include "500.html";
				break;
			case -303:
				$error_info = "反馈ETag出错";
				include "500.html";
				break;
			case -4001:
				$error_info = "数据库操作失败"; 
				include "500.html";
				break;
			case -4002:
				$error_info = "数据库链接失败"; 
				include "500.html";
				break;
			default: 
				$error_info = "未知错误";
				include "500.html";
				break;
		}		
		
	}




	/*
	* 第一部分
	* 页面跳转控制函数index.page.php
	*/

	//展示首页index.php?page=0
	function show_index_page() {
		header("Location: http://www.annhub.cn");
	}

	//展示登录界面index.php?page=1
	function show_login_page() {
		include "login-page.html";
	}

	//展示注册界面index.php?page=2
	function show_signup_page() {
		include "signup-page.html";
	}

	//展示控制台index.php?page=3
	function show_manage_page() {
		$post_url = "http://www.annhub.cn/php/user/user_info_get.php";
		$curl_timeout = 3;
		$email = explode(' ', $_COOKIE['Annhub'])[0];
		$post = [
			"email" => $email
		];
		$cookie = $_COOKIE['Annhub'];
		$header = [
			"Cookie: Annhub=$cookie"
		];

		$curl = curl_init();
		curl_setopt($curl, CURLOPT_URL, $post_url);
		curl_setopt($curl, CURLOPT_POSTFIELDS, $post);
		curl_setopt($curl, CURLOPT_TIMEOUT, $curl_timeout);	
		curl_setopt($curl, CURLOPT_HTTPHEADER, $header);
		curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
		$res = json_decode(curl_exec($curl), true);
		curl_close($curl);

		$state_message = $res['state_message'];
		if($state_message == 0) {
			$email = explode(' ', $_COOKIE["Annhub"])[0];
			$nickname = $res['info']['nickname'];
			$head_url = $res['info']['head_url'];			
			$app_total_num = $res['info']['file_num'];	
			$app_protect_num = $res['info']['file_protected_num'];
			$app_scan_num = $res['info']['file_scan_num'];
			$app_leak_num = $res['info']['file_leak_num'];
			include "manage-index.html";
		} else if($state_message == -106) {
			header("Location: http://www.annhub.cn/manage_system/login-page.html");
		} else {
			error_code_handle($state_message);
		}
	
		
		
	}

	//展示我的应用index.php?page=4
	function show_app_page() {
		$post_url = "http://www.annhub.cn/php/user/user_info_get.php";
		$curl_timeout = 3;
		$email = explode(' ', $_COOKIE['Annhub'])[0];
		$post = [
			"email" => $email
		];
		$cookie = $_COOKIE['Annhub'];
		$header = [
			"Cookie: Annhub=$cookie"
		];

		$curl = curl_init();
		curl_setopt($curl, CURLOPT_URL, $post_url);
		curl_setopt($curl, CURLOPT_POSTFIELDS, $post);
		curl_setopt($curl, CURLOPT_TIMEOUT, $curl_timeout);	
		curl_setopt($curl, CURLOPT_HTTPHEADER, $header);
		curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
		$res = json_decode(curl_exec($curl), true);
		curl_close($curl);

		$state_message = $res['state_message'];
		if($state_message == 0) {
			$email = explode(' ', $_COOKIE["Annhub"])[0];
			$nickname = $res['info']['nickname'];
			$head_url = $res['info']['head_url'];			
			$app_total_num = $res['info']['file_num'];
			include "my-app.html";
		} else if($state_message == -106) {
			header("Location: http://www.annhub.cn/manage_system/login-page.html");
		} else {
			error_code_handle($state_message);
		}
		
	}

	//展示用户信息页面index.php?page=5
	function show_info_page() {
		$post_url = "http://www.annhub.cn/php/user/user_info_get.php";
		$curl_timeout = 3;
		$cookie = $_COOKIE['Annhub'];
		$header = [
			"Cookie: Annhub=$cookie"
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
			$email = explode(' ', $_COOKIE["Annhub"])[0];
			$nickname = $res['info']['nickname'];
			$register_date = $res['info']['register_date'];		
			$head_url = $res['info']['head_url'];

			include "information.html";
		} else if($state_message == -106) {
			header("Location: http://www.annhub.cn/manage_system/login-page.html");
		} else {
			error_code_handle($state_message);
		}
		
	}
	
	//登出index.php?page=6
	function log_out() {
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
			header("Location: http://www.annhub.cn/manage_system/index.php?page=0");
		} else {
			error_code_handle($state_message);
		}
	
	}


	/*
	* 第二部分
	* 表单提交控制函数form_post.php
	*/



	//发送邮箱验证码form_post.php?op=1
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
			echo "<script> alert('验证码已发送至邮箱'); history.go(-1);</script>";
		} else {
			error_code_handle($state_message);
		}


	}

	//注册新用户form_post.php?op=2
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
			//echo "<script> alert('您已成功注册请前往登录界面登录'); history.go(-1);</script>";
			$content = $res['info']['content'];
			$time = $res['info']['time'];
			setcookie('Annhub', $content, $time, '/');
			header("Location: http://www.annhub.cn/manage_system/index.php?page=3");
		} else {
			error_code_handle($state_message);
		}
	}

	//登录form_post.php?op=3
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
			header("Location: http://www.annhub.cn/manage_system/index.php?page=3");
		} else {
			error_code_handle($state_message);
		}

	}


	//修改密码form_post.php?op=4
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

		$curl = curl_init();
		curl_setopt($curl, CURLOPT_URL, $post_url);
		curl_setopt($curl, CURLOPT_POSTFIELDS, $post);
		curl_setopt($curl, CURLOPT_TIMEOUT, $curl_timeout);	
		curl_setopt($curl, CURLOPT_HTTPHEADER, $header);
		curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
		$res = json_decode(curl_exec($curl), true); //true参数将对象转换为关联数组
		curl_close($curl);

		$state_message = $res['state_message'];
		if($state_message == 0) {
			$content = $res['info']['content'];
			$time = $res['info']['time'];
			setcookie('Annhub', $content, $time, '/');
			echo "<script> alert('您已成功修改密码'); history.go(-1);</script>";
		} else {
			error_code_handle($state_message);
		}
	}

	//修改邮箱form_post.php?op=5
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

		$curl = curl_init();
		curl_setopt($curl, CURLOPT_URL, $post_url);
		curl_setopt($curl, CURLOPT_POSTFIELDS, $post);
		curl_setopt($curl, CURLOPT_TIMEOUT, $curl_timeout);	
		curl_setopt($curl, CURLOPT_HTTPHEADER, $header);
		curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
		$res = json_decode(curl_exec($curl), true); //true参数将对象转换为关联数组
		curl_close($curl);

		$state_message = $res['state_message'];
		if($state_message == 0) {
			$content = $res['info']['content'];
			$time = $res['info']['time'];
			setcookie('Annhub', $content, $time, '/');
			header("Location: http://www.annhub.cn/manage_system/index.php?page=5");
		} else {
			error_code_handle($state_message);
		}
	}

	//修改昵称form_post.php?op=6
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

		$curl = curl_init();
		curl_setopt($curl, CURLOPT_URL, $post_url);
		curl_setopt($curl, CURLOPT_POSTFIELDS, $post);
		curl_setopt($curl, CURLOPT_TIMEOUT, $curl_timeout);	
		curl_setopt($curl, CURLOPT_HTTPHEADER, $header);
		curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
		$res = json_decode(curl_exec($curl), true); //true参数将对象转换为关联数组
		curl_close($curl);

		$state_message = $res['state_message'];
		if($state_message == 0) {
			header("Location: http://www.annhub.cn/manage_system/index.php?page=5");
		} else {
			error_code_handle($state_message);
		}
	}

	/*
	* 第三部分
	* 文件上传控制函数file_upload.php
	*/

	//上传至腾讯云的对象存储
	function COS_upload($file_name, $file_path) {
		include "conf.php";
		require(__DIR__.DIRECTORY_SEPARATOR."COS/cos-autoloader.php");
		$state_message = 0;
		$cosClient = new Qcloud\Cos\Client(array(
			"region" => $COS_region, 
			"credentials" => array(
				"appId" => $COS_appid, 
				"secretId" => $COS_secret_id, 
				"secretKey" => $COS_secret_key
			)
		));
		$body = fopen($file_path, 'rb');
		try {
			$result = $cosClient->Upload(
				$COS_bucket, 
				$file_name, 
				$body
			);
		}
		catch (Exception $e) {
			$state_message = -301;
		}
		return $state_message;
	}

	function COS_delete($file_name) {
		include "conf.php";
		require(__DIR__.DIRECTORY_SEPARATOR."COS/cos-autoloader.php");
		$state_message = 0;
		$cosClient = new Qcloud\Cos\Client(array(
			"region" => $COS_region, 
			"credentials" => array(
				"appId" => $COS_appid, 
				"secretId" => $COS_secret_id, 
				"secretKey" => $COS_secret_key
			)
		));
		try {
    		$result = $cosClient->deleteObject(array(
        		'Bucket' => $COS_bucket,
        		'Key' => $file_name,
    		));
		}
		catch (Exception $e) {
			$state_message = -302;
		}
		return $state_message;
	}

	//上传头像file_upload.php?case=1
	function upload_head() {
		$filename = $_FILES["file"]["name"];
  		$filepath = $_FILES["file"]["tmp_name"];
  		$filetype = $_FILES["file"]["type"];
  		$filesize = $_FILES["file"]["size"];
  		$error = $_FILES["file"]["error"];
		if ($error > 0) {
  			//echo "Error: " . $error . "<br />";
			error_code_handle($error);
  		} else {
  			/*
  			echo "Upload: " . $filename . "<br />";
  			echo "Type: " . $filetype . "<br />";
  			echo "Size: " . ($filesize / 1024) . " Kb<br />";
  			echo "Temp file: " . $filepath. "<br />";
  			*/
			
			
  			//文件存入Web缓存后，向后端发起上传COS请求，获取头像唯一的文件名xxx.jpg
  			if(is_uploaded_file($filepath)) {
  				$post_url = "http://www.annhub.cn/php/user/user_head_upload_request.php";
				$curl_timeout = 3;
				$cookie = $_COOKIE['Annhub'];
				$header = [
					"Cookie: Annhub=$cookie"
				];
				$curl = curl_init();
				curl_setopt($curl, CURLOPT_URL, $post_url);
				curl_setopt($curl, CURLOPT_POSTFIELDS, null);
				curl_setopt($curl, CURLOPT_TIMEOUT, $curl_timeout);	
				curl_setopt($curl, CURLOPT_HTTPHEADER, $header);
				curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
				$res = json_decode(curl_exec($curl), true); //true参数将对象转换为关联数组
				curl_close($curl);
				$state_message = $res['state_message'];

				if($state_message == 0) {
					$filename = $res['info']['head_name'];
					$state_message = COS_upload("head/" . $filename, $filepath); //成功获取文件名后上传
					
					if($state_message == 0) {

						$post_url = "http://www.annhub.cn/php/user/user_head_upload_succeed.php";
						$curl_timeout = 3;
						$cookie = $_COOKIE['Annhub'];
						$header = [
							"Cookie: Annhub=$cookie"
						];
						$curl = curl_init();
						curl_setopt($curl, CURLOPT_URL, $post_url);
						curl_setopt($curl, CURLOPT_POSTFIELDS, null);
						curl_setopt($curl, CURLOPT_TIMEOUT, $curl_timeout);	
						curl_setopt($curl, CURLOPT_HTTPHEADER, $header);
						curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
						$res = json_decode(curl_exec($curl), true); //true参数将对象转换为关联数组
						curl_close($curl);
						$state_message = $res['state_message'];
					}
  				} 				
  			} else {
  				$state_message = -666; //没有使用http post方法上传文件
  			}
  			//error_code_handle($state_message);
  			$return = array('$state_message' => $state_message);
  			echo json_encode($return);

  		}
	}

	//上传应用file_upload.php?case=2
	function upload_app() {
		$filename = $_FILES["file"]["name"];
  		$filepath = $_FILES["file"]["tmp_name"];
  		$filetype = $_FILES["file"]["type"];
  		$filesize = $_FILES["file"]["size"];
  		$error = $_FILES["file"]["error"];
		if ($error > 0) {
			error_code_handle($error);
  		} else {
  			//文件存入Web缓存后，向后端发起上传COS请求，获取头像唯一的文件名xxx.jpg
  			if(is_uploaded_file($filepath)) {
  			
  				$post_url = "http://www.annhub.cn/php/file/file_upload_request.php";
				$curl_timeout = 3;
				$cookie = $_COOKIE['Annhub'];
				$header = [
					"Cookie: Annhub=$cookie"
				];
				$curl = curl_init();
				curl_setopt($curl, CURLOPT_URL, $post_url);
				curl_setopt($curl, CURLOPT_POSTFIELDS, null);
				curl_setopt($curl, CURLOPT_TIMEOUT, $curl_timeout);	
				curl_setopt($curl, CURLOPT_HTTPHEADER, $header);
				curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
				$res = json_decode(curl_exec($curl), true); //true参数将对象转换为关联数组
				curl_close($curl);
				$state_message = $res['state_message'];
				$filename = $res['info']['apk_name'];

				if($state_message == 0) {
					
					$state_message = COS_upload("apk/" . $filename, $filepath); //成功获取文件名后上传
					
					if($state_message == 0) {
						$post_url = "http://www.annhub.cn/php/file/file_upload_succeed.php";
						$curl_timeout = 3;
						$file_real_name = $_FILES["file"]["name"];
						$post = [
							"file_real_name" => $file_real_name
						];
						$cookie = $_COOKIE['Annhub'];
						$header = [
							"Cookie: Annhub=$cookie"
						];
						$curl = curl_init();
						curl_setopt($curl, CURLOPT_URL, $post_url);
						curl_setopt($curl, CURLOPT_POSTFIELDS, $post);
						curl_setopt($curl, CURLOPT_TIMEOUT, $curl_timeout);	
						curl_setopt($curl, CURLOPT_HTTPHEADER, $header);
						curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
						$res = json_decode(curl_exec($curl), true); //true参数将对象转换为关联数组
						curl_close($curl);
					}	
					
  				} 
  			} else {
  				$state_message = -677; //没有使用http post方法上传文件
  			}
  			$return = array('$state_message' => $state_message);
  			echo json_encode($return);
  		}

	}
	//删除指定的应用file_upload.php?case=3
	function delete_app() {
		$post_url = "http://www.annhub.cn/php/file/file_delete_request.php";
		$curl_timeout = 3;
		$cookie = $_COOKIE['Annhub'];
		$header = [
			"Cookie: Annhub=$cookie"
		];
		$btn_code = $_GET['file'];
		$post = [
			'btn_code' => $btn_code
		];
		
		$curl = curl_init();
		curl_setopt($curl, CURLOPT_URL, $post_url);
		curl_setopt($curl, CURLOPT_POSTFIELDS, $post);
		curl_setopt($curl, CURLOPT_TIMEOUT, $curl_timeout);	
		curl_setopt($curl, CURLOPT_HTTPHEADER, $header);
		curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
		$res = json_decode(curl_exec($curl), true); //true参数将对象转换为关联数组
		curl_close($curl);
		$state_message = $res['state_message'];
		$apk_name = $res['info']['apk_name'];
		if($state_message == 0) {


			$state_message = COS_delete("apk/" . $apk_name); //进行COS删除操作	

			if($state_message == 0) {
				$post_url = "http://www.annhub.cn/php/file/file_delete_succeed.php";
				$curl_timeout = 3;
				$post = [
					'btn_code' => $btn_code
				];
				$cookie = $_COOKIE['Annhub'];
				$header = [
					"Cookie: Annhub=$cookie"
				];

				$curl = curl_init();
				curl_setopt($curl, CURLOPT_URL, $post_url);
				curl_setopt($curl, CURLOPT_POSTFIELDS, $post);
				curl_setopt($curl, CURLOPT_TIMEOUT, $curl_timeout);	
				curl_setopt($curl, CURLOPT_HTTPHEADER, $header);
				curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
				$res = json_decode(curl_exec($curl), true); //true参数将对象转换为关联数组
				curl_close($curl);

				$state_message = $res['state_message'];
			}
		}
		$return = array('state_message' => $state_message);
		echo json_encode($return);
	}

	/*
	* 第四部分
	* 其他类别函数
	*/

	//按照HTML模板，输出apk文件列表
	function output_app_list() {
		$post_url = "http://www.annhub.cn/php/file/file_info_get.php";
		$curl_timeout = 3;
		$email = explode(' ', $_COOKIE['Annhub'])[0];
		$cookie = $_COOKIE['Annhub'];
		$header = [
			"Cookie: Annhub=$cookie"
		];

		$curl = curl_init();
		curl_setopt($curl, CURLOPT_URL, $post_url);
		curl_setopt($curl, CURLOPT_POSTFIELDS, null);
		curl_setopt($curl, CURLOPT_TIMEOUT, $curl_timeout);	
		curl_setopt($curl, CURLOPT_HTTPHEADER, $header);
		curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
		$res = json_decode(curl_exec($curl), true); //true参数将对象转换为关联数组
		curl_close($curl);

		$state_message = $res['state_message'];
		if($state_message == 0) {
			$app_total_num = $res['info']['app_total_num'];
			$app = $res['info']['app'];
			for($i = 0; $i < $app_total_num; $i ++) {
				$app_name = $app[$i]['app_name'];
				$app_date = $app[$i]['app_date'];
				$report_download_url = $app[$i]['app_report_url'];
				$file_download_url = $app[$i]['app_download_url'];
				echo <<<FILE_OUTPUT
														
														<div class="file-box">
															<div class="file">		
																<div class="icon">
																	<i class="fa fa-file"></i>
																</div>
																<div class="file-name" style="height: 80px;">
																	$app_name
																	<br>
																	<span>时间：$app_date</span>
																</div>
																<div class="dropdown">
																	<!-- Single button -->
																		<button class="btn btn-info dropdown-toggle col-xs-12 col-sm-12 col-md-12" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
																			操作
																			<span class="caret"></span>
																		</button>
																		<ul class="dropdown-menu col-xs-12 col-sm-12 col-md-12">
																			<li><a href="$file_download_url">下载</a></li>
																			<li><a href="$report_download_url" target="_blank">查看检测报告</a></li>
																			<li class="divider"></li>
																			<li><a alt="alert" id="$i">移除</a></li>
																		</ul>
																</div>	
															</div>								
														</div>

FILE_OUTPUT;
			}
		
		} else {
			//include "../500.html";
		}
	}


	//输出apk delete btn点击事件的script
	function output_btn_script() {
		$post_url = "http://www.annhub.cn/php/file/file_info_get.php";
		$curl_timeout = 3;
		$email = explode(' ', $_COOKIE['Annhub'])[0];
		$cookie = $_COOKIE['Annhub'];
		$header = [
			"Cookie: Annhub=$cookie"
		];

		$curl = curl_init();
		curl_setopt($curl, CURLOPT_URL, $post_url);
		curl_setopt($curl, CURLOPT_POSTFIELDS, null);
		curl_setopt($curl, CURLOPT_TIMEOUT, $curl_timeout);	
		curl_setopt($curl, CURLOPT_HTTPHEADER, $header);
		curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
		$res = json_decode(curl_exec($curl), true); //true参数将对象转换为关联数组
		curl_close($curl);

		$state_message = $res['state_message'];
		if($state_message == 0) {
			$app_total_num = $res['info']['app_total_num'];
			$app = $res['info']['app'];
			for($i = 0; $i < $app_total_num; $i ++) {
				echo <<<SCRIPT_TAG
 		<script>
			$('#$i').on('click', function(e){
       			swal({   
            		title: "确定移除选择的应用？",   
            		text: "您将不能恢复",   
            		type: "warning",   
            		showCancelButton: true,   
            		confirmButtonColor: "#fcb03b",   
            		confirmButtonText: "是的，我要移除",   
            		closeOnConfirm: false 
        		}, function(){ 
        			$(this).ajaxSubmit({
						type: "post",
                		url: "file_upload.php?case=3&file=$i",
                		dataType: "json",
                		success: function(msg) {
                			if(msg.state_message == 0) {
                				swal({
            						title: "您选择的应用",
            						text: "已移除",
            						type: "success"
            					}, function(){
            						location.reload();
            					}); 
                			} else {
                				swal({
            						title: "您选择的应用",
            						text: "删除失败",
            						type: "error"
            					}, function(){
            						location.reload();
            					}); 
                			}	
                		}
        			});
        		});						
   	 		});
		</script>

SCRIPT_TAG;
			}
		
		} else {
			
		}
	}





?>

