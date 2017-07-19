<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>电商后台 -登陆页面</title>
<meta name="Copyright" content="Douco Design." />
<link href="css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>

<!-- <script type="text/javascript">
function change(x)
{
	x.src="code.jsp?time"+new Date();
}
</script> -->


</head>
<body>

<!-- <script type="text/javascript" src="content/settings/main.js"></script>
	<div id="content" class="white">
		<h1>
			<img src="img/icons/dashboard.png" alt="" />用戶登陸
		</h1>
		<div class="bloc left">
			<div class="title">登陸信息</div>
			<div class="content dashboard">
				<form method="post"  action="UserAction!login.action">
				<div class="center">
					<div class="input">
						<label for="input1">用户账号</label> <input type="text"
							name="user.username" id="input1" />
					</div>
					<div class="input">
						<label for="input3">账户密码</label> <input type="password"
							name="user.password" id="input3" />
					</div>
					<div class="input" >
						<table>
							<tr>
								<td><label for="input4">验证码</label> <input type="text"
									style="width: 120px;" name="code" id="input4" /></td>
								<td><img onclick="change(this)" alt="点击换一张" title="点击换一张" src="code.jsp" style="width: 130px;height: 30px;margin-left: 5px;position: relative;top: 10px;"/></td>
							</tr>
						</table>

					</div>
					<div class="submit center">
						<input type="submit" value="登陆" style="width: 100px;margin-left: 60px;" />
					</div>
				</div>
				</form>
			</div>
		</div>


	</div> -->


<!-- <form  name="loginForm" action="UserAction!login.action"  method="get"> -->
<form  name="loginForm" action="UserAction.action"  method="get">
	username:<input type="text" name="user.username" /><br/>
	password:<input type="password" name="user.password" /><br/>
	<input type="submit" />
	
</form>

</body>
</html>