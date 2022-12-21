package com.giao.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.giao.bean.TaiKhoan;
import com.giao.service.KhachHangService;

/**
 * Servlet implementation class AdminDangNhap
 */
@WebServlet("/admin/dangnhap")
public class AdminDangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminDangNhap() {
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

		String taiKhoan = request.getParameter("username");
		String matKhau = request.getParameter("password");

		KhachHangService service = new KhachHangService();
		TaiKhoan kh = null;
		try {
			kh = service.dangNhapAdmin(taiKhoan, matKhau);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (kh == null) {
			RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp");
			rd.forward(request, response);
			return;
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("admin", kh);
			response.sendRedirect("trangchu");
			return;
		}
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
