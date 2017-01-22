<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Панель менеджера</title>
<link rel="icon" href="images/favicon.ico">
<link rel="shortcut icon" href="images/favicon.ico" />
<link rel="stylesheet" href="cssAdmin/style.css" type="text/css"
	media="all" />
</head>
<body>
	<!-- Header -->
	<div id="header">
		<div class="shell">
			<!-- Logo + Top Nav -->
			<div id="top">
				<h1>
					<a href="index.jsp">Journey</a>
				</h1>
				<div id="top-navigation">
					Приветствую, <strong>${user.name} ${user.secondName}</strong> <span>|</span> <span>|</span>
					<a href="Controller?com=logOut">Выйти</a>
				</div>
			</div>

			<div id="navigation">
				<ul>
					<li><a href="Controller?com=manager"><span>Панель менеджера</span></a></li>
					<c:choose>
						<c:when test="${user.role=='ADMIN'}">
							<li><a href="Controller?com=admin"><span>Админ панель</span></a></li>
							<li><a href="Controller?com=users" class="active"><span>
										Управление пользователями </span></a></li>
						</c:when>
					</c:choose>


				</ul>
			</div>
		</div>
	</div>

	<div id="container">
		<div class="shell">

			<br />
			<!-- Main -->
			<div id="main">
				<div class="cl">&nbsp;</div>

				<!-- Content -->
				<div id="content">

					<!-- Box -->
					<div class="box">
						<!-- Box Head -->
						<div class="box-head">
							<h2 class="left">Пользователи</h2>
							<br />

							<div class="right">


								<form method="post" action="Controller">
									<input type="hidden" name="com" value="usersSearch"></input> <label>Поиск по имени</label><input type="text" name="client"
										class="field small-field" required /> <input type="submit"
										class="button" value="Поиск" />
								</form>
								<form action="Controller">
									<input type="hidden" name="com" class="button" value="users" />
									<input type="submit" class="button" value="Сбросить" />
								</form>
							</div>

						</div>
						<!-- End Box Head -->

						<!-- Table -->
						<div class="table">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<th>Id</th>
									<th>Имя</th>
									<th>Фамилия</th>
									<th>Email</th>
									<th>Логин</th>
									<th>Роль</th>

								</tr>

								<c:choose>
									<c:when test="${users!=null&&fn:length(users)>0}">
										<c:forEach begin="0" end="${fn:length(users)-1}"
											varStatus="loop">
											<tr>
												<td>${users[loop.index].id}</td>

												<td>${users[loop.index].name}</td>
												<td>${users[loop.index].secondName}</td>
												<td>${users[loop.index].email}</td>
												<td>${users[loop.index].login}</td>
												<td>${users[loop.index].role}<br />
												<c:choose>
														<c:when test="${users[loop.index].role=='CLIENT'}">
															<a href="Controller?com=updateUser&set=man&id=${users[loop.index].id}">Назначить менеджером</a>
															<br />
															<a href="Controller?com=updateUser&set=block&id=${users[loop.index].id}">Блокировать</a>
														</c:when>
														<c:when test="${users[loop.index].role=='BLOCKED'}">
															<a href="Controller?com=updateUser&set=unblock&id=${users[loop.index].id}">Разблокировать</a>
														</c:when>
														<c:when test="${users[loop.index].role=='MANAGER'}">
															<a href="Controller?com=updateUser&set=block&id=${users[loop.index].id}">Блокировать</a>
														</c:when>
														<c:otherwise></c:otherwise>
													</c:choose>
												</td>
											</tr>
										</c:forEach>

									</c:when>

								</c:choose>

							</table>


						</div>
						<!-- Table -->

					</div>
					<!-- End Box -->



				</div>
				<!-- End Content -->

				<!-- Sidebar -->
				<div id="sidebar"></div>
				<!-- End Sidebar -->

				<div class="cl">&nbsp;</div>
			</div>
			<!-- Main -->
		</div>
	</div>
	<!-- End Container -->

</body>
</html>