$(document).ready(function() {
    var options = { 
        //target:        '#output1',    // 用服务器返回的数据 更新 id为output1的内容.
        //beforeSubmit:  showRequest,   // 提交前
        success: showResponse,          // 提交后 
        //url:       url                // 默认是form的action，如果写的话，会覆盖from的action. 
        //type:      type               // 默认是form的method，如果写的话，会覆盖from的method.('get' or 'post').
        dataType:  'json',              // 'xml', 'script', or 'json' (接受服务端返回的类型.) 
        clearForm: false,               // 成功提交后，清除所有的表单元素的值.
        resetForm: false                // 成功提交后，重置所有的表单元素的值.
        //timeout:   3000               //最多等待请求3秒
    }; 
                 
    //'ajaxForm' 方式的表单 .
    $('#signup_form').ajaxForm(options);

    //方法二：回调函数
    //$('#login_form').ajaxForm(function(data) {
    //  alert(data);
    //});
    //方法三：或者 'ajaxSubmit' 方式的提交.
    //$('#myForm').submit(function() { 
    //    $(this).ajaxSubmit(options); 
    //    return false; //来阻止浏览器提交.
    //}); 

       
        
    //提交后
    function showResponse(responseText, statusText)  { 
        //alert(responseText);
        
        switch(responseText) {
            case 0:
                swal({
                    title: '恭喜您注册成功，完成后跳转至控制台',
                    confirmButtonColor: "#3cb878"
                }, function() {
                    location.reload();
                });
                break;
            case 1:
                swal({
                    title: '验证码已成功发送至邮箱，请查收',
                    confirmButtonColor: "#3cb878" 
                });
                $('#verify_button').attr("disabled", true);
                break;
            case 101:
                swal({
                    title: '您输入的信息非法',
                    confirmButtonColor: "#3cb878" 
                 });
                break;
            case 102:
                swal({
                    title: '该邮箱已被注册',
                    onfirmButtonColor: "#3cb878" 
                });
                break;
            case 103:
                swal({
                    title: responseText + '您输入的验证码有误',
                    confirmButtonColor: "#3cb878" 
                });
                break;
            case 104:
                swal({
                    title: '两次密码输入不一致',
                    confirmButtonColor: "#3cb878" 
                });
                break;
            case 105:
                swal({
                    title: '您输入的账号或密码有误',
                    confirmButtonColor: "#3cb878" 
                });        
                break;
            case 106:
                swal({
                    title: '参数不完整',
                    confirmButtonColor: "#3cb878" 
                }); 
                break;
            case 107:
                swal({
                    title: '邮件发送失败',
                    confirmButtonColor: "#3cb878" 
                }); 
                break;
            case 108:
                swal({
                    title: '验证码已过期',
                    confirmButtonColor: "#3cb878" 
                }); 
                break;
            case 109:
                swal({
                    title: '发送验证码过于频繁，请一分钟后再尝试',
                    confirmButtonColor: "#3cb878" 
                }); 
                break;
            default:
                swal({
                    title: '(' + responseText + ') 未知错误',
                    confirmButtonColor: "#3cb878" 
                }); 
                break;
            
        }
        
    }


});

