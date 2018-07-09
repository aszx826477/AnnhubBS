<?php
		/*$curl = curl_init();
		curl_setopt($curl, CURLOPT_URL, "https://api.alittlecat.cn");
		/*curl_setopt($curl, CURLOPT_SSL_VERIFYPEER, TRUE);
		curl_setopt($curl, CURLOPT_SSL_VERIFYHOST, 2);*/
		/*curl_setopt($curl, CURLOPT_USERAGENT, $_SERVER['HTTP_USER_AGENT']);*/
		//curl_setopt($curl, CURLOPT_FOLLOWLOCATION, TRUE);
		//curl_setopt($curl, CURLOPT_AUTOREFERER, TRUE);
		//curl_setopt($curl, CURLOPT_POST, TRUE);
		/*curl_setopt($curl, CURLOPT_POSTFIELDS, http_build_query(array("api_project" => 1, "api_option" => 1, "api_id" => 1, "api_key" => 1)));
		curl_setopt($curl, CURLOPT_TIMEOUT, 30);
		curl_setopt($curl, CURLOPT_RETURNTRANSFER, TRUE);
		$response = json_decode(curl_exec($curl));
		curl_close($curl);
		echo $response["test"];
		echo "o";*/
		$curl = curl_init();
		curl_setopt($curl, CURLOPT_URL, "https://api.alittlecat.cn");
		//curl_setopt($curl, CURLOPT_HEADER, FALSE);
		curl_setopt($curl, CURLOPT_SSL_VERIFYPEER, FALSE);
		curl_setopt($curl, CURLOPT_SSL_VERIFYHOST, 2);
		curl_setopt($curl, CURLOPT_POSTFIELDS, http_build_query(array("0" => 0)));
		curl_setopt($curl, CURLOPT_TIMEOUT, 30);
		curl_setopt($curl, CURLOPT_RETURNTRANSFER, TRUE);
		$response = json_decode(curl_exec($curl));
		curl_close($curl);
		echo $response->test;
?>