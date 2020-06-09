$(document).ready(function() {
    var options = { 
        //target:        '#output1',    // 用服务器返回的数据 更新 id为output1的内容.
        //beforeSubmit:  showRequest,   // 提交前
        success: showResponse,          // 提交后 
        //url:       url                // 默认是form的action，如果写的话，会覆盖from的action. 
        //type:      type               // 默认是form的method，如果写的话，会覆盖from的method.('get' or 'post').
        dataType:  'json',              // 'xml', 'script', or 'json' (接受服务端返回的类型.) 
        clearForm: false,               // 成功提交后，清除所有的表单元素的值.
        resetForm: false,                // 成功提交后，重置所有的表单元素的值.
        //timeout:   3000               //最多等待请求3秒
        xhrFields: {
            withCredentials: true
        },
        crossDomain: true
    }; 

                 
    //'ajaxForm' 方式的表单 .
    $('#set_new_pwd_form').ajaxForm(options);
    $('#set_new_name_form').ajaxForm(options);
    $('#set_new_email_form').ajaxForm(options);

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
      
        switch(responseText) {
            case 0:
                location.reload();
                break;
            case 1:
                swal({
                    title: '验证码已成功发送至邮箱，请查收',
                    confirmButtonColor: "#3cb878" 
                });
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
        }
    }

    $('#head_upload_btn').on('click', function(e){
        $('#head_upload_form').on('submit', function(e){
            e.preventDefault(); // 禁止表单的默认提交行为，全部交给ajax处理
            var file = document.getElementById('fileSelector').files[0];
            //需要前端对文件类型进行初步判断，进行相应的弹窗提示
            if (!file) {
                swal({
                    title: "未选择图片",
                    type: "warning", 
                    confirmButtonColor: "#fcb03b"
                });
                return;
            } else {
                if(file['type'] != 'image/jpeg') {
                    swal({
                        title: "上传格式错误，请上传jpeg的图片格式",
                        type: "warning", 
                        confirmButtonColor: "#fcb03b"
                    });
                    return;
                } 
                if(file['size']/1024 > 1024) {
                    swal({
                        title: "上传的图片过大，请上传小于1MB的图片",
                        type: "warning", 
                        confirmButtonColor: "#fcb03b"
                    });
                    return;
                } 

            }

            $(this).ajaxSubmit({
                type: "post",
                url: "modules/class/file.php?fun=upload_head",
                dataType: "json",
                beforeSubmit: function() {
                    swal({
                        title: "图片正在上传中...",
                        text: "请勿关闭此页面", 
                        imageUrl: "dist/img/upload.png",  
                        showConfirmButton: false 
                    });
                },
                success: function(msg) {
                    swal({   
                        title: "您已成功上传头像图片",   
                        type: "success", 
                        text: "请点击完成刷新页面",
                        confirmButtonColor: "#3cb878",   
                    }, function() {
                        location.reload();
                    });
                    
                }
            });
        });
        
    });    
  
});
