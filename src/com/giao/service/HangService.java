package com.giao.service;

import java.util.ArrayList;

import com.giao.bean.Hang;
import com.giao.dao.HangDao;

public class HangService {
	HangDao hang = new HangDao();

	public ArrayList<Hang> getAllHang() throws Exception {
		return hang.getAllHang();
	}

	public int addHang(String maHang, String tenHang) throws Exception {
		return hang.addHang(maHang, tenHang);
	}

	public int xoaHang(String maHang) throws Exception {
		return hang.completeDeleteHang(maHang);
	}

	public int capNhap(String maHang, String tenHang) throws Exception {
		return hang.updateHang(maHang, tenHang);
	}
	
	public Hang getHang(String maHang) throws Exception {
		return hang.getHang(maHang);
	}
}
