package com.giao.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.giao.bean.ChiTiet;
import com.giao.bean.DonHang;

public class HoaDonDao {
	public int themHoaDon(int maKhachHang) throws Exception {
		String sql = "INSERT INTO HoaDon(MaKhachHang, NgayTao) VALUES(?, ?)";

		PreparedStatement pre = ConnectDatabase.connection().prepareStatement(sql);

		pre.setInt(1, maKhachHang);
		Date d = new Date();
		pre.setDate(2, new java.sql.Date(d.getTime()));

		return pre.executeUpdate();
	}

	public int getMaHoaDonVuaLap() throws Exception {
		int ma = 0;
		String sql = "SELECT MAX(MaHoaDon) as ma FROM HoaDon";
		PreparedStatement pre = ConnectDatabase.connection().prepareStatement(sql);

		ResultSet rs = pre.executeQuery();
		if (rs.next()) {
			ma = rs.getInt("ma");
		}
		return ma;
	}

	public int themChiTietHoaDon(int maHoaDon, int maDienThoai, int soLuong) throws Exception{
		String sql = "INSERT INTO ChiTietHoaDon(MaHoaDon, MaDienThoai, SoLuong) VALUES (?, ?, ?)";
		PreparedStatement pre = ConnectDatabase.connection().prepareStatement(sql);

		pre.setInt(1, maHoaDon);
		pre.setInt(2, maDienThoai);
		pre.setInt(3, soLuong);

		return pre.executeUpdate();
	}
		
	
	// Xac nhan don hang
	public ArrayList<DonHang> getDonHang() throws Exception {
		ArrayList<DonHang> ds = new ArrayList<DonHang>();
		String sql = "SELECT * FROM V_DonHangChoDuyet WHERE TrangThai = 0";
		
		PreparedStatement pre = ConnectDatabase.connection().prepareStatement(sql);
		
		ResultSet rs = pre.executeQuery();
		
		while(rs.next()) {
			int maHoaDon = rs.getInt("MaHoaDon");
			String tenKhachHang = rs.getString("TenKhachHang");
			String soDienThoai = rs.getString("SoDienThoai");
			Date ngayTao = rs.getDate("NgayTao");
			boolean trangThai = rs.getBoolean("TrangThai");
			int soLuongMua = rs.getInt("SoLuongMua");
			long tongTien = rs.getLong("TongTien");
			ds.add(new DonHang(maHoaDon, tenKhachHang, soDienThoai, ngayTao, trangThai, soLuongMua, tongTien));
		}
		return ds;
	}
	
	public ArrayList<DonHang> getDonHangDaXacNhan() throws Exception {
		ArrayList<DonHang> ds = new ArrayList<DonHang>();
		String sql = "SELECT * FROM V_DonHangChoDuyet WHERE TrangThai = 1";
		
		PreparedStatement pre = ConnectDatabase.connection().prepareStatement(sql);
		
		ResultSet rs = pre.executeQuery();
		
		while(rs.next()) {
			int maHoaDon = rs.getInt("MaHoaDon");
			String tenKhachHang = rs.getString("TenKhachHang");
			String soDienThoai = rs.getString("SoDienThoai");
			Date ngayTao = rs.getDate("NgayTao");
			boolean trangThai = rs.getBoolean("TrangThai");
			int soLuongMua = rs.getInt("SoLuongMua");
			long tongTien = rs.getLong("TongTien");
			ds.add(new DonHang(maHoaDon, tenKhachHang, soDienThoai, ngayTao, trangThai, soLuongMua, tongTien));
		}
		return ds;
	}
	
	public int xacNhanDonHang(int maHoaDon) throws Exception {
		String sql = "UPDATE HoaDon SET TrangThai = 1 WHERE MaHoaDon = ?";
		
		PreparedStatement pre = ConnectDatabase.connection().prepareStatement(sql);
		
		pre.setInt(1, maHoaDon);
		
		return pre.executeUpdate();
	}
	
	public ArrayList<ChiTiet> getChiTiet(int maHoaDon) throws Exception {
		ArrayList<ChiTiet> ds = new ArrayList<ChiTiet>();
		String sql = "SELECT * FROM V_ChiTiet WHERE MaHoaDon = ?";
		PreparedStatement pre = ConnectDatabase.connection().prepareStatement(sql);
		pre.setInt(1, maHoaDon);
		
		ResultSet rs = pre.executeQuery();
		
		while(rs.next()) {
			int maDienThoai = rs.getInt("MaDienThoai");
			String tenDienThoai = rs.getString("TenDienThoai");
			long gia = rs.getLong("Gia");
			int soLuong = rs.getInt("SoLuong");
			long thanhTien = rs.getLong("ThanhTien");
			int ma = rs.getInt("MaHoaDon");
			ds.add(new ChiTiet(maDienThoai, tenDienThoai, gia, soLuong, thanhTien, ma));
		}
		return ds;
	}
}
