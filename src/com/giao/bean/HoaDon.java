package com.giao.bean;

import java.util.Date;

public class HoaDon {
	private int maHoaDon;
	private int maKhachHang;
	private Date ngayTao;
	private boolean trangThai;
	private Date ngayHoanThanh;
	
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HoaDon(int maHoaDon, int maKhachHang, Date ngayTao, boolean trangThai, Date ngayHoanThanh) {
		super();
		this.maHoaDon = maHoaDon;
		this.maKhachHang = maKhachHang;
		this.ngayTao = ngayTao;
		this.trangThai = trangThai;
		this.ngayHoanThanh = ngayHoanThanh;
	}

	public int getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public int getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public Date getNgayHoanThanh() {
		return ngayHoanThanh;
	}

	public void setNgayHoanThanh(Date ngayHoanThanh) {
		this.ngayHoanThanh = ngayHoanThanh;
	};
	
	
}
