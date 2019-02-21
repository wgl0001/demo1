<%@page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							2009/11/20 
							<br />
							<a href="${pageContext.request.contextPath}/user/logout.do">安全退出</a>
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Welcome!
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								Name
							</td>
							<td>
								Password
							</td>
							<td>
								Type
							</td>
							<td>
								Operation
							</td>
						</tr>
						<c:forEach items="${requestScope.list}" var="p">
						<tr class="row1">
							<td>
								${p.id}
							</td>
							<td>
								${p.username}
							</td>
							<td>
								${p.password}
							</td>
							<td>
								${p.level}
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/user/remove.do?id=${p.id}">delete emp</a>&nbsp;<a href="${pageContext.request.contextPath}/user/getById.do?id=${p.id}">update emp</a>
							</td>
						</tr>
						</c:forEach>
					</table>
					<p>
						<input type="button" class="button" value="Add Employee" onclick="location='${pageContext.request.contextPath}/addEmp.jsp'"/>
					</p>
				</div>
				<a href="">1</a>
				<a href="">2</a>
				<a href="">3</a>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
