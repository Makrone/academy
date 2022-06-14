<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ЗДАРОВА</title>
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/css/general.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/css/timeline.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/css/slider.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/css/registration.css" />
</head>
<body>

	<div id="carouselExampleSlidesOnly" class="carousel slide"
		data-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img class="d-block w-100"
					src="${pageContext.request.contextPath}/img/bg1.jpg"
					alt="First slide">
				<div class="carousel-caption d-none d-md-block">
					<h1>Выбери что хочешь сделать</h1>

					<div class="bform py-5" role="group" aria-label="Basic example">
						<form action="../servlet/createServlet" method="GET">
							<button class="btn btn-outline-primary btn-sm" type="submit">Создать</button>
						</form>
						<button
							class="btn btn-block btn-danger-gradiant text-white border-0"
							type="submit">Удалить</button>
						<button
							class="btn btn-block btn-danger-gradiant text-white border-0"
							type="submit">Обновить</button>
						<button
							class="btn btn-block btn-danger-gradiant text-white border-0"
							type="submit">Изменить</button>
						<button
							class="btn btn-block btn-danger-gradiant text-white border-0"
							type="submit">Показать все в базе</button>
					</div>
				</div>
			</div>
		</div>
</body>
</html>


