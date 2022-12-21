package com.giao.bean;

public class TaiKhoan {
	private String tenTaiKhoan;
	private String matKhau;
	private boolean quyen;
	
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TaiKhoan(String tenTaiKhoan, String matKhau, boolean quyen) {
		super();
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
		this.quyen = quyen;
	}
	
	public TaiKhoan(String tenTaiKhoan, String matKhau) {
		super();
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
	}

	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public boolean isQuyen() {
		return quyen;
	}

	public void setQuyen(boolean quyen) {
		this.quyen = quyen;
	}
	
	
}
