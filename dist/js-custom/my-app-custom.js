/*
YellowBee
2018-6-12
*/

/*
$(document).ready(function() {
    "use strict";

    $('#file_upload_btn').on('click', function(e){
        $('#file_upload_form').on('submit', function(e){
            e.preventDefault(); // 禁止表单的默认提交行为，全部交给ajax处理
            var file = document.getElementById('fileSelector').files[0];
            //需要前端对文件类型进行初步判断，进行相应的弹窗提示
            if (!file) {
                swal({
                    title: "未选择文件",
                    type: "warning", 
                    confirmButtonColor: "#fcb03b"
                });
                return;
            } else {
                if(file['type'] != 'application/vnd.android.package-archive') {
                    swal({
                        title: "上传格式错误，请上传apk的文件格式",
                        type: "warning", 
                        confirmButtonColor: "#fcb03b"
                    });
                    return;
                } 
                if((file['size']/1024) > (1024*50)) {
                    swal({
                        title: "上传的文件过大，请上传小于50MB的文件",
                        type: "warning", 
                        confirmButtonColor: "#fcb03b"
                    });
                    return;
                } 

            }

            $('#progress').show();
            setTimeout('fetch_progress()', 100);

            $(this).ajaxSubmit({
                type: "post",
                url: "modules/class/file.php?fun=upload_app",
                dataType: "json",
                
                success: function(msg) {
                    swal({   
                        title: "您已成功上传应用",   
                        type: "success", 
                        text: "Annhub将在后台对您的应用进行检测和加固，这需要一段时间，您可以先四处逛逛",
                        confirmButtonColor: "#3cb878",   
                    }, function() {
                        location.reload();
                    });
                    
                }
            });
        });
        
    });

    



});

function fetch_progress(){
        $.get('modules/class/progress.php',{ '<?php echo ini_get("session.upload_progress.name"); ?>' : 'test'}, function(data){
            var progress = parseInt(data);
            $('#progress').html(progress + '%');
            $('#progress').css('width', progress + '%');
            if(progress < 100){
                setTimeout('fetch_progress()', 100);
            }else{
                $('#progress').html('0%');
                $('#progress').css('width', '0%');
            }
        }, 'html');
    }*/

$(document).ready(function() {
    var options = { 
        //target:        '#output1',    // 用服务器返回的数据 更新 id为output1的内容.
        beforeSubmit:  showRequest,     // 提交前
        success: showResponse,          // 提交后 
        //url:       url                // 默认是form的action，如果写的话，会覆盖from的action. 
        //type:      type               // 默认是form的method，如果写的话，会覆盖from的method.('get' or 'post').
        dataType:  'json',              // 'xml', 'script', or 'json' (接受服务端返回的类型.) 
        clearForm: false,               // 成功提交后，清除所有的表单元素的值.
        resetForm: false                // 成功提交后，重置所有的表单元素的值.
        //timeout:   3000               //最多等待请求3秒
    }; 
                 
    //'ajaxForm' 方式的表单 .
    $('#file_upload_form').ajaxForm(options);

    //方法二：回调函数
    //$('#login_form').ajaxForm(function(data) {
    //  alert(data);
    //});
    //方法三：或者 'ajaxSubmit' 方式的提交.
    //$('#myForm').submit(function() { 
    //    $(this).ajaxSubmit(options); 
    //    return false; //来阻止浏览器提交.
    //}); 

    //提交前
    function showRequest() {
        var file = document.getElementById('fileSelector').files[0];
        //var file = $('#fileSelector').files[0];
        //需要前端对文件类型进行初步判断，进行相应的弹窗提示
        if (!file) {
            swal({
                title: "未选择文件",
                type: "warning", 
                confirmButtonColor: "#fcb03b"
            });
            return false;
        } else {
            if(file['type'] != 'application/vnd.android.package-archive') {
                swal({
                    title: "上传格式错误，请上传apk的文件格式",
                    type: "warning", 
                    confirmButtonColor: "#fcb03b"
                });
                return false;
            }
        } 
        if((file['size']/1024) > (1024*100)) {
            swal({
                title: "上传的文件过大，请上传小于100MB的文件",
                type: "warning", 
                confirmButtonColor: "#fcb03b"
            });
            return false;
        } 

        $('#progress').show();
        setTimeout('fetch_progress()', 1000);

        $('#file_upload_btn').attr("disabled",true);
    }
    
    //提交后
    function showResponse(responseText, statusText)  { 

        switch(responseText) {
            case 0:
                swal({   
                    title: "您已成功上传应用",   
                    type: "success", 
                    text: "Annhub将在后台对您的应用进行检测和加固，这需要一段时间，您可以先四处逛逛",
                    confirmButtonColor: "#3cb878",
                }, function() {
                    location.reload();
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

});