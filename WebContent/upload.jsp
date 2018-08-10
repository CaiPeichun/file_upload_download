<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上传文件</title>
<style type="text/css">
	
			body{ 
					 background-image:url('img/img1.jpg');
					background-repeat:no-repeat;
					
					}
			#tool{
				width: 400px;
				height: 280px;
				position: absolute;
				left:50%;
				top:50%;
				margin-left: -200px;
				margin-top: -140px;
				border:1px;
				align:center;
				
			}
			#form{
				width: 300px;
				height: 160px;
				position: relative;
				left:50%;
				top:50%;
				margin-left: -150px;
				margin-top: -80px;
			}
</style>
	
</head>
<body>
<div id="tool">
<div id="form">
<fieldset>
<form action="${pageContext.request.contextPath}/UploadServlet" method="post" enctype="multipart/form-data">
	
	<input  type="file" name="f"><br><br>
	描述:<input type="text" name="describ" ><br><br>
	<div id="submit" align="center">
	<input type="submit" value="上传" >
	</div>
</form>
</fieldset>
</div>
</div>
</body>
</html>