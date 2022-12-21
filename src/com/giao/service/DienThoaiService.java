package com.giao.service;

import java.util.ArrayList;
import java.util.Date;

import com.giao.bean.DienThoai;
import com.giao.dao.DienThoaiDao;

public class DienThoaiService {
	DienThoaiDao dao = new DienThoaiDao();
	public ArrayList<DienThoai> dt = new ArrayList<DienThoai>();

	public ArrayList<DienThoai> getDienThoai() throws Exception {
		dt = dao.getAllDienThoai();
		return dt;
	}

	public ArrayList<DienThoai> getHang(String hang) {
		ArrayList<DienThoai> ds = new ArrayList<DienThoai>();
		for (DienThoai d : dt) {
			if (d.getMaHang().equals(hang)) {
				ds.add(d);
			}
		}
		return ds;
	}

	public ArrayList<DienThoai> tim(String key) {
		ArrayList<DienThoai> tam = new ArrayList<DienThoai>();
		for (DienThoai s : dt)
			if (s.getTenDienThoai().toLowerCase().contains(key.toLowerCase())
					|| s.getMaHang().toLowerCase().contains(key.toLowerCase())
					|| s.getMoTa().toLowerCase().contains(key.toLowerCase()))
				tam.add(s);
		return tam;
	}
	
	public int xoaDienThoai(int maDienThoai) throws Exception {
		return dao.softDeleteDienThoai(maDienThoai);
	}
	
	public int themDienThoai(String tenDienThoai, String maHang, int soLuong, long gia, Date ngayNhap, String anh, int ram,
			int dungLuong, float kichThuoc) throws Exception {
		return dao.themDienThoai(tenDienThoai, maHang, soLuong, gia, ngayNhap, anh, ram, dungLuong, kichThuoc);
	}
	
	public DienThoai getDienThoai(int maDienThoai) throws Exception {
		return dao.getDienThoai(maDienThoai);
	}
	public int suaDienThoai(String tenDienThoai, String maHang, int soLuong, long gia, Date ngayNhap, String anh,
			int ram, int dungLuong, float kichThuoc, int maDienThoai) throws Exception {
		return dao.suaDienThoai(tenDienThoai, maHang, soLuong, gia, ngayNhap, anh, ram, dungLuong, kichThuoc, maDienThoai);
	}
}
