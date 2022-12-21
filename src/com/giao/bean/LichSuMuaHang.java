package com.giao.bean;

import java.util.Date;

public class LichSuMuaHang {
	private String tenDienThoai;
	private int soLuong;
	private long gia;
	private long thanhTien;
	private Date ngayMua;
	private int maKhachHang;
	private boolean trangThai;

	public LichSuMuaHang(String tenDienThoai, int soLuong, long gia, long thanhTien, Date ngayMua, int maKhachHang, boolean trangThai) {
		super();
		this.tenDienThoai = tenDienThoai;
		this.soLuong = soLuong;
		this.gia = gia;
		this.thanhTien = thanhTien;
		this.ngayMua = ngayMua;
		this.maKhachHang = maKhachHang;
		this.trangThai = trangThai;
	}

	public String getTenDienThoai() {
		return tenDienThoai;
	}

	public void setTenDienThoai(String tenDienThoai) {
		this.tenDienThoai = tenDienThoai;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

	public long getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(long thanhTien) {
		this.thanhTien = thanhTien;
	}

	public Date getNgayMua() {
		return ngayMua;
	}

	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}

	public int getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

}
