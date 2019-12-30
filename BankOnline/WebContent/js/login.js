$(function() {
	$("#btn").click(function() {
		var cardNo = $("#cardNo").val().trim();
		var pwd = $("#pwd").val().trim();

		var reg = /^\d{16}$/;
		if (!reg.test(cardNo)) {
			alert("请正确填写您的16位卡号");
			return;
		}

		var regpwd = /^\d{6}$/;
		if (!regpwd.test(pwd)) {
			alert("请正确填写6位登录密码");
			return;
		}
		// 使用ajax实现局部刷新的提示
		$.ajax({
			url : 'login',
			type : 'post',
			data : {
				'cardno' : cardNo,
				'password' : pwd
			},
			dataType : 'text',
			success : function(msg) {
				if (msg == 1) {
					alert("登录失败！您输入的卡号不存!");
					return;
				} else if (msg == 2) {
					alert("登录失败！密码错误!");
					return;
				} else if (msg == 3) {
					alert("登录失败！账户已被冻结！");
					return;
				}
				location.href = "main.jsp";
			}
		});

	});
});