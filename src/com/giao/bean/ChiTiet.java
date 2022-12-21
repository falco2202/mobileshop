package com.giao.bean;

public class ChiTiet {
	private int maDienThoai;
	private String tenDienThoai;
	private long gia;
	private int soLuong;
	private long thanhTien;
	private int maHoaDon;

	public ChiTiet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChiTiet(int maDienThoai, String tenDienThoai, long gia, int soLuong, long thanhTien, int maHoaDon) {
		super();
		this.maDienThoai = maDienThoai;
		this.tenDienThoai = tenDienThoai;
		this.gia = gia;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
		this.maHoaDon = maHoaDon;
	}

	public int getMaDienThoai() {
		return maDienThoai;
	}

	public void setMaDienThoai(int maDienThoai) {
		this.maDienThoai = maDienThoai;
	}

	public String getTenDienThoai() {
		return tenDienThoai;
	}

	public void setTenDienThoai(String tenDienThoai) {
		this.tenDienThoai = tenDienThoai;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public long getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(long thanhTien) {
		this.thanhTien = thanhTien;
	}

	public int getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

}
