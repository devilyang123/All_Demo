<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户注册</title>
</head>
<body>
<h1>用户注册</h1>
<form action="/user/register" method="post">

    用户名:<input type="text" name="userName" /> <br/>
    密码:<input type="password" name="userPassword" /><br />
    <input type="submit" value="注册">

</form>
<a href="/user/getUserList">用户列表</a>
</body>
</html>