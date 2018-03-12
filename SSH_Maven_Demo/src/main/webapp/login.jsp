<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="/struts-tags" prefix="s"%> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="css/component.css" />
<title>登录页面</title>
</head>
<body>
	<div class="container demo-1">
		<div class="content">
			<div id="large-header" class="large-header">
				<canvas id="demo-canvas"></canvas>
				<div class="logo_box">
					<h3>登录</h3>
					<form action="${pageContext.request.contextPath}/LoginAction_login.action" id="login" method="post">
						<div class="input_outer">
							<span class="u_user"></span>
							<input  class="text" style="color: #FFFFFF !important" type="text" name="uname" placeholder="请输入账户">
						</div>
						<div class="input_outer">
							<span class="us_uer"></span>
							<input  class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"  type="password" name="password" placeholder="请输入密码">
						</div>
						<div class="mb2"><a class="act-but submit" href="javascript:document:login.submit();" style="color: #FFFFFF"  >登录</a></div>
					</form>
					<span>${fail}</span>
				</div>
			</div>
		</div>
	</div><!-- /container -->
		<script src="js/TweenLite.min.js"></script>
		<script src="js/EasePack.min.js"></script>
		<script src="js/rAF.js"></script>
		<script src="js/demo-1.js"></script>
</body>
</html>