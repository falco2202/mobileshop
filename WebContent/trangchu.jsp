<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
<link href="templates/css/bootstrap.min.css" rel="stylesheet">
<link href="templates/css/font-awesome.min.css" rel="stylesheet">
<link href="templates/css/prettyPhoto.css" rel="stylesheet">
<link href="templates/css/price-range.css" rel="stylesheet">
<link href="templates/css/animate.css" rel="stylesheet">
<link href="templates/css/main.css" rel="stylesheet">
<link href="templates/css/responsive.css" rel="stylesheet">
<link rel="shortcut icon" href="images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="templates/images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="templates/images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="templates/images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="templates/images/ico/apple-touch-icon-57-precomposed.png">
</head>
<body>
	<header id="header">
		<!--header-->
		<div class="header-middle">
			<!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="trangchu"><img src="templates/images/home/logo.png"
								alt="" /></a>
						</div>
						<div class="btn-group pull-right">
							<div class="btn-group"></div>

							<div class="btn-group"></div>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								<li><a href="giohang"><i class="fa fa-shopping-cart"></i>
										Giỏ hàng(<c:choose>
											<c:when test="${gio == null}">0</c:when>
											<c:otherwise>${gio.size()}</c:otherwise>
										</c:choose>)</a></li>
								<c:choose>
									<c:when test="${user == null}">
										<li><a href="dangnhap" class="active"><i
												class="fa fa-lock"></i> Đăng nhâp</a></li>
									</c:when>
									<c:otherwise>
										<li><a href="dangxuat" class="active"><i
												class="fa fa-lock"></i> Đăng xuất</a></li>
									</c:otherwise>
								</c:choose>

							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/header-middle-->

		<div class="header-bottom">
			<!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle"
								data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span> <span
									class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="trangchu">Trang chủ</a></li>
								<c:forEach var="h" items="${hang}">
									<li><a href="trangchu?hang=${h.getMaHang()}">${h.getTenHang()}</a></li>
								</c:forEach>


								<li class="dropdown"><a href="#">Danh mục<i
										class="fa fa-angle-down"></i></a>
									<ul role="menu" class="sub-menu">
										<li><a href="trangchu">Tất cả sản phẩm</a></li>
										<li><a href="lichsumuahang">Lịch sử mua hàng</a></li>
									</ul></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="search_box pull-right">
							<form action="trangchu">
								<input name="key" type="text" placeholder="Tìm kiếm" />
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/header-bottom-->
	</header>
	<!--/header-->

	<section id="slider">
		<!--slider-->
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div id="slider-carousel" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#slider-carousel" data-slide-to="0"
								class="active"></li>
							<li data-target="#slider-carousel" data-slide-to="1"></li>
							<li data-target="#slider-carousel" data-slide-to="2"></li>
						</ol>

						<div class="carousel-inner">
							<div class="item active">
								<div class="col-sm-6">
									<h1>
										<span>Giao</span> Shop
									</h1>
									<h2>Điện thoại thông minh</h2>
									<h3>Iphone 14 Pro Max</h3>
									<button type="button" class="btn btn-default get">Tận
										hưởng nào!</button>
								</div>
								<div class="col-sm-6">
									<img src="images/banner-iphone.jpg" class="girl img-responsive"
										alt="" />
								</div>
							</div>
							<div class="item">
								<div class="col-sm-6">
									<h1>
										<span>Giao</span> Shop
									</h1>
									<h2>Điện thoại thông minh</h2>
									<h3>Samsung Galaxy Note 10</h3>
									<button type="button" class="btn btn-default get">Tận
										hưởng nào!</button>
								</div>
								<div class="col-sm-6">
									<img src="images/samsungnote10.jpg" class="girl img-responsive"
										alt="" />
								</div>
							</div>
							<div class="item">
								<div class="col-sm-6">
									<h1>
										<span>Giao</span> Shop
									</h1>
									<h2>Điện thoại thông minh</h2>
									<h3>Oppo Reno 7</h3>
									<button type="button" class="btn btn-default get">Tận
										hưởng nào!</button>
								</div>
								<div class="col-sm-6">
									<img src="images/opporeno7.jpg" class="girl img-responsive"
										alt="" />
								</div>
							</div>

						</div>

						<a href="#slider-carousel" class="left control-carousel hidden-xs"
							data-slide="prev"> <i class="fa fa-angle-left"></i>
						</a> <a href="#slider-carousel"
							class="right control-carousel hidden-xs" data-slide="next"> <i
							class="fa fa-angle-right"></i>
						</a>
					</div>

				</div>
			</div>
		</div>
	</section>
	<!--/slider-->

	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-12 padding-right">
					<div class="features_items">
						<!--features_items-->
						<h2 class="title text-center">Tất cả sản phẩm</h2>

						<c:forEach var="sp" items="${dienthoai}">
							<div class="col-sm-4">
								<div class="product-image-wrapper">
									<div class="single-products">
										<div class="productinfo text-center">
											<a href="chitiet?ma=${sp.getMaDienThoai()}"><img 
											 src="${sp.getAnh()}" alt="" /></a>
											<h2>${sp.getGia()}đ</h2>
											<p>${sp.getTenDienThoai()}</p>
											<a
												href="giohang?ma=${sp.getMaDienThoai()}&ten=${sp.getTenDienThoai()}&gia=${sp.getGia()}"
												class="btn btn-default add-to-cart"><i
												class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>

					</div>

				</div>
			</div>
		</div>
	</section>


	<script src="templates/js/jquery.js"></script>
	<script src="templates/js/bootstrap.min.js"></script>
	<script src="templates/js/jquery.scrollUp.min.js"></script>
	<script src="templates/js/price-range.js"></script>
	<script src="templates/js/jquery.prettyPhoto.js"></script>
	<script src="templates/js/main.js"></script>
</body>
</html>