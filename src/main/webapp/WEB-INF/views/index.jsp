<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7">
		<title>党建工作-东北师范大学信息与软件工程学院</title>
		<meta name="keywords" content="东北师范大学信息与软件工程学院">
		<link media="all" href="css/index.css" type="text/css" rel="stylesheet">
	</head>

	<body>
		<div class="top_bg">
		</div>

		<!--list_nav开始-->
		<div class="list_nav">

			<ul>
				<li>
					<a href="" title="学院概况" indepth="true">学院概况</a>
				</li>
				<li>
					<a href="" title="办学特色" indepth="true">办学特色</a>
				</li>
				<li>
					<a href="" title="学科专业" indepth="true">学科专业</a>
				</li>
				<li>
					<a href="" title="科学研究" indepth="true">科学研究</a>
				</li>
				<li>
					<a href="" title="人才培养" indepth="true">人才培养</a>
				</li>
				<li>
					<a href="" title="招生信息" indepth="true">招生信息</a>
				</li>
				<li>
					<a href="" title="学生就业" indepth="true">学生就业</a>
				</li>
				<li>
					<a href="" title="合作交流" indepth="true">合作交流</a>
				</li>
				<li>
					<a href="" title="社会服务" indepth="true">社会服务</a>
				</li>
				<li>
					<a href="index.jsp" title="党建工作" indepth="true">党建工作</a>
				</li>
				<li>
					<a href="" title="教职员工" indepth="true">教职员工</a>
				</li>
				<li>
					<a href="" title="学院资讯" indepth="true">学院资讯</a>
				</li>
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
								<c:forEach items="${columnList}" var="column">
									<li>
										<a href="index.jsp?cid=${column.columnId}" indepth="true" class="all">${column.columnName}</a>
									</li>
								</c:forEach>
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
					<%--<%--%>
						 <%--int cid = 1;--%>
						 <%--if(request.getParameter("cid") != null && !"".equals(request.getParameter("cid"))){--%>
							<%--cid = Integer.parseInt(request.getParameter(("cid")));--%>
						<%--}  --%>
						<%--Column column1 = new Column();--%>
						<%--String cname1 = "";--%>
						<%--column1 = columnDao.getColumn(cid);--%>
						<%--cname1 = column1.getCname(); --%>
			<%----%>
					<%--%>--%>
					<div class="list_img_h1"><%=cname1 %></div>
					<div class="list_seat"><strong><a href = "login.jsp">登录</a></strong></div>

				</div>
				<!--内容-->
				<div class="nei">

					<ul class="nei_1">
						<c:forEach items="essayList" var="essay">
							<li id="line_u7_0">
								<a href="essayDetail.jsp?eid=#{essay.essayId}&cid=#{essay.columnId}"
									target="_top" title="#{essay.essayName}" indepth="true">#{essay.essayName}</a>
							</li>
							<span id="section_u7_0" style="display: none;">
							<hr style="height: 1px; border-width: 1px medium medium; border-style: dashed none none; border-color: rgb(204, 204, 204) currentcolor currentcolor; -moz-border-top-colors: none; -moz-border-right-colors: none; -moz-border-bottom-colors: none; -moz-border-left-colors: none; border-image: none;">
							</span>
						</c:forEach>
					</ul>
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
					<a href="#" >联系我们</a> |
					<a href="http://mail.nenu.edu.cn/" >E-mail</a>
				</div>
			</div>
		</div>
	</body>

</html>