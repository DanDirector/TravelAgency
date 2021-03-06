<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://nure.ua/SummaryTask4"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<fmt:setLocale value="${currentLocale}"/>
<fmt:setBundle basename="resources"/>
<jsp:useBean id="date" class="java.util.Date" />
<fmt:formatDate pattern="yyyy-MM-dd" value="${date}" var="currDate" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key='Tours'/></title>
<link rel="icon" href="images/favicon.ico">
<link rel="shortcut icon" href="images/favicon.ico" />
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/mycss.css">
<script src="js/jquery.js"></script>
<script src="js/jquery-migrate-1.1.1.js"></script>
<script src="js/superfish.js"></script>
<script src="js/jquery.jqtransform.js"></script>
<script src="js/jquery.equalheights.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/jquery.ui.totop.js"></script>
<script>
	$(window).load(function() {
		$().UItoTop({
			easingType : 'easeOutQuart'
		});
	});

	$(function() {
		//find all form with class jqtransform and apply the plugin
		$(".form1").jqTransform();
	});
</script>
<!--[if lt IE 8]>
       <div style=' clear: both; text-align:center; position: relative;'>
         <a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
           <img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
         </a>
      </div>
    <![endif]-->
<!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <link rel="stylesheet" media="screen" href="css/ie.css">

    <![endif]-->


