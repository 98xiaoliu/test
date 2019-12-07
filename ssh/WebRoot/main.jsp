<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    
    <center>
      
      <h2>
         ${empty nowuser ? "<a href='login.jsp'>请登录</a>":"" }
      </h2>
      <h2>
        <a href="usersctrl/list.do">查看用户列表</a>
      </h2>
      
      <hr>
      <h2>文件上传</h2>
      <form action="usersctrl/upload.do" method="post"
            enctype="multipart/form-data">
            图片：<input type="file" name="upload">
            <input type="submit" value="提交">
      </form>
      
    </center>
    
  </body>
</html>
