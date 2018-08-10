<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>请选择下载文件</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<td>文件名称</td>
			<td>文件描述</td>
			<td>文件下载</td>
		</tr>
		<tr>
		<c:forEach items="${rs}" var="c">
			<td>${c.realname}</td>
			<td>${c.description}</td>
			<td><a href="${pageContext.request.contextPath }/DownloadServlet?id=${c.id}">文件下载</a></td>
			
		</tr>
		</c:forEach>
	</table>
</body>
</html>