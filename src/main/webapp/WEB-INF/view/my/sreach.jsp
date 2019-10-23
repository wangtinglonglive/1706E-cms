<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="/resource/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="/resource/css/cms.css?v=1.1" />
<style type="text/css">
</style>

<script type="text/javascript">
	 function myopen(id){
		 //在新窗口打开文章的详情J
		 window.open("/article/show?id="+id,"_blank")
	 }
   </script>
</head>
<body>
	<table class="table table-striped" border="1" align="right">
		<c:forEach items="${sreach }" var="a">
		<tr align="center">
			<td><img  width="120"  height="80" class="align-self-start mr-3" src="/pic/${a.picture }"  alt="no pic"></td>
			<td><fmt:formatDate value="${a.created }" pattern="yyyy年MM月dd日  HH:mm:ss"/></td>
			<td><a href="javascript:myopen(${a.id })"> ${a.title }</a></td>
		</tr>
		</c:forEach>
	</table>
<a href="index">返回</a>
</body>
</html>