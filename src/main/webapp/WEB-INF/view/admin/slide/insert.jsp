<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>添加页面</h1>
	<form action="inster" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>名字</td>
				<td><input type="text" name="title"></td>
				<td>图片</td>
				<td><input type="file" name="file"></td>
			</tr>
		</table>
		<input type="submit" value="添加">
	</form>

</body>
</html>