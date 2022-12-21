package com.giao.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.giao.bean.Hang;

public class HangDao {
	public ArrayList<Hang> getAllHang() throws Exception {
		ArrayList<Hang> ds = new ArrayList<Hang>();
		String sql = "SELECT * FROM Hang WHERE DaXoa = 0";

		PreparedStatement pre = ConnectDatabase.connection().prepareStatement(sql);

		ResultSet rs = pre.executeQuery();

		while (rs.next()) {
			String maHang = rs.getString("MaHang");
			String tenHang = rs.getString("TenHang");
			ds.add(new Hang(maHang, tenHang));
		}
		rs.close();
		return ds;
	}
	
	public Hang getHang(String maHang) throws Exception {
		String sql = "SELECT * FROM Hang WHERE DaXoa = 0 AND MaHang = ?";

		PreparedStatement pre = ConnectDatabase.connection().prepareStatement(sql);
		pre.setString(1, maHang);

		ResultSet rs = pre.executeQuery();
		Hang hang = null;

		if (rs.next()) {
			String ma = rs.getString("MaHang");
			String tenHang = rs.getString("TenHang");
			hang = new Hang(ma, tenHang);
		}
		rs.close();
		return hang;
	}

	public int addHang(String maHang, String tenHang) throws Exception {
		String sql = "INSERT INTO Hang(MaHang, TenHang) VALUES(?, ?)";

		PreparedStatement pre = ConnectDatabase.connection().prepareStatement(sql);

		pre.setString(1, maHang);
		pre.setString(2, tenHang);

		return pre.executeUpdate();
	}

	public int updateHang(String maHang, String tenHang) throws Exception {
		String sql = "UPDATE Hang SET TenHang = ? WHERE MaHang = ?";

		PreparedStatement pre = ConnectDatabase.connection().prepareStatement(sql);

		pre.setString(1, tenHang);
		pre.setString(2, maHang);

		return pre.executeUpdate();
	}

	public int softDeleteHang(String maHang) throws Exception {
		String sql = "UPDATE Hang SET DaXoa = 1 WHERE MaHang = ?";

		PreparedStatement pre = ConnectDatabase.connection().prepareStatement(sql);

		pre.setString(1, maHang);

		return pre.executeUpdate();
	}

	public int completeDeleteHang(String maHang) throws Exception {
		String sql = "DELETE FROM Hang WHERE MaHang = ?";

		PreparedStatement pre = ConnectDatabase.connection().prepareStatement(sql);

		pre.setString(1, maHang);

		return pre.executeUpdate();
	}

	public int khoiPhuc(String maHang) throws Exception {
		String sql = "UPDATE Hang SET DaXoa = 0 WHERE MaHang = ?";

		PreparedStatement pre = ConnectDatabase.connection().prepareStatement(sql);

		pre.setString(1, maHang);

		return pre.executeUpdate();
	}

}