</head>
<body class="">

	<header>
	<div class="container_12">
		<div class="grid_12">
			<h1>
				<a href="index.jsp"><img src="images/logo.png"
					alt="Gerald Harris attorney at law"></a>
			</h1>


			<div class="clear"></div>
		</div>
		<div class="menu_block">
			<nav class="">
			<ul class="sf-menu">
				<li><a href="index.jsp"><fmt:message key='Home'/></a></li>
				<li><a href="index-1.jsp"><fmt:message key='About'/></a></li>
				<li><a href="index-2.jsp"><fmt:message key='Gallery'/></a></li>
				<li class="current"><a href="Controller?com=allTours"><fmt:message key='Tours'/></a></li>
				<li><a href="Controller?com=myAccount"><fmt:message key='Account'/></a>
					<ul>
						<c:choose>
							<c:when test="${user==null}">
								<li><a href="login.jsp"><fmt:message key='Login'/></a></li>
								<li><a href="register.jsp"><fmt:message key='Register'/></a></li>
							</c:when>
							<c:otherwise>
								<li><a href="Controller?com=logOut"><fmt:message key='Log_out'/></a></li>
							</c:otherwise>
						</c:choose>
					</ul></li>
				<li><a href="index-5.jsp"><fmt:message key='Contacts'/></a></li>
			</ul>
			</nav>
			<div class="clear"></div>
		</div>
		<div class="clear"></div>
	</div>
	</header>
    <div class="lng">
		<form action="changeLocale.jsp" method="post">
		<input type="hidden" name="page" value="tours.jsp">
			<select name="locale">
				<c:forEach items="${applicationScope.locales}" var="locale">
					<c:set var="selected"
						value="${locale.key == currentLocale ? 'selected' : '' }" />
					<option value="${locale.key}" ${selected}>${locale.value}</option>
				</c:forEach>
			</select> <input class="lnginput" type="submit"
				value="<fmt:message key='Save'/>">

		</form>
	</div>
	<div class="main">
		<!--=======content================================-->

		<div class="content">
			<div class="ic"></div>
			<div class="container_12">
				<div class="grid_9">
					<h3><fmt:message key='All'/> <fmt:message key='Tours'/></h3>
					<div class="tours">
						<c:choose>
							<c:when test="${simpleTours==null||hotTours==null}">
								<c:redirect url="Controller?com=allTours" />
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${fn:length(simpleTours)==0}">
										<c:set var="si" value="0" scope="session" />
									</c:when>
									<c:otherwise>
										<c:set var="si" value="1" scope="session" />
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${fn:length(hotTours)==0}">
										<c:set var="hi" value="0" scope="session" />
									</c:when>
									<c:otherwise>
										<c:set var="hi" value="1" scope="session" />
									</c:otherwise>
								</c:choose>
								<c:forEach begin="0" end="${fn:length(hotTours)-hi}"
									varStatus="loop">
									<c:choose>
										<c:when test="${fn:length(hotTours)==0}">
										</c:when>
										<c:otherwise>
											<c:choose>
												<c:when test="${loop.index%2==0}">
													<div class="grid_4 alpha">
														<div class="tour">
															<img src="${hotTours[loop.index].imagePath}" alt=""
																class="img_inner fleft">
															<div class="extra_wrapper">
																<p class="text1">${hotTours[loop.index].hotel.country}</p>
																<p class="price">
																	<span>${hotTours[loop.index].price} $ <strong
																		class="hot">&#128293</strong></span>
																</p>
																<p class="text1">
																	<span class="goldstar">  
																	<c:forEach begin="0" end="${hotTours[loop.index].hotel.rate-1}" >
																	★
																	</c:forEach>
																	</span>
																</p>

																<p class="text1">
																	<fmt:formatDate pattern="dd-MM-yyyy"
																		value="${hotTours[loop.index].departureDate}" />
																</p>
																<p class="text1">${hotTours[loop.index].personCount}
																	&#128107

																</p>
																<a href="details.jsp?tourId=${hotTours[loop.index].id}"	class="btn">
																	<fmt:message key='Details'/></a>

															</div>
														</div>
													</div>
												</c:when>
												<c:otherwise>
													<div class="grid_4 omega">
														<div class="tour">
															<img src="${hotTours[loop.index].imagePath}" alt=""
																class="img_inner fleft">
															<div class="extra_wrapper">
																<p class="text1">${hotTours[loop.index].hotel.country}</p>
																<p class="price">
																	<span>${hotTours[loop.index].price} $ <strong
																		class="hot">&#128293</strong></span>
																</p>
																<p class="text1">
																	<span class="goldstar"><c:forEach begin="0" end="${hotTours[loop.index].hotel.rate-1}" >
																	★
																	</c:forEach></span>
																</p>
																<p class="text1">
																	<fmt:formatDate pattern="dd-MM-yyyy"
																		value="${hotTours[loop.index].departureDate}" />
																</p>
																<p class="text1">${hotTours[loop.index].personCount}
																	&#128107
																</p>
																<a
																		href="details.jsp?&tourId=${hotTours[loop.index].id}"
																		class="btn"><fmt:message key='Details'/></a>

															</div>
														</div>
													</div>
													<div class="clear"></div>
												</c:otherwise>
											</c:choose>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<div class="clear"></div>
								<c:forEach begin="0" end="${fn:length(simpleTours)-si}"
									varStatus="loop">
									<c:choose>
										<c:when test="${fn:length(simpleTours)==0}">
										</c:when>
										<c:otherwise>
											<c:choose>
												<c:when test="${loop.index%2==0}">
													<div class="grid_4 alpha">
														<div class="tour">
															<img src="${simpleTours[loop.index].imagePath}" alt=""
																class="img_inner fleft">
															<div class="extra_wrapper">
																<p class="text1">${simpleTours[loop.index].hotel.country}</p>
																<p class="price">
																	<span>${simpleTours[loop.index].price} $ </span>
																</p>
																<p class="text1">
																	<span class="goldstar"><c:forEach begin="0" end="${simpleTours[loop.index].hotel.rate-1}" >
																	★
																	</c:forEach></span>
																</p>
																<p class="text1">
																	<fmt:formatDate pattern="dd-MM-yyyy"
																		value="${simpleTours[loop.index].departureDate}" />
																</p>
																<p class="text1">${simpleTours[loop.index].personCount}
																	&#128107 
																</p>
																<a href="details.jsp?com=Details&tourId=${simpleTours[loop.index].id}"
																		class="btn"><fmt:message key='Details'/></a>

															</div>
														</div>
													</div>
												</c:when>
												<c:otherwise>
													<div class="grid_4 omega">
														<div class="tour">
															<img src="${simpleTours[loop.index].imagePath}" alt=""
																class="img_inner fleft">
															<div class="extra_wrapper">
																<p class="text1">${simpleTours[loop.index].hotel.country}</p>
																<p class="price">
																	<span>${simpleTours[loop.index].price} $ </span>
																</p>
																<p class="text1">
																	<span class="goldstar"><c:forEach begin="0" end="${simpleTours[loop.index].hotel.rate-1}" >
																	★
																	</c:forEach></span>
																</p>
																<p class="text1">
																	<fmt:formatDate pattern="dd-MM-yyyy"
																		value="${simpleTours[loop.index].departureDate}" />
																</p>
																<p class="text1">${simpleTours[loop.index].personCount}
																	&#128107 
																</p>
																<a href="details.jsp?com=Details&tourId=${simpleTours[loop.index].id}"
																		class="btn"><fmt:message key='Details'/></a>

															</div>
														</div>
													</div>
													<div class="clear"></div>
												</c:otherwise>
											</c:choose>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</c:otherwise>
						</c:choose>

					</div>
				</div>
				<div class="grid_3">
					<h3><fmt:message key='Browse_Tours'/></h3>
					<form method="post" action="Controller" id="form1" class="form1">
						<input type="hidden" value="Sort" name="com"> <label
							class="mb0"> <span><fmt:message key='Sort_tours_by'/>: </span> <select
							name="select">
								<option value="asc"><fmt:message key='By_prices_ascending'/></option>
								<option value="desc"><fmt:message key='By_prices_descending'/></option>
								<option value="date"><fmt:message key='By_date'/></option>
						</select>
						</label>
						<button class="mybtn" type="submit"><fmt:message key='Sort'/></button>
					</form>
					<h3><fmt:message key='Search'/> <fmt:message key='Tours'/></h3>
					<form method="post" action="Controller" id="form2" class="form1">
						<input type="hidden" name="com" value="Select"> <label>
							<span><span class="col1"><fmt:message key="Choose"/> <fmt:message key="Parameters"/>: </span><br><fmt:message key="Type_of_vacation"/>
								</span>
					   <select name="selectType">
								<option value="%"><fmt:message key="Any"/></option>
								<option value="sum_relax"><fmt:message key="Summer_Vacation"/></option>
								<option value="win_relax"><fmt:message key="Winter_Vacation"/></option>
								<option value="exc"><fmt:message key="Excursion"/></option>
								<option value="shop"><fmt:message key="Shopping"/></option>
						</select>
						</label> <label> <span><fmt:message key="Country"/></span> <select name="selectCountry">
								<option value="%"><fmt:message key="Any"/></option>
								<c:forEach begin="0" end="${fn:length(countries)-1}"
									varStatus="loop">
									<option value="${countries[loop.index]}">${countries[loop.index]}</option>
								</c:forEach>
						</select>
						</label> <label> <span><fmt:message key="Hotel_rating"/></span> <select
							name="selectRate">
								<option value="%"><fmt:message key="Any"/></option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="3">4</option>
								<option value="4">5</option>
						</select>
						</label> 
						<label class="mb0">
							<p class="otstup"><fmt:message key="Departure_date"/><br /></p>
							<fmt:message key="From"/>
							<input class="dat" type="date" name="date" value="${currDate}" required><br/><br/><br/>
						</label>
						<label class="mb0"> <span><fmt:message key="Price"/></span><fmt:message key="From"/>  <input
							type="number" name="from" value="0" required> <fmt:message key="to"/>  <input
							type="number" name="to" value="100000" required> $<br />
						</label>
						<label class="mb0">
							<p class="otstup"><fmt:message key="The_count_of_people"/></p> <input type="number"
							name="people" value="2" required>
						</label>
						<div class="clear"></div>
						<button class="mybtn" type="submit"><fmt:message key="Search"/></button>

						<a href="Controller?com=allTours" class="btn"><fmt:message key="See_all"/></a>

					</form>
				</div>
				<div class="clear"></div>
			</div>
		</div>

		<!--=======bottom================================-->
	<f:b/>
		<!--==============================footer=================================-->

	</div>
	<footer>
	<div class="container_12">
		<div class="grid_12">
			
			<div class="copy">
				Journey &copy; 2016
			</div>
		</div>
		<div class="clear"></div>
	</div>

	</footer>

</body>
</html>