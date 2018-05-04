<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户列表</title>
    <style type="text/css">

        table {
            width: 300px;
            border: 1px solid #ccc;
        }

    </style>

</head>
<body>
<h1>用户列表</h1>

<table>

    <tr>
        <td>ID</td>
        <td>姓名</td>
        <td>密码</td>
    </tr>
    <#list userList as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.userPassword}</td>
            <td><a href="
            /user/updateUser?id=${user.id}">修改</a></td>
            <td><a href="/user/deleteUserByID?id=${user.id}">删除</a></td>
        </tr>
    </#list>

</table>
<button type="button" onclick="javascript:history.back(-1);">返回</button>
<a href="/register">用户注册</a>
</body>
</html>