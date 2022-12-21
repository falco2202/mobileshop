package com.giao.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.giao.bean.KhachHang;
import com.giao.service.GioHangService;
import com.giao.service.HoaDonService;

/**
 * Servlet implementation class MuaHang
 */
@WebServlet("/muahang")
public class MuaHang extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MuaHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();

		if (session.getAttribute("user") == null) {
			response.sendRedirect("dangnhap");
			return;
		}
		
		HoaDonService hoaDon = new HoaDonService();
		GioHangService gio = (GioHangService)session.getAttribute("gio");
		KhachHang kh = (KhachHang)session.getAttribute("user");
		try {
			hoaDon.muaHang(gio.gio, kh.getMaKhachHang());
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.setAttribute("gio", null);
		response.sendRedirect("giohang");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
