<?php 

if(isset($_GET['code'])) {

	$code = $_GET['code'];

	switch($_GET['code']) {
		case -1:
			$info = '失败';
			header("Location: ../../500.php?code=$code&info=$info");
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
			$info = "cookie无效";
			header("Location: ../../500.php?code=$code&info=$info");
			break;
		case -201:
			echo "<script> alert('参数不完整'); history.go(-1); </script>";
			break;
		case -401:
			echo "<script> alert('邮件发送失败'); history.go(-1); </script>"; 
			break;
		case -300:
			$info = "COS headObject出错";
			header("Location: ../../500.php?code=$code&info=$info");
			break;
		case -301:
			$info = "COS upload出错";
			header("Location: ../../500.php?code=$code&info=$info");
			break;
		case -302:
			$info = "COS delete出错";
			header("Location: ../../500.php?code=$code&info=$info");
			break;
		case -303:
			$info = "反馈ETag出错";
			header("Location: ../../500.php?code=$code&info=$info");
			break;
		case -4001:
			$info = "数据库操作失败"; 
			header("Location: ../../500.php?code=$code&info=$info");
			break;
		case -4002:
			$info = "数据库链接失败"; 
			header("Location: ../../500.php?code=$code&info=$info");
			break;
		default: 
			$info = "未知错误";
			header("Location: ../../500.php?code=$code&info=$info");
			break;
	}
}

