<?php
	/*
	YellowBee
	2018-5-29
	*/
	include "manage_func.php";

	if(! isset($_COOKIE['Annhub']) && isset($_GET["page"])) { //没有名称为annhub的cookie,且设置的page参数

		$option = $_GET["page"];
		switch($option) {
			case 0:
				show_index_page(); //展示annhub主页
				break;
			case 1:
				show_login_page(); //展示登录页面
				break;
			case 2:
				show_signup_page(); //展示注册页面
				break;
			default:
				$state_message = -400;
				include "404.html";
				break;
		}
	} 

	if(isset($_COOKIE['Annhub']) && isset($_GET["page"])) { //有名称为annhub的cookie,且设置了page参数
		$option = $_GET["page"];
		switch($option) {
			case 0:
				show_index_page(); //展示annhub主页
				break;
			case 1:
				show_manage_page(); //展示控制台页面
				break;
			case 2:
				show_manage_page();
				break;
			case 3:
				show_manage_page(); 
				break;
			case 4:
				show_app_page(); //展示我的应用页面
				break;
			case 5:
				show_info_page(); //展示用户信息页面
				break;
			case 6:
				log_out(); //登出
				break;
			
			default:
				$state_message = -400;
				include "404.html";
				break;

		}
	}

?>