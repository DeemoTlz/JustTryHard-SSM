<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	img {
		width: 100%;
	}
</style>
<title>登录</title>
</head>

<body>
	<h4>Login Page</h4>

	<form id="form-login" action="#">
		<label>userName: <input type="text" name="userName"></label>
		<label>password: <input type="text" name="password"></label>
		<input type="button" id="btn-login" value="提交">
	</form>

	<img src="img/111.png" alt="111">
	<img src="img/222.png" alt="222">
</body>

<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$('#btn-login').click(function () {
		$.ajax({
             type: "POST",
             url: "shiro/login",
             data: $('#form-login').serialize(),
             dataType: "json",
             success: function(data){
				 if (200 === data.code_) {
					 window.location.href="index.jsp"
				 } else {
					 alert('登录失败！');
				 }
			 }
         });
	});
</script>
</html>