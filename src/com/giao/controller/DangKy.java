package com.giao.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.giao.service.KhachHangService;
import com.giao.util.MaHoa;

/**
 * Servlet implementation class DangKy
 */
@WebServlet("/dangky")
public class DangKy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangKy() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String tenDangNhap = request.getParameter("username");
		String matKhau = request.getParameter("password");
		String hoTen = request.getParameter("fullname");
		String diaChi = request.getParameter("address");
		String soDienThoai = request.getParameter("phone");
		String email = request.getParameter("email");

		if (tenDangNhap == null) {
			RequestDispatcher rd = request.getRequestDispatcher("dangky.jsp");
			rd.forward(request, response);
			return;
		}

		if (request.getParameter("dangky") != null) {
			KhachHangService service = new KhachHangService();
			try {
				if (service.dangKy(hoTen, diaChi, soDienThoai, email, tenDangNhap, MaHoa.ecrypt(matKhau))) {
					response.sendRedirect("dangnhap");
					return;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher("dangky.jsp");
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
