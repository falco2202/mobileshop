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

import com.giao.bean.KhachHang;
import com.giao.service.KhachHangService;

/**
 * Servlet implementation class AdminQuanLyNguoiDung
 */
@WebServlet("/admin/nguoidung")
public class AdminQuanLyNguoiDung extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminQuanLyNguoiDung() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		if (session.getAttribute("admin") == null) {
			response.sendRedirect("dangnhap");
			return;
		}
		KhachHangService service = new KhachHangService();
		ArrayList<KhachHang> kh = null;
		
		try {
			kh = service.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("ds", kh);
		RequestDispatcher rd = request.getRequestDispatcher("quanlykhachhang.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
