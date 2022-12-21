package com.giao.service;

import java.util.ArrayList;

import com.giao.bean.KhachHang;
import com.giao.bean.LichSuMuaHang;
import com.giao.bean.TaiKhoan;
import com.giao.dao.KhachHangDao;

public class KhachHangService {
	KhachHangDao kh = new KhachHangDao();

	// admin
	public ArrayList<KhachHang> getAll() throws Exception {
		return kh.getAll();
	}

	public int xoaKhachHang(String maKhachHang) throws Exception {
		return 0;
	}
	
	public TaiKhoan dangNhapAdmin(String taiKhoan, String matKhau) throws Exception {
		return kh.danhNhapAdmin(taiKhoan, matKhau);
	}

	
	// User
	// Dang nhap
	public KhachHang dangNhap(String taiKhoan, String matKhau) throws Exception {
		if(!kh.kiemTra(taiKhoan, matKhau)) {
			return null;
		}
		return kh.dangNhap(taiKhoan, matKhau);
	}

	// Dang ky
	public boolean dangKy(String tenKhachHang, String diaChi, String soDienThoai, String email, String taiKhoan, String matKhau) throws Exception {
		if(kh.kiemTraTonTai(taiKhoan))
			return false;
		if(kh.themTaiKhoan(taiKhoan, matKhau) == 1 && kh.themKhachHang(tenKhachHang, diaChi, soDienThoai, email, taiKhoan) == 1)
			return true;
		return false;
	}
	
	// Xem lich su mua hang
	public ArrayList<LichSuMuaHang> xemLichSu(int maKhachHang) throws Exception {
		return kh.xemLichSu(maKhachHang);
	}
}
