<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src = "../../js/jquery-1.8.3.js" ></script>

<script type="text/javascript">
		 function f(){
			$.post(
					"${pageContext.request.contextPath}/findUser_1", //url地址
					//{"":value},										 //发送的参数(key/value)
					function(data){									 //载入成功时回调函数
						alert(data.email);
					},
					
					"json"											 //返回内容格式
				);
		} 
			
		function f1(){
			$.ajax({
					url:"${pageContext.request.contextPath}/findUser_1",	 //url地址
					type:"POST", 											 //请求方式
					data:"",												 //发送到服务器的数据
					async:true,											 	 //是否异步，默认为true
					success:function(data){									 //载入成功时回调函数
						alert(data.username);
					},
					error:function(data){									 //载入shibai时回调函数
						alert("请求失败");
					},
					dataType:"json",										 //返回内容格式
			});
		}
</script>
<style type="text/css">
	input{
		padding:0;
		margin:0;
	}
	#input{
		position:relative;
	}
	#searchResult{
		display:none;
		position:absolute;
		background: #fff;
		z-index: 1000;
		width: 151px;
		border:1px solid #ccc;
	}

</style>	
<!-- 异步搜索用户 -->
<script type="text/javascript">
	
	function searchUser(obj){
		//获取输入的内容
		var username = $(obj).val(); 
		//根据输入内容去数据库中模糊查询 
		var content = "";
		$.post(
			"${pageContext.request.contextPath}/searchUser", 
			{"username":username},										
			function(data){	
				if(data.length>0){
					for(var i = 0; i < data.length; i++){		
						content += "<div style='padding:5px; cursor:pointer' onclick='mouseClick(this)' onmouseover='mouseOver(this)' onmouseout='mouseOut(this)'>"
						+data[i].username+"</div>";
					}
					//将返回的名字显示到div中
					$("#searchResult").html(content);
					$("#searchResult").css("display","block");
					
				}else{
					$("#searchResult").html(null);
					$("#searchResult").css("display","block");
					$("#searchResult").css("height","150px");
				}
			},
			
			"json"											 
		);
		
		
	}
	function mouseOver(obj){
		$(obj).css("background","#DBEAF9");
	}
	function mouseOut(obj){
		$(obj).css("background","#fff");
	}
	function mouseClick(obj){
		$("#search").val($(obj).html());
		$("#searchResult").css("display","none");
	}

</script>


<title>SSM</title>
</head>
<body>
	<h1>异步测试</h1>
	<input type="button" onclick="f()" value="post" /> <br/>
	<input type="button" onclick="f1()" value="ajax" /><br	>
	<a href="${pageContext.request.contextPath}/register">注册页面</a><br	>
	<a href="${pageContext.request.contextPath}/login">登录页面</a><br	><br><br>
	
	<form action="${pageContext.request.contextPath}/search" method="post">
		<div id = "input">
			<input id = "search"  type = "text" name = "username" placeholder = "Search" onkeyup = "searchUser(this)"/>
		
	    	<input  type = "submit"  value = "Search" />
	    
	    	<div id = "searchResult" >
	    		<!-- 这里会动态添加div -->
	   	 	</div>
		</div>	
	</form>
	
	
	
</body>
</html>