$(function(){
	$("#qx").click(function(){
		location.href="main";
	})
	
	$("#tj").click(function(){
		var id = $("#id").val().trim();
		var sy = $("#sy").val().trim();
		var qs = $("#qs").val().trim();
		var jz = $("#jz").val().trim();
		var idf = $("#idf").text().trim();
		
		$.ajax({
			url : 'xg',
			type : 'post',
			data : {
				'id' : id,
				'sy' : sy,
				'qs' : qs,
				'jz' : jz,
				'idf' : idf,
			},
			dataType : 'text',
			success : function(msg) {
				if(msg == 0){
					alert("异常");
				}else if(msg == 1){
					alert("修改数据成功");
				}
			}
		})
	})
})