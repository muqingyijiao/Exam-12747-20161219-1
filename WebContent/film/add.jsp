<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>film添加</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>


<body>
	<!-- 画界面 -->
	<form action="${pageContext.request.contextPath }/film" method="post">
		<input type="hidden" name="submitFlag" value="add">
		<table width="60%" align="center" bordercolor="#abcdef" border="1">
			<tr>
				<td align="center" colspan="2">film添加</td>
			</tr>
			<tr>
				<td align="center">title</td>
				<td align="center"><input type="text" name="title"></td>
			</tr>
			<tr>
				<td align="center">description</td>
				<td align="center"><input type="text" name="description"></td>
			</tr>
			<tr>
				<td align="center">language</td>
				<td align="center"><select name="language"
					style="width: 150px;"><option value="English"
							selected="selected">English</option>
						<option value="Italian">Italian</option>
						<option value="Japanese">Japanese</option>
						<option value="Mandarin">Mandarin</option>
						<option value="French">French</option>
						<option value="German">German</option></select>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="添加">&nbsp;&nbsp;
					<input type="button" value="返回"
					onclick="window.location.href='${pageContext.request.contextPath }/film?submitFlag=toList'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
