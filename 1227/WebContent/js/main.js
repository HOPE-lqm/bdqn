$(function(){
	$("tr:odd").attr("bgColor","#ffffff");
	$("tr:even").attr("bgColor","#787878");
})
function ui(id){
	$.ajax({
		url : 'datele',
		type : 'post',
		data : {
			'id' : id
		},
		dataType : 'text',
		success : function(msg) {
			if(msg == 0){
				alert("异常");
			}else if(msg >= 1){
				alert("删除成功");
				location.href="main";
			}
		}
	})
}
function you(){
	$.ajax({
		url : 'ajaxmain',
		type : 'post',
		data : {
			'iddm' : dm,
			'fx' : xl
		},
		dataType : 'json',
		success : prss
	})
}
function prss(data) {
	var table = $("#table");
	table.html("<table><tr><th>产品代码</th><th>风险评级</th><th>预期收益</th><th>发售启示日</th><th>发售截止日</th><th>产品到期日</th><th>操作</th></tr><tr>");
	for(var i = 0;i < data.length;){
		table.append("<td>" + data[i].id + "</td>");
		table.append("<td>" + data[i].risk + "</td>");
		table.append("<td>" + data[i].income + "</td>");
		table.append("<td>" + data[i].saleStarting + "</td>");
		table.append("<td>" + data[i].saleEnd + "</td>");
		table.append("<td>" + data[i].end + "</td>");
		table.append("<td><a class='c' href='c' onclick=''>修改</a><a class='c' href='c' onclick=''>删除</a></td>");
	}
	table.append("</tr>");
}