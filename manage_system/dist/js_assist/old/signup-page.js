/*
YellowBee
2018-5-27
*/
$(document).ready( function() {

	function send_verify_code() {
		document.getElementById('signup_form').action = "form_post.php?op=1";
	}

	function register() {
		document.getElementById('signup_form').action = "form_post.php?op=2";
	}
/*
	//给注册按钮添加点击事件
	$('#register_button').on("click", function() {
		$('#signup_form').on("submit", function(e) {
			/*
			e.preventDefault(); // 禁止表单的默认提交行为，全部交给ajax处理
            $(this).ajaxSubmit({
				type: "post",
				url: "../php/user/user_register.php",
				dataType: "json",
				success: function(msg) {
					switch(msg.state_message) {
						case 0: 
							alert('您已成功注册，请前往登录界面登录'); location.reload(); break;
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
			
			$(this).form.action = "form_post.php?op=2";
		});
	});

	//给发送验证码的按钮添加点击事件
	$('#verify_button').on("click", function() {
		$('#signup_form').on("submit", function(e) {
			$(this).form.action = "form_post.php?op=1";
		});
	});*/

});