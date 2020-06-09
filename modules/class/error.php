<?php 

if(isset($_GET['code'])) {

	$code = $_GET['code'];

	switch($_GET['code']) {

        case 101:
        	echo "<script> alert('您输入的信息非法'); history.go(-1); </script>";
            break;
        case 102:
            echo "<script> alert('该邮箱已被注册'); history.go(-1); </script>";
            break;
        case 103:
            echo "<script> alert('您输入的验证码有误'); history.go(-1); </script>";
            break;
        case 104:
        	echo "<script> alert('两次密码输入不一致'); history.go(-1); </script>";
            break;
        case 105: 
            echo "<script> alert('您输入的账号或密码有误'); history.go(-1); </script>";     
            break;
        case 106:
            echo "<script> alert('参数不完整'); history.go(-1); </script>";
            break;
        case 107:
            echo "<script> alert('邮件发送失败'); history.go(-1); </script>";
            break;
        case 108:
            echo "<script> alert('验证码已过期'); history.go(-1); </script>";
            break;

		case 201:
			$info = "cookie无效";
			header("Location: ../../500.php?code=$code&info=$info");
			break;
		case 202:
			$info = "delete参数越界";
			header("Location: ../../500.php?code=$code&info=$info");
			break;
		case 203:
			$info = "cookie过期或无cookie";
			header("Location: ../../500.php?code=$code&info=$info");
			break;
			
		case 301:
			$info = "COS headObject出错（COS check对象不存在）";
			header("Location: ../../500.php?code=$code&info=$info");
			break;
		case 302:
			$info = "COS upload出错";
			header("Location: ../../500.php?code=$code&info=$info");
			break;
		case 303:
			$info = "COS delete出错";
			header("Location: ../../500.php?code=$code&info=$info");
			break;
		case 304:
			$info = "反馈ETag出错";
			header("Location: ../../500.php?code=$code&info=$info");
			break;
		case 305:
			$info = "没有使用http post方法上传文件";
			header("Location: ../../500.php?code=$code&info=$info");
			break;

		case 401:
			$info = "数据库连接失败"; 
			header("Location: ../../500.php?code=$code&info=$info");
			break;
		case 402:
			$info = "数据库insert失败"; 
			header("Location: ../../500.php?code=$code&info=$info");
			break;
		case 403:
			$info = "数据库delete失败"; 
			header("Location: ../../500.php?code=$code&info=$info");
			break;
		case 404:
			$info = "数据库select失败"; 
			header("Location: ../../500.php?code=$code&info=$info");
			break;
		case 405:
			$info = "数据库update失败"; 
			header("Location: ../../500.php?code=$code&info=$info");
			break;
		case 406:
			$info = "数据库的多种操作失败"; 
			header("Location: ../../500.php?code=$code&info=$info");
			break;

		default: 
			$info = "未知错误";
			header("Location: ../../500.php?code=$code&info=$info");
			break;
	}
}

