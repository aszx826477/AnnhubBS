/*
YellowBee
2018-6-2
*/
$(document).ready( function() {
	"use strict";

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
                url: "file_upload.php?case=1",
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