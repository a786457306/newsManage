<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
      <meta http-eqive="Content-Type" content="text.html;charset=utf-8"/>
    </head>
    <body>
     <%
     	session.invalidate();
     	response.sendRedirect("/DJGZ/f/index.jsp");
      %>
    </body>
  </html>