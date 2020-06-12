$().ready(function() {
    $('.summernote').summernote({
        height : '300px',
        lang : 'zh-CN',
        toolbar: [
            //<!--字体工具-->
            ['fontname', ['fontname']], //字体系列
            ['style', ['bold', 'italic', 'underline', 'clear']], // 字体粗体、字体斜体、字体下划线、字体格式清除
            ['fontsize', ['fontsize']], //字体大小
            ['color', ['color']], //字体颜色

            //<!--段落工具-->
            ['style', ['style']],//样式
            ['para', ['ul', 'ol', 'paragraph']], //无序列表、有序列表、段落对齐方式
            ['height', ['height']], //行高

            //<!--插入工具-->
            ['table',['table']], //插入表格
            ['hr',['hr']],//插入水平线
            ['link',['link']], //插入链接
            ['picture',['picture']], //插入图片

            //<!--其它-->
            ['fullscreen',['fullscreen']], //全屏
            ['codeview',['codeview']], //查看html代码
            ['help',['help']], //帮助
        ],
        callbacks: {
            onImageUpload: function(files, editor, $editable) {
                sendFile(files);
            },
            onPaste: function (ne) {
                var bufferText = ((ne.originalEvent || ne).clipboardData || window.clipboardData).getData('Text/plain');
                ne.preventDefault ? ne.preventDefault() : (ne.returnValue = false);
                setTimeout(function () {
                    document.execCommand("insertText", false, bufferText);
                }, 10);
            }
        }
    });
    $('#content_sn').summernote('code',  $("#content_sn").parent().next().val());
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/information/leaveMsg/update",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入名字"
			}
		}
	})
}