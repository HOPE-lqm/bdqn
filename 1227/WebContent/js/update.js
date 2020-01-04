$(function(){
	$("#qx").click(function(){
		location.href="main";
	})
	
	$("#tj").click(function(){
		var id = $("#id").val().trim();
		var sy = $("#sy").val().trim();
		var qs = $("#qs").val().trim();
		var jz = $("#jz").val().trim();
		
		$.ajax({
			url : 'into',
			type : 'post',
			data : {
				'id' : id,
				'sy' : sy,
				'qs' : qs,
				'jz' : jz,
			},
			dataType : 'text',
			success : function(msg) {
				if(msg == 0){
					alert("异常");
				}else if(msg == 1){
					alert("新增数据成功");
				}
			}
		})
	})
})