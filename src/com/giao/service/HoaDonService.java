package com.giao.service;

import java.util.ArrayList;

import com.giao.bean.ChiTiet;
import com.giao.bean.DonHang;
import com.giao.bean.GioHang;
import com.giao.dao.HoaDonDao;

public class HoaDonService {
	HoaDonDao hoaDon = new HoaDonDao();
	
	public void muaHang(ArrayList<GioHang> ds, int maKhachHang) throws Exception {
		hoaDon.themHoaDon(maKhachHang);
		
		int maHoaDon = hoaDon.getMaHoaDonVuaLap();
		for(GioHang g: ds) {
			hoaDon.themChiTietHoaDon(maHoaDon, g.getMaDienThoai(), g.getSoLuong());
		}
	}
	
	public ArrayList<DonHang> getDonHang() throws Exception{
		return hoaDon.getDonHang();
	}
	
	public int xacNhanHoaDon(int maHoaDon) throws Exception {
		return hoaDon.xacNhanDonHang(maHoaDon);
	}
	
	public ArrayList<DonHang> getDonHangDaXacNhan() throws Exception {
		return hoaDon.getDonHangDaXacNhan();
	}
	
	public ArrayList<ChiTiet> getChiTiet(int maHoaDon) throws Exception {
		return hoaDon.getChiTiet(maHoaDon);
	}
}
