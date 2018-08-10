<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8" />
		<title>小菜的网盘系统</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<style type="text/css">
			body{ 
					 background-image:url('img/img1.jpg');
					background-repeat:no-repeat;
					
					}
			a:link {
					color: cadetblue;
					text-decoration:underline;
					font-size:180% ;
					}
			a:visited {
					color: darkseagreen;
					text-decoration:none;
			}
			a:hover {
					color: crimson;
					text-decoration:none;
			}
			
			
			
			
		</style>
	</head>
<body>
<!DOCTYPE html>
<html>
	
	<body>
		
		<h1 class="font_bk">--小菜滴网盘系统--</h1>
		<!-- <img  name="topic" src="topic.jpg" width="300px" height="100px" style="position:absolute; left:0px; top:0px;"/> -->
		<img src="img/白板.png" style="position:absolute; left:150px; top:250px;"/>
		<a href="${pageContext.request.contextPath }/upload.jsp" style="position:absolute; left:190px; top:320px;">文件上传</a>
		
		<img src="img/白板2.png" style="position:absolute; left:400px; top:150px;"/>
		<a href="${pageContext.request.contextPath}/ShowDownloadServlet" style="position:absolute; left:440px; top:220px;">文件下载</a>
		<div>
		<img src="img/hero.jpg" style="position:absolute; bottom:10px;right: 10px;" />
		</div>
	</body>
</html>
</body>
</html>