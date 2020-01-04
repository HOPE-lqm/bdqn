<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
table {
    border-collapse: collapse;
}

table, td, th {
    border: 1px solid black;
}
th{
	width: 130px;
}
</style>
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
	<div style="width: 600px;height:200px;margin: 0px auto;text-align: center;">
		<div>
			<form action="main" method="post">
				姓名:&nbsp;&nbsp;
			<input id="dm" type="text" name="chk_option"/>
			&nbsp;&nbsp;<input id="name" type="submit" value="查询"/>
			</form>
		</div>
		<div id="table" style="margin-top:20px">
			<table>
				<tr>
					<th style="width: 60px;">编号</th>
					<th style="width: 120px;">员工姓名</th>
					<th style="width: 100px;">部门</th>
					<th style="width: 200px;">考勤日期</th>
					<th style="width: 120px;">考勤类型</th>
					<th style="width: 100px;">操作</th>
				</tr>
				<c:forEach items="${requestScope.list }" var="ned">
				<tr>
					<td>${ned.id }</td>
					<td>${ned.empname }</td>
					<td>${ned.dept }</td>
					<td>${ned.chkdate }</td>
					<c:choose>
						<c:when test="${ned.status eq 1 }">
							<td>正常</td>
						</c:when>
						<c:when test="${ned.status eq 2 }">
							<td>迟到</td>
						</c:when>
						<c:when test="${ned.status eq 3 }">
							<td>早退</td>
						</c:when>
						<c:when test="${ned.status eq 4 }">
							<td>休假</td>
						</c:when>
						<c:when test="${ned.status eq 5 }">
							<td>外出</td>
						</c:when>
					</c:choose>
					<td>
						<a class="c" href="opui?id=${ned.id }">修改</a>
						<a class="c" href="#" onclick="ui(${ned.id })">删除</a>
					</td>
				</tr>
			</c:forEach>
			</table>
		</div>
		<div style="margin-top:150px">
			<a href="update.jsp">新增信息</a>
		</div>
	</div>
</body>
</html>