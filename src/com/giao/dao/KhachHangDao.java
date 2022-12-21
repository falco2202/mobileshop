package com.giao.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.giao.bean.KhachHang;
import com.giao.bean.LichSuMuaHang;
import com.giao.bean.TaiKhoan;

public class KhachHangDao {
	public ArrayList<KhachHang> getAll() throws Exception {
		ArrayList<KhachHang> ds = new ArrayList<KhachHang>();
		String sql = "SELECT * FROM V_KhachHang";

		PreparedStatement pre = ConnectDatabase.connection().prepareStatement(sql);

		ResultSet rs = pre.executeQuery();

		while (rs.next()) {
			int maKhachHang = rs.getInt("MaKhachHang");
			String tenKhachHang = rs.getString("TenKhachHang");
			String diaChi = rs.getString("DiaChi");
			String soDienThoai = rs.getString("SoDienThoai");
			String email = rs.getString("Email");
			String taiKhoan = rs.getString("TaiKhoan");
			String matKhau = rs.getString("MatKhau");
			ds.add(new KhachHang(maKhachHang, tenKhachHang, diaChi, soDienThoai, email, taiKhoan, matKhau));
		}
		rs.close();
		return ds;
	}
	
	// Dang nhap admin
	public TaiKhoan danhNhapAdmin(String taiKhoan, String matKhau) throws Exception {
		TaiKhoan tk = null;
		String sql = "SELECT * FROM TaiKhoan WHERE TaiKhoan = ? AND MatKhau = ? AND Quyen = 1";

		PreparedStatement pre = ConnectDatabase.connection().prepareStatement(sql);
		pre.setString(1, taiKhoan);
		pre.setString(2, matKhau);

		ResultSet rs = pre.executeQuery();

		while (rs.next()) {
			String user = rs.getString("TaiKhoan");
			String pass = rs.getString("MatKhau");
			tk = new TaiKhoan(user, pass);
		}
		return tk;
	}
	
	
	public boolean kiemTraTonTai(String taiKhoan) throws Exception {
		boolean check = false;
		String sql = "SELECT * FROM TaiKhoan WHERE TaiKhoan = ?";

		PreparedStatement pre = ConnectDatabase.connection().prepareStatement(sql);
		pre.setString(1, taiKhoan);

		ResultSet rs = pre.executeQuery();
		
		while(rs.next()) {
			check = true;
		}
		return check;
	}

	public int themTaiKhoan(String taiKhoan, String matKhau) throws Exception {
		String sql = "INSERT INTO TaiKhoan(TaiKhoan, MatKhau) VALUES(?, ?)";

		PreparedStatement pre = ConnectDatabase.connection().prepareStatement(sql);
		pre.setString(1, taiKhoan);
		pre.setString(2, matKhau);

		return pre.executeUpdate();
	}

	public int themKhachHang(String tenKhachHang, String diaChi, String soDienThoai, String email, String taiKhoan)
			throws Exception {
		String sql = "INSERT INTO KhachHang(TenKhachHang, DiaChi, SoDienThoai, Email, TaiKhoan) VALUES(?, ?, ?, ?, ?)";

		PreparedStatement pre = ConnectDatabase.connection().prepareStatement(sql);
		pre.setString(1, tenKhachHang);
		pre.setString(2, diaChi);
		pre.setString(3, soDienThoai);
		pre.setString(4, email);
		pre.setString(5, taiKhoan);

		return pre.executeUpdate();
	}

	public boolean kiemTra(String taiKhoan, String matKhau) throws Exception {
		boolean check = false;
		String sql = "SELECT * FROM TaiKhoan WHERE TaiKhoan = ? AND MatKhau = ? AND Quyen = 0";

		PreparedStatement pre = ConnectDatabase.connection().prepareStatement(sql);
		pre.setString(1, taiKhoan);
		pre.setString(2, matKhau);

		ResultSet rs = pre.executeQuery();

		while (rs.next()) {
			check = true;
		}
		return check;
	}

	public KhachHang dangNhap(String taiKhoan, String matKhau) throws Exception {
		KhachHang kh = null;
		String sql = "SELECT * FROM V_KhachHang WHERE TaiKhoan = ?";

		PreparedStatement pre = ConnectDatabase.connection().prepareStatement(sql);
		pre.setString(1, taiKhoan);
		ResultSet rs = pre.executeQuery();

		while (rs.next()) {
			int maKhachHang = rs.getInt("MaKhachHang");
			String tenKhachHang = rs.getString("TenKhachHang");
			String diaChi = rs.getString("DiaChi");
			String soDienThoai = rs.getString("SoDienThoai");
			String email = rs.getString("Email");
			String tk = rs.getString("TaiKhoan");
			String mk = rs.getString("MatKhau");
			kh = new KhachHang(maKhachHang, tenKhachHang, diaChi, soDienThoai, email, tk, mk);
		}
		return kh;
	}

	public int xoaKhachHang(String maKhachHang) throws Exception {
		String sql = "DELETE FROM KhachHang WHERE MaKhachHang = ?";
		PreparedStatement pre = ConnectDatabase.connection().prepareStatement(sql);
		pre.setString(1, maKhachHang);

		return pre.executeUpdate();
	}
	
	public ArrayList<LichSuMuaHang> xemLichSu(int maKhachHang) throws Exception{
		ArrayList<LichSuMuaHang> ls = new ArrayList<LichSuMuaHang>();
		
		String sql = "SELECT * FROM V_LichSuMuaHang WHERE MaKhachHang = ?";

		PreparedStatement pre = ConnectDatabase.connection().prepareStatement(sql);
		pre.setInt(1, maKhachHang);
		ResultSet rs = pre.executeQuery();

		while (rs.next()) {
			int ma = rs.getInt("MaKhachHang");
			String tenDienThoai = rs.getString("TenDienThoai");
			long gia = rs.getLong("Gia");
			int sl = rs.getInt("SoLuong");
			long thanhTien = rs.getLong("ThanhTien");
			Date ngayTao = rs.getDate("NgayTao");
			boolean trangThai = rs.getBoolean("TrangThai");
			ls.add(new LichSuMuaHang(tenDienThoai, sl, gia, thanhTien, ngayTao, ma, trangThai));
		}
		return ls;
	}
}
