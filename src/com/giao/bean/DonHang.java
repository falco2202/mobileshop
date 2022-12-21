package com.giao.bean;

import java.util.Date;

public class DonHang {
	private int maHoaDon;
	private String tenKhachHang;
	private String soDienThoai;
	private Date ngayTao;
	private boolean trangThai;
	private int soLuongMua;
	private long tongTien;

	public DonHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DonHang(int maHoaDon, String tenKhachHang,String soDienThoai, Date ngayTao, boolean trangThai, int soLuongMua, long tongTien) {
		super();
		this.maHoaDon = maHoaDon;
		this.tenKhachHang = tenKhachHang;
		this.soDienThoai = soDienThoai;
		this.ngayTao = ngayTao;
		this.trangThai = trangThai;
		this.soLuongMua = soLuongMua;
		this.tongTien = tongTien;
	}

	public int getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
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

	public int getSoLuongMua() {
		return soLuongMua;
	}

	public void setSoLuongMua(int soLuongMua) {
		this.soLuongMua = soLuongMua;
	}

	public long getTongTien() {
		return tongTien;
	}

	public void setTongTien(long tongTien) {
		this.tongTien = tongTien;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

}
