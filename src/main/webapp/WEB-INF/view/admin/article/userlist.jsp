<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/resource/js/cms.js"></script>

<script type="text/javascript">
//修改
function update(id){
	var result = confirm("您确定要禁止该用户吗？");
	if(!result)
		return;
	
	location="userupadte?id="+id;
	
}

</script>
</head>
<body>
<table class="table" border="1" align="right" >
	<tr align="center">
		<td>用户名</td>
		<td>创建时间</td>
		<td>用户状态</td>
		<td>管理操作</td>
	</tr>
	<c:forEach items="${list }" var="u">
	<tr align="center">
		<td>${u.username }</td>
		<td><fmt:formatDate value="${u.create_time }" pattern="yyyy年MM月dd日  HH:mm:ss"/> </td>
		<td>${u.locked==0?"未禁止":u.locked==1?"已禁止":"禁止"}</td>
		<td><button type="button" class="btn btn-outline-success" onclick="update(${u.id})"> 禁止该用户</button> </td>
	</tr>
	</c:forEach>
</table>

</body>
</html>