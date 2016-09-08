<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page isELIgnored="false" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1">

<title>Погода в Украине и мире</title>

<!-- Loading third party fonts -->
<link href="http://fonts.googleapis.com/css?family=Roboto:300,400,700|"
	rel="stylesheet" type="text/css">
<link href="/resources/fonts/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- Loading main css file -->
<link rel="stylesheet" href="/resources/css/style.css">

<!--[if lt IE 9]>
		<script src="/weather/resources/js/ie-support/html5.js"></script>
		<script src="/weather/resources/js/ie-support/respond.js"></script>
		<![endif]-->

</head>
<body>
	<div class="site-content">
		<div class="site-header">
			<div class="container">
				<a href='<spring:url value="/"></spring:url>' class="branding">
					<div class="logo-type">
						<h1 class="site-title">Актуальная погода в любой точке мира</h1> 
						
						<small class="site-description"><h3>Погода в городе ${nearestArea.getAreaName()} область ${nearestArea.getRegion()} страна ${nearestArea.getCountry()} </h3></small>
					</div>
				</a>
				<!-- Default snippet for navigation -->
				<div class="main-navigation">
					<button type="button" class="menu-toggle">
						<i class="fa fa-bars"></i>
					</button>
					<ul class="menu">
						<!-- <li class="menu-item current-menu-item"><a href="index.html">Home</a></li>
						<li class="menu-item"><a href="news.html">News</a></li>
						<li class="menu-item"><a href="live-cameras.html">Live
								cameras</a></li>
						<li class="menu-item"><a href="photos.html">Photos</a></li>
						<li class="menu-item"><a href="contact.html">Contact</a></li> -->
					</ul>
					<!-- .menu -->
				</div>
				<!-- .main-navigation -->

				<div class="mobile-navigation"></div>

			</div>
		</div>
		<!-- .site-header -->

		<div class="hero" data-bg-image="/resources/images/banner.png">
			<div class="container">
				<%-- 	<form:form  class="find-location" method="get" modelAttribute="location">
			<form:input path="location" type="text" />
			<input type="submit" value="Find">
			</form:form>  --%>
				<form name="form1"
					action='<spring:url value="location"></spring:url>'
					class="find-location" method="get" id="searchForm">
					<input type="text" placeholder="Введите свой город ... "
						name="city" id="searchInput">  <input type="submit" value="Найти"
						> 
				</form>

			</div>
		</div>
		<div class="forecast-table">
			<div class="container">
				<div class="forecast-container">
					<div class="today forecast">
						<div class="forecast-header">
							<div class="day">${day}</div>
							<div class="date">${localtime}</div>
						</div>
						<!-- .forecast-header -->
						<div class="forecast-content">
							<div class="location">${location}</div>
							<div class="degree">
								<div class="num">

									${currentTemperature}<sup>o</sup>C
								</div>
								<div class="forecast-icon">
									<img src="${icon}" alt="" width=90>
								</div>
							</div>
							<span><img src="/resources/images/humidity.png"
								alt="" width="50" height="50">${humidity} %</span> <span><img
								src="/resources/images/wind.png" alt="" width="50"
								height="50">${wind} km/h</span> <span><img
								src="/resources/images/visibility.png" alt="" width="50"
								height="50">${visibility}</span>
						</div>
					</div>
					<c:forEach items="${weather}" var="weather">
					<div class="forecast">
						<div class="forecast-header">
							<div class="day">${weather.getDay()}<p>  ${weather.getDate()}</p></div>
						</div>
					
						<!-- .forecast-header -->
						<div class="forecast-content">
						
						Макс
							<div class="degree">
							
								${weather.getMaxtempC()}<sup>o</sup>C
							</div>
							<br>Мин<br>
							<small>${weather.getMintempC()}<sup>o</sup>C</small>
							<p>	<a href='<spring:url value="/detail/${weather.getDate()}"></spring:url>'>Подробнее</a></p>
						</div>
					</div></c:forEach>
				</div>
			</div>
		</div>
		<main class="main-content">
		<div class="fullwidth-block">
			<div class="container">
				<div class="row"><a href='<spring:url value="/byip"></spring:url>'>Найти по IP</a></div>
			</div>
		</div>
		</main>
		<!-- .main-content -->
		<script type="text/javascript">
			function allLetter(inputtxt) {
				var letters = /^[A-Za-z]+$/;
				if (inputtxt.value.match(letters)) {
					document.form1.submit();
					return true;
				} else {
					alert('Введите название кирилицей. Напрамер: London, Tokio');
					return false;
				}
			}
			(function() {
				var form = document.querySelector('#searchForm');
				var searchInput = document.querySelector('#searchInput');
				
				form.addEventListener('submit', function(event) {
					var letters = /^[A-Za-z]+$/;
					/* if (inputtxt.value.match(letters)) {
						return true;
					} else {
						alert('Введите название кирилицей. Напрамер: London, Tokio');
						return false;
					} */
					if (!searchInput.value.match(letters)) {
						alert('Введите название кирилицей. Напрамер: London, Tokio, Moscow. Или найдите погоду по своему IP (кнопка внизу страницы)');
						event.preventDefault();
					}
				});
			})();
		</script>

		<!-- .site-footer -->
	</div>

	<script src="/resources/js/jquery-1.11.1.min.js"></script>
	<script src="/resources/js/plugins.js"></script>
	<script src="/resources/js/app.js"></script>

</body>

</html>