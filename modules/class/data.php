<?php 
	


	//获取demoy的相关参数
	function get_app_name_demo() {
		include 'conf.php';
		return $app_name_demo;
	}
	function get_app_date_demo() {
		include 'conf.php';
		return $app_date_demo;
	}
	function get_app_demo() {
		include 'conf.php';
		return $app_demo;
	}
	function get_report_demo() {
		include 'conf.php';
		return $report_demo;
	}
	function get_report_pdf_demo() {
		include 'conf.php';
		return $report_pdf_demo;
	}
	function get_app_protect_demo() {
		include 'conf.php';
		return $app_protect_demo;
	}
	function get_report_protect_demo() {
		include 'conf.php';
		return $report_protect_demo;
	}
	function get_report_protect_pdf_demo() {
		include 'conf.php';
		return $report_protect_pdf_demo;
	}

	//获取用户应用总数
	function get_app_total_num() {
		
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
			$app_total_num = $res['info']['file_num'];
			return $app_total_num;
		} 
		
	}
	//获取用户已加固应用数
	function get_app_protect_num() {
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
			$app_protect_num = $res['info']['file_protected_num'];
			return $app_protect_num;
		} 
		
	}

	//获取用户已扫描应用数
	function get_app_scan_num() {
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
			$app_scan_num = $res['info']['file_scan_num'];
			return $app_scan_num;
		} 
	}

	//获取用户漏洞数目
	function get_app_leak_num() {
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
			$app_leak_num = $res['info']['file_leak_num'];
			return $app_leak_num;
		} 
		
	}



	//获取用户邮箱
	function get_email() {
		if(isset($_COOKIE["Annhub"])) {
			$email = explode(' ', $_COOKIE["Annhub"])[0];
			return $email;
		} 
	}

	//获取用户昵称
	function get_nickname() {
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
			$nickname = $res['info']['nickname'];
			return $nickname;
		} 
	}

	//获取用户注册日期
	function get_register_date() {
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
			$register_date = $res['info']['register_date'];		
			return $register_date;
		} 
	}

	//获取用户头像url
	function get_head_url() {
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
			$head_url = $res['info']['head_url'];
			return $head_url;
		} 
	}

	

	//输出apk文件列表
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
			//$i = 2;
			for($i = 0; $i < $app_total_num; $i ++) {
			
				$apk_real_name = $app[$i]['apk_real_name'];
				$upload_date = $app[$i]['upload_date'];
				$protected = $app[$i]['protected'];
				$scanned = $app[$i]['scanned'];

				$app_url = $app[$i]['app']; //关于命名的小BUG
				$report = $app[$i]['report'];
				$report_pdf = $app[$i]['report_pdf'];

				$app_protect = $app[$i]['app_protect'];
				$report_protect = $app[$i]['report_protect'];
				$report_protect_pdf = $app[$i]['report_protect_pdf'];

														echo <<<FILE_OUTPUT
														
														<div class="file-box">
															<div class="file">		
																<div class="icon">
																	<i class="fa fa-file"></i>
																</div>
																<div class="file-name" style="height: 80px;">
																	$apk_real_name <br/>
													
																	<span>$upload_date</span>
																</div>
																<div class="dropdown">
																	<!-- Single button -->
																		<button class="btn btn-info dropdown-toggle col-xs-12 col-sm-12 col-md-12" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
																			操作
																			<span class="caret"></span>
																		</button>
																		<ul class="dropdown-menu col-xs-12 col-sm-12 col-md-12">
																			<li><a href="$app_url">下载</a></li>
FILE_OUTPUT;
																			if($scanned == 1) {
																				echo '<li><a href="$report">查看检测报告</a></li>';
																				echo '<li><a href="$report_pdf">下载检测报告</a></li>';
																			} else {
																				echo '<li><a href="#">正在扫描</a></li>';				
																			}

																			echo '<li class="divider"></li>';
																			if($protected == 1) {
																				echo '<li><a href="$app_protect">下载加固包</a></li>';
																				echo '<li><a href="$report_protect">查看加固包的检测报告</a></li>';
																				echo '<li><a href="$report_protect_pdf">下载加固包的检测报告</a></li>';
																			} else {
																				echo '<li><a href="#">正在加固</a></li>';
																			}
																				
																			echo <<<FILE_OUTPUT1
																			<li class="divider"></li>
																			<li><a href="#" alt="alert" id="$i">移除</a></li>
																		</ul>
																</div>	
															</div>								
														</div>
FILE_OUTPUT1;

			}

		
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
                		url: "modules/class/file.php?fun=delete_app&file=$i",
                		dataType: "json",
                		success: function(msg) {
                			
                			swal({
            					title: "您选择的应用",
            					text: "已移除",
            					type: "success"
            				}, function(){
            					location.reload();
            				}); 
                			
                		}
        			});
        		});						
   	 		});
		</script>

SCRIPT_TAG;
			}
		
		} 
	}

