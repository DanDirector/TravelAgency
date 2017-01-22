<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="f" uri="http://nure.ua/SummaryTask4"%>
<jsp:useBean id="date" class="java.util.Date" />
<fmt:formatDate pattern="yyyy-MM-dd" value="${date}" var="currDate" />
<fmt:setLocale value="ru" scope="session"/>
<fmt:setBundle basename="resources"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Админ панель</title>
<link rel="icon" href="images/favicon.ico">
<link rel="shortcut icon" href="images/favicon.ico" />
<link rel="stylesheet" href="cssAdmin/style.css" type="text/css" media="all" />
<!-- <link rel="stylesheet" type="text/css" href="css/mycss.css"> -->
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
					Приветствую, <strong>${user.name} ${user.secondName}</strong> <span>|</span> <span>|</span>
					<a href="Controller?com=logOut">Выйти</a>
				</div>
			</div>

			<div id="navigation">
				<ul>
					<li><a href="Controller?com=manager"><span>Панель менеджера</span></a></li>
					<c:choose>
						<c:when test="${user.role=='ADMIN'}">
							<li><a href="Controller?com=admin" class="active"><span>Админ панель</span></a></li>
							<li><a href="Controller?com=users"><span>
										Управление пользователями </span></a></li>
						</c:when>
					</c:choose>


				</ul>
			</div>
		</div>
	</div>
	<!-- End Header -->

	<!-- Container -->
	<div id="container">
		<div class="shell">

			<br />
			<!-- Main -->
			<div id="main">
				<div class="cl">&nbsp;</div>

				<!-- Content -->
				<div id="content">

					<!-- Box -->
					<div class="box" style="width: 1155px">
						<!-- Box Head -->
						<div class="box-head">
							<h2 class="left">Все туры</h2>
							<div class="right">
								<label>Поиск по ID отеля</label>
								<form action="Controller" method="post">
									<input type="hidden" name="com" class="button" value="admin" />
									<input type="number" class="field small-field" name="hotel" required>
									<input type="submit" class="button" value="Поиск" />
								</form>
								<form action="Controller" method="post">
									<input type="hidden" name="com" class="button" value="admin" />
									<input type="submit" class="button" value="Все туры" />
								</form>
							</div>

						</div>
						<!-- End Box Head -->

						<!-- Table -->
						<div class="table">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<th>Id</th>
									<th>Тип</th>
									<th>Цена</th>
									<th>Человек</th>
									<th>Id отеля</th>
									<th>Дата отправления</th>
									<th>Город отправления</th>
									<th>Ночей</th>
									<th>Статус</th>
									<th>Фото тура</th>
									<th>Управление</th>


								</tr>

								<c:choose>
									<c:when test="${fn:length(tours)>0}">
										<c:forEach begin="0" end="${fn:length(tours)-1}"
											varStatus="loop">
											<tr>
												<td style="text-align: center; width: 29px;">${tours[loop.index].id}</td>
												<td>${tours[loop.index].type}<br />
													<form action="Controller" method="post">
														<input type="hidden" name="com" value="updateTour">
														<input type="hidden" name="tourId"
															value="${tours[loop.index].id}"> <select
															name="selectType">
															<option value="sum_relax">Летний отдых</option>
															<option value="win_relax">Зимний отдых</option>
															<option value="exc">Экскурсия</option>
															<option value="shop">Шоппинг</option>
														</select> <input type="submit" value="Ok">
													</form>
												</td>
												<td>${tours[loop.index].price}$<c:choose>
														<c:when test="${tours[loop.index].isHot}">&#128293</c:when>
														<c:otherwise></c:otherwise>
													</c:choose> <br />
													<form action="Controller" method="post">
														<input type="hidden" name="com" value="updateTour">
														<input type="hidden" name="tourId"
															value="${tours[loop.index].id}"> <input
															type="number" step="any" name="editPrice"
															style="width: 60px"> <input type="submit"
															value="Ok">
													</form>
												</td>
												<td>${tours[loop.index].personCount}&#128107<br />
													<form action="Controller" method="post">
														<input type="hidden" name="com" value="updateTour">
														<input type="hidden" name="tourId"
															value="${tours[loop.index].id}"> <input
															type="number" name="editPersonCount" style="width: 50px">
														<input type="submit" value="Ok">
													</form>
												</td>
												<td>${tours[loop.index].hotel.id}<br />
													<form action="Controller" method="post">
														<input type="hidden" name="com" value="updateTour">
														<input type="hidden" name="tourId"
															value="${tours[loop.index].id}"> <input
															type="number" name="editHotel" style="width: 50px">
														<input type="submit" value="Ok">
													</form>
												</td>
												<td><br />
													<form action="Controller" method="post">
														<input type="hidden" name="com" value="updateTour">
														<input type="hidden" name="tourId"
															value="${tours[loop.index].id}"> <input
															class="dat" type="date" name="editDate"
															value="${tours[loop.index].departureDate}"
															style="width: 118px" required> <input
															type="submit" value="Ok">
													</form></td>

												<td>${tours[loop.index].departureCity}<br />
													<form action="Controller" method="post">
														<input type="hidden" name="com" value="updateTour">
														<input type="hidden" name="tourId"
															value="${tours[loop.index].id}"> <input
															style="width: 80px" type="text" name="editCity"
															accept-charset="utf-8"> <input type="submit"
															value="Ok">
													</form>
												</td>
												<td>${tours[loop.index].nights}<br />
													<form action="Controller" method="post">
														<input type="hidden" name="com" value="updateTour">
														<input type="hidden" name="tourId"
															value="${tours[loop.index].id}"> <input
															style="width: 40px" type="number" name="editNights"> 
															<input type="submit" value="ОК">
													</form>
												</td>
												<td style="width: 76px"><c:choose>
														<c:when test="${tours[loop.index].isHot}">
															<a
																href="Controller?page=adminPanel.jsp&com=setHot&set=simple&tour=${tours[loop.index].id}"
																class="ico edit" style="margin-left: -16px;">Снять с горящих</a>

														</c:when>
														<c:otherwise>
															<a
																href="Controller?page=adminPanel.jsp&com=setHot&set=hot&tour=${tours[loop.index].id}"
																class="ico edit" style="margin-left: -16px;">В горящие</a>
														</c:otherwise>
													</c:choose></td>
													<td>					
													<form action="AddFilesServlet" method="post"
														name="sendform" enctype="multipart/form-data">
														<input type="hidden" name="path" value="images/tour_im/"> 
														<input type="hidden" name="id" value="${tours[loop.index].id}"> 
														Фото для отправки:<input type="File" name="file_send">
														 <input type="submit" value="Ok">
													</form>
													 </td>
												<td><a
													href="Controller?com=deleteTour&tourId=${tours[loop.index].id}"
													class="ico del">Удалить</a></td>
											</tr>
										</c:forEach>

									</c:when>
									<c:otherwise></c:otherwise>
								</c:choose>

							</table>


						</div>


						<!-- Pagging -->
						<div class="pagging">

							<div class="right">
								<a href="Controller?com=previousPage&page=toursPage&o=tours">Назад</a>
								<a href="Controller?com=nextPage&page=toursPage&o=tours">Вперед</a>
								<a href="Controller?com=admin">В начало</a>
							</div>
						</div>
						<!-- End Pagging -->

					</div>
					<!-- Table -->


					<!-- End Box -->

					<!-- Box -->

					<!-- End Box -->
				</div>
			</div>
			<!-- End Content -->

			<!-- Sidebar -->
			<div id="sidebar" style="margin-right: 75px;">

				<!-- Box -->
				<div class="box" style="width: 296px">

					<!-- Box Head -->
					<div class="box-head">
						<h2>Поиск туров</h2>
					</div>
					<!-- End Box Head-->

					<div class="box-content">
						<a href="javascript:PopUpShow()" class="add-button"><span>Новый тур</span></a>
						<div class="cl">&nbsp;</div>


						<!-- Sort -->
						<div class="sort">
							<label>Выбрать по</label>
							<form method="post" action="Controller">
								<input type="hidden" name="com" value="admin"> <input
									type="hidden" name="select" value="select"> <label>
									<span><br>Тип отдыха</span> <select class="sb"
									name="selectType">
										<option value="%">Любой</option>
										<option value="sum_relax">Летний</option>
										<option value="win_relax">Зимний</option>
										<option value="exc">Экскурсия</option>
										<option value="shop">Шопиинг</option>
								</select>

								</label> </br> <label> <span>Страна</span> <select class="sb"
									name="selectCountry">
										<option value="%">Любая</option>
										<c:forEach begin="0" end="${fn:length(countries)-1}"
											varStatus="loop">
											<option value="${countries[loop.index]}">${countries[loop.index]}</option>
										</c:forEach>
								</select>
								</label> </br> <label> <span>Рейтинг отеля</span> <select class="sb"
									name="selectRate">
										<option value="%">Любой</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="3">4</option>
										<option value="4">5</option>
								</select>
								</label> </br> <label class="mb0">
									<p class="otstup">
										Отправление из <input style="float: right; width: 120px"
											class="dat" type="date" name="date" value="${currDate}"
											required>
									</p> <br /> <br />

								</label> <label class="mb0"> <span>Цена</span> от <input
									style="width: 91px" type="number" name="from" value="0"
									required> до <input style="width: 91px" type="number"
									name="to" value="100000" required> <br />
								</label> <br> <label class="mb0">
									<p class="otstup">
										Число человек<input style="float: right; width: 50px"
											type="number" name="people" value="2" required>
									</p>
								</label> <br> <br>
								<div class="clear"></div>
								<button style="padding: 5px; margin-right: 10px;" class="mybtn"
									type="submit">Поиск</button>

								<a href="Controller?com=admin" class="btn">Сбросить</a>

							</form>
						</div>
						<!-- End Sort -->

					</div>
				</div>
				<!-- End Box -->
			</div>
			<!-- End Sidebar -->

			<div class="cl">&nbsp;</div>
		</div>
		<!-- Main -->
	</div>
	<div id="container"
		style="width: 750px; margin-left: 14px; float: left; padding-top: 0px;">
		<div class="shell2">






			<!-- Main -->
			<div id="main">
				<div class="cl">&nbsp;</div>

				<!-- Content -->
				<div id="content">

					<!-- Box -->
					<div class="box2">
						<!-- Box Head -->
						<div class="box-head">
							<h2 class="left">Все отели</h2>
							<div class="right">
								<label>Поиск по стране</label>
								<form action="Controller" method="post">
									<input type="hidden" name="com" class="button"
										value="searchHotels" /> <input type="text"
										class="field small-field" name="country" /> <input
										type="submit" class="button" value="Поиск" />
								</form>
								<form action="Controller" method="post">
									<input type="hidden" name="com" class="button" value="admin" />
									<input type="submit" class="button" value="Сбросить" />
								</form>
							</div>
						</div>
						<!-- End Box Head -->

						<!-- Table -->
						<div class="table" >
							<table style="width:500px" width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<th>Id отеля</th>
									<th>Название</th>
									<th>Рейтинг</th>
									<th>Питание</th>
									<th>Страна/ Регион</th>
									<th>Путь к  фото</th>
									<th>Добавить фото</th>
									<th>Удалить отель</th>
								</tr>

								<c:choose>
									<c:when test="${fn:length(hotels)>0}">
										<c:forEach begin="0" end="${fn:length(hotels)-1}"
											varStatus="loop">
											<tr>
												<td>${hotels[loop.index].id}</td>
												<td>${hotels[loop.index].name}</td>
												<td>${hotels[loop.index].rate}</td>
												<td>${hotels[loop.index].nut}</td>
												<td>${hotels[loop.index].country}<br />${hotels[loop.index].city}</td>
												<td>${hotels[loop.index].photosPath}</td>
												<td>
													<form action="AddFilesServlet" method="post"
														name="sendform" enctype="multipart/form-data">

														<input type="hidden" name="path"
															value="${hotels[loop.index].photosPath}"> Фото  для отправки:<input type="File" name="file_send"> <input
															type="submit" value="Send">
													</form>
												</td>
												<td><a
													href="Controller?com=deleteHotel&id=${hotels[loop.index].id}"
													class="ico del">Удалить</a></td>
											</tr>
										</c:forEach>

									</c:when>

								</c:choose>

							</table>


						</div>




					</div>
					<!-- Table -->


					<!-- End Box -->

					<!-- Box -->

					<!-- End Box -->
				</div>
			</div>
			<!-- End Content -->

			<!-- Sidebar -->
			<div id="sidebar"></div>
			<!-- End Sidebar -->

			<div class="cl">&nbsp;</div>
		</div>
		<!-- Main -->
	</div>
	<div class="box" style="float: right;    width: 617px;    margin-right: 13px;">
		<!-- Box Head -->
		<div class="box-head">
			<h2>Добавить новый отель</h2>
		</div>
		<!-- End Box Head -->

		<form action="Controller" method="post">
			<input type="hidden" name="com" value="newHotel" />
			<!-- Form -->
			<div class="form">
				<p>
					<label> Название отеля </label> <input type="text"
						class="field size4" name="name" />
				</p>
				<p class="inline-field">

					<label>Рейтинг Питание</label> <select class="field size2"
						name="rate">
						<option value="2">2 ★</option>
						<option value="3">3 ★</option>
						<option value="4">4 ★</option>
						<option value="5">5 ★</option>
					</select> <select class="field size3" name="nut">
						<option value="BB">BB</option>
						<option value="AL">AL</option>
						<option value="HB">HB</option>
						<option value="FB">FB</option>
						<option value="UALL">UALL</option>
					</select> <input type="text" name="country" value="Страна" /> <input
						type="text" name="city" value="Город" />
				</p>

				<p>
					<label>Описание</label>
					<textarea class="field size4" rows="10" cols="30" name="desc"></textarea>
				</p>

			</div>
			<!-- End Form -->

			<!-- Form Buttons -->
			<div class="buttons">
				<input type="submit" class="button" value="Добавить" />
			</div>
			<!-- End Form Buttons -->
		</form>
	</div>
	<div id="popup">
		<div class="popupcontent">
			<form action="Controller" method="post">
				<input type="hidden" name="com" value="newTour">
				<input type="hidden" name="path" value="images/tour_im/"> 
				<div class="popupitem">
					<div class="popupitemleft">
				        Тип отдыха:
				    </div>
				    <div class="popupitemright">
				    	<select  name="selectType">
				    		<option value="sum_relax">Summer Vacation</option>
				    		<option value="win_relax">Winter Vacation</option>
				    		<option value="exc">Excursion</option>
				    		<option value="shop">Shopping</option>
				    	</select></br>
				    </div>
				</div>
				<div class="popupitem">
					<div class="popupitemleft">
				        Цена:
				    </div>
				    <div class="popupitemright">
					    <input type="number" step="any" name="price" required></br>
					</div>
				</div>
				<div class="popupitem">  
					<div class="popupitemleft">
				        Число человек:
					</div>
					<div class="popupitemright">
					    <input type="number" name="people" required></br>
					</div>
				</div>
				<div class="popupitem">  
					<div class="popupitemleft">
				         ID отеля:
					</div>
					<div class="popupitemright">
					    <input type="number" name="hotelId" required></br>
					</div>
				</div>
				<div class="popupitem">  
					<div class="popupitemleft">
				        Дата отправления:
					</div>
					<div class="popupitemright">
					    <input type="date" name="date" value="${currDate}"  required></br>
					</div>
				</div>
				<div class="popupitem">  
					<div class="popupitemleft">
				        Ночей:
				    </div>
				    <div class="popupitemright">
					    <input type="number" name="nights" required></br>
					</div>
				</div>
				<div class="popupitem">
					<div class="popupitemleft">
				        Город отправления:
					</div>
					<div class="popupitemright">
					    <input type="text" name="depCity" required></br>
					</div>
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
				
			</form>
		</div>
	</div>
	
	<!-- End Container -->


</body>
</html>