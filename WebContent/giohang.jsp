<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giỏ hàng của bạn</title>
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
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="templates/assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="templates/css/styles.css" rel="stylesheet" />
<style type="text/css">
.table-items {
	margin: 70px auto;
	width: 90%;
}

.delete-icon {
	width: 20px;
}

.title-cart {
	text-align: center;
}

.input-box {
	width: 40px;
}

.form-search .input-group {
	width: 70%;
	margin: 20px auto;
	display: flex;
}

.form-search .input-group .input-search {
	margin-right: 20px;
}

.btn-search {
	background-color: #3b71ca;
	color: white;
}

.container-global {
	display: flex;
	flex-wrap: wrap;
	width: 100%;
	padding: 0 20px;
	gap: 10%;
}

.container-global .list-categories {
	width: 20%
}

.container-global .list-content {
	width: 70%;
	display: grid;
	grid-template-columns: auto auto auto;
}

.item-book {
	margin-bottom: 30px;
}
</style>
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
							<input type="text" placeholder="Tìm kiếm" />
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/header-bottom-->
	</header>

	<h2 class="title-cart">Giỏ hàng của bạn</h2>
	<div class="list-cart">
		<c:set var="tong" value="${0}"></c:set>
		<c:set var="count" value="${1}"></c:set>
		<c:choose>
			<c:when test="${gio.size() == 0}">
				<div class="d-flex justify-content-center">
					<div style="text-align: center;">
						Giỏ hàng trống
						<form action="trangchu">
							<button class="btn btn btn-success" type="submit">Mua hàng</button>
						</form>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="table-list">
					<table class="table-items table table-striped">
						<thead>
							<tr>
								<th class="col">#</th>
								<th class="col">STT</th>
								<th class="col">Tên điện thoại</th>
								<th class="col">Đơn giá</th>
								<th class="col">Số lượng</th>
								<th class="col">Thành tiền</th>
								<th class="col">#</th>
								<th class="col">#</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="gh" items="${gio}">
								<tr>
									<td><input form="xulyxoa" type="checkbox" name="selected"
										value="${gh.getMaDienThoai()}"></td>
									<td>${count}</td>
									<td>${gh.getTenDienThoai()}</td>
									<td>${gh.getGia()}đ</td>
									<td><input form="xuly" class="input-box" type="number"
										min=0 name="amount" value="${gh.getSoLuong()}"></td>
									<td>${gh.getThanhTien()}đ</td>
									<c:set var="tong" value="${tong+ gh.getThanhTien()}"></c:set>
									<c:set var="count" value="${count+1}"></c:set>
									<td>
										<button form="xuly" type="submit" name="delete"
											value="${gh.getMaDienThoai()}">
											<img class="delete-icon" alt="" src="icons/delete.jpg">
										</button>
									</td>
									<td>
										<button form="xuly" type="submit" name="update"
											value="${gh.getMaDienThoai()}">Cập nhật</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div
					style="padding-left: 100px; padding-bottom: 20px; font-size: 20px">
					Tổng tiền:
					<c:out value="${tong}"></c:out>
					đồng
				</div>
				<div style="display: flex; gap: 20px; margin-left: 100px;">
					<form action="giohang" id="xulyxoa" method="post">
						<button class="btn btn-warning" type="submit" value="deleteSelect">Xóa</button>
					</form>
					<form action="giohang" id="xuly" method="post">
						<button type="submit" class="btn btn-danger" name="deleteAll">Xóa
							tất cả</button>
					</form>
					<form action="muahang" method="post">
						<button style="margin-left: 1200px;" class="btn btn-success"
							type="submit">Xác nhận mua hàng</button>
					</form>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>