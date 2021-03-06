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
<link rel="stylesheet" href="cssAdmin/style.css" type="text/css" media="all" />
<link rel="stylesheet" type="text/css" href="cssAdmin/capicon.css">

<script src="http://code.jquery.com/jquery-2.0.2.min.js"></script>
<script type="text/javascript" src="js/popup.js"></script>
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
					Приветствую, <strong>${user.name} ${user.secondName}</strong> <span>|</span>
					<span>|</span> <a href="Controller?com=logOut">Выйти</a>
				</div>
			</div>
			<!-- Form -->
			<div id="popup">
				<div class="popupcontent">
					<form action="Controller" method="post">
						<input type="hidden" name="com" value="mail" />
						<div class="form">
							<label> Рассылка новости всем подписчикам</label>
							</br>
							<p><label>Тема</label>
								<input style="float: none;" type="text" name="theme">
							</p>
							<p>
							</br>
								<label>Описание</label>
								<textarea  rows="10" cols="30" name="message"></textarea>
							</p>
						</div>
						<div class="popupitem">	
							<div class="popupitemleft">
								<a href="javascript:PopUpHide()" class="popbtnl">
									<i class="icon-057"></i>
								</a>
							</div>
							<div class="popupitemright">
								<button class="popbtnr" type="submit" value="">
									<i class="icon-055"></i>
								</button>
							</div>
						</div>
<!-- 						<input type="submit" class="button" value="Отправить" />
 -->					</form>
<!-- 					<a href="javascript:PopUpHide()">cancel</a>
 -->				</div>
			</div>
		<!-- End Form -->
			<div id="navigation">
				<ul>
					<li><a href="Controller?com=manager" class="active"><span>Панель
								менеджера</span></a></li>
					<c:choose>
						<c:when test="${user.role=='ADMIN'}">
							<li><a href="Controller?com=admin"><span>Админ
										панель</span></a></li>
							<li><a href="Controller?com=users"><span>
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
							<h2 class="left">Текущие заказы</h2>
							<br /> 
							<form method="post" action="Controller" style="float: left;">
								<input type="hidden" name="com" value="SelectOrders"> 
								<select	name="status">
									<option value="REGISTERED">Заказан</option>
									<option value="CANCELED">Отменен</option>
									<option value="PAYED">Оплачен</option>
								</select> 
								<input type="submit" value="Поиск" class="button">
							</form>
							<a href="javascript:PopUpShow()" class="smail">Рассылка новости</a>
							<a href="Controller?com=current">Текущие заказы</a>
							<div class="right">	
							<label>Поиск по клиенту</label>
								<form method="post" action="Controller">
									<input type="hidden" name="com" value="ClientsSearch"></input>
									<input type="text" name="client" class="field small-field"
										required /> <input type="submit" class="button"
										value="Поиск" />
								</form>
								<form action="Controller">
									<input type="hidden" name="com" class="button" value="manager" />
									<input type="submit" class="button" value="Все заказы" />
								</form>
							</div>

						</div>
						<!-- End Box Head -->

						<!-- Table -->
						<div class="table">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<th>ID</th>
									<th>Страна/регион</th>
									<th>Отель/Питание</th>
									<th>Рейтинг</th>
									<th>Ночей</th>
									<th>Отправление с <br />Дата
									</th>
									<th>Цена/Скидка</th>
									<th width="130">Клиент</th>
									<th width="110">Статус заказа</th>
									<th>Макс. скидка</th>
									<th>Шаг скидки</th>
									<th width="170" class="ac">Управление</th>
								</tr>

								<c:choose>
									<c:when test="${fn:length(orders)>0}">
										<c:forEach begin="0" end="${fn:length(orders)-1}"
											varStatus="loop">
											<tr>
												<td>${orders[loop.index].id}</td>
												<td>${orders[loop.index].tour.hotel.country}<br />${orders[loop.index].tour.hotel.city}</td>
												<td>${orders[loop.index].tour.hotel.name}<br />${orders[loop.index].tour.hotel.nut}</td>
												<td>${orders[loop.index].tour.hotel.rate}★</td>
												<td>${orders[loop.index].tour.nights} ночей</td>
												<td>&#9992 ${orders[loop.index].tour.departureCity}<br />${orders[loop.index].tour.departureDate}
												</td>
												<td>${orders[loop.index].tour.price}$<c:choose>
														<c:when test="${orders[loop.index].tour.isHot}">&#128293</c:when>
														<c:otherwise></c:otherwise>
													</c:choose><br />${orders[loop.index].discount} %
												</td>
												<td>${orders[loop.index].user.name}<br />${orders[loop.index].user.secondName}<br />${orders[loop.index].user.email}</td>
												<td>${orders[loop.index].status}<br /> <c:choose>
														<c:when test="${orders[loop.index].status=='REGISTERED'}">
															<a
																href="Controller?com=update&update=setPayed&order=${orders[loop.index].id}"
																class="ico edit">Оплачен</a>
															<br />
															<a
																href="Controller?com=update&update=setCanceled&order=${orders[loop.index].id}"
																class="ico edit">Отменить</a>
														</c:when>
														<c:when test="${orders[loop.index].status=='PAYED'}">
															<a
																href="Controller?com=update&update=setCanceled&order=${orders[loop.index].id}"
																class="ico edit">Отменить</a>
														</c:when>
														<c:otherwise></c:otherwise>
													</c:choose>
												</td>
												<td><c:choose>
														<c:when test="${orders[loop.index].status!='CANCELED'}">
															<form method="post" action="Controller">
																<input type="hidden" name="com" value="update"></input>
																<input type="hidden" name="update" value="max"></input>
																<input type="hidden" name="order"
																	value="${orders[loop.index].id}"></input> <input
																	type="number" step="any" name="max" required=""></input><br />
																<br /> <input type="submit" value="Макс.Скидка">
																${orders[loop.index].maxDiscount} %
															</form>
														</c:when>
													</c:choose></td>
												<td><c:choose>
														<c:when test="${orders[loop.index].status!='CANCELED'}">
															<form method="post" action="Controller">
																<input type="hidden" name="com" value="update"></input>
																<input type="hidden" name="update" value="step"></input>
																<input type="hidden" name="order"
																	value="${orders[loop.index].id}"></input> <input
																	type="number" step="any" name="step" required=""></input><br />
																<br /> <input type="submit" value="Шаг Скидки">
																${orders[loop.index].discountStep} %
															</form>
														</c:when>
													</c:choose></td>
												<td><c:choose>
														<c:when test="${orders[loop.index].tour.isHot}">
															<a
																href="Controller?com=setHot&set=simple&tour=${orders[loop.index].tour.id}"
																class="ico edit">В Негорящие</a>
															<br />
														</c:when>
														<c:otherwise>
															<a
																href="Controller?com=setHot&set=hot&tour=${orders[loop.index].tour.id}"
																class="ico edit">В Горящие</a>
														</c:otherwise>
													</c:choose></td>
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