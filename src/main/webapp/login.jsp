<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>

	<h4>Login Page</h4>
	
	<form id="form-login">
		userName: <input type="text" name="userName">
		password: <input type="text" name="password">
		<input type="button" id="btn-login" value="提交">
	</form>
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
					 alert('登录成功！');
				 } else {
					 alert('登录失败！');
				 }
			 }
         });
	});
</script>
</html>