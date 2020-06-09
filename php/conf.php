<?php
	/*
	20180524	Author:ALi
	建立文件
	2018-11-06	YellowBee
	完善各种参数
	*/
	//数据库参数
	$MYSQL_ADDRESS = "localhost";
	$MYSQL_USER = "root";
	$MYSQL_PASSWORD = "25506216";
	$MYSQL_DATABASE = "annhub";

	//user默认参数
	$NICKNAME_DEFAULT = "HelloWorld";
	$HEAD_URL_DEFAULT = "http://www.annhub.cn/default/header_default.png";

	//SMTP参数
	/*
	$smtp_server = "smtp.ym.163.com";//"smtp.ym.163.com";//SMTP服务器
	$smtp_port = 25;//SMTP服务器端口
	$smtp_usermail = "verify@annhub.cn";//SMTP服务器的用户邮箱
	$smtp_user = "verify@annhub.cn";//SMTP服务器的用户帐号
	$smtp_password = "ALi1005678141";//SMTP服务器的用户密码
	$smtp_nick = "Annhub";//发件人昵称
	$smtp_title = "Annhub验证码";//邮件主题
	$smtp_mail = "<h1>Annhub</h1><br><h3>您的验证码是<strong><u>$verification_code</u></strong>，5分钟内有效。<h3>";//邮件内容
	*/
	
	$smtp_server = "smtp.qq.com";//"smtp.ym.163.com";//SMTP服务器
	$smtp_port = 25;//SMTP服务器端口
	$smtp_usermail = "yelbee@qq.com";//SMTP服务器的用户邮箱
	$smtp_user = "yelbee@qq.com";//SMTP服务器的用户帐号
	$smtp_password = "javeihbquvaobcgi";//SMTP服务器的用户密码
	$smtp_nick = "Annhub";//发件人昵称
	$smtp_title = "Annhub验证码";//邮件主题
	$smtp_mail = "<h1>Annhub</h1><br><h3>您的验证码是<strong><u>$verification_code</u></strong>，5分钟内有效。<h3>";//邮件内容

	//COS
	/*
	$COS_appid = "1252169221";
	$COS_secret_id = "AKID86txtivn2DHBtrw7zf9HKRO9i5e4lPJ0";
	$COS_secret_key = "e6NSOFwY1ITTJxRnLj05yfBaq7rTbbQI";
	$COS_region = "ap-beijing";
	$COS_bucket = "annhub-1252169221";
	*/
	$COS_appid = "1252789527";
	$COS_secret_id = "AKIDujNr9FK1oSuPmDI2Rex7KemiljV93woj";
	$COS_secret_key = "1rUzlZNCwYyCGf8GJAxZ5PaZM8xcAXN7";
	$COS_region = "ap-shanghai";
	$COS_bucket = "annhub-1252789527";
	//apk存储路径
	$apk_path = "/var/www/apk/"
?>