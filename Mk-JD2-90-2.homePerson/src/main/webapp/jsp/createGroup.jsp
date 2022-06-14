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
					<h1>Создай</h1>

					<div class="bform py-5">
						<!-- Row -->
						<div class="row">
							<div class="container">
								<div
									class="col-lg-6 align-justify-center pr-4 pl-0 contact-form">
									<div class="">
										<h6 class="subtitle font-weight-normal">Please register
											to use all services of our company</h6>
										<form class="mt-3" action="main" method="POST">
											<div class="row">
												<div class="col-lg-12">
													<div class="form-group">
														<input class="form-control" type="text" id="name" required
															name="name" data-validation="custom"
															data-validation-regexp="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$"
															data-validation-help="First name should start with a letter and consist of 1-20 characters"
															placeholder="name" />
													</div>
												</div>
												<div class="col-lg-12">
													<div class="footer">
														<input type="hidden" name="action" value="registration" />
														<div class="btnfirst">
															<button
																class="btn btn-outline-primary btn-sm"
																type="submit" name="registration">Саздать </button>
														</div>
													</div>
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!--================Registration end  =================-->
				</div>
			</div>
		</div>
	</div>
</body>
</html>


