package com.giao.service;

import java.util.ArrayList;

import com.giao.bean.GioHang;

public class GioHangService {
	public ArrayList<GioHang> gio = new ArrayList<GioHang>();

	public void themVaoGio(int ma, String ten, long gia, int soLuong) {
		for (GioHang g : gio) {
			if (g.getMaDienThoai() == ma) {
				g.setSoLuong(g.getSoLuong() + soLuong);
				return;
			}
		}
		gio.add(new GioHang(ma, ten, gia, soLuong));
	}

	public long tongTien() {
		long tong = 0;

		for (GioHang g : gio) {
			tong += g.getThanhTien();
		}
		return tong;
	}

	public void xoa(int ma) {
		for (GioHang g : gio) {
			if (g.getMaDienThoai() == ma) {
				gio.remove(g);
				return;
			}
		}
	}

	public void xoaTatCa() {
		gio.removeAll(gio);
	}
	
	public void suaSoLuong(int ma, int soLuong) {
		  for(GioHang s : gio) {
			  if(s.getMaDienThoai() == ma) {
				  s.setSoLuong(soLuong);
				  return;
			  }
		  }
	  }
}
