<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>

	<h4>Index Page</h4>
	<br><br>
	Welcome:<shiro:principal />
	
	<shiro:hasRole name="admin">
		<br><br>
		<a href="admin.jsp">admin</a>
	</shiro:hasRole>
	
	<shiro:hasPermission name="student:_page">
		<br><br>
		<form action="student/_page" method="post">
			<a href="javascript:void(0);" onclick="submit();">page</a>
		</form>
	</shiro:hasPermission>
	
	<br><br>
	<a href="user.jsp">user</a>
	<br><br>
	<a href="logout">Logout</a>
	
</body>

<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(() => {
		$.ajax({
			type: "POST",
			url: "student/_list",
			data: $('#form-login').serialize(),
			dataType: "json",
			success: function(data){
				console.log(data);
			}
		});
	});
</script>
</html>