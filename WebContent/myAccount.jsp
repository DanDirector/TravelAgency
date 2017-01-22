<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="l" uri="http://nure.ua/SummaryTask4"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://nure.ua/SummaryTask4"%>
<fmt:setLocale value="${currentLocale}" scope="session"/>
<fmt:setBundle basename="resources"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key='Account'/></title>
<link rel="icon" href="images/favicon.ico">
<link rel="shortcut icon" href="images/favicon.ico" />
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/mycss.css">
<link rel="stylesheet" href="css/animate.min.css">
<link rel="stylesheet" href="css/slider.css">
<script src="js/jquery.js"></script>
<script src="js/jquery-migrate-1.1.1.js"></script>
<script src="js/superfish.js"></script>
<script src="js/jquery.equalheights.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/jquery.ui.totop.js"></script>
<script src="js/animate-css.js"></script>
<script src="js/common.js"></script>
<script src="js/waypoints.min.js"></script>
<script src="js/sForm.js"></script>
<script src="js/jquery.jqtransform.js"></script>
<script src="js/tms-0.4.1.js"></script>
<script src="js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="js/jquery.ui.totop.js"></script>
<script>
	$(window).load(function() {
		$('.slider')._TMS({
			show : 0,
			pauseOnHover : false,
			prevBu : '.prev',
			nextBu : '.next',
			playBu : false,
			duration : 800,
			preset : 'random',
			pagination : false,//'.pagination',true,'<ul></ul>'
			pagNums : false,
			slideshow : 8000,
			numStatus : false,
			banners : true,
			waitBannerAnimation : false,
			progressBar : false
		});
		$("#tabs").tabs();

		$().UItoTop({
			easingType : 'easeOutQuart'
		});
	});
</script>
<script>
	$(window).load(function() {
		$().UItoTop({
			easingType : 'easeOutQuart'
		});
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
	<!--==============================header=================================-->
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
				<li><a href="Controller?com=allTours"><fmt:message key='Tours'/></a></li>
				<li class="current"><a href="Controller?com=myAccount"><fmt:message key='Account'/></a>
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
		<input type="hidden" name="page" value="myAccount.jsp">
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
			<div class="acc"><fmt:message key='Welcome'/>, ${user.name} ${user.secondName}</div>
			<h3 style="margin-left: 71px"><fmt:message key='Your_orders'/></h3>




			<div class="shapka">

				<div class="zac">
					<div class="topi"><fmt:message key='Country_Region'/></div>
					<div class="topi"><fmt:message key='Hotel_Nutrition'/></div>
					<div class="topi"><fmt:message key='Rating_Nights'/></div>
					<div class="topi"><fmt:message key='Departure_from'/></div>
					<div class="topi"><fmt:message key='Price_Discount'/></div>
					<div class="topi"><fmt:message key='Status'/></div>
				</div>
			</div>
			<c:choose>
				<c:when test="${orderList!=null&&fn:length(orderList)>0}">
					<c:forEach begin="0" end="${fn:length(orderList)-1}"
						varStatus="loop">
						<div class="zac">
							<div class="zitem">
								<div class="zdown">${orderList[loop.index].tour.hotel.country}<br />
									${orderList[loop.index].tour.hotel.city}
								</div>
							</div>
							<div class="zitem">
								<div class="zdown">
									"${orderList[loop.index].tour.hotel.name}" <br />
									${orderList[loop.index].tour.hotel.nut}
								</div>
							</div>
							<div class="zitem">
								<div class="zdown">${orderList[loop.index].tour.hotel.rate}
									★ <br /> ${orderList[loop.index].tour.nights} nights
								</div>
							</div>
							<div class="zitem">
								<div class="zdown">&#9992
									${orderList[loop.index].tour.departureCity}</div>
							</div>
							<div class="zitem">
								<div class="zdown">${orderList[loop.index].tour.price}
									$ <br />${orderList[loop.index].discount} %
								</div>
							</div>
							<div class="zitem">
								<div class="zdown"><fmt:message key='${orderList[loop.index].status}'/></div>
							</div>
						</div>
						<br class="clear">
					</c:forEach>
				</c:when>
				<c:otherwise></c:otherwise>
			</c:choose>
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