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

import com.giao.bean.DonHang;
import com.giao.service.HoaDonService;

/**
 * Servlet implementation class AdminDonHang
 */
@WebServlet("/admin/donhang")
public class AdminDonHang extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminDonHang() {
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
		if (session.getAttribute("admin") == null) {
			response.sendRedirect("dangnhap");
			return;
		}

		String xacNhan = request.getParameter("xacnhan");

		HoaDonService service = new HoaDonService();
		ArrayList<DonHang> ds = null;
		try {
			if (xacNhan != null) {
				service.xacNhanHoaDon(Integer.parseInt(xacNhan));
			}
			ds = service.getDonHang();
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("donhang", ds);
		RequestDispatcher rd = request.getRequestDispatcher("donhang.jsp");
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
