package com.giao.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.giao.bean.DienThoai;

public class DienThoaiDao {
	public ArrayList<DienThoai> getAllDienThoai() throws Exception {
		ArrayList<DienThoai> ds = new ArrayList<DienThoai>();
		String sql = "SELECT * FROM DienThoai WHERE DaXoa = 0";

		PreparedStatement pre = ConnectDatabase.connection().prepareStatement(sql);

		ResultSet rs = pre.executeQuery();

		while (rs.next()) {
			int maDienThoai = rs.getInt("MaDienThoai");
			String tenDienThoai = rs.getString("TenDienThoai");
			String maHang = rs.getString("MaHang");
			int soLuong = rs.getInt("SoLuong");
			long gia = rs.getLong("Gia");
			int ram = rs.getInt("ram");
			int dungLuong = rs.getInt("dungLuong");
			float kichThuoc = rs.getFloat("KichThuoc");
			String moTa = rs.getString("MoTa");
			Date ngayNhap = rs.getDate("NgayNhap");
			String anh = rs.getString("Anh");
			ds.add(new DienThoai(maDienThoai, tenDienThoai, maHang, soLuong, gia, ram, dungLuong, kichThuoc, moTa,
					ngayNhap, anh));
		}
		rs.close();
		return ds;
	}

	public DienThoai getDienThoai(int ma) throws Exception {
		DienThoai dt = null;
		String sql = "SELECT * FROM DienThoai WHERE DaXoa = 0 AND MaDienThoai = ?";

		PreparedStatement pre = ConnectDatabase.connection().prepareStatement(sql);
		pre.setInt(1, ma);

		ResultSet rs = pre.executeQuery();

		while (rs.next()) {
			int maDienThoai = rs.getInt("MaDienThoai");
			String tenDienThoai = rs.getString("TenDienThoai");
			String maHang = rs.getString("MaHang");
			int soLuong = rs.getInt("SoLuong");
			long gia = rs.getLong("Gia");
			int ram = rs.getInt("ram");
			int dungLuong = rs.getInt("dungLuong");
			float kichThuoc = rs.getFloat("KichThuoc");
			String moTa = rs.getString("MoTa");
			Date ngayNhap = rs.getDate("NgayNhap");
			String anh = rs.getString("Anh");
			dt = new DienThoai(maDienThoai, tenDienThoai, maHang, soLuong, gia, ram, dungLuong, kichThuoc, moTa,
					ngayNhap, anh);
		}
		rs.close();
		return dt;
	}

	public int themDienThoai(String tenDienThoai, String maHang, int soLuong, long gia, Date ngayNhap, String anh,
			int ram, int dungLuong, float kichThuoc) throws Exception {
		String sql = "INSERT INTO DienThoai(TenDienThoai, MaHang, SoLuong, Gia, NgayNhap, Anh, Ram, DungLuong, KichThuoc) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pre = ConnectDatabase.connection().prepareStatement(sql);

		pre.setString(1, tenDienThoai);
		pre.setString(2, maHang);
		pre.setInt(3, soLuong);
		pre.setLong(4, gia);
		pre.setDate(5, new java.sql.Date(ngayNhap.getTime()));
		pre.setString(6, anh);
		pre.setInt(7, ram);
		pre.setInt(8, dungLuong);
		pre.setFloat(9, kichThuoc);

		return pre.executeUpdate();
	}

	public int suaDienThoai(String tenDienThoai, String maHang, int soLuong, long gia, Date ngayNhap, String anh,
			int ram, int dungLuong, float kichThuoc, int maDienThoai) throws Exception {
		String sql = "UPDATE DienThoai SET TenDienThoai = ?, MaHang = ? , SoLuong = ?, Gia = ?, NgayNhap = ?, Anh = ?, Ram = ?, DungLuong = ?, KichThuoc = ? WHERE MaDienThoai = ?";
		PreparedStatement pre = ConnectDatabase.connection().prepareStatement(sql);

		pre.setString(1, tenDienThoai);
		pre.setString(2, maHang);
		pre.setInt(3, soLuong);
		pre.setLong(4, gia);
		pre.setDate(5, new java.sql.Date(ngayNhap.getTime()));
		pre.setString(6, anh);
		pre.setInt(7, ram);
		pre.setInt(8, dungLuong);
		pre.setFloat(9, kichThuoc);
		pre.setInt(10, maDienThoai);

		return pre.executeUpdate();
	}

	public int softDeleteDienThoai(int maDienThoai) throws Exception {
		String sql = "UPDATE DienThoai SET DaXoa = 1 WHERE MaDienThoai = ?";

		PreparedStatement pre = ConnectDatabase.connection().prepareStatement(sql);

		pre.setInt(1, maDienThoai);

		return pre.executeUpdate();
	}

	public int completeDeleteDienThoai(int maDienThoai) throws Exception {
		String sql = "DELETE FROM DienThoai WHERE MaDienThoai = ?";

		PreparedStatement pre = ConnectDatabase.connection().prepareStatement(sql);

		pre.setInt(1, maDienThoai);

		return pre.executeUpdate();
	}

}
