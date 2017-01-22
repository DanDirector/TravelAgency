<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://nure.ua/SummaryTask4"%>
<fmt:setLocale value="${currentLocale}" scope="session"/>
<fmt:setBundle basename="resources"/>
<!DOCTYPE html>
<html lang="en">
<head>
<title><fmt:message key='Login'/></title>
<meta charset="utf-8">
<link rel="icon" href="images/favicon.ico">
<link rel="shortcut icon" href="images/favicon.ico" />
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/form.css">
<link rel="stylesheet" href="css/mycss.css">
<script src="js/jquery.js"></script>
<script src="js/forms.js"></script>
<script src="js/jquery-migrate-1.1.1.js"></script>
<script src="js/superfish.js"></script>
<script src="js/jquery.equalheights.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/jquery.ui.totop.js"></script>
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
		<input type="hidden" name="page" value="login.jsp">
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


				<h3><fmt:message key='Login'/></h3>
				<div class="myForm">
					<form class="myfrm" method="post" action="Controller">
						<input type="hidden" name="com" value="login">
						
						<div class="grid_6">
							<div class="success_wrapper"></div>
							<c:choose>
							<c:when test="${wrong!=null}"><p style="color: chocolate;"><fmt:message key='${wrong}'/></p></c:when>
							</c:choose>
							<fieldset>
								<label class="name"> <input type="text" name="login"
									placeholder="<fmt:message key='LOGIN'/>" required> <br class="clear">

								</label> <label class="name"> <input type="password"
									name="password" placeholder="<fmt:message key='PASSWORD'/>" required> <br
									class="clear">

								</label>

								<div class="clear"></div>
      
							</fieldset>
							<button class="mybtn" type="submit"><fmt:message key='Login'/></button>
							<button class="mybtn" type="reset"><fmt:message key='Clear'/></button>

						</div>
						<div class="grid_6"></div>
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
<c:set var="wrong" value="${null}" scope="session"/>
</body>
</html>