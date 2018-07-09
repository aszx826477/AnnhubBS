/*
YellowBee
2018-5-27
*/
$(document).ready( function() {
	$('#login_button').on("click", function() {
		$('#login_form').on("submit", function(e) {
			e.preventDefault(); // 禁止表单的默认提交行为，全部交给ajax处理
            $(this).ajaxSubmit({
				type: "post",
				url: "../php/user/user_login.php",
				dataType: "json",
				success: function(msg) {
					switch(msg.state_message) {
						case 0: 
							location.href = "http://www.annhub.cn/manage_system/index.php?page=3";
							//document.write(msg.info.file_num);
							break;
						case -1:
							alert('失败'); location.reload(); break;
						case -101:
							alert('您输入的信息非法'); location.reload(); break;
						case -102:
							alert('该邮箱已被注册'); location.reload(); break;
						case -103:
							alert('您输入的验证码有误'); location.reload(); break;
						case -104:
							alert('两次密码输入不一致'); location.reload(); break;
						case -105:
							alert('您输入的账号或密码有误'); location.reload(); break;
						case -106:
							alert('您输入的账号或密码有误'); location.reload(); break;
						case -201:
							alert('参数不完整'); location.reload(); break;
						case -401:
							alert('邮件发送失败'); location.reload(); break;
						default: 
							alert('未知错误'); location.reload(); break;
					}	
				},
			});
		});
	});
});
