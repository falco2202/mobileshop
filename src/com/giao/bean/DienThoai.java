package com.giao.bean;

import java.util.Date;

public class DienThoai {
	private int maDienThoai;
	private String tenDienThoai;
	private String maHang;
	private int soLuong;
	private long gia;
	private int ram;
	private int dungLuong;
	private float kichThuoc;
	private String moTa;
	private Date ngayNhap;
	private String anh;

	public DienThoai() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DienThoai(int maDienThoai, String tenDienThoai, String maHang, int soLuong, long gia, int ram, int dungLuong,
			float kichThuoc, String moTa, Date ngayNhap, String anh) {
		super();
		this.maDienThoai = maDienThoai;
		this.tenDienThoai = tenDienThoai;
		this.maHang = maHang;
		this.soLuong = soLuong;
		this.gia = gia;
		this.ram = ram;
		this.dungLuong = dungLuong;
		this.kichThuoc = kichThuoc;
		this.moTa = moTa;
		this.ngayNhap = ngayNhap;
		this.anh = anh;
	}

	public DienThoai(String tenDienThoai, String maHang, int soLuong, long gia, int ram, int dungLuong, float kichThuoc,
			String moTa, Date ngayNhap, String anh) {
		super();
		this.tenDienThoai = tenDienThoai;
		this.maHang = maHang;
		this.soLuong = soLuong;
		this.gia = gia;
		this.ram = ram;
		this.dungLuong = dungLuong;
		this.kichThuoc = kichThuoc;
		this.moTa = moTa;
		this.ngayNhap = ngayNhap;
		this.anh = anh;
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

	public String getMaHang() {
		return maHang;
	}

	public void setMaHang(String maHang) {
		this.maHang = maHang;
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

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getDungLuong() {
		return dungLuong;
	}

	public void setDungLuong(int dungLuong) {
		this.dungLuong = dungLuong;
	}

	public float getKichThuoc() {
		return kichThuoc;
	}

	public void setKichThuoc(float kichThuoc) {
		this.kichThuoc = kichThuoc;
	}

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

}
