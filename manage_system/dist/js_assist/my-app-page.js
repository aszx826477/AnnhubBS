/*
YellowBee
2018-6-12
*/
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
            $(this).ajaxSubmit({
                type: "post",
                url: "file_upload.php?case=2",
                dataType: "json",
                beforeSubmit: function() {
                    swal({
                        title: "应用正在上传中...",
                        text: "请勿关闭此页面", 
                        imageUrl: "dist/img/upload.png",  
                        showConfirmButton: false 
                    });
                },
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