<%@page import="entity.Column"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:useBean id="columnDao" class = "dao.ColumnDao"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7">
<title>栏目管理-增加栏目</title>
<meta name="keywords" content="东北师范大学信息与软件工程学院">
<link media="all" href="../css/jtnr.css" type="text/css"
	rel="stylesheet">
</head>

<body>
	<div class="top_bg"></div>

	<!--list_nav开始-->
	<div class="list_nav">

		<ul>
			<li><a href="" title="学院概况" indepth="true">学院概况</a></li>
			<li><a href="" title="办学特色" indepth="true">办学特色</a></li>
			<li><a href="" title="学科专业" indepth="true">学科专业</a></li>
			<li><a href="" title="科学研究" indepth="true">科学研究</a></li>
			<li><a href="" title="人才培养" indepth="true">人才培养</a></li>
			<li><a href="" title="招生信息" indepth="true">招生信息</a></li>
			<li><a href="" title="学生就业" indepth="true">学生就业</a></li>
			<li><a href="" title="合作交流" indepth="true">合作交流</a></li>
			<li><a href="" title="社会服务" indepth="true">社会服务</a></li>
			<li><a href="index.jsp" title="党建工作" indepth="true">党建工作</a></li>
			<li><a href="" title="教职员工" indepth="true">教职员工</a></li>
			<li><a href="" title="学院资讯" indepth="true">学院资讯</a></li>
		</ul>

	</div>
	<!--list_nav结束-->
	<div class="list_banner"></div>
	<div class="list_warp">
			<div class="list_left">
				<h1>信息科学与技术学院</h1>
				<div class="list_left_list">
					<div class="leftnav_center">
						<div class="leftnav_center">
							<ul id="menu">
							<%
								Column column = new Column();
								ArrayList<Column> clist = columnDao.selectColumn(column);
								if(clist != null){
									for(int i = 0;i < clist.size();i ++){
									column = clist.get(i);
							%>
								<li>
									<a href="index.jsp?cid=<%=column.getCid() %>" indepth="true" class="all"><%=column.getCname() %></a>
								</li>
							<%							
									}
								}
							%>
							</ul>

						</div>
					</div>
				</div>
				<div class="left_banner"> 
					<img src="/DJGZ/img/left_banner.jpg" border="0">
				</div>
			</div>
		<div class="list_right">
			<div class="list_top">
				<div class="list_img"></div>
				<div class="list_img_h1">登录</div>
			</div>
			<!--内容-->
			<div class="nei" style="text-align:center;font-size:30px">

				<form action="/DJGZ/servlet/LoginServlet" method="post">

					<h2 align="center">个人信息</h2>
					<div
						style="text-align: center; line-height: 25px; font-size: 12px;">

						<input type="text" name="uname" placeholder="用户名" required><br><br> 
						<input type="password" name="upsw" placeholder="密码" required><br><br> 
						<input type="submit" value="提交"><br><br>
					</div>
				</form>

			</div>
		</div>
		<div style="clear: both;"></div>
	</div>
	<div class="copyright">
		<div class="copyright_box">
			<div class="copyright_01"></div>
			<div class="copyright_02">
				<p>版权所有© 东北师范大学信息与软件工程学院 地址：吉林省长春市净月大街2555号 邮编：130117</p>
			</div>
			<div class="copyright_03">
				<a href="#">联系我们</a> | <a href="http://mail.nenu.edu.cn/">E-mail</a>
			</div>
		</div>
	</div>
</body>

</html>