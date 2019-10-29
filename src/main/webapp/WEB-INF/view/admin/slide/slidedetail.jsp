<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"></script>
</head>
<body>
<table class="table" border="1" align="right" >
	<tr>
		<td>编号</td>
		<td>名称</td>
		<td>图片</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${slide }" var="s">
		<tr>
			<td>${s.id}</td>
			<td>${s.title}</td>
			<td><img alt=".." src="/pic/${s.picture}" style="height: 100px;width: 200px;"> </td>
			<td> <button>删除</button> </td>
		</tr>
	
	</c:forEach>
</table>
<button onclick="toinsert()">添加</button>


</body>
<script type="text/javascript">
function toinsert(){
	$("#content-wrapper").load("insert");
}
</script>
</html>