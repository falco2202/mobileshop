package com.giao.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.giao.bean.Hang;
import com.giao.bean.KhachHang;
import com.giao.service.GioHangService;
import com.giao.service.HangService;
import com.giao.service.KhachHangService;

/**
 * Servlet implementation class LichSuMuaHang
 */
@WebServlet("/lichsumuahang")
public class LichSuMuaHang extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LichSuMuaHang() {
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
		
		KhachHangService service = new KhachHangService();
		KhachHang kh = (KhachHang)session.getAttribute("user");
		ArrayList<com.giao.bean.LichSuMuaHang> ls = null;
		try {
			ls = service.xemLichSu(kh.getMaKhachHang());
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayList<Hang> dsHang = null;
		HangService hang = new HangService();
		try {
			dsHang = hang.getAllHang();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		GioHangService gh = null;
		gh = (GioHangService) session.getAttribute("gio");
		if(gh == null) {
			request.setAttribute("gio", gh);
		} else {
			request.setAttribute("gio", gh.gio);
		}
		request.setAttribute("hang", dsHang);
		request.setAttribute("lichsu", ls);
		RequestDispatcher rd = request.getRequestDispatcher("lichsumuahang.jsp");
		rd.forward(request, response);
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
