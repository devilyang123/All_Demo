<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改用户</title>
</head>
<body>
<h1>修改用户</h1>
<form action="/user/toUpdateUser" method="post">

    <input type="hidden"  name="id" value="${user.id }">
    用户名:<input type="text" name="userName" value="${user.userName}"/> <br/>
    密码:<input type="password" name="userPassword" value="${user.userPassword}" /><br />
    <input type="submit" value="修改">

</form>
<a href="/user/getUserList">用户列表</a>
</body>
</html>