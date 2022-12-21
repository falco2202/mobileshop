package com.giao.bean;

public class ChiTietHoaDon {
	private int maChiTietHD;
	private int maHoaDon;
	private int maDienThoai;
	private int soLuong;
	private String ghiChu;

	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChiTietHoaDon(int maChiTietHD, int maHoaDon, int maDienThoai, int soLuong, String ghiChu) {
		super();
		this.maChiTietHD = maChiTietHD;
		this.maHoaDon = maHoaDon;
		this.maDienThoai = maDienThoai;
		this.soLuong = soLuong;
		this.ghiChu = ghiChu;
	}

	public int getMaChiTietHD() {
		return maChiTietHD;
	}

	public void setMaChiTietHD(int maChiTietHD) {
		this.maChiTietHD = maChiTietHD;
	}

	public int getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public int getMaDienThoai() {
		return maDienThoai;
	}

	public void setMaDienThoai(int maDienThoai) {
		this.maDienThoai = maDienThoai;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

}
