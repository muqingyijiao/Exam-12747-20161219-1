<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>film列表</title>

<link rel="stylesheet" type="text/css"></link>
</head>
<body>
	<div style="color: red;text-align: center;size: 23">
		<%
			String errorMsg = (String) request.getAttribute("errorMsg");
			if (errorMsg != null) {
		%>
		<%=errorMsg%>
		<%
			}
		%>
	</div>
	<form action="">
		<table align="center" id="table" width="80%" bordercolor="#abcdef"
			border="1">
			<tr>
				<td colspan="6" align="center">file列表</td>
			</tr>
			<tr align="center">
				<td colspan="6"><input type="button" value="新增"
					onclick="window.location.href='${pageContext.request.contextPath }/film?submitFlag=toAdd'" /></td>
			</tr>
			<tr>
				<td align="center">film_id</td>
				<td align="center">title</td>
				<td align="center">description</td>
				<td align="center">language</td>
				<td colspan="2" align="center">操&nbsp;&nbsp;&nbsp;&nbsp;作</td>
			</tr>
			<c:forEach items="${list}" var="m">
				<tr>
					<td align="center">${m.film_id }</td>
					<td align="center">${m.title }</td>
					<td align="center">${m.description }</td>
					<td align="center">${m.language}</td>
					<td align="center" colspan="2"><a
						href="film?submitFlag=toUpdate&film_id=${m.film_id }">修改</a><br>
						<a href="film?submitFlag=toDelete&film_id=${m.film_id }">删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>