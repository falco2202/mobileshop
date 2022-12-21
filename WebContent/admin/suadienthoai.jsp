<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<link href="../templates/admin/css/styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<!-- Navbar Brand-->
		<a class="navbar-brand ps-3" href="admin/trangchu">Quản lý</a>
		<!-- Sidebar Toggle-->
		<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
			id="sidebarToggle" href="#!">
			<i class="fas fa-bars"></i>
		</button>
		<!-- Navbar Search-->
		<form
			class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
			<div class="input-group">
				<input class="form-control" type="text" placeholder="Search for..."
					aria-label="Search for..." aria-describedby="btnNavbarSearch" />
				<button class="btn btn-primary" id="btnNavbarSearch" type="button">
					<i class="fas fa-search"></i>
				</button>
			</div>
		</form>
		<!-- Navbar-->
		<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
				role="button" data-bs-toggle="dropdown" aria-expanded="false"><i
					class="fas fa-user fa-fw"></i></a>
				<ul class="dropdown-menu dropdown-menu-end"
					aria-labelledby="navbarDropdown">
					<li><a class="dropdown-item" href="#!">Settings</a></li>
					<li><a class="dropdown-item" href="#!">Activity Log</a></li>
					<li><hr class="dropdown-divider" /></li>
					<li><a class="dropdown-item" href="#!">Logout</a></li>
				</ul></li>
		</ul>
	</nav>

	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-dark"
				id="sidenavAccordion">
				<div class="sb-sidenav-menu">
					<div class="nav">
						<a class="nav-link" href="trangchu">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> Trang chủ
						</a>
						<div class="sb-sidenav-menu-heading">Nghiệp vụ</div>
						<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapseLayouts" aria-expanded="false"
							aria-controls="collapseLayouts">
							<div class="sb-nav-link-icon">
								<i class="fas fa-columns"></i>
							</div> Quản lý sản phẩm
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<div class="collapse" id="collapseLayouts"
							aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link" href="hang">Hãng</a> <a class="nav-link"
									href="dienthoai">Điện thoại</a>
							</nav>
						</div>
						<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
							data-bs-target="#pagesCollapseAuth" aria-expanded="false"
							aria-controls="collapsePages">
							<div class="sb-nav-link-icon">
								<i class="fas fa-book-open"></i>
							</div> Quản lý bán hàng
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>

						<div class="collapse" id="pagesCollapseAuth"
							aria-labelledby="headingOne"
							data-bs-parent="#sidenavAccordionPages">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link" href="donhang">Quản lý đơn hàng</a> <a
									class="nav-link" href="chuyentien">Các đơn hàng đã xác nhận</a>
							</nav>
						</div>

						<div class="sb-sidenav-menu-heading">Người dùng</div>
						<a class="nav-link" href="nguoidung">
							<div class="sb-nav-link-icon">
								<i class="fas fa-chart-area"></i>
							</div> Quản lý khách hàng
						</a> <a class="nav-link" href="tables.html">
							<div class="sb-nav-link-icon">
								<i class="fas fa-table"></i>
							</div> Khôi phục
						</a>
					</div>
				</div>
			</nav>
		</div>
		<div id="layoutSidenav_content">
			<main>
				<div class="container px-4">
					<section class="panel panel-default mt-4">
						<div class="panel-heading">
							<h3 class="panel-title">Thêm điện thoại</h3>
						</div>
						<div class="panel-body">
							<form action="suadienthoai" class="form-horizontal"
								enctype="multipart/form-data" method="post">
								<div class="form-group mb-3">
									<label for="name" class="col-sm-3 control-label">Mã
										điện thoại</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" name="maDienThoai"
											id="name" placeholder="Nhập tên điện thoại"
											value="${dt.getMaDienThoai()}" readonly="readonly">
									</div>
								</div>
								<div class="form-group mb-3">
									<label for="name" class="col-sm-3 control-label">Tên
										điện thoại</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" name="tenDienThoai"
											required="required" id="name"
											placeholder="Nhập tên điện thoại"
											value="${dt.getTenDienThoai()}">
									</div>
								</div>
								<!-- form-group // -->
								<div class="form-group mb-3">
									<label for="name" class="col-sm-3 control-label">Số
										lượng</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" name="soLuong"
											required="required" id="name" placeholder="Nhập số lượng"
											value="${dt.getSoLuong()}">
									</div>
								</div>
								<!-- form-group // -->
								<div class="form-group mb-3">
									<label for="qty" class="col-sm-3 control-label">Giá</label>
									<div class="col-sm-3">
										<input type="text" class="form-control" name="gia" id="qty"
											required="required" placeholder="Nhập giá"
											value="${dt.getGia()}">
									</div>
								</div>
								<!-- form-group // -->
								<div class="form-group mb-3">
									<label for="qty" class="col-sm-3 control-label">Ngày
										nhập</label>
									<div class="col-sm-3">
										<input type="date" class="form-control" name="ngayNhap"
											required="required" id="date" value="${dt.getNgayNhap()}">
									</div>
								</div>


								<div class="form-group mb-3">
									<label for="qty" class="col-sm-3 control-label">Ram</label>
									<div class="col-sm-3">
										<input type="number" class="form-control" name="ram" id="qty"
											placeholder="Nhập dung lượng ram" value="${dt.getRam()}"
											required="required">
									</div>
								</div>

								<div class="form-group mb-3">
									<label for="qty" class="col-sm-3 control-label">Dung
										lượng</label>
									<div class="col-sm-3">
										<input type="number" class="form-control" name="dungLuong"
											id="qty" placeholder="Nhập dung lượng lưu trữ"
											value="${dt.getDungLuong()}" required="required">
									</div>
								</div>

								<div class="form-group mb-3">
									<label for="qty" class="col-sm-3 control-label">Kích
										thước</label>
									<div class="col-sm-3">
										<input type="text" class="form-control" name="kichThuoc"
											id="qty" placeholder="Nhập kích thước"
											value="${dt.getKichThuoc()}" required="required">
									</div>
								</div>


								<div class="form-outline mb-4">
									<label class="form-label" for="form6Example6">Chọn hãng</label>
									<select class="custom-select" name="maHang" id="gender2"
										required="required">
										<option required="required" selected>Lựa chọn...</option>
										<c:forEach var="l" items="${hang}">
											<option id="${l.maHang}" value="${l.maHang }">${l.tenHang}</option>
										</c:forEach>
									</select>

								</div>
								<!-- form-group // -->
								<div class="form-group mb-4">
									<label class="form-label">Chọn ảnh</label> <input type="file"
										class="form-control col-lg-offset-3" name="txtfile"
										onchange="document.getElementById('Photo').src = window.URL.createObjectURL(this.files[0])" />


								</div>
								<div class="form-group">
									<div class="col-sm-offset-3 col-sm-9">
										<input hidden type="text" id="anhSach" name="anh"
											value="${dt.getAnh()}" /> <img id="Photo"
											src="../${dt.getAnh()}" class="img img-bordered"
											style="width: 250px;" />
									</div>
								</div>
								<!-- form-group // -->
								<hr>
								<div class="form-group">
									<div class="col-sm-offset-3 col-sm-9">
										<button type="submit" class="btn btn-primary">Lưu</button>
									</div>
								</div>
								<!-- form-group // -->
							</form>

						</div>
						<!-- panel-body // -->
					</section>
					<!-- panel// -->

				</div>
			</main>


			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid px-4">
					<div
						class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Copyright &copy; Your Website 2022</div>
						<div>
							<a href="#">Privacy Policy</a> &middot; <a href="#">Terms
								&amp; Conditions</a>
						</div>
					</div>
				</div>
			</footer>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="../templates/admin/js/scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<script src="../templates/admin/assets/demo/chart-area-demo.js"></script>
	<script src="../templates/admin/assets/demo/chart-bar-demo.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
	<script src="../templates/admin/js/datatables-simple-demo.js"></script>


</body>
</html>