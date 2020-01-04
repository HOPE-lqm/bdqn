<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/opui.js"></script>
</head>
<body>
	<div style="width: 400px;height:200px;margin: 0px auto;">
		<c:forEach items="${requestScope.list }" var="ned">
		<span>编号:</span><span id="idf">${ned.id }</span>
		<div>员工姓名：<input id="id" type="text" value="${ned.empname }"/></div>
		<div>部&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;门：<input id="sy" type="text" value="${ned.dept }"/></div>
		<div>考勤日期：<input id="qs" type="text" value="${ned.chkdate }"/></div>
		<div>考勤类型：<input id="jz" type="text" value="${ned.status }"/></div>
		<div style="float:left;margin-left:50px;"><input id="tj" type="button" value="提交"/></div>
		<div style="float:right;margin-right:200px;"><input id="qx" type="button" value="取消"/></div>
		</c:forEach>
		</div>
</body>
</html>