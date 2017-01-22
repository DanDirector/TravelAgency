<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="f" uri="http://nure.ua/SummaryTask4"%>
<fmt:setLocale value="${currentLocale}" scope="session" />
<fmt:setBundle basename="resources" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title><fmt:message key='Contacts' /></title>
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
        <a href="index.jsp"><img src="images/logo.png" alt=""></a>
      </h1>


      <div class="clear"></div>
    </div>
    <div class="menu_block">
      <nav class="">
      <ul class="sf-menu">
        <li><a href="index.jsp"><fmt:message key="Home" /></a></li>
        <li><a href="index-1.jsp"><fmt:message
              key='About' /></a></li>
        <li><a href="index-2.jsp"><fmt:message key='Gallery' /></a></li>
        <li><a href="Controller?com=allTours"><fmt:message
              key='Tours' /></a></li>
        <li><a href="Controller?com=myAccount"><fmt:message
              key='Account' /></a>
          <ul>

            <c:choose>
              <c:when test="${user==null}">
                <li><a href="login.jsp"><fmt:message key='Login' /></a></li>
                <li><a href="register.jsp"><fmt:message key='Register' /></a></li>
              </c:when>
              <c:otherwise>
                <li><a href="Controller?com=logOut"><fmt:message
                      key='Log_out' /></a></li>
              </c:otherwise>
            </c:choose>
          </ul></li>
        <li class="current"><a href="index-5.jsp"><fmt:message key='Contacts' /></a></li>
      </ul>
      </nav>
      <div class="clear"></div>
    </div>
    <div class="clear"></div>
  </div>
  </header>
   <div class="lng">
    <form action="changeLocale.jsp" method="post">
    <input type="hidden" name="page" value="index-5.jsp">
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
					<h3><fmt:message key='Contacts'/></h3>
					<div class="map">
						<figure class="img_inner fleft"> <script
							type="text/javascript" charset="utf-8" async
							src="https://api-maps.yandex.ru/services/constructor/1.0/js/?sid=6S7bkTxfShZB6zNAdLV6hwiH-aBnQk4p&amp;width=700&amp;height=349&amp;lang=ru_RU&amp;sourceType=constructor&amp;scroll=true"></script>
						</figure>
						
						
					</div>
				</div>
				<div class="grid_3">
					<address style=" margin-top: 91px">
							<dl>
								<dt>
									<fmt:message key='str'/>, 30<br> <fmt:message key='Kh'/>, 61052.
								</dt>
								<dd>
									<span><fmt:message key='tel'/>:</span>+3 8093 475 6373
								</dd>
								<dd>
									<span><fmt:message key='tel'/>:</span>+3 8099 603 6035
								</dd>
								<dd>
									<span>FAX:</span>+3 8097 889 9898
								</dd>
								<dd>
									E-mail: <a href="#" class="link-1">mail@journey.org</a>
								</dd>
							</dl>
						</address>
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