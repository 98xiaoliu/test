<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
	  var islogin="${param.islogin}";
	  if(islogin=="no"){
	     alert("您未登录，请先登录！");
	  }
	</script>

  </head>
  
  <body>
    
    <center>
       <h1>用户登录</h1>
       <h2 style="color: red">
          ${empty param.isfail ? "":"用户名或密码错误！" }
       </h2>    <!-- 控制器中的方法url地址 -->
       <form action="loginctrl/login.do" method="post">
         用户名：<input type="text" name="uname" placeholder="请输入用户名">
         <br>
         <br>
         密码:<input type="password" name="upass" placeholder="请输入密码">
         <br>
         <br>
         <input type="submit" value="登录">
       </form>
    </center>
    
  </body>
</html>
