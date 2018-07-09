<?php
	/*
	YellowBee
	2018-6-11
	*/
	include "manage_func.php";

	if(isset($_GET['case'])) {
		$case = $_GET['case'];
		switch($case) {
			case 1:
				upload_head();
				break;
			case 2:
				upload_app();
				break;
			case 3:
				if(isset($_GET['file'])) {
					delete_app();
				}
				break;
			default:
				$state_message = -400;
				include "500.html";
				break;

		}
	}


?>