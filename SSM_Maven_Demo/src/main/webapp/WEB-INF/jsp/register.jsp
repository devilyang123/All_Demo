<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>用户注册</title>
	<script type="text/javascript" src = "../../js/jquery-1.8.3.js" ></script>
	
	<script type="text/javascript">
		//页面加载就执行这个函数
		$(function(){
			//输入框绑定失去焦点事件 
			$("#username").blur(function(){
				//失去焦点后 获得输入框的内容
				var usernameInput = $("#username").val();
				//去服务端校验该用户名是否存在
				$.post(
				   "${pageContext.request.contextPath}/checkUsername",
					{"username":usernameInput},
					function(data){
						if(data != null){
							$("#checkUsername").html("用户名不可用");
							$("#checkUsername").css("color","red");
						}else{
							$("#checkUsername").html("用户名可用");
							$("#checkUsername").css("color","green");
						}
					},
					"json"
				);
			});
			
		});
		
	
	</script>
</head>
<body>

	<h1>用户注册</h1>
	<form action="${pageContext.request.contextPath}/user/register" method="post">
		用户名：	<input type="text" 		name="username"  id="username" />
				<span id = "checkUsername"></span> <br />
		密码：  	<input type="password"  name="password" /> <br />
		年龄：  	<input type="text" 	    name="age" /><br />
		性别：  	<input type="radio" 	name="gender" value="男" checked="checked" />男
			    <input type="radio"	    name="gender" value="女" />女<br />
		email:  <input type="text" 		name="email" /><br />
				<input type="submit" value="注册" />
	</form>
	
</body>
</html>