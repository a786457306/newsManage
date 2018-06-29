<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7">
<title>栏目管理-栏目列表</title>
<meta name="keywords" content="东北师范大学信息与软件工程学院">
<link media="all" href="/resources/css/jtnr.css" type="text/css"
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
			<h1>后台管理系统</h1>
			<div class="list_left_list">
				<!--左侧导航开始 -->
				<div class="leftnav_center">
					<!--左侧导航开始 -->
					<div class="leftnav_center">

						<ul id="menu">

							<li><a href="/admin/listColumn" indepth="true"
								   class="all">栏目管理</a></li>

							<li><a href="/admin/listEssay" indepth="true"
								   class="all">文章管理</a></li>

							<li><a href="/admin/logout" indepth="true"
								   class="all">退出登录</a></li>

						</ul>

					</div>

					<!--左侧导航结束 -->
				</div>
			</div>
			<div class="left_banner">
				<img src="/resources/img/left_banner.jpg" border="0">
			</div>
		</div>
		<div class="list_right">
			<div class="list_top">
				<div class="list_img"></div>
				<div class="list_img_h1">栏目管理</div>
				<div class="list_seat"><strong><a href = "${website}/admin/newColumn">增加</a></strong></div>
			</div>
			<!--内容-->
			<div class="manage_table">

				<table border="2px">
						<tr>
							<td>序号</td>
							<td>栏目名称</td>
							<td colspan="3">操作</td>
						</tr>
					<c:forEach items="${columnPage.list}" var="column">
						<tr>
							<td>${column.columnId}</td>
							<td>${column.columnName}</td>
							<td><a href="${website}/admin/updateColumn?columnId=${column.columnId}">编辑</a></td>
							<td><a href="${website}/admin/delColumn?columnId=${column.columnId}">删除</a></td>
						</tr>
					</c:forEach>
					</table>
				
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