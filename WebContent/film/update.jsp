<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>update.jsp</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>


<body>
	<form action="${pageContext.request.contextPath }/film" method="post">
		<input type="hidden" name="submitFlag" value="update"> <input
			type="hidden" name="filmId" value="${film.film_id }">
		<table width="60%" align="center" bordercolor="#abcdef" border="1">
			<tr>
				<td align="center" colspan="2">修改</td>
			</tr>
			<tr>
				<td align="center">title</td>
				<td align="center"><input type="text" name="title"
					value="${film.title }"></td>
			</tr>
			<tr>
				<td align="center">description</td>
				<td align="center"><input type="text" name="description"
					value="${film.description }"></td>
			</tr>
			<tr>
				<td align="center">language</td>
				<td align="center"><select name="language"
					style="width: 150px;">
						<c:forEach items="${lname }" var="name">
							<option value="${name}"
								<c:if test="${film.language eq name}">selected="selected"</c:if>>${name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="修改">&nbsp;&nbsp;
					<input type="button" value="返回"
					onclick="window.location.href='${pageContext.request.contextPath }/film?submitFlag=toList'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
