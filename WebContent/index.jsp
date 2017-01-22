<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://nure.ua/SummaryTask4"%>
<fmt:setLocale value="${currentLocale}" scope="session"/>
<fmt:setBundle basename="resources"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key='Home'/></title>
<link rel="icon" href="images/favicon.ico">
<link rel="shortcut icon" href="images/favicon.ico" />
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/mycss.css">
<link rel="stylesheet" href="css/slider.css">
<script src="js/jquery.js"></script>
<script src="js/jquery-migrate-1.1.1.js"></script>
<script src="js/superfish.js"></script>
<script src="js/sForm.js"></script>
<script src="js/jquery.jqtransform.js"></script>
<script src="js/jquery.equalheights.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
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
	$(document).on("submit", "#myform", function(event){
		var $form = $(this);
		$.post($form.attr("action"), $form.serialize(), function(response){
			$("#otvet").text(response);
		});
		event.preventDefault();
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
<body class="page1">
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
				<li class="current"><a href="index.jsp"><fmt:message key="Home"/></a></li>
				<li><a href="index-1.jsp"><fmt:message key='About'/></a> </li>
				<li><a href="index-2.jsp"><fmt:message key='Gallery'/></a></li>
				<li><a href="Controller?com=allTours"><fmt:message key='Tours'/></a></li>
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
		<input type="hidden" name="page" value="index.jsp">
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
		<div class="container_12">
			<div class="grid_12">
				<div class="slider-relative">
					<div class="slider-block">
						<div class="slider">
							<a href="#" class="prev"></a><a href="#" class="next"></a>
							<ul class="items">
								<li><img src="images/slide.jpg" alt="">
									<div class="banner">
										<div><fmt:message key='planty_places'/></div>
										<br> <span><fmt:message key='worth_seeing'/></span>
									</div></li>
								<li><img src="images/slide1.jpg" alt=""></li>
								<li><img src="images/slide2.jpg" alt=""></li>
								<li><img src="images/slide3.jpg" alt=""></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!--=======content================================-->

		<div class="content">
			<div class="ic"></div>
			<div class="container_12">
				<div class="grid_12">
					<h3><fmt:message key='Top_Destinations'/></h3>
				</div>
				<div class="boxes">
					<div class="grid_4">
						<figure>
						<div>
							<img src="images/page1_img1.jpg" alt="">
						</div>
						<figcaption>
						<h3><fmt:message key='Египет'/></h3>
						<fmt:message key='EgyptHome'/>
						<a href="Controller?com=Countries&country=Египет" class="btn"><fmt:message key='Tours'/></a> </figcaption> </figure>
					</div>
					<div class="grid_4">
						<figure>
						<div>
							<img src="images/page1_img2.jpg" alt="">
						</div>
						<figcaption>
						<h3><fmt:message key='Греция'/></h3>
						<fmt:message key='GreeceHome'/>
					    <a href="Controller?com=Countries&country=Греция" class="btn"><fmt:message key='Tours'/></a>

						</figcaption> </figure>
					</div>
					<div class="grid_4">
						<figure>
						<div>
							<img src="images/page1_img3.jpg" alt="">
						</div>
						<figcaption>
						<h3><fmt:message key='ОАЭ'/></h3>
						<fmt:message key='UAEHome'/>
						<a href="Controller?com=Countries&country=ОАЭ" class="btn"><fmt:message key='Tours'/></a> </figcaption> </figure>
					</div>
					<div class="clear"></div>
				</div>
				<div class="grid_8">
					<div id="tabs">
						<ul>
							<li><a href="#tabs-1"><fmt:message key='Insurance'/></a></li>
							<li><a href="#tabs-2"><fmt:message key='h2'/></a></li>
							<li><a href="#tabs-3"><fmt:message key='h3'/></a></li>
						</ul>
						<div class="clear"></div>
						<div class="tab_cont" id="tabs-1">
							<img src="images/page1_img4.jpg" alt="">
							<div class="extra_wrapper">
							<fmt:message key='Insur'/>
								<div class="clear "></div>

							</div>
							
						</div>
						<div class="tab_cont" id="tabs-2">
							<img src="images/page1_img4_1.jpg" alt="">
							<div class="extra_wrapper">
								<div class="text1"><fmt:message key='Bingo'/></div>
								<p class="style1"><fmt:message key='Fortuna'/>
								<div class="clear "></div>

							</div>
							<div class="clear cl1"></div>
							
							
						</div>
						<div class="tab_cont" id="tabs-3">

							<img src="images/page1_img5.jpg" alt="">
							<div class="extra_wrapper">
								<div class="text1"><fmt:message key='Rasro'/></div>
								<p class="style1"> <fmt:message key='Rasr'/>
								<div class="clear "></div>

							</div>
							<div class="clear cl1"></div>
													
						</div>
					</div>
				</div>

				<!-- <div class="grid_4">
					<div class="newsletter_title"><fmt:message key='NewsLetter'/></div>
					<div class="n_container">
						<form id="newsletter" action="Controller" method="post">
						<input type="hidden" name="com" value="subscribe"/>
							<div class="text1"><fmt:message key='Sign_up'/></div>
							 <input name="email" type="email"
								placeholder="email address"> 
						        <br/><br/><br/>
							<div class="clear"></div>
							<input type="submit" value="Subscribe">
							<c:choose>
							 <c:when test="${success!=null}">
							  <div class="text1" style="color: #53acd6;">
							    <fmt:message key=' ${success}'/>
							  </div>
							 </c:when>
							 <c:otherwise></c:otherwise>
							</c:choose>
						</form>
						
					</div>
				</div> -->


				<div class="grid_4">
					<div class="newsletter_title"><fmt:message key='NewsLetter'/></div>
					<div class="n_container">
						<form id="myform" action="Controller" method="post">
						<input type="hidden" name="com" value="subscribe"/>
							<div class="text1"><fmt:message key='Sign_up'/></div>
							 <input name="email" type="email"
								placeholder="email address"> 
						        <br/><br/><br/>
							<div class="clear"></div>
							<input type="submit" value="Subscribe">
							<div class="text1" style="color: #53acd6;">
							  	<div id="otvet"></div>
							 </div>
						</form>
					</div>
				</div>
				<!-- <form id="myform" action="Controller" method="post">
					<input type="hidden" name="com" value="subscribe"/>
					<input type="text" name="email"/>
					<input type="submit" value="ok">
				</form>
				<div id="otvet"></div> -->
				<div class="clear"></div>
			</div>
		</div>
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
<c:set var="success" value="${null}" scope="session"/>
</body>
</html>