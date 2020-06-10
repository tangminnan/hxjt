$().ready(function() {
    $('.summernote').summernote({
        height : '400px',
        lang : 'zh-CN',
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
    var content_sn = $("#content_sn").summernote('code');
    $("#content_sn").parent().next().val(content_sn);
    var formData = new FormData(document.getElementById("signupForm"));
	$.ajax({
		cache : true,
		type : "POST",
		url : "/information/jiezhengFuwu/update",
        data : formData,//$('#signupForm').serialize(), // 你的formid
        processData:false,
        contentType:false,
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