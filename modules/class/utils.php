<?php

	//发送post请求的函数
	function send_post($post_url, $header, $post_fields) {	
		$curl_timeout = 3;
		$curl = curl_init();
		curl_setopt($curl, CURLOPT_URL, $post_url);
		curl_setopt($curl, CURLOPT_POSTFIELDS, $post_fields);
		curl_setopt($curl, CURLOPT_TIMEOUT, $curl_timeout);	
		curl_setopt($curl, CURLOPT_HTTPHEADER, $header);
		curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
		$res = json_decode(curl_exec($curl), true);
		curl_close($curl);
		return $res;
	}



?>