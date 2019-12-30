$(function() {
	$("#btn").click(function() {
		var incardNo = $("#inaccount").val().trim();
		var inmoeny = $("#inmoeny").val().trim();

		var reg = /^\d{16}$/;
		if (!reg.test(incardNo)) {
			alert("请正确填写转入的16位账号");
			return;
		}

		var regmoney = /^\d+(\.\d{2})?$/;
		if (!regmoney.test(inmoeny)) {
			alert("请正确填写转账的金额");
			return;
		}

		$.ajax({
			url : 'checktr',
			type : 'post',
			data : {
				'incardNo' : incardNo,
				'inmoney' : inmoeny
			},
			dataType : 'text',
			success : function(msg) {
				if (msg == 1) {
					alert("转账失败！目标账户不存在!");
					return;
				} else if (msg == 3) {
					alert("转账失败！目标账户已被冻结!");
					return;
				} else if (msg == 4) {
					alert("转账失败！转出账户余额不足！");
					return;
				} else {
					// 验证通过，进行转账操作
					$.ajax({
						url : 'transaction',
						type : 'post',
						data : {
							'incardNo' : incardNo,
							'inmoney' : inmoeny
						},
						dataType : 'text',
						success : function(msg) {
							if(msg == 1){
								alert("转账成功");
							}else{
								alert("转账失败");
							}
						}
					});
				}
			}
		});
	});

});